package com.mycompany.mywebapp.controller;

import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.service.SafetyTrainingProgramService;
import com.mycompany.mywebapp.exception.ProgramNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SafetyTrainingProgramController {

    @Autowired
    private SafetyTrainingProgramService programService;

    @GetMapping(value = "/programs")
    public String showProgramList(Model model) {
        List<SafetyTrainingProgram> listPrograms = programService.listAll();
        model.addAttribute("listPrograms",listPrograms);
        return "programs";
    }

    @GetMapping(value = "/programs/new")
    public String showNewForm(Model model){
        model.addAttribute("program", new SafetyTrainingProgram());
        model.addAttribute("pageTitle", "Add new Program");
        return "program_form";
    }

    @GetMapping(value = "/programs/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra){
        try{
            SafetyTrainingProgram program =  programService.get(id);
            model.addAttribute("employee", program);
            model.addAttribute("pageTitle", "Edit Program (ID:" + id + ")");
            return "program_form";
        }catch (ProgramNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/programs";
        }
    }

    @GetMapping("/programs/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            programService.delete(id);
            ra.addFlashAttribute("message",  "The Employee (ID:" + id + ") has been deleted" );
        } catch (ProgramNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/programs";

    }

}
