package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.SafetyTrainingProgramDto;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.entity.SafetyTrainingProgramRepository;
import com.mycompany.mywebapp.exception.ProgramNotFoundException;
import com.mycompany.mywebapp.сonverter.EmployeeConverter;
import com.mycompany.mywebapp.сonverter.SafetyTrainingProgramConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SafetyTrainingProgramService {

    @Autowired
    private SafetyTrainingProgramRepository repoProgram;

    @Autowired
    private SafetyTrainingProgramConverter converter;

    public List<SafetyTrainingProgramDto> getAllPrograms(){
        List<SafetyTrainingProgram> programs = (List<SafetyTrainingProgram>) repoProgram.findAll();
        return converter.entityToDto(programs);
    }

    public void save(SafetyTrainingProgramDto program){
        repoProgram.save(converter.dtoToEntity(program));
    }

    public SafetyTrainingProgramDto get(Long id) throws ProgramNotFoundException{
        Optional<SafetyTrainingProgram> result = repoProgram.findById(id);
        if(result.isPresent()){
            return converter.entityToDto(result.get());
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
