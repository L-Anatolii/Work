package com.mycompany.mywebapp.сonverter;

import com.mycompany.mywebapp.dto.SafetyTrainingProgramDto;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SafetyTrainingProgramConverter {
    @Autowired
    TypeConverter converter;

    public SafetyTrainingProgramDto entityToDto(SafetyTrainingProgram program){
        SafetyTrainingProgramDto dto = new SafetyTrainingProgramDto();
        dto.setProgramId(program.getId());
        dto.setTitleOfProgram(program.getTitleOfProgram());
        dto.setProgramNumber(program.getProgramNumber());
        dto.setDuration(program.getDuration());
        dto.setApprovedTheProgram(TypeConverter.enamToString(program.getApprovedTheProgram()));
        dto.setDateOfApproval(converter.dateToString((Date) program.getDateOfApproval()));
        return dto;
    }

    public List<SafetyTrainingProgramDto> entityToDto (List<SafetyTrainingProgram> programs){
        return programs.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }

    public SafetyTrainingProgram dtoToEntity(SafetyTrainingProgramDto dto){
        SafetyTrainingProgram program =  new SafetyTrainingProgram();
        program.setId(dto.getProgramId());
        program.setTitleOfProgram(dto.getTitleOfProgram());
        program.setProgramNumber(dto.getProgramNumber());
        program.setDuration(dto.getDuration());
        program.setApprovedTheProgram(TypeConverter.StringToEnam(dto.getApprovedTheProgram()));
        program.setDateOfApproval(converter.stringToDate(dto.getDateOfApproval()));
        return program;
    }

    public List<SafetyTrainingProgram> dtoToEntity(List<SafetyTrainingProgramDto> dto){
        return dto.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());
    }
}
