package com.mycompany.mywebapp.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificationRepository extends CrudRepository<Certification, Long> {

    public List<Certification> findAll();
}
