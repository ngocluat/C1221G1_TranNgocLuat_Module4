package com.validate_form.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {

    private Integer id;


    @NotEmpty(message = " Fistname cannot be blank ")

    @Size(min = 5, max = 45)
    private String fistName;

    @NotEmpty(message = "lastname cannot be blank")
    @Size(min = 5, max = 45)
    private String lastName;


    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = " Phone Sai định Dạng ")
    private String phoneNumber;

    //    @Range(min = 18, max = 170)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = " day of birth  cannot be left blank")
    private String dayOfBirh;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDayOfBirh() {
        return dayOfBirh;
    }

    public void setDayOfBirh(String dayOfBirh) {
        this.dayOfBirh = dayOfBirh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if ("luat".equals(userDto.getLastName())) {
            errors.rejectValue("lastName", "name.valid", "lỗi");
        }
    }
}
