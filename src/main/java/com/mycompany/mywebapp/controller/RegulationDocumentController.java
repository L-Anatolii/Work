package com.mycompany.mywebapp.controller;

import com.mycompany.mywebapp.entity.RegulationDocument;
import com.mycompany.mywebapp.service.RegulationDocumentServise;
import com.mycompany.mywebapp.exception.RegulationDocumentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RegulationDocumentController {

    @Autowired
    private RegulationDocumentServise regulationDocumentServise;

    @GetMapping(value = "/regulationDocuments")
    public String showRegulationDocumentList(Model model) {
        List<RegulationDocument> listRegulationDocuments = regulationDocumentServise.listAll();
        model.addAttribute("listRegulationDocuments",listRegulationDocuments);
        return "regulationDocuments";
    }

    @GetMapping(value = "/regulationDocuments/new")
    public String showNewForm(Model model){
        model.addAttribute("regulationDocument", new RegulationDocument());
        model.addAttribute("pageTitle", "Add new Regulation document");
        return "regulationDocument_form";
    }

    @GetMapping(value = "/regulationDocuments/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra){
        try{
            RegulationDocument regulationDocument =  regulationDocumentServise.get(id);
            model.addAttribute("regulationDocument", regulationDocument);
            model.addAttribute("pageTitle", "Edit Regulation document (ID:" + id + ")");
            return "regulationDocument_form";
        }catch (RegulationDocumentNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/regulationDocuments";
        }
    }

    @GetMapping("/regulationDocuments/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            regulationDocumentServise.delete(id);
            ra.addFlashAttribute("message",  "The Regulation documents (ID:" + id + ") has been deleted" );
        } catch (RegulationDocumentNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/regulationDocuments";

    }

}
