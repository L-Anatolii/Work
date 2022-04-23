package com.mycompany.mywebapp.entity;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public Long countById(Long id);
}
