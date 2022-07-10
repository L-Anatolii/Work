package com.mycompany.mywebapp.сonverter;

import com.mycompany.mywebapp.dto.EmployeeDto;
import com.mycompany.mywebapp.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {

    public EmployeeDto entityToDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployeeId(employee.getId());
        dto.setJobPosition(TypeConverter.enamToString(employee.getJobPosition()));
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setPatronymic(employee.getPatronymic());
//        dto.setCertification(employee.getCertifications());
        return dto;
    }

    public List<EmployeeDto> entityToDto (List<Employee> employees){
        return employees.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }

    public Employee dtoToEntity(EmployeeDto employeeDto){
        Employee employee =  new Employee();
        employee.setId(employeeDto.getEmployeeId());
        employee.setJobPosition(TypeConverter.StringToEnam(employeeDto.getJobPosition()));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setPatronymic(employeeDto.getPatronymic());
        return employee;
    }

    public List<Employee> dtoToEntity(List<EmployeeDto> dto){
        return dto.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());
    }


}
