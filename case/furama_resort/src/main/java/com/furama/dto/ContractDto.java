package com.furama.dto;

import com.furama.model.ContractDetail;
import com.furama.model.Customer;
import com.furama.model.Employee;
import com.furama.model.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ContractDto implements Validator {

    private static final String DATE_TIME_REGEX = "\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";

    private Long contractId;
    @NotNull(message = "not null !! ")
    private String contractStartDay;
    @NotNull(message = "not null !! ")
    private String contractEndDay;
    @NotNull(message = "not null !! ")
    private Double contractDeposit;
    @NotNull(message = "not null !! ")
    private Double contractToTalMoney;
    List<ContractDetail> contractDetails;
    @NotNull(message = "not null !! ")
    Service idService;
    @NotNull(message = "not null !! ")
    Customer idCustomer;
    @NotNull(message = "not null !! ")
    Employee idEmployee;


    public ContractDto() {
    }

    public static String getDateTimeRegex() {
        return DATE_TIME_REGEX;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDay() {
        return contractStartDay;
    }

    public void setContractStartDay(String contractStartDay) {
        this.contractStartDay = contractStartDay;
    }

    public String getContractEndDay() {
        return contractEndDay;
    }

    public void setContractEndDay(String contractEndDay) {
        this.contractEndDay = contractEndDay;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractToTalMoney() {
        return contractToTalMoney;
    }

    public void setContractToTalMoney(Double contractToTalMoney) {
        this.contractToTalMoney = contractToTalMoney;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    // check ngày sau và trước trong pakage tets :))
    public static void compareDates(String d1, String d2) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(d1);
            Date date2 = sdf.parse(d2);

            System.out.println("Date1" + sdf.format(date1));
            System.out.println("Date2" + sdf.format(date2));
            System.out.println();
            if (date1.after(date2)) {

//                System.out.println("Date1 is after Date2");
            }
            if (date1.before(date2)) {
                System.out.println("Date1 is before Date2");
            }
            if (date1.equals(date2)) {
                System.out.println("Date1 is equal Date2");
            }
            System.out.println();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void validate(Object target, Errors errors) {

        ContractDto contractDto = (ContractDto) target;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = sdf.parse(contractDto.getContractStartDay());
            Date date2 = sdf.parse(contractDto.getContractEndDay());

            System.out.println("Date1" + sdf.format(date1));
            System.out.println("Date2" + sdf.format(date2));
            System.out.println();
            if (date1.after(date2)) {
                errors.rejectValue("contractEndDay", "day.errors", "errors !! ");
            }
            if (date1.equals(date2)) {
                errors.rejectValue("contractEndDay", "day.equal", "errors !! ");
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

//        try {
//            if ("".equals(contractDto.contractStartDay)) {
//                errors.rejectValue("contractStartDate", "blank.error", "System Error");
//            } else if (!contractDto.contractStartDay.matches(DATE_TIME_REGEX)) {
//                errors.rejectValue("contractStartDate", "day.error", "System Error");
//            } else {
//                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//                Date date = null;
//                Date current = new Date();
//                try {
//                    date = fmt.parse(contractDto.contractStartDay);
////                 KIEM TRA NGAY CO TRONG QUA KHU KHONG
//                    if (date != null && date.compareTo(new Date()) < 0) {
//                        errors.rejectValue("contractStartDay", "", "Start date don't in the past");
//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                    errors.rejectValue("contractStartDay", "day.error", "System Error");
//                }
//            }
//            if ("".matches(contractDto.contractEndDay)) {
//                errors.rejectValue("contractEndDate", "blank.error", "System Error");
//            } else if (!contractDto.contractEndDay.matches(DATE_TIME_REGEX)) {
//                errors.rejectValue("contractEndDate", "day.error", "System Error");
//            } else {
//                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//                Date startDate = null;
//                Date endDate = null;
//                Date current = new Date();
//                try {
//                    endDate = fmt.parse(contractDto.contractEndDay);
//                    startDate = fmt.parse(contractDto.contractStartDay);
////                 KIEM TRA NGAY CO TRONG QUA KHU KHONG
//                    if (endDate != null && endDate.compareTo(startDate) < 0) {
//                        errors.rejectValue("contractEndDay", "", "End date must be after Start date");
//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                    errors.rejectValue("contractEndDay", "day.error", "System Error");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errors.rejectValue("contractEndDay", "day.error", "System Error");
//
//        }
}

