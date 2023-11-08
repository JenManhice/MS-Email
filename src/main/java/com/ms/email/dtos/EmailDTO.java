package com.ms.email.dtos;

import jakarta.validation.constraints.NotBlank;


public record EmailDTO (
        @NotBlank
                (message = "The reference cannot be blanck")
        String ownerRef,
        @NotBlank
                (message = "The email cannot be blanck")
        String emailFrom,
        @NotBlank
                (message = "The email receiver cannot be blanck")
        String emailTo,
        @NotBlank
                (message = "The subject cannot be blanck")
        String subject,
        @NotBlank
                (message = "The email body cannot be blanck")
        String text)
{


}
