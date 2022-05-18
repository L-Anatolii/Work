package com.mycompany.mywebapp.jdbc.dao;

import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.jdbc.DAO;
import com.mycompany.mywebapp.jdbc.mapper.SafetyTrainingProgramMapper;
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
        return jdbcTemplate.query("SELECT * FROM safetytrainingprograms", new SafetyTrainingProgramMapper());
    }

    @Override
    public SafetyTrainingProgram findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM safetytrainingprograms WHERE id=?", new Object[]{id},new SafetyTrainingProgramMapper()).
                stream().findAny().orElse(null);
    }

    @Override
    public void save(SafetyTrainingProgram program) {
        jdbcTemplate.update("INSERT INTO safetytrainingprograms(titleofprogram, programnumber, duration, approvedtheprogram, dateofapproval) VALUES(?,?,?,?,?)",
                program.getTitleOfProgram(),
                program.getProgramNumber(),
                program.getDuration(),
                program.getJobPosition().toString(),
                program.getDateOfApproval());
    }

    @Override
    public void update(Long id, SafetyTrainingProgram program) {
        jdbcTemplate.update("UPDATE safetytrainingprograms SET titleofprogram=?, programnumber=?, duration=?, approvedtheprogram=?, dateofapproval=? WHERE id=?",
                program.getTitleOfProgram(),
                program.getProgramNumber(),
                program.getDuration(),
                program.getJobPosition().toString(),
                program.getDateOfApproval(),
                id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM safetytrainingprograms WHERE id=?", id);

    }
}
