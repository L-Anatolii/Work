package com.mycompany.mywebapp;

import com.mycompany.mywebapp.entity.*;
import com.mycompany.mywebapp.сonverter.TypeConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


//@RunWith(SpringRunner.class)
@SpringBootTest
class MyWebAppApplicationTests {

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
////        long d = System.currentTimeMillis();
//////        Date date = new Date(repoDocument.get(1L).getDateOfApproval().getTime());
////        String stringDate = date.toString();
////        System.out.println(stringDate+" String");
////        System.out.println(Date.valueOf(stringDate)+" SQL");
////        System.out.println(Date.valueOf("2222-02-02")+" SQL");
////
////        SimpleDateFormat pattern = new SimpleDateFormat("dd.MM.yyyy");
////        System.out.println(pattern.format(repoDocument.get(1L).getDateOfApproval().getTime())+"новое");
//
////
////        String stringDate = d.toString();
////        System.out.println(d+" мое 2");
//
//
//    }
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Autowired
//    SafetyTrainingProgramRepository safetyTrainingProgramRepository;
//
//    @Autowired
//    CertificationRepository certificationRepository;
//
//    @Autowired
//    ProtocolRepository protocolRepository;
//
//    @Test
//    public void Protocol(){
//
////        Certification certification1 = new Certification();
////        certification1.setNumber(500);
////        Set<Certification> certifications1 = new HashSet<>();
////        certifications1.add(certification1);
////
////        SafetyTrainingProgram program1 = new SafetyTrainingProgram();
////        program1.setProgramNumber(11);
////        program1.setTitleOfProgram("Программа по обучению машиниста ТК");
////        program1.setDuration(56);
////        program1.setJobPosition(JobPositions.MASHINIST_TC);
////        program1.setDateOfApproval(Date.valueOf(LocalDate.now()));
////        program1.setCertifications(certifications1);
////        Set<SafetyTrainingProgram> safetyTrainingPrograms = new HashSet<>();
////        safetyTrainingPrograms.add(program1);
////
////
////        Protocol protocol1 = new Protocol();
////        protocol1.setChairman(JobPositions.GLAVNII_INJENER);
////        protocol1.setOneMemberOfCommission(JobPositions.NACHALNIK_ASUA_I_TM);
////        protocol1.setTwoMemberOfCommission(JobPositions.NACHALNIK_ATS);
////        protocol1.setThreeMemberOfCommission(JobPositions.NACHALNIK_DS);
////        protocol1.setFourMemberOfCommission(JobPositions.NACHALNIK_EHZ);
////        protocol1.setDateOfExamination(Date.valueOf(LocalDate.now()));
////        List<Protocol> protocols = new ArrayList<>();
////        protocols.add(protocol1);
////
////        Employee employee1 = new Employee();
////        employee1.setFirstName("Анатолий");
////        employee1.setLastName("Анатолий");
////        employee1.setPatronymic("Анатольевич");
////        employee1.setJobPosition(JobPositions.INJENER_PO_EOGO);
////        employee1.setPrograms(safetyTrainingPrograms);
////        employee1.setProtocols(protocols);
////
////
////        employeeRepository.save(employee1);
////        protocolRepository.save(protocol1);
////        safetyTrainingProgramRepository.save(program1);
////        certificationRepository.save(certification1);
////
//        Certification certification2 = new Certification();
//        certification2.setNumber(600);
//        Certification certification3 = new Certification();
//        certification3.setNumber(500);
//
//
//        SafetyTrainingProgram program2 = new SafetyTrainingProgram();
//        program2.setProgramNumber(17);
//        program2.setTitleOfProgram("Программа по обучению работ на высоте");
//        program2.setDuration(20);
//        program2.setJobPosition(JobPositions.GLAVNII_INJENER);
//        program2.setDateOfApproval(Date.valueOf(LocalDate.now()));
//        program2.setCertification(certification2);
//
//        SafetyTrainingProgram program3 = new SafetyTrainingProgram();
//        program3.setProgramNumber(11);
//        program3.setTitleOfProgram("Программа по обучению машиниста ТК");
//        program3.setDuration(56);
//        program3.setJobPosition(JobPositions.GLAVNII_INJENER);
//        program3.setDateOfApproval(Date.valueOf(LocalDate.now()));
//        program3.setCertification(certification3);
//
//        Set<SafetyTrainingProgram> safetyTrainingPrograms = new HashSet<>();
//        safetyTrainingPrograms.add(program2);
//        safetyTrainingPrograms.add(program3);
//
//        Employee employee2 = new Employee();
//        employee2.setFirstName("Андрей");
//        employee2.setLastName("Андрей");
//        employee2.setPatronymic("Андреевич");
//        employee2.setJobPosition(JobPositions.INJENER_PO_EOGO);
//        employee2.setPrograms(safetyTrainingPrograms);
//
//        Employee employee3 = new Employee();
//        employee3.setFirstName("Анатолий");
//        employee3.setLastName("Анатолий");
//        employee3.setPatronymic("Анатольевич");
//        employee3.setJobPosition(JobPositions.INJENER_PO_EOGO);
//        employee3.setPrograms(safetyTrainingPrograms);
//
//        List<Employee> employees = new ArrayList<>();
//        employees.add(employee2);
//        employees.add(employee3);
//
//
//        Protocol protocol2 = new Protocol();
//        protocol2.setChairman(JobPositions.GLAVNII_INJENER);
//        protocol2.setOneMemberOfCommission(JobPositions.NACHALNIK_ASUA_I_TM);
//        protocol2.setTwoMemberOfCommission(JobPositions.NACHALNIK_ATS);
//        protocol2.setThreeMemberOfCommission(JobPositions.NACHALNIK_DS);
//        protocol2.setFourMemberOfCommission(JobPositions.NACHALNIK_EHZ);
//        protocol2.setDateOfExamination(Date.valueOf(LocalDate.now()));
//        protocol2.setEmployees((List<Employee>) employeeRepository.findAll());
//
////        protocolRepository.save(protocol2);
//
//        employeeRepository.save(employee2);
//        employeeRepository.save(employee3);
////        safetyTrainingProgramRepository.save(program2);
////        safetyTrainingProgramRepository.save(program3);
////        certificationRepository.save(certification2);
////        certificationRepository.save(certification3);
//    }
//
//    @Autowired
//    SafetyTrainingProgramRepository safetyTrainingProgram;
//
//
//
//    @Test
//    public void Protocol2(){
//        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
//
//
//    }


}
