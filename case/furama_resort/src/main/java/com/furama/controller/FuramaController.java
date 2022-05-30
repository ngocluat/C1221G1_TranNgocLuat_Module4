package com.furama.controller;

import com.furama.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("counter")
public class FuramaController {

    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @GetMapping({"/", "/furama/luat.tran94"})
    public String goHomeFurama(@ModelAttribute("counter") Counter counter) {
        counter.increment();
        return "home-furama";
    }

    @GetMapping("/tranluat.94")
    public String goHomeAuthor() {
        return "tranluat";
    }

    @ExceptionHandler(Exception.class)
    public String errors() {
        return "errorsPage";
    }
}
