package com.mycompany.mywebapp.jdbc.dao;

import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.jdbc.DAO;
import com.mycompany.mywebapp.jdbc.resultSetExtractor.EmployeesProgramsExtractor;
import com.mycompany.mywebapp.jdbc.resultSetExtractor.ProgramsEmployeesExtractor;
import com.mycompany.mywebapp.jdbc.rowMapper.SafetyTrainingProgramMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SafetyTrainingProgramDao implements DAO<SafetyTrainingProgram, Long> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SafetyTrainingProgramDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SafetyTrainingProgram> findAll() {
        return jdbcTemplate.query("SELECT * FROM safety_training_programs", new SafetyTrainingProgramMapper());
    }

    @Override
    public SafetyTrainingProgram findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM safety_training_programs WHERE id=?", new Object[]{id}, new SafetyTrainingProgramMapper()).
                stream().findAny().orElse(null);
    }

    @Override
    public void save(SafetyTrainingProgram program) {
        jdbcTemplate.update("INSERT INTO safety_training_programs(title_of_program, program_number, duration, approved_the_program, date_of_approval) VALUES(?,?,?,?,?)",
                program.getTitleOfProgram(),
                program.getProgramNumber(),
                program.getDuration(),
                program.getApprovedTheProgram().toString(),
                program.getDateOfApproval());
    }

    @Override
    public void update(Long id, SafetyTrainingProgram program) {
        jdbcTemplate.update("UPDATE safety_training_programs SET title_of_program=?, program_number=?, duration=?, approved_the_program=?, date_of_approval=? WHERE id=?",
                program.getTitleOfProgram(),
                program.getProgramNumber(),
                program.getDuration(),
                program.getApprovedTheProgram().toString(),
                program.getDateOfApproval(),
                id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM safety_training_programs WHERE id=?", id);

    }

    public List<SafetyTrainingProgram> findByIdProgramsWithEmployees() {
        jdbcTemplate.query("SELECT " +
                "s.id, \n" +
                "s.title_of_program, \n" +
                "s.program_number,\n" +
                "s.duration, \n" +
                "s.approved_the_program, \n" +
                "s.date_of_approval, \n" +
                "c.number_certification,\n" +
                "c.certification_id,\n" +
                "c.safety_training_program_id,\n" +
                "e.id AS employee_id, \n" +
                "e.first_name, \n" +
                "e.last_name, \n" +
                "e.patronymic, \n" +
                "e.job_position \n" +
                "FROM safety_training_programs s INNER JOIN certifications c on s.id = c.safety_training_program_id JOIN certifications ON s.id = c.certification_id \n" +
                "JOIN employees e ON c.employee_id=e.id\n" +
//                "FROM employees e JOIN certifications c ON e.id = c.employee_id \n" +
//                "JOIN safety_training_programs s ON c.safety_training_program_id=s.id\n" +
                "ORDER BY s.id, e.id DESC ", new ProgramsEmployeesExtractor());
    }

    //Поменять название 2
    public List<SafetyTrainingProgram> findBertyIdProgramsWithEmployees() {
        return jdbcTemplate.query("SELECT\n" +
                "c.safety_training_program_id,\n" +
                "c.employee_id,\n" +
                "e.id,\n" +
                "e.first_name,\n" +
                "e.job_position,\n" +
                "e.last_name,\n" +
                "e.patronymic \n" +
                "from certifications c inner join employees e on c.employee_id = e.id\n" +
                "where c.safety_training_program_id=?", new ProgramsEmployeesExtractor());

    }

    //Поменять название 3
//    public List<SafetyTrainingProgram> findByIdProgramsWithEmployees() {
//           return jdbcTemplate.query("select\n" +
//                "c.employee_id,\n" +
//                "c.safety_training_program_id,\n" +
//                "s.id,\n" +
//                "s.date_of_approval,\n" +
//                "s.duration,\n" +
//                "s.approved_the_program,\n" +
//                "s.program_number,\n" +
//                "s.title_of_program\n" +
//                "from certifications c inner join safety_training_programs s on c.safety_training_program_id=s.id \n" +
//                "where c.employee_id=?", new ProgramsEmployeesExtractor());
//}
}

//SELECT
//        s.id,
//        s.title_of_program,
//        s.program_number,
//        s.duration,
//        s.approved_the_program,
//        s.date_of_approval,
//        c.number_certification,
//        e.id AS employee_id,
//        e.first_name,
//        e.last_name,
//        e.patronymic,
//        e.job_position
//        FROM safety_training_programs s INNER JOIN certifications c ON c.certification_id = c.safety_training_program_id
//        JOIN employees e ON c.employee_id=e.id
//        ORDER BY s.id, e.id