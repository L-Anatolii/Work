package com.mycompany.mywebapp.repository;

import com.mycompany.mywebapp.entity.Certification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationKeyRepo extends CrudRepository<Certification,Long> {
}
