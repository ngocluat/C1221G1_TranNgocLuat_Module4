package com.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FuramaController {


    @GetMapping({"/", "/furama/luat.tran94"})
    public String goHomeFurama() {
        return "home-furama";
    }

    @GetMapping("/tranluat.94")
    public String goHomeAuthor() {
        return "tranluat";
    }

    @ExceptionHandler(Exception.class)
    public String errors() {
        return "templates/errorsPage.html";
    }
}
