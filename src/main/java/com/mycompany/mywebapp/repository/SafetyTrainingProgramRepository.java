package com.mycompany.mywebapp.repository;

import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SafetyTrainingProgramRepository extends CrudRepository<SafetyTrainingProgram, Long> {
    Long countById(Long id);

    @Query("SELECT s.* " +
            "FROM safety_training_programs s " +
            "JOIN employee_program ep ON s.id=ep.safety_training_program_id " +
            "WHERE ep.safety_training_program_id = :id")
    Set<SafetyTrainingProgram> findByProgramId(@Param("id") Long id);
}
