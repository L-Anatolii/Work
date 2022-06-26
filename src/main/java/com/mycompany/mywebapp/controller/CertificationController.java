//package com.mycompany.mywebapp.controller;
//
//import com.mycompany.mywebapp.entity.Certification;
//import com.mycompany.mywebapp.exception.CertificationNotFoundException;
//import com.mycompany.mywebapp.service.CertificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.List;
//
//@Controller
//public class CertificationController {
//    @Autowired
//    private CertificationService certificationService;
//
//    @GetMapping(value = "/certifications")
//    public String showCertificationList(Model model) {
//        List<Certification> listCertification = certificationService.getAllCertifications();
//        model.addAttribute("listCertification",listCertification);
//        return "certifications";
//    }
//
//    @GetMapping(value = "/certifications/new")
//    public String showNewForm(Model model){
//        model.addAttribute("certification", new Certification());
//        model.addAttribute("pageTitle", "Add new Certification");
//        return "certification_create";
//    }
//
//    @PostMapping("/certifications/save")
//    public String saveEmployee(Certification certification, RedirectAttributes ra){
//        certificationService.save(certification);
//        ra.addFlashAttribute("message", "The employee has been saved successfully.");
//        return "redirect:/certifications";
//    }
//    @GetMapping(value = "/certifications/edit/{id}")
//    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) throws CertificationNotFoundException {
//        Certification certification =  certificationService.findById(id);
//        model.addAttribute("certification", certification);
//        model.addAttribute("pageTitle", "Update Certification (ID:" + id + ")");
//        return "certification_update";
//    }
//
//    @GetMapping("/certifications/delete/{id}")
//    public String showDeleteForm(@PathVariable("id") Long id, RedirectAttributes ra) throws CertificationNotFoundException {
//        certificationService.delete(id);
//        ra.addFlashAttribute("message",  "The Certification (ID:" + id + ") has been deleted" );
//        return "redirect:/certifications";
//
//    }
//}
