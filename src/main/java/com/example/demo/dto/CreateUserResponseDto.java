package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserResponseDto {

    private String message;
    private Long id;

}
