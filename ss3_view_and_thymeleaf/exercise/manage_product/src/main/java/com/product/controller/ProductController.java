package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping({"/", "/adg"})
    public String goHome(Model model) {
        model.addAttribute("product", iProductService.findAll());
        return "home";
    }


    @GetMapping("/show-create")
    public String ShowCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save-product")
    public String create(Product product, Model model) {
        iProductService.save(product);
        model.addAttribute("msg", "successfully add new");
        return "/create";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product customer) {
        iProductService.update(customer.getId(), customer);
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }

    public String seaching(Product product, Model model, String name ) {
        List<Product> productList = new ArrayList<>();
        for (Product sinhVien : productList) {
            if (sinhVien.getNameProduct().contains(name)) {
                productList.add(sinhVien);
            }
        }

        return "";
    }


}
