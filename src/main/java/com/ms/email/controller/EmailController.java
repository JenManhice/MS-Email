package com.ms.email.controller;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.dtos.ResponseAPI;
import com.ms.email.models.Email;
import com.ms.email.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/sending-email")
@RestController
@ResponseStatus(HttpStatus.OK)
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<ResponseAPI> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) throws Exception{
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);
        emailService.sendEmail(email);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseAPI("E-mail enviado com sucesso!", null));

    }
}
