package com.furama.controller;

import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller

public class ListCustomerVipController {

    @Autowired
    private IContractService iContractService;

    @GetMapping("/vip-customer")
    public String goVipCustomer(Model model,
                                @RequestParam Optional<LocalDate> dayStart,
                                @RequestParam Optional<LocalDate> dayEnd
    ) {
        LocalDate key1 = dayStart.orElse(null);
        LocalDate key2 = dayStart.orElse(null);
        model.addAttribute("vipCustomer", iContractService.getCustomerVip(key1, key2));
        return "contract/vip";
    }

}
