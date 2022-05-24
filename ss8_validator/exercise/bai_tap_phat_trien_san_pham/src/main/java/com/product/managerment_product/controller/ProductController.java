package com.product.managerment_product.controller;


import com.product.managerment_product.dot.ProductDto;
import com.product.managerment_product.model.Product;
import com.product.managerment_product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping({"/", "/product"})
    public String goHome(Model model,
                         @RequestParam Optional<String> nameProductSeach,
                         @RequestParam Optional<String> description,
                         @RequestParam(defaultValue = "0") Integer page,
                         @RequestParam(defaultValue = "20") Integer pageSize,
                         @RequestParam(defaultValue = "id") String sort,
                         @RequestParam(defaultValue = "asc") String dir) {

        Pageable pageable;
        if (dir.equals("asc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.by(sort).descending());
        }

        String key = nameProductSeach.orElse("");
        String key2 = description.orElse("");

        model.addAttribute("product", iProductService.seachingProduct(key, key2, pageable));
        model.addAttribute("sort", sort);
        model.addAttribute("dir", dir);
        return "home";
    }


    @GetMapping("/show-create")
    public String ShowCreateProduct(ModelMap model) {
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }

    @PostMapping("/save-product")
    public String create(@Validated @ModelAttribute ProductDto productDto,
                         BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        productDto.setListProductCode(iProductService.getListProduvtCode());

        new ProductDto().validate(productDto, bindingResult);

        try {
            if (bindingResult.hasFieldErrors()) {
                return "create";
            } else {
                Product product = new Product();
                BeanUtils.copyProperties(productDto, product);
                iProductService.save(product);
                redirectAttributes.addFlashAttribute("msg", "successfully add new");
                return "create";
            }
        } catch (Exception e) {
            return "error";
        }

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
//        iProductService.remove(product);
//        redirect.addFlashAttribute("success", "Removed customer successfully!");
//        return "redirect:/";
//    }



}
