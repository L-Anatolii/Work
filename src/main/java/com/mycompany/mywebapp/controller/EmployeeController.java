package com.mycompany.mywebapp.controller;

import com.mycompany.mywebapp.dto.EmployeeDto;
import com.mycompany.mywebapp.service.EmployeeService;
import com.mycompany.mywebapp.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public String showEmployeeList(Model model) {
        List<EmployeeDto> listEmployees = employeeService.getAllEmployees();
        model.addAttribute("listEmployees",listEmployees);
        return "employees";
    }

    @GetMapping(value = "/employees/new")
    public String showNewForm(Model model){
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("pageTitle", "Add new Employee");
        return "employee_create";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(EmployeeDto employeeDto, RedirectAttributes ra){
        employeeService.save(employeeDto);
        ra.addFlashAttribute("message", "The employee has been saved successfully.");
        return "redirect:/employees";
    }
    @GetMapping(value = "/employees/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra){
        EmployeeDto employee =  employeeService.findById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "Update Employee (ID:" + id + ")");
        return "employee_update";
    }

    @PostMapping(value = "/employees/update")
    public String updateForm(EmployeeDto employeeDto, RedirectAttributes ra){
        employeeService.update(employeeDto.getEmployeeId(), employeeDto);
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, RedirectAttributes ra) {
        employeeService.delete(id);
        ra.addFlashAttribute("message",  "The Employee (ID:" + id + ") has been deleted" );
        return "redirect:/employees";

    }

}
