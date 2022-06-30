package com.mycompany.mywebapp;

import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.repository.SafetyTrainingProgramRepository;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class Hibernate {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    SafetyTrainingProgramRepository programRepository;

    @Test
    public void addEmployeeWithPrograms() {

        SafetyTrainingProgram program = new SafetyTrainingProgram();
        program.setTitleOfProgram("Машинист");
        program.setProgramNumber(17);
        program.setDuration(56);
        program.setApprovedTheProgram(JobPositions.INJENER_PO_REMONTU);
        program.setDateOfApproval(new Date());
        Set<SafetyTrainingProgram> safetyTrainingPrograms = new HashSet<>();
        safetyTrainingPrograms.add(program);

        Employee employee = new Employee();
        employee.setFirstName("Анатолий");
        employee.setLastName("Анатолий");
        employee.setPatronymic("Анатольевич");
        employee.setJobPosition(JobPositions.INJENER_PO_EOGO);
        employee.setPrograms(safetyTrainingPrograms);
        employeeRepository.save(employee);

    }
}
