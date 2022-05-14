package com.product.managerment_product.dot;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;


public class ProductDto implements Validator {


    Integer id;


    @NotEmpty
    String productCode;


    @NotEmpty(message = "name product not empty !!")
    String nameProduct;


    @Length(max = 300, message = "description of product has length no exceed 300 character")
    String description;

    Double price;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "is empty ")
    @Column(columnDefinition = "DATE")
    String dayManufacturing;


    private List<String> listProductCode;


    public ProductDto() {
    }


    public ProductDto(@NotEmpty String productCode, @NotEmpty(message = "name product not empty !!") String nameProduct, @Length(max = 300, message = "description of product has length no exceed 300 character") String description, Double price, @NotEmpty(message = "is empty ") String dayManufacturing) {
        this.productCode = productCode;
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
        this.dayManufacturing = dayManufacturing;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDayManufacturing() {
        return dayManufacturing;
    }

    public void setDayManufacturing(String dayManufacturing) {
        this.dayManufacturing = dayManufacturing;
    }

    public List<String> getListProductCode() {
        return listProductCode;
    }

    public void setListProductCode(List<String> listProductCode) {
        this.listProductCode = listProductCode;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;

        String dayManufacturing = productDto.getDayManufacturing();
        if (!"".equals(dayManufacturing)) {
            LocalDate localDate = LocalDate.parse(dayManufacturing);
            if (LocalDate.now().minusYears(2).isBefore(localDate)) {
                errors.rejectValue("dayManufacturing", "day.before", "errors system");
            }
        }
        if (productDto.getPrice() == null) {
            errors.rejectValue("price", "price.notnull", "errors system");
        } else if (productDto.getPrice() < 5) {
            errors.rejectValue("price", "price.small", "errors system");

        }
        if (productDto.getListProductCode().contains(productDto.getProductCode())){
            errors.rejectValue("listProductCode", "product.code", " Duplicate productCode");
        }
    }
}
