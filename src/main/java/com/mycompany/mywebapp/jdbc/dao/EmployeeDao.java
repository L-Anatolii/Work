package com.mycompany.mywebapp.jdbc.dao;

import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.jdbc.DAO;
import com.mycompany.mywebapp.jdbc.resultSetExtractor.EmployeeCertificationsExtractor;
import com.mycompany.mywebapp.jdbc.resultSetExtractor.EmployeesProgramsExtractor;
import com.mycompany.mywebapp.jdbc.rowMapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao implements DAO<Employee, Long> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //+
    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees", new EmployeeMapper());
    }

    //+
    @Override
    public Employee findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM employees WHERE id=?", new Object[]{id}, new EmployeeMapper()).
                stream().findAny().orElse(null);
    }

    //+
    @Override
    public void save(Employee employee) {
        jdbcTemplate.update("INSERT INTO employees(first_name, last_name, patronymic, job_position) VALUES(?,?,?,?)",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPatronymic(),
                employee.getJobPosition().toString());
    }

    @Override
    public void update(Long id, Employee updateEmployee) {
        jdbcTemplate.update("UPDATE employees SET first_name=?, last_name=?, patronymic=?, job_position=? WHERE id=?",
                updateEmployee.getFirstName(),
                updateEmployee.getLastName(),
                updateEmployee.getPatronymic(),
                updateEmployee.getJobPosition().toString(),
                id);
    }

    //+
    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employees WHERE id=?", id);
    }

    public List<Employee> findByIdEmployeeWithCertifications(Long id){
        return jdbcTemplate.query("SELECT * FROM employees e, certifications WHERE e.id=?",
                new EmployeeCertificationsExtractor(), id);
    }
//    public List<Employee> findByIdEmployeeWithCertifications(){
//        return jdbcTemplate.query("SELECT * FROM employees e, certifications c ORDER BY e.id DESC",
//                new EmployeesProgramsExtractor());
//    }
        // Many To Many
    public List<Employee> findByIdEmployeesWithCertifications(){
        return jdbcTemplate.query("SELECT e.id, \n" +
                                             "e.first_name, \n" +
                                             "e.last_name, \n" +
                                             "e.patronymic, \n" +
                                             "e.job_position,\n" +
                                             "c.certification_id,\n" +
                                             "c.employee_id,\n" +
                                             "c.safety_training_program_id,\n" +
                                             "c.number_certification,\n" +
                                             "s.id AS program_id, \n" +
                                             "s.title_of_program, \n" +
                                             "s.program_number,\n" +
                                             "s.duration, \n" +
                                             "s.approved_the_program, \n" +
                                             "s.date_of_approval \n" +
                                             "FROM employees e JOIN certifications c ON e.id = c.employee_id \n" +
                                             "JOIN safety_training_programs s ON c.safety_training_program_id=s.id\n" +
                                             "ORDER BY e.id, s.id DESC ", new EmployeesProgramsExtractor());
    }
}


