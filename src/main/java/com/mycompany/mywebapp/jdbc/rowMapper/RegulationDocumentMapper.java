package com.mycompany.mywebapp.jdbc.rowMapper;

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
        document.setDocumentNumber(resultSet.getInt("document_number"));
        document.setTitleOfDocument(resultSet.getString("title_of_document"));
        document.setApprovedTheDocument(JobPositions.valueOf(resultSet.getString("approved_the_document")));
        document.setDateOfApproval(resultSet.getDate("date_of_approval"));
        return document;
    }
}
