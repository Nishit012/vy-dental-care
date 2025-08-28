package com.vydentalcare.service;

import com.vydentalcare.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(Appointment appointment) {
        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo("vydentalcare@gmail.com");
        msg.setTo("nishitgamer0@gmail.com");
        msg.setSubject("New Appointment Booking");

        StringBuilder content = new StringBuilder();
        content.append("🦷 New appointment booked:\n\n")
                .append("👤 Name: ").append(appointment.getName()).append("\n")
                .append("📞 Mobile: ").append(appointment.getMobile()).append("\n")
                .append("🎂 Age: ").append(appointment.getAge()).append("\n")
                .append("⚧️ Sex: ").append(appointment.getSex()).append("\n")
                .append("📅 Day: ").append(appointment.getDay()).append("\n")
                .append("🕓 Time Slot: ").append(appointment.getTimeSlot()).append("\n")
                .append("⏰ Appointment Time: ").append(appointment.getAppointmentTime()).append("\n");

        if (appointment.getAddress() != null && !appointment.getAddress().isEmpty()) {
            content.append("🏠 Address: ").append(appointment.getAddress()).append("\n");
        }

        if (appointment.getRemark() != null && !appointment.getRemark().isEmpty()) {
            content.append("📝 Remark: ").append(appointment.getRemark()).append("\n");
        }

        msg.setText(content.toString());
        System.out.println("**************** email:   "+msg+"    sent successfully         *******************");
        javaMailSender.send(msg);
    }

}