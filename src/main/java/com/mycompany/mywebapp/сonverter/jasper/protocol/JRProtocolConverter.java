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
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.сonverter.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JRProtocolConverter {
    @Autowired
    TypeConverter converter;

    public JRProtocolDto entityToDto(Protocol protocol){
        JRProtocolDto dto = new JRProtocolDto();
        dto.setProtocolId(protocol.getId());
        dto.setDateOfExamination(converter.dateToString((Date) protocol.getDateOfExamination()));
        dto.setChairman(protocol.getChairman());
        dto.setOneMemberOfCommission(protocol.getOneMemberOfCommission());
        dto.setTwoMemberOfCommission(protocol.getTwoMemberOfCommission());
        dto.setThreeMemberOfCommission(protocol.getThreeMemberOfCommission());
        dto.setFourMemberOfCommission(protocol.getFourMemberOfCommission());

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
                subJRCertificationDto.setNumberCertification(certification.getNumber());
                subJRCertificationDto.setReason("Очередная");
                subJRCertificationDto.setTitleOfProgram(certification.getProgram().getTitleOfProgram());
                subJRCertificationDto.setApprovedTheProgram(certification.getProgram().getApprovedTheProgram().getName());
                subJRCertificationDto.setProgramNumber(certification.getProgram().getProgramNumber());
                subJRCertificationDto.setDuration(certification.getProgram().getDuration());
                subJRCertificationDto.setDateOfApproval(converter.dateToString(certification.getProgram().getDateOfApproval()));
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
