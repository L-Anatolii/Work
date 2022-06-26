package com.mycompany.mywebapp.jdbc.resultSetExtractor;

import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Example implements ResultSetExtractor<List<SafetyTrainingProgram>> {
    @Override
    public List<SafetyTrainingProgram> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, SafetyTrainingProgram> map = new HashMap();
        SafetyTrainingProgram program = null;
        while (rs.next()) {
            Long id = rs.getLong( "id");
            program = map.get(id);
            if(!map.containsKey(id)) {
                program = new SafetyTrainingProgram();
                program.setId(id);
                program.setTitleOfProgram(rs.getString("title_of_program" ));
                program.setProgramNumber((rs.getInt("program_number")));
                program.setDuration(rs.getInt("duration"));
                program.setApprovedTheProgram(JobPositions.valueOf(rs.getString("approved_the_program")));
                program.setDateOfApproval(rs.getDate("date_of_approval"));
                program.setCertifications(new ArrayList<Certification>());
                program.setEmployees(new ArrayList<Employee>());
                map.put(id, program);
            }
            SafetyTrainingProgram programId = map.get(id);
            Long certificationId = rs.getLong("certification_id");
            if (certificationId > 0) {
                Certification certification = new Certification();
                certification.setCertification_id(certificationId);
                certification.setEmployee_id(rs.getLong("employee_id"));
                certification.setSafety_training_program_id(rs.getLong("safety_training_program_id"));
                certification.setNumber(rs.getInt("number_certification"));
                programId.getCertifications().add(certification);

            }
            Long employeeId = rs.getLong("employee_id");
            if (employeeId > 0) {
                Employee employee = new Employee();
                employee.setId(employeeId);
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setPatronymic(rs.getString("patronymic"));
                employee.setJobPosition(JobPositions.valueOf(rs.getString("job_position")));
                employee.setCertifications(programId.getCertifications());
                employee.setPrograms((List<SafetyTrainingProgram>) map.get(id));
                programId.getEmployees().add(employee);
            }
        }
        map.forEach((key, value) -> {
            value = value;
            System.out.println(key + "=" + value);
        });
        return new ArrayList<SafetyTrainingProgram>(map.values());
    }
}
