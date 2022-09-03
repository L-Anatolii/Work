package com.mycompany.mywebapp.сonverter.jasper.protocol;

import com.mycompany.mywebapp.dto.CertificationDto;
import com.mycompany.mywebapp.dto.SafetyTrainingProgramDto;
import com.mycompany.mywebapp.dto.jasper.protocol.JRProtocolDto;
import com.mycompany.mywebapp.dto.jasper.protocol.SubJRCertificationDto;
import com.mycompany.mywebapp.dto.jasper.protocol.SubJREmployeeDto;
import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.сonverter.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JRProtocolConverter {
    @Autowired
    TypeConverter converter;

    public JRProtocolDto entityToDto(Protocol protocol){
        JRProtocolDto dto = new JRProtocolDto();
        dto.setProtocolId(protocol.getId());
        dto.setDateOfExamination(converter.dateToString((Date) protocol.getDateOfExamination()));
        dto.setChairman(TypeConverter.enamToString(protocol.getChairman()));
        dto.setOneMemberOfCommission(TypeConverter.enamToString(protocol.getOneMemberOfCommission()));
        dto.setTwoMemberOfCommission(TypeConverter.enamToString(protocol.getTwoMemberOfCommission()));
        dto.setThreeMemberOfCommission(TypeConverter.enamToString(protocol.getThreeMemberOfCommission()));
        dto.setFourMemberOfCommission(TypeConverter.enamToString(protocol.getFourMemberOfCommission()));

        Set<Employee> employees = protocol.getEmployees();
        List<SubJREmployeeDto> subJREmployeeDtos = new ArrayList<>();
        for(Employee employee: employees){
            SubJREmployeeDto subJREmployeeDto = new SubJREmployeeDto();
            subJREmployeeDto.setEmployeeId(employee.getId());
            subJREmployeeDto.setFirstName(employee.getFirstName());
            subJREmployeeDto.setLastName(employee.getLastName());
            subJREmployeeDto.setPatronymic(employee.getPatronymic());

            Set<Certification> certifications = employee.getCertifications();
            List<SubJRCertificationDto> subJRCertificationDtos = new ArrayList<>();
            for(Certification certification : certifications){
                SubJRCertificationDto subJRCertificationDto = new SubJRCertificationDto();
                subJRCertificationDto.setEmployeeId(certification.getEmployee().getId());
                subJRCertificationDto.setProgramId(certification.getProgram().getId());
                subJRCertificationDto.setNumberCertification(certification.getNumber());
                subJRCertificationDto.setReason("Очередная");

                SafetyTrainingProgramDto programDto = new SafetyTrainingProgramDto();
                programDto.setApprovedTheProgram(certification.getProgram().getApprovedTheProgram().getName());
                programDto.setDuration(certification.getProgram().getDuration());
                programDto.setProgramNumber(certification.getProgram().getProgramNumber());
                programDto.setDateOfApproval(converter.dateToString(certification.getProgram().getDateOfApproval()));
                programDto.setTitleOfProgram(certification.getProgram().getTitleOfProgram());

                subJRCertificationDto.setProgramDto(programDto);
                subJRCertificationDtos.add(subJRCertificationDto);
            }
            subJREmployeeDto.setJasperCertification(subJRCertificationDtos);
            subJREmployeeDtos.add(subJREmployeeDto);
        }
        dto.setSubReport(subJREmployeeDtos);
        return dto;
    }
    public List<JRProtocolDto> entityToDto (List<Protocol> protocols){
        return protocols.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }
}
