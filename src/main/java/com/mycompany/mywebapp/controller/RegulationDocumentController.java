package com.mycompany.mywebapp.controller;

import com.mycompany.mywebapp.dto.EmployeeDto;
import com.mycompany.mywebapp.dto.RegulationDocumentDto;
import com.mycompany.mywebapp.entity.RegulationDocument;
import com.mycompany.mywebapp.service.RegulationDocumentServise;
import com.mycompany.mywebapp.exception.RegulationDocumentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RegulationDocumentController {

    @Autowired
    private RegulationDocumentServise regulationDocumentServise;

    @GetMapping(value = "/regulationDocuments")
    public String showRegulationDocumentList(Model model) {
        List<RegulationDocumentDto> listRegulationDocuments = regulationDocumentServise.getAllRegulationDocuments();
        model.addAttribute("listRegulationDocuments",listRegulationDocuments);
        return "regulationDocuments";
    }


    @GetMapping(value = "/regulationDocuments/new")
    public String showNewForm(Model model){
        model.addAttribute("regulationDocument", new RegulationDocumentDto());
        model.addAttribute("pageTitle", "Add new Regulation document");
        return "regulationDocument_create";
    }

    @PostMapping("/regulationDocuments/save")
    public String saveRegulationDocument(RegulationDocumentDto regulationDocumentDto, RedirectAttributes ra){
        regulationDocumentServise.save(regulationDocumentDto);
        ra.addFlashAttribute("message", "The regulation document has been saved successfully.");
        return "redirect:/regulationDocuments";
    }


    @GetMapping(value = "/regulationDocuments/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra){
            RegulationDocumentDto regulationDocument =  regulationDocumentServise.findById(id);
            model.addAttribute("regulationDocument", regulationDocument);
            model.addAttribute("pageTitle", "Edit Regulation document (ID:" + id + ")");
            return "regulationDocument_update";
    }

    @PostMapping(value = "/regulationDocuments/update")
    public String updateForm(RegulationDocumentDto documentDto, RedirectAttributes ra){
        regulationDocumentServise.update(documentDto.getDocumentId(), documentDto);
        return "redirect:/regulationDocuments";
    }

    @GetMapping("/regulationDocuments/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, RedirectAttributes ra) {
        regulationDocumentServise.delete(id);
        ra.addFlashAttribute("message",  "The Regulation documents (ID:" + id + ") has been deleted" );
        return "redirect:/regulationDocuments";

    }

}
