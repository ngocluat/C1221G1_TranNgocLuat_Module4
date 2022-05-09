package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired  
    private IProductService iProductService;

    @GetMapping({"/", "/adg"})
    public String goHome(Model model) {
        model.addAttribute("product", iProductService.findAll());
        return "home";
    }


    @GetMapping("/show-create")
    public String ShowCreateProduct(ModelMap model) {
        model.addAttribute("product", new Product());
        return "/abc";
    }

    @PostMapping("/save-product")
    public String create(Product product, Model model) {
        iProductService.save(product);
        model.addAttribute("msg", "successfully add new");
        return "/abc";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {

        iProductService.remove(product);
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
        iProductService.update( customer);
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }

    @PostMapping("/searching")
    public String seaching(@RequestParam String nameProductSeach, Model model) {
        List<Product> productListResutl = iProductService.seachingProduct(nameProductSeach);
        if (productListResutl == null) {
            model.addAttribute("message", "not found!! ");
        } else {
            model.addAttribute("product", productListResutl);
        }
        return "/home";
    }


}
