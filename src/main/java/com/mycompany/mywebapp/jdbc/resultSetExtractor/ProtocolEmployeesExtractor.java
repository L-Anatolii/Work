package com.mycompany.mywebapp.jdbc.resultSetExtractor;

import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtocolEmployeesExtractor implements ResultSetExtractor<List<Protocol>> {
    @Override
    public List<Protocol> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Protocol> map = new HashMap();
        Protocol protocol = null;
        while (rs.next()) {
            Long id = rs.getLong( "id");
            protocol = map.get(id);
            if (protocol == null) {
                protocol = new Protocol();
                protocol.setId(id);
                protocol.setDateOfExamination(rs.getDate("date_of_examination" ));
                protocol.setChairman(JobPositions.valueOf(rs.getString("chairman")));
                protocol.setOneMemberOfCommission(JobPositions.valueOf(rs.getString("one_member_of_commission")));
                protocol.setTwoMemberOfCommission(JobPositions.valueOf(rs.getString("two_member_of_commission")));
                protocol.setThreeMemberOfCommission(JobPositions.valueOf(rs.getString("three_member_of_commission")));
                protocol.setFourMemberOfCommission(JobPositions.valueOf(rs.getString("four_member_of_commission")));
                protocol.setEmployees(new ArrayList<Employee>());
                map.put(id, protocol);
            }
            Long employeeId = rs.getLong("protocol_id");
            if (employeeId > 0) {
                Employee employee = new Employee();
                employee.setId(employeeId);
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setPatronymic(rs.getString("patronymic"));
                employee.setJobPosition(JobPositions.valueOf(rs.getString("job_position")));
                protocol.getEmployees().add(employee);
            }
        }
                return new ArrayList<Protocol> (map.values());
    }
}
