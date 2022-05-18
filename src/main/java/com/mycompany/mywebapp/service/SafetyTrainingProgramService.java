package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.SafetyTrainingProgramDto;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.jdbc.dao.SafetyTrainingProgramDao;
import com.mycompany.mywebapp.сonverter.SafetyTrainingProgramConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafetyTrainingProgramService {

    @Autowired
    private SafetyTrainingProgramDao programDao;

    @Autowired
    private SafetyTrainingProgramConverter converter;

    public List<SafetyTrainingProgramDto> getAllPrograms(){
        List<SafetyTrainingProgram> programs = programDao.findAll();
        return converter.entityToDto(programs);
    }

    public void save(SafetyTrainingProgramDto program){
        programDao.save(converter.dtoToEntity(program));
    }

    public SafetyTrainingProgramDto findById(Long id){
        SafetyTrainingProgram program = programDao.findById(id);
        return converter.entityToDto(program);
    }

    public void update(Long id, SafetyTrainingProgramDto programDto) {
        programDao.update(id, converter.dtoToEntity(programDto));
    }
    public void delete(Long id){
        programDao.delete(id);
    }
}
