package com.mycompany.mywebapp.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegulationDocumentRepository extends CrudRepository<RegulationDocument, Long> {


    @Query(value = "SELECT id, " +
                          "date_of_approval, " +
                          "(to_char(date_of_approval, 'dd.mm.yyyy')) as string_date_of_approval, " +
                          "document_number, " +
                          "approved_the_document, " +
                          "title_of_document " +
                   "FROM public.regulation_documents " +
                   "ORDER BY id ASC ", nativeQuery = true)
    public List<RegulationDocument> findAll();

    public Long countById(Long id);
}
