package com.mycompany.mywebapp.repository;

import com.mycompany.mywebapp.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Long countById(Long id);
}
