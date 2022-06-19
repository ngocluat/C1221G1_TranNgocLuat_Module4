package com.example.controller;


import com.example.dto.OderProductDto;
import com.example.model.OderProduct;
import com.example.model.Product;
import com.example.service.IOderService;
import com.example.service.IProductService;
import com.example.service.ITypeProductSrvice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    IProductService iProductService;

    @Autowired
    IOderService iOderService;

    @Autowired
    ITypeProductSrvice iTypeProduct;

    @GetMapping({"/", "/product"})
    public String goHomeProduct(@RequestParam Optional<String> dayStart,
                                @RequestParam Optional<String> dayEnd,
                                Model model,
                                Pageable pageable,
                                @RequestParam(defaultValue = "0") Integer page,
                                @RequestParam(defaultValue = "4") Integer pageSize,
                                @RequestParam Optional<String> sort
    ) {
        String sortVal = sort.orElse("");
        String dayOderStart = dayStart.orElse("");
        String dayOderEnd = dayEnd.orElse("");

        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
            model.addAttribute("Oderproduct", iOderService.listOderProducts(dayOderStart, dayOderEnd, pageable));
        } else {
            pageable = PageRequest.of(page, pageSize);
            model.addAttribute("Oderproduct", iOderService.top(pageable));
        }

        model.addAttribute("Oderproduct", iOderService.listOderProducts(dayOderStart, dayOderEnd, pageable));
        return "home";
    }


    @GetMapping("/{oderCode}/edit")
    public String goEdit(@PathVariable Long oderCode,
                         Model model, Pageable pageable) {
        OderProduct oderProduct = iOderService.findByOderCode(oderCode).orElse(null);
        List<Product> productList = iProductService.listProducts();
        OderProductDto oderProductDto = new OderProductDto();

        BeanUtils.copyProperties(oderProduct, oderProductDto);

        model.addAttribute("oderProductDto", oderProductDto);
        model.addAttribute("product", productList);
        model.addAttribute("typeProduct", iTypeProduct.listTypeProducts());
        return "edit";
    }

    @PostMapping("/update-product")
    public String edit(@ModelAttribute @Validated OderProductDto oderProductDto,
                       Model model,
                       BindingResult bindingResult) {
        new OderProductDto().validate(oderProductDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            List<Product> productList = iProductService.listProducts();
            model.addAttribute("product", productList);
            model.addAttribute("typeProduct", iTypeProduct.listTypeProducts());
            return "edit";
        } else {
            OderProduct oderProducts = new OderProduct();
            BeanUtils.copyProperties(oderProductDto, oderProducts);
            iOderService.update(oderProducts);
            return "redirect:/";
        }
    }


}
