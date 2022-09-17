package com.mycompany.mywebapp.jasperreport;

import com.mycompany.mywebapp.dto.jasper.protocol.JRProtocolDto;
import com.mycompany.mywebapp.dto.jasper.protocol.SubJREmployeeDto;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.repository.ProtocolRepository;
import com.mycompany.mywebapp.сonverter.jasper.protocol.JRProtocolConverter;
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
    JRProtocolConverter jrProtocolConverter;
    @Autowired
    EmployeeRepository employeeRepository;

    public String fullName(Long employee){
        Optional<Employee> person = employeeRepository.findById(employee);
        StringBuilder str = new StringBuilder();
        if(person.isPresent()){
            Employee emp = person.get();
            str.append(emp.getFirstName().substring(0, 1)+".");
            str.append(emp.getPatronymic().substring(0, 1)+". ");
            str.append(emp.getLastName());
        }
        return str.toString();
    }
    public String employeeWithPosition(Long employee){
        Optional<Employee> person = employeeRepository.findById(employee);
        StringBuilder str = new StringBuilder();
        if(person.isPresent()){
            Employee emp = person.get();
            str.append(emp.getLastName()+" ");
            str.append(emp.getFirstName()+" ");
            str.append(emp.getPatronymic()+" - ");
            String[] arr = emp.getPosition().getName().split(" ");
            for(int i = 0; i < arr.length; i ++)
            {
                if(i==0){
                    str.append(arr[i].toLowerCase()+" ");
                }
                if(i!=0){
                    str.append(arr[i]+" ");
                }
            }
        }
        return str.toString();
    }
    public String generateReport() {

        try {
            String reportPath = "C:\\Users\\Anato\\Desktop\\MyWebApp\\src\\main\\resources";

            Optional<Protocol> protocolRepo = protocolRepository.findById(1L);
            Protocol protocol = new Protocol();
            if(protocolRepo.isPresent()){
                protocol = protocolRepo.get();
            }
            JRProtocolDto jrProtocolDto = jrProtocolConverter.entityToDto(protocol);
            List<SubJREmployeeDto> employees = new ArrayList<>();
            employees.add(new SubJREmployeeDto());
            for (SubJREmployeeDto subEmployees: jrProtocolDto.getSubReport()){
                employees.add(subEmployees);
            }

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(employees);
            Map<String, Object> parametrs = new HashMap();
            parametrs.put("DateOfExamination",protocol.getDateOfExamination());
            parametrs.put("Chairman",employeeWithPosition(jrProtocolDto.getChairman()));
            parametrs.put("OneMemberOfCommission",employeeWithPosition(jrProtocolDto.getOneMemberOfCommission()));
            parametrs.put("TwoMemberOfCommission",employeeWithPosition(jrProtocolDto.getTwoMemberOfCommission()));
            parametrs.put("ThreeMemberOfCommission",employeeWithPosition(jrProtocolDto.getThreeMemberOfCommission()));
            parametrs.put("FourMemberOfCommission",employeeWithPosition(jrProtocolDto.getFourMemberOfCommission()));
            parametrs.put("FullNameChairman",fullName(jrProtocolDto.getChairman()));
            parametrs.put("FullNameOneMemberOfCommission",fullName(jrProtocolDto.getOneMemberOfCommission()));
            parametrs.put("FullNameTwoMemberOfCommission",fullName(jrProtocolDto.getTwoMemberOfCommission()));
            parametrs.put("FullNameThreeMemberOfCommission",fullName(jrProtocolDto.getThreeMemberOfCommission()));
            parametrs.put("FullNameFourMemberOfCommission",fullName(jrProtocolDto.getFourMemberOfCommission()));
            parametrs.put("CollectionBeanEmployee",jrBeanCollectionDataSource);

            // Compile the Jasper report from .jrxml to .japser
            JasperReport jasperReport = JasperCompileManager
//                    .compileReport(reportPath + "\\Protocol.jrxml");
                    .compileReport(reportPath + "\\Protocol с Dto(list inner list).jrxml");
//                    .compileReport(reportPath + "\\Protocol с Dto.jrxml");
//                    .compileReport(reportPath + "\\Group.jrxml");

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


