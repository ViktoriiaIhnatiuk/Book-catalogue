package com.example.bookcatalogueapp.dto.request;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private String authorName;
    private String phone;
    private String email;
}
