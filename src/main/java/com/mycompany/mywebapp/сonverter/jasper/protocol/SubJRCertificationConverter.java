package com.mycompany.mywebapp.сonverter.jasper.protocol;

import com.mycompany.mywebapp.dto.jasper.protocol.SubJRCertificationDto;
import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.сonverter.SafetyTrainingProgramConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SubJRCertificationConverter {
    @Autowired
    SafetyTrainingProgramConverter converter;

    public SubJRCertificationDto entityToDto(Certification certification){
        SubJRCertificationDto dto = new SubJRCertificationDto();
        dto.setNumberCertification(certification.getNumber());
        dto.setEmployeeId(certification.getEmployee().getId());
        dto.setProgramId(certification.getProgram().getId());
        dto.setProgramDto(converter.entityToDto(certification.getProgram()));
        dto.setReason(new String("Очередная"));
        return dto;
    }
    public List<SubJRCertificationDto> entityToDto (Set<Certification> certifications){
        return certifications.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }
}
