package com.mycompany.mywebapp.entity;

import org.springframework.data.repository.CrudRepository;

public interface SafetyTrainingProgramRepository extends CrudRepository<SafetyTrainingProgram, Long> {

    public Long countById(Long id);


}
