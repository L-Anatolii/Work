package com.mycompany.mywebapp.controller;

import com.mycompany.mywebapp.service.MailSender;
import com.mycompany.mywebapp.jasperreport.ReportService;
import com.mycompany.mywebapp.service.UserService;
import com.mycompany.mywebapp.entity.User;
import com.mycompany.mywebapp.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class UserController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private UserService service;

    @Autowired
    private MailSender mailSender;

    @Autowired
    ReportService reportService;

    private static String UPLOADED_FOLDER = "C:/Users/Anato/Desktop";

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add new User");
        return "user_form";
    }

//    @PostMapping("/users/save")
//    public String saveUser(User user, RedirectAttributes ra) {
//        service.save(user);
//        ra.addFlashAttribute("message", "The user has been saved successfully.");
//        return "redirect:/users";
//    }

    @PostMapping("/users/save")
    public String saveUser(@RequestParam("email") String email,         @RequestParam("password") String password,
                           @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                           @RequestParam("enabled") Boolean enabled,    @RequestParam("file") MultipartFile file) throws IOException {
        User user = new User();
        if(file != null){
//          Через @Value("${upload.path}") передаю значение полю private String uploadPath и провераю директорию
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
//          Создаю имя файлу
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
//          Загруюжаю файл
            file.transferTo(new File(uploadDir + "/" + resultFilename));
            user.setFileName(resultFilename);
        }
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEnabled(enabled);
        service.save(user);
        return "redirect:/users";
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadStatus";
//        }

//        try {
//
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + "/"+ file.getOriginalFilename());
//            System.out.println(UPLOADED_FOLDER + "/" + file.getOriginalFilename());
//            Files.write(path, bytes);
//
////            redirectAttributes.addFlashAttribute("message",
////                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/users";
    }


    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            User user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (ID:" + id + ")");
            return "user_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }

    }

    @GetMapping("/users/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message",  "The User (ID:" + id + ") has been deleted" );
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";

    }

    @GetMapping("/users/sendmail/{id}")
    public String sendMail(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            User user = service.get(id);
            mailSender.send(user.getEmail(), "письмо", "привет");
            ra.addFlashAttribute("message",  "Письмо отправлено" );
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }
    @GetMapping("/pdf")
    @ResponseBody
    public String generatePdf(){
        reportService.generateReport();
        return "redirect:/users";

    }


}
