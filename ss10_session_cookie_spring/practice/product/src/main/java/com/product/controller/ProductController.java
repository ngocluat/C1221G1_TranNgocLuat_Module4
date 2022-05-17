package com.product.controller;

import com.product.model.Cart;
import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping({"/", "/shop"})
    public ModelAndView showShop(Model model,
                                 @CookieValue(value = "idProduct", defaultValue = "-1") Long idProduct) {

        if (idProduct != 1) {
            model.addAttribute("history", productService.findById(idProduct));
        }

        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }


    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "detail";
        }

        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/reduction/{id}")
    public String reductionToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "detail";
        }
        if (action.equals("show")) {
            cart.reductionProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }


    @GetMapping("/{id}/detail")
    public String detail(@PathVariable Long id,
                         Model model,
                         HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("cart", id + "");
        cookie.setMaxAge(60 * 60 * 2);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);

        Optional<Product> productOptional = productService.findById(id);

        model.addAttribute("product", productOptional.get());
        return "detail2";
    }





}