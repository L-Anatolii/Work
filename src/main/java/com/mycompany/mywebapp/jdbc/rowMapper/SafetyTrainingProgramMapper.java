package com.mycompany.mywebapp.jdbc.rowMapper;

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
        program.setTitleOfProgram(resultSet.getString("title_of_program"));
        program.setProgramNumber(resultSet.getInt("program_number"));
        program.setDuration(resultSet.getInt("duration"));
        program.setApprovedTheProgram(JobPositions.valueOf(resultSet.getString("approved_the_program")));
        program.setDateOfApproval(resultSet.getDate("date_of_approval"));
        return program;

    }
}