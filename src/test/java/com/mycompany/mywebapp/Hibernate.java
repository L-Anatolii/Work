package com.mycompany.mywebapp;

import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.exception.EmployeeNotFoundException;
import com.mycompany.mywebapp.repository.CertificationRepository;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.repository.ProtocolRepository;
import com.mycompany.mywebapp.repository.SafetyTrainingProgramRepository;
import com.mycompany.mywebapp.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class Hibernate {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    SafetyTrainingProgramRepository programRepository;
    @Autowired
    CertificationRepository certificationRepository;
    @Autowired
    EmployeeService employeeService;

    @Autowired
    ProtocolRepository protocolRepository;

    @Test
    public void getEmployeeWithCertifications() throws EmployeeNotFoundException {
        Employee employee = employeeService.findByIdWithCertifications(1L);
        Set<Certification> certifications = employee.getCertifications();
        System.out.println(certifications);
        for(Certification certification :certifications){
            System.out.println(certification.getNumber());
        }
    }

    @Test
    public void getProtocolWithEmployees() throws EmployeeNotFoundException {
        Employee employee = employeeService.findByIdWithCertifications(1L);
        Protocol protocol = protocolRepository.findAllById(1l);
        Set<Protocol> protocols = new HashSet<>();
        protocols.add(protocol);
        employee.setProtocols(protocols);
        employeeService.saves(employee);
    }
    @Test
    public void findAllEmployee() throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findAllById(1L);
        Set<Protocol> protocols = employee.getProtocols();
        for (Protocol protocol : protocols){
            System.out.println(protocol.getFourMemberOfCommission());
        }
    }

    @Test
    public void findAllProtocol() throws EmployeeNotFoundException {
        Protocol protocol = protocolRepository.findAllById(1L);
        Set<Employee> employees = protocol.getEmployees();
        for (Employee employee : employees){
            System.out.println(employee.getFirstName());
        }
    }
}
