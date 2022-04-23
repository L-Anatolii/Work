package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.EmployeeRepository;
import com.mycompany.mywebapp.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repoEmployee;

    public List<Employee> listAll(){
        return (List<Employee>) repoEmployee.findAll();
    }

    public void save(Employee employee){
        repoEmployee.save(employee);
    }

    public Employee get(Long id) throws EmployeeNotFoundException {
        Optional<Employee> result = repoEmployee.findById(id);
        if(result.isPresent()){
            return result.get();
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
