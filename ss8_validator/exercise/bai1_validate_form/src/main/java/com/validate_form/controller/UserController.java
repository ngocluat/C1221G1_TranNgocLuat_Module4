package com.validate_form.controller;

import com.validate_form.dto.UserDto;
import com.validate_form.model.User;
import com.validate_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping({"/", "form"})
    public String goHome(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "home";
    }


    @PostMapping("/create")
    public String create(@ModelAttribute @Validated UserDto userDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {

        new UserDto().validate(userDto,bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "home";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);

            return "result";
        }

    }
}
