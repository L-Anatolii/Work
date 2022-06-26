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

public class ProgramCertificationsExtractor implements ResultSetExtractor<List<SafetyTrainingProgram>> {

    @Override
    public List<SafetyTrainingProgram> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, SafetyTrainingProgram> map = new HashMap();
        SafetyTrainingProgram program = null;
        while (rs.next()) {
            Long id = rs.getLong( "id");
            program = map.get(id);
            if (program == null) {
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
            Long certificationId = rs.getLong("certification_id");
            if (certificationId > 0) {
                Certification certification = new Certification();
                certification.setCertification_id(certificationId);
                certification.setEmployee_id(rs.getLong("employee_id"));
                certification.setSafety_training_program_id(rs.getLong("safety_training_program_id"));
                certification.setNumber(rs.getInt("number_certification"));
                program.getCertifications().add(certification);
            }
        }
        return new ArrayList<SafetyTrainingProgram> (map.values());
    }
}
