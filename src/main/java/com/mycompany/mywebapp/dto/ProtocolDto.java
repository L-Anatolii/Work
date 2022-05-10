package com.mycompany.mywebapp.dto;

import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProtocolDto {

    private Long certificationId;
    private String dateOfExamination;
    private String firstNameEmployee;
    private String lastNameEmployee;
    private String patronymicEmployee;
    private String jobPositionEmployee;
    private String chairman;
    private String oneMemberOfCommission;
    private String twoMemberOfCommission;
    private String threeMemberOfCommission;
    private String fourMemberOfCommission;

    private Set<SafetyTrainingProgram> safetyTrainingPrograms;



}
