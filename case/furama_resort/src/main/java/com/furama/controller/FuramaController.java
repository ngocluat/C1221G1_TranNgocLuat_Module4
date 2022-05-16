package com.furama.controller;

import com.furama.model.Customer;
import com.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class FuramaController {

    @Autowired
    ICustomerService iCustomerService;

    @GetMapping({"/", "/furama/luat.tran94"})
    public String goHomeFurama() {
        return "home-furama";
    }


    @GetMapping("/customer")
    public ModelAndView goListCusstomer(Pageable pageable,
                                        @PageableDefault(size = 4, sort = {})
                                        @RequestParam Optional<String> nameCustomerSeach,
                                        @RequestParam Optional<String> addressCustomerSearch,
                                        @RequestParam Optional<String> customerCodeSearch
    ) {

        String name = nameCustomerSeach.orElse("");
        String address = addressCustomerSearch.orElse("");
        String code = customerCodeSearch.orElse("");

        ModelAndView modelAndView = new ModelAndView("customer/home");
        modelAndView.addObject("customer",
                iCustomerService.findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerCodeContaining(name, address, code, pageable));
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public String goCreateCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "thêm mới thành công");
        return "redirect:/customer";

    }


    @GetMapping("/{id}/edit")
    public String goEditCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customerEdit", iCustomerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/update-customer")
    public String editCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("message", "chỉnh sửa thành công");
        return "redirect:/customer";
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Customer customerDelete = iCustomerService.findById(id);
        iCustomerService.remove(customerDelete);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/customer";
    }

}
