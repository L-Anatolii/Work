package com.mycompany.mywebapp.jdbc.rowMapper;

import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProtocolMapper implements RowMapper<Protocol> {
    @Override
    public Protocol mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Protocol protocol = new Protocol();
        protocol.setId(resultSet.getLong("id"));
        protocol.setDateOfExamination(resultSet.getDate("date_of_examination"));
        protocol.setChairman(JobPositions.valueOf(resultSet.getString("chairman")));
        protocol.setOneMemberOfCommission(JobPositions.valueOf(resultSet.getString("one_member_of_commission")));
        protocol.setTwoMemberOfCommission(JobPositions.valueOf(resultSet.getString("two_member_of_commission")));
        protocol.setThreeMemberOfCommission(JobPositions.valueOf(resultSet.getString("three_member_of_commission")));
        protocol.setFourMemberOfCommission(JobPositions.valueOf(resultSet.getString("four_member_of_commission")));
        return protocol;
    }
}
