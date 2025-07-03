package com.vydentalcare.config;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfig {

    private String accountSid;
    private String authToken;
    private String fromWhatsapp;

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, authToken);
    }

}
