package com.mycompany.mywebapp.jdbc.rowMapper;


import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setPatronymic(resultSet.getString("patronymic"));
        employee.setJobPosition(JobPositions.valueOf(resultSet.getString("job_position")));
        return employee;
    }
}
