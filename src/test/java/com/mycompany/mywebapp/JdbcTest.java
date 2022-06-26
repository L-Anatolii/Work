package com.mycompany.mywebapp;

import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.exception.EmployeeNotFoundException;
import com.mycompany.mywebapp.jdbc.dao.CertificationDao;
import com.mycompany.mywebapp.jdbc.dao.EmployeeDao;
import com.mycompany.mywebapp.jdbc.dao.SafetyTrainingProgramDao;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.repository.SafetyTrainingProgramRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SafetyTrainingProgramRepository programRepository;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    SafetyTrainingProgramDao programDao;

    @Autowired
    CertificationDao certificationDao;


    @Test
    public void testOneToMany() throws EmployeeNotFoundException {
        employeeDao.findByIdEmployeeWithCertifications(1L);
//        System.out.println(certificationDao.findByIdCertificationWithEmployees(2L));
    }
    @Test
    public void testManyToMany1() throws EmployeeNotFoundException {
        employeeDao.findByIdEmployeesWithCertifications();
//        System.out.println(certificationDao.findByIdCertificationWithEmployees(2L));
    }
    @Test
    public void testManyToMany2() throws EmployeeNotFoundException {
        System.out.println( programDao.findByIdProgramsWithEmployees());
//        System.out.println(programDao.findByIdCertificationWithEmployees(2L));
    }


    @Test
    public void testRelationship(){
//        Employee employee = new Employee();
//        employee.setId(3L);
//        employee.setFirstName("Таня");
//        employee.setLastName("Таня");
//        employee.setPatronymic("Ивановна");
//        employee.setJobPosition(JobPositions.MASHINIST_TC);
//
//        employeeRepository.save(employee);
//
//        SafetyTrainingProgram program = new SafetyTrainingProgram();
//        program.setId(9L);
//        program.setProgramNumber(72);
//        program.setTitleOfProgram("слесарь");
//        program.setDuration(56);
//        program.setDateOfApproval(new Date());
//        program.setApprovedTheProgram(JobPositions.NACHALNIK_ASUA_I_TM);
//
//        program.addEmployee(employee);
//        programRepository.save(program);
//        for( SafetyTrainingProgram p: programRepository.findAll()){
//            System.out.println(employeeRepository.findAllById(p.getEmployeeIds()));
//        }
//
//        for( Employee e: employeeRepository.findAll()){
//            System.out.println(programRepository.findByProgramId(e.getId()));
//        }





    }
}
