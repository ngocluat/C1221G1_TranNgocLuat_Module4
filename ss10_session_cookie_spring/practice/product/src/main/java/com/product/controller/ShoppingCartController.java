package com.product.controller;

import com.product.model.Cart;
import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShoppingCartController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("{id}/delete")
    public String removeCart(@PathVariable Long id, RedirectAttributes redirectAttributes, @SessionAttribute("cart") Cart cart) {
        Product product = productService.findById(id).get();
        cart.removeProduct(product);
        redirectAttributes.addFlashAttribute("message", "you delete one product in to cart");
        return "redirect:/shopping-cart";

    }
}
