//package com.mycompany.mywebapp;
//
//import com.mycompany.mywebapp.entity.Certification;
//import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
//import com.mycompany.mywebapp.repository.CertificationRepository;
//import com.mycompany.mywebapp.repository.SafetyTrainingProgramRepository;
//import com.mycompany.mywebapp.service.Positions.JobPositions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//
//@SpringBootTest
//public class New {
//
//    @Autowired
//    private SafetyTrainingProgramRepository programRepository;
//
//    @Autowired
//    private CertificationRepository certificationRepository;
//
//    @Test
//    public void contextLoads() {
//        Certification certification = new Certification();
//        certification.setId(null);
//        certification.setNumber(11);
//
//        SafetyTrainingProgram program = new SafetyTrainingProgram();
//
////        program.setId(null);
//        program.setTitleOfProgram("Машинист");
//        program.setDuration(56);
//        program.setProgramNumber(11);
//        program.setApprovedTheProgram(JobPositions.INJENER_PO_REMONTU);
//        program.setDateOfApproval(new Date());
////        program.setCertification(certification);
////        certificationRepository.save(certification);
////        programRepository.save(program);
////        System.out.println(programRepository.findAll());
//        programRepository.deleteById(3L);
//    }
//}
