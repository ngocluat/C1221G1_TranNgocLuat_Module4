package com.furama.controller;

import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ListCustomerVipController {

    @Autowired
    private IContractService iContractService;

    @GetMapping("/vip-customer")
    public String goVipCustomer(Model model) {
        model.addAttribute("vipCustomer", iContractService.getCustomerVip());
        return "contract/vip";
    }

}
