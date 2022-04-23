package com.mycompany.mywebapp.controller;

import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.service.EmployeeService;
import com.mycompany.mywebapp.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public String showEmployeeList(Model model) {
        List<Employee> listEmployees = employeeService.listAll();
        model.addAttribute("listEmployees",listEmployees);
        return "employees";
    }

    @GetMapping(value = "/employees/new")
    public String showNewForm(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("pageTitle", "Add new Employee");
        return "employee_form";
    }

    @GetMapping(value = "/employees/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra){
        try{
            Employee employee =  employeeService.get(id);
            model.addAttribute("employee", employee);
            model.addAttribute("pageTitle", "Edit Employee (ID:" + id + ")");
            return "eployee_form";
        }catch (EmployeeNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/employees";
        }
    }

    @GetMapping("/employees/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            employeeService.delete(id);
            ra.addFlashAttribute("message",  "The Employee (ID:" + id + ") has been deleted" );
        } catch (EmployeeNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/employees";

    }

}