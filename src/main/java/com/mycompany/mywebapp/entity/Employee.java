package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table("employees")
@Data
@AllArgsConstructor
public class Employee {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private JobPositions jobPosition;


    private List<Certification> certifications = new ArrayList<>();

    private List<SafetyTrainingProgram> programs = new ArrayList<>();



    public Employee() {

    }


//   private Set<SafetyTrainingProgram> programs = new HashSet<>();
//
//   public void addProgram(SafetyTrainingProgram program) {
//       programs.add(program);
//       program.getEmployees().add(this);
//   }
//   public void removeProgram(SafetyTrainingProgram program) {
//       programs.remove(program);
//       program.getEmployees().remove(this);
//   }





}
