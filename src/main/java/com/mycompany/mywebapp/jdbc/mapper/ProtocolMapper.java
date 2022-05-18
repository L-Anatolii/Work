package com.mycompany.mywebapp.jdbc.mapper;

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
        protocol.setDateOfExamination(resultSet.getDate("dateofexamination"));
        protocol.setChairman(JobPositions.valueOf(resultSet.getString("chairman")));
        protocol.setOneMemberOfCommission(JobPositions.valueOf(resultSet.getString("onememberofcommission")));
        protocol.setTwoMemberOfCommission(JobPositions.valueOf(resultSet.getString("twomemberofcommission")));
        protocol.setThreeMemberOfCommission(JobPositions.valueOf(resultSet.getString("threememberofcommission")));
        protocol.setFourMemberOfCommission(JobPositions.valueOf(resultSet.getString("fourmemberofcommission")));
        return protocol;
    }
}
