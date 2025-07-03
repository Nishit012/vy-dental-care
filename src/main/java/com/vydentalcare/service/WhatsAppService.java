package com.vydentalcare.service;

import com.vydentalcare.model.Appointment;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

@Service
public class WhatsAppService {

    @Value("${twilio.from.whatsapp}")
    private String fromWhatsapp;

    public void sendWhatsAppMessage(Appointment appointment) {
        String toWhatsapp = "whatsapp:+91" + appointment.getMobile();

        StringBuilder messageBody = new StringBuilder();
        messageBody.append("🦷 New Appointment Booked!\n")
                .append("👤 Name: ").append(appointment.getName()).append("\n")
                .append("📞 Mobile: ").append(appointment.getMobile()).append("\n")
                .append("📅 Day: ").append(appointment.getDay()).append("\n")
                .append("🕓 Slot: ").append(appointment.getTimeSlot()).append("\n")
                .append("⏰ Time: ").append(appointment.getAppointmentTime());

        Message message = Message.creator(
                new PhoneNumber(toWhatsapp),
                new PhoneNumber(fromWhatsapp),
                messageBody.toString()
        ).create();

        System.out.println("✅ WhatsApp Message Sent! SID: " + message.getSid());
    }
}