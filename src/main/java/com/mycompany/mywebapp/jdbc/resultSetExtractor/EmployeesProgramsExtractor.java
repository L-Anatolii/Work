package com.mycompany.mywebapp.jdbc.resultSetExtractor;

import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeesProgramsExtractor implements ResultSetExtractor<List<Employee>> {
    @Override
    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Employee> map = new HashMap();
        Employee employee = null;
        while (rs.next()) {
            Long id = rs.getLong( "id");
            if(!map.containsKey(id)) {
                employee = new Employee();
                employee.setId(id);
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setPatronymic(rs.getString("patronymic"));
                employee.setJobPosition(JobPositions.valueOf(rs.getString("job_position")));
                employee.setCertifications(new ArrayList<Certification>());
                employee.setPrograms(new ArrayList<SafetyTrainingProgram>());
                map.put(id, employee);
            }
            Employee employeeId = map.get(id);
            Long certificationId = rs.getLong("certification_id");
            if (certificationId > 0) {
                Certification certification = new Certification();
                certification.setCertification_id(certificationId);
                certification.setEmployee_id(rs.getLong("employee_id"));
                certification.setSafety_training_program_id(rs.getLong("safety_training_program_id"));
                certification.setNumber(rs.getInt("number_certification"));
                employeeId.getCertifications().add(certification);
            }
            Long programId = rs.getLong("program_id");
            if (programId > 0) {
                SafetyTrainingProgram program = new SafetyTrainingProgram();
                program.setId(programId);
                program.setTitleOfProgram(rs.getString("title_of_program"));
                program.setProgramNumber(rs.getInt("program_number"));
                program.setDuration(rs.getInt("duration"));
                program.setApprovedTheProgram(JobPositions.valueOf(rs.getString("approved_the_program")));
                program.setDateOfApproval(rs.getDate("date_of_approval"));
                employeeId.getPrograms().add(program);
            }
        }
                map.forEach((key, value) -> {
                value = value;
                System.out.println(key + "=" + value);
                });
        return new ArrayList<Employee> (map.values());

    }
}
//===================Для вывода ResulSetExtractor================

//        System.out.println(map.values());

//        int columns = rs.getMetaData().getColumnCount();
//        while(rs.next()){
//            for (int i = 1; i <= columns; i++){
//                System.out.print(rs.getString(i) + "\t");
//            }
//            System.out.println();
//        }

//        map.forEach((key, value) -> {
//                value = value;
//                System.out.println(key + "=" + value);
//                });