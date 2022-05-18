package com.mycompany.mywebapp.jdbc.dao;

import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.jdbc.DAO;
import com.mycompany.mywebapp.jdbc.mapper.EmployeeMapper;
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
    public List<Employee> findAll(){
        return jdbcTemplate.query("SELECT * FROM employees", new EmployeeMapper());
    }
    //+
    @Override
    public Employee findById(Long id){
        return jdbcTemplate.query("SELECT * FROM employees WHERE id=?", new Object[]{id},new EmployeeMapper()).
                stream().findAny().orElse(null);
    }
    //+
    @Override
    public void save(Employee employee) {
        jdbcTemplate.update("INSERT INTO employees(firstname, lastname, patronymic, jobposition) VALUES(?,?,?,?)",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPatronymic(),
                employee.getJobPosition().toString());
    }

    @Override
    public void update(Long id, Employee updateEmployee){
        jdbcTemplate.update("UPDATE employees SET firstname=?, lastname=?, patronymic=?, jobposition=? WHERE id=?",
                updateEmployee.getFirstName(),
                updateEmployee.getLastName(),
                updateEmployee.getPatronymic(),
                updateEmployee.getJobPosition().toString(),
                id);
    }
    //+
    @Override
    public void delete(Long id){
        jdbcTemplate.update("DELETE FROM employees WHERE id=?", id);
    }

}
