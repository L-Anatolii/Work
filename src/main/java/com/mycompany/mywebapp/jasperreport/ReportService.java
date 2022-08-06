package com.mycompany.mywebapp.jasperreport;

import com.mycompany.mywebapp.entity.Employee;
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

            // Get your data source
//            List<Employee> list = (List<Employee>) employeeRepository.findAll();
//            Optional<Employee> employee = employeeRepository.findById(1l);
//            Employee employee1 = employee.get();
//            list.add(employee1);
//            for(Employee employee6 : employeeRepository.findAll() ){
//                Employee employee4 = new Employee();
//                employee4.setId(employee6.getId());
//                employee4.setFirstName(employee6.getFirstName());
//                employee4.setLastName(employee6.getLastName());
//                employee4.setPatronymic(employee6.getPatronymic());
//                list.add(employee4);
//            }
            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
            for (Employee employee : employeeRepository.findAll()) {
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("id", employee.getId());
                item.put("firstName", employee.getFirstName());
                item.put("lastName", employee.getLastName());
                item.put("patronymic", employee.getPatronymic());
                result.add(item);
            }


            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(result);


            // Compile the Jasper report from .jrxml to .japser
            JasperReport jasperReport = JasperCompileManager
//                    .compileReport(reportPath + "\\Simple_Blue.jrxml");
                    .compileReport(reportPath + "\\Protocol.jrxml");

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,
                    jrBeanCollectionDataSource);

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Протокол ОТ.pdf");
//            JRSaver.saveObject();
            System.out.println("Done");

            return "Report successfully generated @path= " + reportPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error--> check the console log";
        }
    }
}


