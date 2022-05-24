package com.furama.controller;

import com.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FuramaController {

    @Autowired
    ICustomerService iCustomerService;

    @GetMapping({"/", "/furama/luat.tran94"})
    public String goHomeFurama() {
        return "home-furama";
    }

    @ExceptionHandler(Exception.class)
    public String errors() {
        return "errors";
    }
}
