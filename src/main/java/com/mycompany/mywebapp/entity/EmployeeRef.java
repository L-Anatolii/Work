package com.mycompany.mywebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee_program")
@Data
@AllArgsConstructor
public class EmployeeRef {

    private Long employeeId;

}
