package com.mycompany.mywebapp.jdbc.resultSetExtractor;

import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeCertificationsExtractor implements ResultSetExtractor<List<Employee>>{
    @Override
    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Employee> map = new HashMap();
        Employee employee = null;
        while (rs.next()) {
            Long id = rs.getLong( "id");
            employee = map.get(id);
            if (employee == null) {
                employee = new Employee();
                employee.setId(id);
                employee.setFirstName(rs.getString("first_name" ));
                employee.setLastName(rs.getString("last_name"));
                employee.setPatronymic(rs.getString("patronymic"));
                employee.setJobPosition(JobPositions.valueOf(rs.getString("job_position")));
                employee.setCertifications(new ArrayList<Certification>());
                map.put(id, employee);
            }
            Long certificationId = rs.getLong("certification_id");
            if (certificationId > 0) {
                Certification certification = new Certification();
                certification.setCertification_id(certificationId);
                certification.setEmployee_id(rs.getLong("employee_id"));
                certification.setSafety_training_program_id(rs.getLong("safety_training_program_id"));
                certification.setNumber(rs.getInt("number_certification"));
                employee.getCertifications().add(certification);
            }
        }
        return new ArrayList<Employee> (map.values());
    }
}
