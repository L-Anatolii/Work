package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.EmployeeDto;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.jdbc.dao.EmployeeDao;
import com.mycompany.mywebapp.сonverter.EmployeeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeConverter converter;


    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeDao.findAll();
        return converter.entityToDto(employees);
    }

    public void save(EmployeeDto employeeDto){
        employeeDao.save(converter.dtoToEntity(employeeDto));
    }

    public EmployeeDto findById(Long id) {
        Employee employee = employeeDao.findById(id);
        return converter.entityToDto(employee);
    }

    public void update(Long id, EmployeeDto employeeDto) {
        employeeDao.update(id, converter.dtoToEntity(employeeDto));
    }


    public void delete(Long id){
        employeeDao.delete(id);
    }

}
