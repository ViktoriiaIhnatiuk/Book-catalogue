package com.example.bookcatalogueapp.dto.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class BookRequestDto {
    @NotNull
    @NotBlank
    @NotEmpty
    private String bookName;
    @NotNull
    @Digits(integer = 300, fraction = 0)
    @Positive
    private Long authorId;
    @NotNull
    @Digits(integer = 300, fraction = 0)
    @Positive
    private Long publishedAmount;
    @NotNull
    @Digits(integer = 300, fraction = 0)
    @Positive
    private Long soldAmount;
}
