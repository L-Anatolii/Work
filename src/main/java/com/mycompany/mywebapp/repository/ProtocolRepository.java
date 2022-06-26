package com.mycompany.mywebapp.repository;

import com.mycompany.mywebapp.entity.Protocol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolRepository extends CrudRepository<Protocol, Long> {
    Long countById(Long id);
}
