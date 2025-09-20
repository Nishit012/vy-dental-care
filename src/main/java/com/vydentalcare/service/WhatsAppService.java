package com.vydentalcare.service;

import com.twilio.Twilio;
import com.vydentalcare.model.Appointment;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;


@Service
public class WhatsAppService {

    @Value("${twilio.from.whatsapp}")
    private String fromWhatsapp;
    @Value("${twilio.account.sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth.token}")
    private String AUTH_TOKEN;



    public void sendWhatsAppMessage(Appointment appointment) {
//        String toWhatsapp = "whatsapp:+91" + "6352617207";
        String toWhatsapp = "whatsapp:+91" + "9023591363";  //wp number where to send message

        StringBuilder messageBody = new StringBuilder();
        messageBody.append("🦷 New Appointment Booked!\n")
                .append("👤 Name: ").append(appointment.getName()).append("\n")
                .append("📞 Mobile: ").append(appointment.getMobile()).append("\n")
                .append("📅 Day: ").append(appointment.getDay()).append("\n")
                .append("🕓 Slot: ").append(appointment.getTimeSlot()).append("\n")
                .append("⏰ Time: ").append(appointment.getAppointmentTime());
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(toWhatsapp),
                new com.twilio.type.PhoneNumber(fromWhatsapp),
                messageBody.toString()
        ).create();


        System.out.println("✅ WhatsApp Message : " + message.getBody());
    }
}