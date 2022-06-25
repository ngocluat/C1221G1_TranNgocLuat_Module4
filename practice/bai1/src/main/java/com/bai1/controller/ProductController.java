package com.bai1.controller;

import com.bai1.dto.OderProductDto;
import com.bai1.model.OderProduct;
import com.bai1.model.Product;
import com.bai1.service.IOderService;
import com.bai1.service.IProductService;
import com.bai1.service.ITypeProductSrvice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String goEdit(@PathVariable String oderCode,
                         Model model, Pageable pageable) {
        OderProduct oderProduct = iOderService.findByOderCode(oderCode).orElse(null);

        OderProductDto oderProductDto = new OderProductDto();
        BeanUtils.copyProperties(oderProduct, oderProductDto);

        model.addAttribute("oderProductDto", oderProductDto);
        model.addAttribute("typeProduct", iTypeProduct.listTypeProducts());
        return "edit";
    }

    @PostMapping("/update-product")
    public String edit( @ModelAttribute @Validated OderProductDto oderProductDto,
                        Model model,
                        BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
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
