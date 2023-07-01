package com.amcef.assignment.apiapp.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PostDTO {


    @NotNull(message = "userId cannot be null")
    @Positive(message = "userId must be positive")
    private Integer userId;

    @NotBlank(message = "title cannot be blank")
    private String title;

    @NotBlank(message = "body cannot be blank")
    private String body;

}
