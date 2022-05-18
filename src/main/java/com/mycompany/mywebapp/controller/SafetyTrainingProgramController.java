package com.mycompany.mywebapp.controller;

import com.mycompany.mywebapp.dto.EmployeeDto;
import com.mycompany.mywebapp.dto.SafetyTrainingProgramDto;
import com.mycompany.mywebapp.entity.SafetyTrainingProgram;
import com.mycompany.mywebapp.exception.ProgramNotFoundException;
import com.mycompany.mywebapp.service.SafetyTrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SafetyTrainingProgramController {

    @Autowired
    private SafetyTrainingProgramService programService;

    @GetMapping(value = "/programs")
    public String showProgramList(Model model) {
        List<SafetyTrainingProgramDto> listPrograms = programService.getAllPrograms();
        model.addAttribute("listPrograms",listPrograms);
        return "programs";
    }

    @GetMapping(value = "/programs/new")
    public String showNewForm(Model model){
        model.addAttribute("program", new SafetyTrainingProgramDto());
        model.addAttribute("pageTitle", "Add new Program");
        return "program_create";
    }
    @PostMapping("/programs/save")
    public String saveProgram(SafetyTrainingProgramDto programDto, RedirectAttributes ra) {
        programService.save(programDto);
        ra.addFlashAttribute("message", "The program has been saved successfully.");
        return "redirect:/programs";
    }

    @GetMapping(value = "/programs/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra){
            SafetyTrainingProgramDto program =  programService.findById(id);
            model.addAttribute("program", program);
            model.addAttribute("pageTitle", "Edit Program (ID:" + id + ")");
            return "program_update";
    }

    @PostMapping(value = "/programs/update")
    public String updateForm(SafetyTrainingProgramDto programDto, RedirectAttributes ra){
        programService.update(programDto.getProgramId(), programDto);
        return "redirect:/programs";
    }

    @GetMapping("/programs/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, RedirectAttributes ra) {
        programService.delete(id);
        ra.addFlashAttribute("message",  "The Employee (ID:" + id + ") has been deleted" );
        return "redirect:/programs";

    }

}
