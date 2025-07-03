package com.vydentalcare.controller;

import com.vydentalcare.model.Appointment;
import com.vydentalcare.repository.AppointmentRepository;
import com.vydentalcare.service.EmailService;
import com.vydentalcare.service.WhatsAppService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private WhatsAppService whatsAppService;

    @PostMapping("/submit-appointment")
    public String submitAppointment(@ModelAttribute Appointment appointment) {
        System.out.println("*****************    Received appointment: " + appointment.toString()+"     *******************");
        appointmentRepository.save(appointment);
        emailService.sendEmail(appointment);
        whatsAppService.sendWhatsAppMessage(appointment);
        System.out.println("***************   Entering in success Html   ***************");
        return "success";
    }
}