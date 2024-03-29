package com.mycompany.mywebapp.jasperreport;

import com.mycompany.mywebapp.entity.Certification;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.repository.ProtocolRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRHibernateAbstractDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportService {

    @Autowired
    ProtocolRepository protocolRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    public String generateReport() {


        try {
            String reportPath = "C:\\Users\\Anato\\Desktop\\MyWebApp\\src\\main\\resources";

            Protocol protocol = (Protocol) protocolRepository.findAllById(1L);

            Set<Employee> employees = (Set<Employee>) protocol.getEmployees();
            Set<Employee> listEmployees = new HashSet<>();
            listEmployees.add(new Employee());
            for(Employee employee :employees){
                listEmployees.add(employee);
            }

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(listEmployees);


            Map<String, Object> parametrs = new HashMap();
            parametrs.put("Chairman",protocol.getChairman().toString());
            parametrs.put("OneMemberOfCommission",protocol.getOneMemberOfCommission().toString());
            parametrs.put("TwoMemberOfCommission",protocol.getTwoMemberOfCommission().toString());
            parametrs.put("ThreeMemberOfCommission",protocol.getThreeMemberOfCommission().toString());
            parametrs.put("FourMemberOfCommission",protocol.getFourMemberOfCommission().toString());
            parametrs.put("DateOfExamination",protocol.getDateOfExamination().toString());
            parametrs.put("CollectionBeanEmployee",jrBeanCollectionDataSource);

            // Compile the Jasper report from .jrxml to .japser
            JasperReport jasperReport = JasperCompileManager
//                    .compileReport(reportPath + "\\Protocol.jrxml");
                    .compileReport(reportPath + "\\Protocol.jrxml");

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


