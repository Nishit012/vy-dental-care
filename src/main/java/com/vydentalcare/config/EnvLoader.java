//package com.vydentalcare.config;
//
//import io.github.cdimascio.dotenv.Dotenv;
//import javax.annotation.PostConstruct;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class EnvLoader {
//
//    @PostConstruct
//    public void loadEnv() {
//        Dotenv dotenv = Dotenv.configure()
//                .filename(".env")
//                .ignoreIfMissing()
//                .load();
//
//        dotenv.entries().forEach(entry -> {
//            System.setProperty(entry.getKey(), entry.getValue());
//        });
//    }
//}
