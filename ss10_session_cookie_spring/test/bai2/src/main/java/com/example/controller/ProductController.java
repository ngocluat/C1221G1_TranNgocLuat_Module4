package com.example.controller;


import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
@SessionAttributes("pro")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @ModelAttribute("pro")
    public Product getUpProduct() {
        return new Product();
    }


    @GetMapping({"/", "/zxc"})
    public String goHome(Model  model ) {

        model.addAttribute("product", iProductService.listProduct());
        return "/home";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id,
                         Model model,
                         HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("pro", "sfgfs" + id + "1rt44jybd56");
        cookie.setMaxAge(30);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);

        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "/detail";
    }



}
