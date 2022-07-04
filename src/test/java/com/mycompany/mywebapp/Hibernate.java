package com.mycompany.mywebapp;

import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.repository.CertificationRepository;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.repository.SafetyTrainingProgramRepository;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class Hibernate {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    SafetyTrainingProgramRepository programRepository;
    @Autowired
    CertificationRepository certificationRepository;

    @Test
    public void addEmployeeWithPrograms(){
        SafetyTrainingProgram program = new SafetyTrainingProgram();
        program.setTitleOfProgram("Машинист");
        program.setProgramNumber(17);
        program.setDuration(56);
        program.setApprovedTheProgram(JobPositions.INJENER_PO_REMONTU);
        program.setDateOfApproval(new Date());
        programRepository.save(program);
        SafetyTrainingProgram program2 = new SafetyTrainingProgram();
        program2.setTitleOfProgram("Машинист");
        program2.setProgramNumber(17);
        program2.setDuration(56);
        program2.setApprovedTheProgram(JobPositions.INJENER_PO_REMONTU);
        program2.setDateOfApproval(new Date());
        programRepository.save(program2);
        SafetyTrainingProgram program3 = new SafetyTrainingProgram();
        program3.setTitleOfProgram("Машинист");
        program3.setProgramNumber(17);
        program3.setDuration(56);
        program3.setApprovedTheProgram(JobPositions.INJENER_PO_REMONTU);
        program3.setDateOfApproval(new Date());
        programRepository.save(program3);

        Employee employee = new Employee();
        employee.setFirstName("Анатолий");
        employee.setLastName("Анатолий");
        employee.setPatronymic("Анатольевич");
        employee.setJobPosition(JobPositions.INJENER_PO_EOGO);
        employeeRepository.save(employee);

        Certification certification = new Certification();
        certification.setEmployee(employee);
        certification.setProgram(program3);
        certification.setNumber(55);
        certificationRepository.save(certification);
    }

    @Test
    public void getAllCertification(){
        Employee employee = new Employee();
        employee = employeeRepository.findAllById(1L);
        Set<Certification> certifications = employee.getCertifications();
        for(Certification certification :certifications){
            System.out.println(certification.getNumber());
        }
    }
}
