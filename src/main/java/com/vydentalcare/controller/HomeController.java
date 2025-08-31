package com.vydentalcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        System.out.println("***************   Entering in index Html    ***************");
        return "index";
    }

    @GetMapping("/appointment")
    public String appointmentForm() {
        System.out.println("***************   Entering in appoinment Html   ***************");
        return "appointment_form";
    }

    @GetMapping("/appointment-success")
    public String appointmentSuccess(Model model,RedirectAttributes redirectAttributes) {
//        model.addAttribute("message", "Appointment booked successfully!");
        redirectAttributes.addFlashAttribute("message", "Appointment booked successfully!");
        return "redirect:/";
    }

}