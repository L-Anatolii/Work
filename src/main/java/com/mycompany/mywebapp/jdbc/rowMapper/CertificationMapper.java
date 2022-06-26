package com.mycompany.mywebapp.jdbc.rowMapper;

import com.mycompany.mywebapp.entity.Certification;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CertificationMapper implements RowMapper<Certification> {
    @Override
    public Certification mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Certification certification = new Certification();
//        certification.setId(resultSet.getLong("id"));
        certification.setNumber(resultSet.getInt("number"));
        return certification;
    }
}
