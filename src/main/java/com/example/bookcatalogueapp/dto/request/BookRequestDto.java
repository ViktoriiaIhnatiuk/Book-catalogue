package com.example.bookcatalogueapp.dto.request;

import lombok.Data;

@Data
public class BookRequestDto {
    private String bookName;
    private Long authorId;
    private Long publishedAmount;
    private Long soldAmount;
}
