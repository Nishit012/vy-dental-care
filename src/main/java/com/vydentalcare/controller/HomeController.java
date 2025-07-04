package com.vydentalcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String appointmentSuccess(Model model) {
        model.addAttribute("message", "Appointment booked successfully!");
        return "index";
    }

}