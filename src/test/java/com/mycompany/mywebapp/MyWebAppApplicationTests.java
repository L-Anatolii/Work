//package com.mycompany.mywebapp;
//
//import com.mycompany.mywebapp.dto.EmployeeDto;
//import com.mycompany.mywebapp.entity.*;
//import com.mycompany.mywebapp.exception.RegulationDocumentNotFoundException;
//import com.mycompany.mywebapp.service.Positions.JobPositions;
//import com.mycompany.mywebapp.service.RegulationDocumentServise;
//import com.mycompany.mywebapp.сonverter.EmployeeConverter;
//import com.mycompany.mywebapp.сonverter.TypeConverter;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import java.sql.Date;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//
////@RunWith(SpringRunner.class)
//@SpringBootTest
//class MyWebAppApplicationTests {
//
//    @Autowired
//    private EmployeeRepository repoEmployee;
//
//    @Autowired
//    private SafetyTrainingProgramRepository repoProgram;
//
//    @Autowired
//    private UserRepository repo;
//
//    @Test
//    public void contextLoads() {
//
//
//        Employee employee = new Employee();
//        employee.setFirstName("Иванов");
//        employee.setLastName("Иван");
//        employee.setPatronymic("Иванович");
//        employee.setJobPosition(JobPositions.INJENER_PO_EOGO);
//
//        SafetyTrainingProgram program = new SafetyTrainingProgram();
//
//        program.setProgramNumber(72);
//        program.setDuration(20);
//        program.setTitleOfProgram("Слесарь по ремонту");
//        program.setJobPosition(JobPositions.INJENER_PO_REMONTU);
//
//
//        Set<SafetyTrainingProgram> safetyTrainingPrograms = new HashSet<>();
//        safetyTrainingPrograms.add(program);
//
//        Set<Employee> employees = new HashSet<>();
//        employees.add(employee);
//
//        program.setEmployees(employees);
//        employee.setPrograms(safetyTrainingPrograms);
//
//        repoEmployee.save(employee);
//        repoProgram.save(program);
//    }
//
//    @Test
//    public void dtoToEntity(){
//        Employee employee =  new Employee();
//        employee.setId(10L);
//        employee.setJobPosition(TypeConverter.StringToEnam("Начальник цеха"));
//        employee.setFirstName("Иван");
//        employee.setLastName("Иван");
//        employee.setPatronymic("Иван");
//        System.out.println(employee);
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId(10L);
//        employeeDto.setJobPosition(TypeConverter.enamToString(JobPositions.SLESAR_PO_REMONTU_TU));
//        employeeDto.setFirstName("Иван");
//        employeeDto.setLastName("Иван");
//        employeeDto.setPatronymic("Иван");
//        System.out.println(typeConverter.dtoToEntity(employeeDto));
//        System.out.println(employeeDto.getJobPosition());
//    }
//
//    @Autowired
//    EmployeeConverter typeConverter;
//
//    @Test
//    public void entityToDto(){
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId(10L);
//        employeeDto.setJobPosition(TypeConverter.enamToString(JobPositions.SLESAR_PO_REMONTU_TU));
//        employeeDto.setFirstName("Иван");
//        employeeDto.setLastName("Иван");
//        employeeDto.setPatronymic("Иван");
//        System.out.println(typeConverter.dtoToEntity(employeeDto));
//        System.out.println(employeeDto);
//    }
//
//    @Autowired
//    private RegulationDocumentServise repoDocument;
//
//    @Test
//    public void dateToString() throws RegulationDocumentNotFoundException{
//        GregorianCalendar cannes = new GregorianCalendar(2016, Calendar.AUGUST, 2);
//        cannes.set(Calendar.ERA, GregorianCalendar.BC);
//        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
//        System.out.println(df.format(cannes.getTime()));
//
//
////        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
////        Date date = new Date(1212121212121L);
////        Date d = (Date) repoDocument.get(1L).getDateOfApproval();
//////        System.out.println(formatter.format(d)+" мое");
////        System.out.println(formatter.format(d.getTime())+" мое");
//        long d = System.currentTimeMillis();
////        Date date = new Date(repoDocument.get(1L).getDateOfApproval().getTime());
//        String stringDate = date.toString();
//        System.out.println(stringDate+" String");
//        System.out.println(Date.valueOf(stringDate)+" SQL");
//        System.out.println(Date.valueOf("2222-02-02")+" SQL");
//
//        SimpleDateFormat pattern = new SimpleDateFormat("dd.MM.yyyy");
//        System.out.println(pattern.format(repoDocument.get(1L).getDateOfApproval().getTime())+"новое");
//
////
////        String stringDate = d.toString();
////        System.out.println(d+" мое 2");
//
//
//    }
//
//
//}
