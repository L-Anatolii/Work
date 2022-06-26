package com.mycompany.mywebapp.jdbc.dao;

import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.jdbc.DAO;
import com.mycompany.mywebapp.jdbc.rowMapper.CertificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
    public Certification findById(Long certification_id) {
        return jdbcTemplate.query("SELECT * FROM certifications WHERE certification_id=?", new Object[]{certification_id}, new CertificationMapper()).
                stream().findAny().orElse(null);
    }

    @Override
    public void save(Certification certification) {
        jdbcTemplate.update("INSERT INTO certifications(number_certification) VALUES(?)",
                certification.getNumber());
    }

    @Override
    public void update(Long certification_id, Certification updateCertification) {
        jdbcTemplate.update("UPDATE certifications SET number_certification=? WHERE certification_id=?",
                updateCertification.getNumber(),
                certification_id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM certifications WHERE certification_id=?", id);
    }

//    public List<Certification> findByIdCertificationWithEmployees(Long certification_id){
//        return jdbcTemplate.query("SELECT * FROM certifications c, employees  WHERE c.certification_id=?",
//                new CertificationEmployeesExtractor(), certification_id);
//    }


}
