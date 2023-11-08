package com.ms.email.services;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.Email;
import com.ms.email.repositories.EmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.time.LocalDate;

@Service
public class EmailService {
    @Autowired
    EmailRepo emailRepo;
    @Autowired
    private JavaMailSender emailSender;


    public Email sendEmail(Email email) {
        email.setSendDateEmail(LocalDate.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);
            System.out.println("sending");
            email.setStatusEmail(StatusEmail.SENT);
            System.out.println(email.getStatusEmail());
        }catch (MailException e ) {
            email.setStatusEmail(StatusEmail.ERROR);
            System.out.println(email.getStatusEmail());
        } finally {
            System.out.println("finally");
                    return emailRepo.save(email);

            }
            }

        }


