package com.mycompany.mywebapp.repository;

import com.mycompany.mywebapp.entity.Protocol;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolRepository extends CrudRepository<Protocol, Long> {
    Long countById(Long id);

    @EntityGraph(value = "protocol-with-employees", type = EntityGraph.EntityGraphType.LOAD)
    Protocol findAllById(Long id);
}
