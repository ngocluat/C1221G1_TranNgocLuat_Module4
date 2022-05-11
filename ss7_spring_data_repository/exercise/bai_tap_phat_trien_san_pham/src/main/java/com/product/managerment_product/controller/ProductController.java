package com.product.managerment_product.controller;


import com.product.managerment_product.model.Product;
import com.product.managerment_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired  
    private IProductService iProductService;

    @GetMapping({"/", "/adg"})
    public String goHome(Model model,@PageableDefault( value = 5    ) Pageable pageable,
                         @RequestParam Optional<String> nameProductSeach ) {

        String key = nameProductSeach.orElse("");
        model.addAttribute("product", iProductService.seachingProduct(key,pageable));
        return "home";
    }


    @GetMapping("/show-create")
    public String ShowCreateProduct(ModelMap model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save-product")
    public String create(Product product, Model model) {
        iProductService.save(product);
        model.addAttribute("msg", "successfully add new");
        return "create";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
       Product product= iProductService.findById(id);
        iProductService.remove(product);
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


//    @PostMapping("/searching")
//    public String seaching(@RequestParam String nameProductSeach, @PageableDefault(value = 5) Pageable pageable, Model model) {
//        Page<Product> productListResutl = iProductService.seachingProduct(nameProductSeach, pageable);
//        if (productListResutl == null) {
//            model.addAttribute("message", "not found!! ");
//        } else {
//            model.addAttribute("product", productListResutl);
//        }
//        return "/home";
//    }



//    @PostMapping("/delete")
//    public String delete(Product product, RedirectAttributes redirect) {
//
//        iProductService.remove(product);
//        redirect.addFlashAttribute("success", "Removed customer successfully!");
//        return "redirect:/";
//    }



}
