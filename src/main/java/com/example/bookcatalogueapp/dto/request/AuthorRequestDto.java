package com.example.bookcatalogueapp.dto.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class AuthorRequestDto {
    @NotNull
    @NotBlank
    @NotEmpty
    private String authorName;
    @Positive
    @NotNull
    @Digits(integer = 20, fraction = 0)
    private String phone;
    private String email;
}
