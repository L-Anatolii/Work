package com.mycompany.mywebapp.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProtocolRepository extends CrudRepository<Protocol, Long> {

    @Query(value =  "SELECT  emp.first_name," +
                            "emp.last_name," +
                            "emp.patronymic," +
                            "emp.job_position," +
                            "stp.program_number," +
                            "stp.title_of_program," +
                            "stp.duration," +
                            "stp.approved_the_program," +
                            "stp.date_of_approval," +
                            "p.chairman," +
                            "p.one_member_of_commission," +
                            "p.two_member_of_commission," +
                            "p.three_member_of_commission," +
                            "p.four_member_of_commission," +
                            "p.date_of_examination" +
                            "FROM public.employees emp FULL JOIN  public.protocols p ON emp.protocol_id = p.id" +
                            "FULL JOIN public.employees_safety_training_program emstp ON emp.id = emstp.employee_id " +
                            "FULL JOIN public.safety_training_programs stp ON emstp.safety_training_program_id = stp.id"
                    , nativeQuery = true)
    public List<Protocol> findAllProtocols();



}
