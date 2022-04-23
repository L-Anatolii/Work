package com.mycompany.mywebapp;

import com.mycompany.mywebapp.entity.*;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;


//@RunWith(SpringRunner.class)
@SpringBootTest
class MyWebAppApplicationTests {

    @Autowired
    private EmployeeRepository repoEmployee;

    @Autowired
    private SafetyTrainingProgramRepository repoProgram;

    @Autowired
    private UserRepository repo;

    @Test
    public void contextLoads() {


        Employee employee = new Employee();
        employee.setFirstName("Иванов");
        employee.setLastName("Иван");
        employee.setPatronymic("Иванович");
        employee.setJobPosition(JobPositions.INJENER_PO_EOGO);

        SafetyTrainingProgram program = new SafetyTrainingProgram();

        program.setProgramNumber(72);
        program.setDuration(20);
        program.setTitleOfProgram("Слесарь по ремонту");
        program.setJobPosition(JobPositions.INJENER_PO_REMONTU);


        Set<SafetyTrainingProgram> safetyTrainingPrograms = new HashSet<>();
        safetyTrainingPrograms.add(program);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);

        program.setEmployees(employees);
        employee.setPrograms(safetyTrainingPrograms);

        repoEmployee.save(employee);
        repoProgram.save(program);
    }

}
