package com.mycompany.mywebapp.jasperreport;

import com.mycompany.mywebapp.dto.jasper.protocol.JRProtocolDto;
import com.mycompany.mywebapp.dto.jasper.protocol.SubJREmployeeDto;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.repository.ProtocolRepository;
import com.mycompany.mywebapp.сonverter.jasper.protocol.JRProtocolConverter;
import com.mycompany.mywebapp.сonverter.jasper.protocol.SubJREmployeeConverter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportProtocol {

    @Autowired
    ProtocolRepository protocolRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    JRProtocolConverter jrProtocolConverter;

    @Autowired
    SubJREmployeeConverter jrEmployeeConverter;
    public String generateReport() {

        try {
            String reportPath = "C:\\Users\\Tolik\\Desktop\\MyWebApp\\src\\main\\resources";

            Optional<Protocol> protocolRepo = protocolRepository.findById(1L);
            Protocol protocol = new Protocol();
            if(protocolRepo.isPresent()){
                protocol = protocolRepo.get();
            }
            JRProtocolDto jrProtocolDto = jrProtocolConverter.entityToDto(protocol);

            Optional<Employee> employeeRepo = employeeRepository.findById(1L);
            Employee employee = new Employee();
            if(employeeRepo.isPresent()){
                employee = employeeRepo.get();
            }
            SubJREmployeeDto subJREmployeeDto = jrEmployeeConverter.entityToDto(employee);

//            Employee employee = employeeRepository.findById(1L);


//            SubJREmployeeDto subJREmployeeDto = jrEmployeeConverter.entityToDto((Employee) protocol.getEmployees());

            List<JRProtocolDto> employees = new ArrayList<>();
            employees.add(jrProtocolDto);
//            employees.add((SubJREmployeeDto) jrProtocolDto.getSubReport());

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(employees);
            Map<String, Object> parametrs = new HashMap();
            parametrs.put("Chairman",jrProtocolDto.getChairman());
            parametrs.put("OneMemberOfCommission",jrProtocolDto.getOneMemberOfCommission());
            parametrs.put("TwoMemberOfCommission",jrProtocolDto.getTwoMemberOfCommission());
            parametrs.put("ThreeMemberOfCommission",jrProtocolDto.getThreeMemberOfCommission());
            parametrs.put("FourMemberOfCommission",jrProtocolDto.getFourMemberOfCommission());
            parametrs.put("DateOfExamination",protocol.getDateOfExamination());
            parametrs.put("CollectionBeanEmployee",jrBeanCollectionDataSource);

            // Compile the Jasper report from .jrxml to .japser
            JasperReport jasperReport = JasperCompileManager
//                    .compileReport(reportPath + "\\Protocol.jrxml");
                    .compileReport(reportPath + "\\Protocol с Dto.jrxml");

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametrs,jrBeanCollectionDataSource);


            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Протокол ОТ.pdf");
            System.out.println("Done");

            return "Report successfully generated @path= " + reportPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error--> check the console log";
        }
    }
}


