package com.mycompany.mywebapp.controller;

import com.mycompany.mywebapp.dto.EmployeeDto;
import com.mycompany.mywebapp.dto.ProtocolDto;
import com.mycompany.mywebapp.jasperreport.ReportProtocol;
import com.mycompany.mywebapp.jasperreport.ReportService;
import com.mycompany.mywebapp.service.EmployeeService;
import com.mycompany.mywebapp.service.ProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProtocolController {

    @Autowired
    private ProtocolService protocolService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReportProtocol reportProtocol;
    @Autowired
    ReportService reportService;

    @GetMapping(value = "/protocols")
    public String showProtocolList(Model model) {
        List<ProtocolDto> listProtocols = protocolService.getAllProtocols();
        model.addAttribute("listProtocols",listProtocols);
        return "protocols";
    }

    @GetMapping(value = "/protocols/new")
    public String showNewForm(Model model){
        List<EmployeeDto> listEmployees = employeeService.getAllEmployees();
        model.addAttribute("listEmployees",listEmployees);
        model.addAttribute("protocol", new ProtocolDto());
        model.addAttribute("pageTitle", "Add new Protocol");
        return "protocol_create";
    }

    @PostMapping("/protocols/save")
    public String saveProtocol(ProtocolDto protocolDto, RedirectAttributes ra){
        protocolService.save(protocolDto);
        ra.addFlashAttribute("message", "The employee has been saved successfully.");
        return "redirect:/protocols";
    }
    @GetMapping(value = "/protocols/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) throws Exception {
        ProtocolDto protocol =  protocolService.findById(id);
        model.addAttribute("protocol", protocol);
        model.addAttribute("pageTitle", "Update Protocol (ID:" + id + ")");
        return "protocol_update";
    }


    @GetMapping("/protocols/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, RedirectAttributes ra) throws Exception {
        protocolService.delete(id);
        ra.addFlashAttribute("message",  "The Protocol (ID:" + id + ") has been deleted" );
        return "redirect:/protocols";

    }

    @GetMapping("/pdf")
    public String generatePdf(){
        reportProtocol.generateReport();
        return "redirect:/pdf1";
    }
}
