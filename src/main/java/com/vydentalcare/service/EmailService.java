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

//    public void sendEmail(Appointment appointment) {
//        //Appointment(id=7, name=NISHIT_GURU, age=25, sex=Male, email=nishitbhandvauri@gmail.com, mobile=6352617207, address=sadas, timeSlot=9 AM - 1 PM, remark=asdsad)
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom(appointment.getEmail());
//        msg.setTo("vydentalcare@gmail.com");
//        msg.setSubject("New Appointment Booking");
//
//        String content = "New appointment booked:\n\n" +
//                "Name: " + appointment.getName() + "\n" +
//                "Mobile: " + appointment.getMobile() + "\n" +
//                "Age: " + appointment.getAge() + "\n" +
//                "Sex: " + appointment.getSex() + "\n" +
//                "Address: " + appointment.getAddress() + "\n" +
//                "Time Slot: " + appointment.getTimeSlot();
//
//        msg.setText(content);
//        javaMailSender.send(msg);
//    }


    public void sendEmail(Appointment appointment) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(appointment.getEmail());
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