package com.mycompany.mywebapp.jdbc.dao;

import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.jdbc.DAO;
import com.mycompany.mywebapp.jdbc.mapper.ProtocolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProtocolDao implements DAO<Protocol, Long> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProtocolDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Protocol> findAll() {
        return jdbcTemplate.query("SELECT * FROM protocols", new ProtocolMapper());
    }

    @Override
    public Protocol findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM protocols WHERE id=?", new Object[]{id},new ProtocolMapper()).
                stream().findAny().orElse(null);
    }

    @Override
    public void save(Protocol protocol) {
        jdbcTemplate.update("INSERT INTO protocols(dateofexamination, " +
                                                        "chairman, " +
                                                        "onememberofcommission, " +
                                                        "twomemberofcommission, " +
                                                        "threememberofcommission, " +
                                                        "fourmemberofcommission) VALUES(?,?,?,?,?,?)",
                protocol.getDateOfExamination(),
                protocol.getChairman().toString(),
                protocol.getOneMemberOfCommission().toString(),
                protocol.getTwoMemberOfCommission().toString(),
                protocol.getThreeMemberOfCommission().toString(),
                protocol.getFourMemberOfCommission().toString());
    }

    @Override
    public void update(Long id, Protocol updateProtocol) {
        jdbcTemplate.update("UPDATE protocols SET dateofexamination=?, " +
                                                        "chairman=?, " +
                                                        "onememberofcommission=?, " +
                                                        "twomemberofcommission=? , " +
                                                        "threememberofcommission=?, " +
                                                        "fourmemberofcommission=? WHERE id=?",
                updateProtocol.getDateOfExamination(),
                updateProtocol.getChairman().toString(),
                updateProtocol.getOneMemberOfCommission().toString(),
                updateProtocol.getTwoMemberOfCommission().toString(),
                updateProtocol.getThreeMemberOfCommission().toString(),
                updateProtocol.getFourMemberOfCommission().toString(),
                id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM protocols WHERE id=?", id);

    }
}
