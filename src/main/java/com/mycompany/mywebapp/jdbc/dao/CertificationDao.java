package com.mycompany.mywebapp.jdbc.dao;

import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.jdbc.DAO;
import com.mycompany.mywebapp.jdbc.mapper.CertificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CertificationDao implements DAO<Certification, Long> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CertificationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Certification> findAll() {
        return jdbcTemplate.query("SELECT * FROM certifications", new CertificationMapper());
    }

    @Override
    public Certification findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM certifications WHERE id=?", new Object[]{id},new CertificationMapper()).
                stream().findAny().orElse(null);
    }

    @Override
    public void save(Certification certification) {
        jdbcTemplate.update("INSERT INTO certifications(number) VALUES(?)",
                certification.getNumber());
    }

    @Override
    public void update(Long id, Certification updateCertification) {
        jdbcTemplate.update("UPDATE employees SET firstname=?, lastname=?, patronymic=?, jobposition=? WHERE id=?",
                updateCertification.getNumber(),
                id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM certifications WHERE id=?", id);
    }
}
