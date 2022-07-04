package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.EmployeeDto;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.exception.EmployeeNotFoundException;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.сonverter.EmployeeConverter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeConverter converter;

    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        return converter.entityToDto(employees);
    }

    public void save(EmployeeDto employeeDto){
        employeeRepository.save(converter.dtoToEntity(employeeDto));
    }

    public EmployeeDto findById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return converter.entityToDto(employee.get());
        }
        throw new EmployeeNotFoundException(("Could not find any employees with ID"+ id));
    }

    public void delete(Long id) throws EmployeeNotFoundException{
        Long count = employeeRepository.countById(id);
        if(count == null || count == 0){
            throw new EmployeeNotFoundException("Could not find any employees with ID"+ id);
        }
        employeeRepository.deleteById(id);
    }

}
