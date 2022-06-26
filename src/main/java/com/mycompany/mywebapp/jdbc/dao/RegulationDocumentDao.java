package com.mycompany.mywebapp.jdbc.dao;

import com.mycompany.mywebapp.entity.RegulationDocument;
import com.mycompany.mywebapp.jdbc.DAO;
import com.mycompany.mywebapp.jdbc.rowMapper.RegulationDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegulationDocumentDao implements DAO<RegulationDocument, Long> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RegulationDocumentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RegulationDocument> findAll() {
        return jdbcTemplate.query("SELECT * FROM regulationdocuments", new RegulationDocumentMapper());
    }

    @Override
    public RegulationDocument findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM regulationdocuments WHERE id=?", new Object[]{id},new RegulationDocumentMapper()).
                stream().findAny().orElse(null);
    }

    @Override
    public void save(RegulationDocument document) {
        jdbcTemplate.update("INSERT INTO regulationdocuments(document_number, title_of_document, approved_the_document, date_of_approval) VALUES(?,?,?,?)",
                document.getDocumentNumber(),
                document.getTitleOfDocument(),
                document.getApprovedTheDocument().toString(),
                document.getDateOfApproval());
    }

    @Override
    public void update(Long id, RegulationDocument updateDocument) {
        jdbcTemplate.update("UPDATE regulationdocuments SET document_number=?, title_of_document=?, approved_the_document=?, date_of_approval=? WHERE id=?",
                updateDocument.getDocumentNumber(),
                updateDocument.getTitleOfDocument(),
                updateDocument.getApprovedTheDocument().toString(),
                updateDocument.getDateOfApproval(),
                id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM regulationdocuments WHERE id=?", id);
    }
}
