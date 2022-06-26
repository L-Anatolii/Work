//package com.mycompany.mywebapp.jdbc.resultSetExtractor;
//
//import com.mycompany.mywebapp.entity.Certification;
//import com.mycompany.mywebapp.entity.Employee;
//import com.mycompany.mywebapp.service.Positions.JobPositions;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.ResultSetExtractor;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ProgramEmployeesExtractor implements ResultSetExtractor<List<Certification>> {
//
//    @Override
//    public List<Certification> extractData(ResultSet rs) throws SQLException, DataAccessException {
//        Map<Long, Certification> map = new HashMap();
//        Certification certification = null;
//        while (rs.next()) {
//            Long id = rs.getLong( "certification_id");
//            certification = map.get(id);
//            if (certification == null) {
//                certification = new Certification();
//                certification.setCertification_id(id);
//                certification.setEmployee_id(rs.getLong("employee_id" ));
//                certification.setSafety_training_program_id(rs.getLong("safety_training_program_id"));
//                certification.setNumber(rs.getInt("number_certification"));
//                certification.setEmployees(new ArrayList<Employee>());
//                map.put(id, certification);
//            }
//            Long employeeId = rs.getLong("id");
//            if (employeeId > 0) {
//                Employee employee = new Employee();
//                employee.setId(employeeId);
//                employee.setFirstName(rs.getString("first_name" ));
//                employee.setLastName(rs.getString("last_name"));
//                employee.setPatronymic(rs.getString("patronymic"));
//                employee.setJobPosition(JobPositions.valueOf(rs.getString("job_position")));
//                certification.getEmployees().add(employee);
//            }
//        }
//        return new ArrayList<Certification> (map.values());
//    }
//}
