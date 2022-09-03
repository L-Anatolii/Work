package com.mycompany.mywebapp.сonverter.jasper.protocol;

import com.mycompany.mywebapp.dto.jasper.protocol.SubJREmployeeDto;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.сonverter.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SubJREmployeeConverter {

    @Autowired
    SubJRCertificationConverter jrConverter;
    @Autowired
    SubJREmployeeDto subJREmployeeDto;

    public SubJREmployeeDto entityToDto(Employee employee){
        SubJREmployeeDto dto = new SubJREmployeeDto();
        dto.setEmployeeId(employee.getId());
        dto.setJobPosition(TypeConverter.enamToString(employee.getJobPosition()));
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setPatronymic(employee.getPatronymic());
//        dto.setJasperCertification(jrConverter.entityToDto(employee.getCertifications()));
        return dto;
    }
    public List<SubJREmployeeDto> entityToDto (Set<Employee> employees){
        return employees.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }



}
