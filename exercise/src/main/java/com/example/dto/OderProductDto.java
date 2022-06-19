package com.example.dto;


import com.example.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class OderProductDto implements Validator {

    Long id;

    @NotEmpty(message = "not null !! ")
    String dayBuy;

    Integer quantity;
    Product product;

    public OderProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayBuy() {
        return dayBuy;
    }

    public void setDayBuy(String dayBuy) {
        this.dayBuy = dayBuy;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        OderProductDto customerDto = (OderProductDto) (target);
        if (customerDto.quantity == null) {
            errors.rejectValue("quantity", "is.empty", "errors");
        } else if (customerDto.quantity < 0) {
            errors.rejectValue("quantity", "quantity.small", "errors");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = sdf.parse(customerDto.getDayBuy());
            Date date2 = sdf.parse(LocalDate.now().toString());

            System.out.println("Date1" + sdf.format(date1));
            System.out.println("Date2" + sdf.format(date2));
            System.out.println();
            if (date1.before(date2)) {
                errors.rejectValue("dayBuy", "day.errors", "errors !! ");
            }if (date1.equals(date2)) {
                errors.rejectValue("dayBuy", "day.equal", "errors !! ");
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}
