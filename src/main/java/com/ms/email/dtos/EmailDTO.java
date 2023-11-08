package com.ms.email.dtos;

import jakarta.validation.constraints.NotBlank;

public record EmailDTO (@NotBlank (message = "The reference cannot be blanck") String ownerRef, String emailFrom, String emailTo, String subject, String text) {


}
