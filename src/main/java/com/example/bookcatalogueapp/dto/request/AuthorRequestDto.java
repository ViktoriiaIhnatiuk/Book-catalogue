package com.example.bookcatalogueapp.dto.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

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
