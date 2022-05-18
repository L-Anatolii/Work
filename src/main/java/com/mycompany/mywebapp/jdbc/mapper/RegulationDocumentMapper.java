package com.mycompany.mywebapp.jdbc.mapper;

import com.mycompany.mywebapp.entity.RegulationDocument;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegulationDocumentMapper implements RowMapper<RegulationDocument> {
    @Override
    public RegulationDocument mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        RegulationDocument  document= new RegulationDocument();
        document.setId(resultSet.getLong("id"));
        document.setDocumentNumber(resultSet.getInt("documentNumber"));
        document.setTitleOfDocument(resultSet.getString("titleofdocument"));
        document.setJobPosition(JobPositions.valueOf(resultSet.getString("approvedthedocument")));
        document.setDateOfApproval(resultSet.getDate("dateofapproval"));
        return document;
    }
}
