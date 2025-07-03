package com.vydentalcare.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String sex;
    private String email;
    private String mobile;
    private String address;
    private String timeSlot;
    private String remark;
    private String day;
    private String appointmentTime;

}