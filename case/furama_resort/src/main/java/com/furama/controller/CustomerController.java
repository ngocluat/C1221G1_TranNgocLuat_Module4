package com.furama.controller;

import com.furama.dto.CustomerDto;
import com.furama.model.Customer;
import com.furama.service.ICustomerService;
import com.furama.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @GetMapping("/customer")
    public ModelAndView goListCusstomer(@PageableDefault(size = 5, sort = {}) Pageable pageable,
                                        @RequestParam Optional<String> nameCustomerSeach,
                                        @RequestParam Optional<String> addressCustomerSearch,
                                        @RequestParam Optional<String> customerCodeSearch, Model model
    ) {

        String name = nameCustomerSeach.orElse("");
        String address = addressCustomerSearch.orElse("");
        String code = customerCodeSearch.orElse("");
        model.addAttribute("customerType", iCustomerTypeService.findAll());

        ModelAndView modelAndView = new ModelAndView("customer/home");
        modelAndView.addObject("customer",
                iCustomerService.findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerCodeContaining(name, address, code, pageable));
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public String goCreateCustomer(Model model) {

        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model
    ) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", iCustomerTypeService.findAll());

            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);

            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "successfully added new");
            return "redirect:/customer";
        }
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
