package com.whattheflatmap.helloproblem;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestDto {
    @NotBlank(message = "Name is mandatory")
    private String name;
}
