package com.furama.controller;

import com.furama.model.Customer;
import com.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class FuramaController {

    @Autowired
    ICustomerService iCustomerService;

    @GetMapping({"/", "/furama/luat.tran94"})
    public String goHomeFurama() {
        return "home-furama";
    }




}
