package com.mycompany.mywebapp.jdbc.mapper;

import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SafetyTrainingProgramMapper implements RowMapper<SafetyTrainingProgram> {
    @Override
    public SafetyTrainingProgram mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        SafetyTrainingProgram  program= new SafetyTrainingProgram();
        program.setId(resultSet.getLong("id"));
        program.setTitleOfProgram(resultSet.getString("titleofprogram"));
        program.setProgramNumber(resultSet.getInt("programNumber"));
        program.setDuration(resultSet.getInt("duration"));
        program.setJobPosition(JobPositions.valueOf(resultSet.getString("approvedtheprogram")));
        program.setDateOfApproval(resultSet.getDate("dateofapproval"));
        return program;

    }
}