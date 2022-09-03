package com.mycompany.mywebapp;

import com.mycompany.mywebapp.dto.jasper.protocol.SubJREmployeeDto;
import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.repository.ProtocolRepository;
import com.mycompany.mywebapp.service.jasper.JRProtocolService;
import com.mycompany.mywebapp.сonverter.jasper.protocol.JRProtocolConverter;
import com.mycompany.mywebapp.сonverter.jasper.protocol.SubJRCertificationConverter;
import com.mycompany.mywebapp.сonverter.jasper.protocol.SubJREmployeeConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class JRTest {

    @Autowired
    EmployeeRepository repository;
    @Autowired
    ProtocolRepository protocolRepository;
    @Autowired
    SubJRCertificationConverter subJRCertificationConverter;

    @Autowired
    SubJREmployeeConverter subJREmployeeConverter;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    JRProtocolConverter jrProtocolConverter;

    @Autowired
    JRProtocolService jrProtocolService;
    @Autowired
    SubJREmployeeConverter jrEmployeeConverter;
    @Test
    public void JRCertification() throws Exception {
        Optional<Employee> employee = repository.findById(1l);
        Set<Certification> certifications = new HashSet<>();
        certifications = employee.get().getCertifications();
        List<Certification> certificationList = new ArrayList<>();
        for(Certification certification: certifications){
            certificationList.add(certification);
        }
        System.out.println(subJRCertificationConverter.entityToDto(certificationList.get(1)));
    }

    @Test
    public void JREmployee() throws Exception {
        Optional<Employee> employeeRepo = employeeRepository.findById(1L);
        Employee employee = new Employee();
        if(employeeRepo.isPresent()){
            employee = employeeRepo.get();
        }
        SubJREmployeeDto subJREmployeeDto = jrEmployeeConverter.entityToDto(employee);
    }

    @Test
    public void JRProtocol() throws Exception {
        Optional<Protocol> protocol = protocolRepository.findById(1l);
        List<Protocol> protocols = new ArrayList<>();
        protocols.add(protocol.get());
        System.out.println(jrProtocolConverter.entityToDto((List<Protocol>) protocols));
    }

}
