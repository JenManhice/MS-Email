package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table (name = "email")
public class Email {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private String ownerRef;
    private  String emailFrom;
    private String emailTo;
    private String subject;
    @Column (columnDefinition = "TEXT")
    private String text;
    private LocalDate sendDateEmail;
    private StatusEmail statusEmail;
}

