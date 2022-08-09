package com.example.bookcatalogueapp.dto.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

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
