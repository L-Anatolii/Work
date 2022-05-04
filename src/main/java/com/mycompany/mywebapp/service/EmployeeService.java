package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.EmployeeDto;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.EmployeeRepository;
import com.mycompany.mywebapp.exception.EmployeeNotFoundException;
import com.mycompany.mywebapp.сonverter.EmployeeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repoEmployee;

    @Autowired
    private EmployeeConverter converter;

    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = (List<Employee>) repoEmployee.findAll();
        return converter.entityToDto(employees);
    }

    public void save(EmployeeDto employeeDto){
        repoEmployee.save(converter.dtoToEntity(employeeDto));
    }

    public EmployeeDto get(Long id) throws EmployeeNotFoundException {
        Optional<Employee> result = repoEmployee.findById(id);
        if(result.isPresent()){
            return converter.entityToDto(result.get());
        }
        throw new EmployeeNotFoundException(("Could not find any employees with ID"+ id));
    }

    public void delete(Long id) throws EmployeeNotFoundException{
        Long count = repoEmployee.countById(id);
        if(count == null || count == 0){
            throw new EmployeeNotFoundException("Could not find any employees with ID"+ id);
        }
        repoEmployee.deleteById(id);
    }

}
