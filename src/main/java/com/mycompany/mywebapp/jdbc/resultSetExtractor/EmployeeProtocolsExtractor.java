//package com.mycompany.mywebapp.jdbc.resultSetExtractor;
//
//import com.mycompany.mywebapp.entity.Employee;
//import com.mycompany.mywebapp.entity.Protocol;
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
//public class EmployeeProtocolsExtractor implements ResultSetExtractor<List<Employee>> {
//    @Override
//    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
//        Map<Long, Employee> map = new HashMap();
//        Employee employee = null;
//        while (rs.next()) {
//            Long id = rs.getLong( "id");
//            employee = map.get(id);
//            if (employee == null) {
//                employee = new Employee();
//                employee.setId(id);
//                employee.setDateOfExamination(rs.getDate("date_of_examination" ));
//                employee.setChairman(JobPositions.valueOf(rs.getString("chairman")));
//                employee.setOneMemberOfCommission(JobPositions.valueOf(rs.getString("one_member_of_commission")));
//                employee.setTwoMemberOfCommission(JobPositions.valueOf(rs.getString("two_member_of_commission")));
//                employee.setThreeMemberOfCommission(JobPositions.valueOf(rs.getString("three_member_of_commission")));
//                employee.setFourMemberOfCommission(JobPositions.valueOf(rs.getString("four_member_of_commission")));
//                employee.setEmployees(new ArrayList<Employee>());
//                map.put(id, employee);
//            }
//            Long employeeId = rs.getLong("protocol_id");
//            if (employeeId > 0) {
//                Employee employee = new Employee();
//                employee.setId(employeeId);
//                employee.setProtocolId(id);
//                employee.setFirstName(rs.getString("first_name"));
//                employee.setLastName(rs.getString("last_name"));
//                employee.setPatronymic(rs.getString("patronymic"));
//                employee.setJobPosition(JobPositions.valueOf(rs.getString("job_position")));
//                employee.getEmployees().add(employee);
//            }
//        }
//        return new ArrayList<Protocol> (map.values());
//    }
//}
