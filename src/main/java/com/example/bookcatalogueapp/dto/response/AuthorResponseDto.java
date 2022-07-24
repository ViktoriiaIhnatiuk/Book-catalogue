package com.example.bookcatalogueapp.dto.response;

import lombok.Data;

@Data
public class AuthorResponseDto {

    private Long id;
    private String authorName;
    private String phone;
    private String email;
}
