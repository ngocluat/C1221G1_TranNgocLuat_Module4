package com.example.common;
import org.springframework.validation.Errors;

import java.time.LocalDate;
public class Validation {

    private static final String FACILITY_REGEX = "^DV-\\d{4}$";
    private static final String CUSTOMER_CODE_REGEX = "^KH-\\d{4}$";
    private static final String COMMON_NAME_REGEX = "^(\\p{L}|\\d)+( (\\p{L}|\\d)+)*$";
    private static final String FACILITY_NAME_REGEX = "^\\p{Lu}\\p{Ll}+( \\p{Lu}\\p{Ll}+)*( [0-9]+)*$";
    private static final String YEAR_REGEX = "^[+]?\\d{4}$";
    private static final String DDMMYYYY_REGEX = "^(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/\\d\\d\\d\\d$";
    private static final String POSITIVE_INTEGER_REGEX = "^[+]?\\d+$";
    private static final String INTEGER_GREATER_THAN_0_REGEX = "^[+]?[0]*[1-9][0-9]*$";
    private static final String POSITIVE_INTEGER_FROM_1_TO_19_REGEX = "^[+]?([1-9]|1[0-9])$";
    private static final String POSITIVE_DOUBLE_REGEX = "^[+]?(\\d*\\.)?\\d+$";
    private static final String EMAIL_REGEX = "^\\w+([\\.-]?\\w+)*@[a-z]+\\.(\\w+)(\\.\\w{2,3})?";
    private static final String PHONE_REGEX = "^(090|091|\\(84\\)90|\\(84\\)91)\\d{7}$";
    private static final String IDCARD_REGEX = "^[1-9]\\d{8,11}$";
    private static final String ALL_STRING_NUMBER_REGEX = "^\\w+( \\w+)*$";

    //Tên Tiếng Việt có dấu \p{L}: Tất cả Các ký tự Unicode.
    //                     \p{Ll}: Các ký tự Unicode lowercase .
    //                     \p{Lu}: Các ký tự Unicode Uppercase .
    private static final String VIETNAMESE_NAME_REGEX = "^\\p{Lu}\\p{Ll}+( \\p{Lu}\\p{Ll}*)*$";

    public static void checkVietnameseName(String fieldName, String name, Errors error) {
        if ("".equals(name)) {
            error.rejectValue(fieldName, "name.empty");
        } else if (!name.matches(VIETNAMESE_NAME_REGEX)) {
            error.rejectValue(fieldName, "name.invalid");
        }
    }

    public static void checkBirthday(String fieldName, LocalDate birthday, Errors error) {
        LocalDate now = LocalDate.now();
        LocalDate eighteenYear = now.minusYears(18);
        LocalDate hundredYear = now.minusYears(100);
        if (birthday == null) {
            error.rejectValue(fieldName, "birthday.empty");
        } else if (birthday.compareTo(eighteenYear) > 0 || birthday.compareTo(hundredYear) < 0) {
            error.rejectValue(fieldName, "birthday.invalid");
        }
    }

    public static void checkIdCard(String fieldName, String IdCard, Errors error) {
        if ("".equals(IdCard)) {
            error.rejectValue(fieldName, "idCard.empty");
        } else if (!IdCard.matches(IDCARD_REGEX)) {
            error.rejectValue(fieldName, "idCard.invalid");
        }
    }

    public static void checkPhone(String fieldName, String phone, Errors error) {
        if ("".equals(phone)) {
            error.rejectValue(fieldName, "phone.empty");
        } else if (!phone.matches(PHONE_REGEX)) {
            error.rejectValue(fieldName, "phone.invalid");
        }
    }

    public static void checkEmail(String fieldName, String email, Errors error) {
        if ("".equals(email)) {
            error.rejectValue(fieldName, "email.empty");
        } else if (!email.matches(EMAIL_REGEX)) {
            error.rejectValue(fieldName, "email.invalid");
        }
    }

    public static void checkEmpty(String fieldName, String field, Errors error) {
        if ("".equals(field)) {
            error.rejectValue(fieldName, "field.empty");
        }
    }

    public static void checkPositiveDouble(String fieldName, Double field, Errors error) {
        if (field == null) {
            error.rejectValue(fieldName, "field.empty");
        } else if (field < 0) {
            error.rejectValue(fieldName, "field.negative");
        }
    }

    public static void checkGender(String fieldName, Integer field, Errors error) {
        if (field == null) {
            error.rejectValue(fieldName, "gender.empty");
        } else if (-1 > field || field > 1) {
            error.rejectValue(fieldName, "gender.invalid");
        }
    }

    public static void checkCustomerCode(String fieldName, String customerCode, Errors error) {
        if ("".equals(customerCode)) {
            error.rejectValue(fieldName, "customerCode.empty");
        } else if (!customerCode.matches(CUSTOMER_CODE_REGEX)) {
            error.rejectValue(fieldName, "customerCode.invalid");
        }
    }

    public static void checkFacilityCode(String fieldName, String facilityCode, Errors error) {
        if ("".equals(facilityCode)) {
            error.rejectValue(fieldName, "facilityCode.empty");
        } else if (!facilityCode.matches(FACILITY_REGEX)) {
            error.rejectValue(fieldName, "facilityCode.invalid");
        }
    }

    public static void checkFacilityName(String fieldName, String facilityName, Errors error) {
        if ("".equals(facilityName)) {
            error.rejectValue(fieldName, "facilityName.empty");
        } else if (!facilityName.matches(COMMON_NAME_REGEX)) {
            error.rejectValue(fieldName, "facilityName.invalid");
        }
    }

    public static void checkMaximumPeople(String fieldName, Integer people, Errors error) {
        if (people == null) {
            error.rejectValue(fieldName, "people.empty");
        } else if (1 > people || people > 19) {
            error.rejectValue(fieldName, "people.invalid");
        }
    }

    public static void checkNumberFloor(String fieldName, Integer numberFloor, Errors error) {
        if (numberFloor == null) {
            error.rejectValue(fieldName, "numberFloor.empty");
        } else if (1 > numberFloor || numberFloor > 10) {
            error.rejectValue(fieldName, "numberFloor.invalid");
        }
    }

    public static void checkStartDate(String fieldName, LocalDate startDate, Errors error) {
        LocalDate now = LocalDate.now();
        if (startDate == null) {
            error.rejectValue(fieldName, "startDate.empty");
        } else if (startDate.compareTo(now) < 0) {
            error.rejectValue(fieldName, "startDate.past");
        }
    }

    public static void checkEndDate(String fieldName, LocalDate startDate, LocalDate endDate, Errors error) {
        LocalDate now = LocalDate.now();
        if (endDate == null) {
            error.rejectValue(fieldName, "endDate.empty");
        } else if (endDate.compareTo(startDate) < 0) {
            error.rejectValue(fieldName, "endDate.past");
        }
    }

    public static void checkPositiveInteger(String fieldName, Integer field, Errors error) {
        if (field == null) {
            error.rejectValue(fieldName, "field.empty");
        } else if (field < 0) {
            error.rejectValue(fieldName, "Integer.invalid");
        }
    }

    public static void checkStringSalary(String fieldName, String salary, Errors error){
        if ("".equals(salary)){
            error.rejectValue(fieldName, "field.empty");
        }else if (!salary.matches(POSITIVE_DOUBLE_REGEX)){
            error.rejectValue(fieldName, "salary.invalid");
        }
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate pass = now.minusYears(18);
        System.out.println(pass);
        LocalDate localDate = LocalDate.parse("2010-05-15");
        if (pass.compareTo(localDate) >= 0) {
            System.out.println("Lon hon");
        } else {
            System.out.println("nho hon");
        }
    }
}

