package com.input.demo.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class User {

    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;

    @Min(18)
    private int age;


}
