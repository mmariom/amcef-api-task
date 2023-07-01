package com.amcef.assignment.apiapp.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdatePostDTO {



    @NotBlank(message = "title cannot be blank")
    private String title;

    @NotBlank(message = "body cannot be blank")
    private String body;

}
