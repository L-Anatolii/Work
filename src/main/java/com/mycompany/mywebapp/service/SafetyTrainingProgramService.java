package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.SafetyTrainingProgramDto;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.exception.ProgramNotFoundException;
import com.mycompany.mywebapp.jdbc.dao.SafetyTrainingProgramDao;
import com.mycompany.mywebapp.repository.SafetyTrainingProgramRepository;
import com.mycompany.mywebapp.сonverter.SafetyTrainingProgramConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SafetyTrainingProgramService {

    @Autowired
    private SafetyTrainingProgramRepository programRepository;

    @Autowired
    private SafetyTrainingProgramConverter converter;

    public List<SafetyTrainingProgramDto> getAllPrograms(){
        List<SafetyTrainingProgram> programs = (List<SafetyTrainingProgram>) programRepository.findAll();
        return converter.entityToDto(programs);
    }

    public void save(SafetyTrainingProgramDto programDto){
        programRepository.save(converter.dtoToEntity(programDto));
    }

    public SafetyTrainingProgramDto findById(Long id) throws ProgramNotFoundException {
        Optional<SafetyTrainingProgram> result = programRepository.findById(id);
        if(result.isPresent()){
            return converter.entityToDto(result.get());
        }
        throw new ProgramNotFoundException("Could not find any programs with ID"+ id);
    }


    public void delete(Long id) throws ProgramNotFoundException {
        Long count = programRepository.countById(id);
        if(count == null || count == 0){
            throw new ProgramNotFoundException("Could not find any programs with ID"+ id);
        }
        programRepository.deleteById(id);
    }
}
