package com.bai1.controller;

import com.bai1.model.OderProduct;
import com.bai1.service.IOderService;
import com.bai1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Autowired
    IOderService iOderService;

    @GetMapping({"/", "/product"})
    public String goHomeProduct(@RequestParam Optional<String> dayOder,
                                Model model,
                                Pageable pageable,
                                @RequestParam(defaultValue = "0") Integer page,
                                @RequestParam(defaultValue = "2") Integer pageSize,
                                @RequestParam Optional<String> sort,
                                @RequestParam Optional<String> dir

    ) {
        String sortVal = sort.orElse("");
        String dirVal = dir.orElse("");
        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        }
        String dayOderFlag = dayOder.orElse("");
        model.addAttribute("product", iOderService.listOderProducts(dayOderFlag, pageable));
        return "home";
    }


    @GetMapping("/{oderCode}/edit")
    public String goEdit(@PathVariable Long oderCode,
                         Model model, Pageable pageable) {
        model.addAttribute("oderProduct", iOderService.findByOderCode(oderCode));
        return "edit";
    }

    @PostMapping("/update-product")
    public String edit(@ModelAttribute OderProduct oderProduct,
                       Model model,
                       Pageable pageable) {
        iOderService.update(oderProduct);
        return "redirect:/";
    }

}
