package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.entity.SafetyTrainingProgramRepository;
import com.mycompany.mywebapp.exception.ProgramNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SafetyTrainingProgramService {

    @Autowired
    private SafetyTrainingProgramRepository repoProgram;

    public List<SafetyTrainingProgram> listAll(){
        return (List<SafetyTrainingProgram>) repoProgram.findAll();
    }

    public void save(SafetyTrainingProgram program){
        repoProgram.save(program);
    }

    public SafetyTrainingProgram get(Long id) throws ProgramNotFoundException{
        Optional<SafetyTrainingProgram> result = repoProgram.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ProgramNotFoundException("Could not find any programs with ID"+ id);
    }

    public void delete(Long id) throws ProgramNotFoundException{
        Long count = repoProgram.countById(id);
        if(count == null || count == 0){
            throw new ProgramNotFoundException("Could not find any programs with ID"+ id);
        }
        repoProgram.deleteById(id);
    }
}
