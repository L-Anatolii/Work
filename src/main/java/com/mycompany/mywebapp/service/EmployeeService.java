package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.EmployeeDto;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.exception.EmployeeNotFoundException;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.сonverter.EmployeeConverter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeConverter converter;

    @Transactional
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        return converter.entityToDto(employees);
    }
    @Transactional
    public void save(EmployeeDto employeeDto){
        employeeRepository.save(converter.dtoToEntity(employeeDto));
    }
    @Transactional()
    public void saves(Employee employee){
        employeeRepository.save(employee);
    }
    @Transactional
    public EmployeeDto findById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return converter.entityToDto(employee.get());
        }
        throw new EmployeeNotFoundException(("Could not find any employees with ID"+ id));
    }

    @Transactional(readOnly = true)
    public Employee findByIdWithCertifications(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employeeProxy = employeeRepository.findById(id);
        if(employeeProxy.isPresent()){
            Employee employee = employeeProxy.get();
            Hibernate.initialize(employee.getCertifications());
            return employee;
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
