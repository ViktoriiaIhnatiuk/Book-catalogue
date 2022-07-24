package com.example.bookcatalogueapp.dto.response;

import lombok.Data;

@Data
public class BookResponseDto {
    private Long id;
    private String bookName;
    private Long authorId;
    private Long publishedAmount;
    private Long soldAmount;
}
