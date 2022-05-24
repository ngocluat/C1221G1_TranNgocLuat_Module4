package com.furama.controller;

import com.furama.dto.EmployeeDto;
import com.furama.model.Employee;
import com.furama.service.IDivisionService;
import com.furama.service.IEducattionService;
import com.furama.service.IEmployeeService;
import com.furama.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IPositionService iPositionService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IEducattionService iEducattionService;

    @GetMapping("/employee")
    public String goHoneEmployee(Model model,
                                 @RequestParam Optional<String> name,
                                 @RequestParam Optional<String> address,
                                 @RequestParam Optional<String> phone,
                                 @RequestParam(defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "6") Integer pageSize,
                                 @RequestParam(defaultValue = "employeeId") String sort,
                                 @RequestParam(defaultValue = "asc") String dir
    ) {

        Pageable pageable;

        if (dir.equals("asc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.by(sort).descending());
        }

        String key1 = name.orElse("");
        String key2 = address.orElse("");
        String key3 = phone.orElse("");

        model.addAttribute("employee", iEmployeeService.findAllEmployees(key1, key2, key3, pageable));
        model.addAttribute("sort", sort);
        model.addAttribute("dir", dir);
        return "employee/home";
    }


    @GetMapping("/create-employee")
    public String goCreareEmloyee(Model model) {
        model.addAttribute("position", iPositionService.listPositons());
        model.addAttribute("education", iEducattionService.lisEducationDegree());
        model.addAttribute("division", divisionService.listDivisions());

        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create";
    }

    @PostMapping("/create")
    public String creareEmloyee(@Validated @ModelAttribute EmployeeDto employeeDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {

        new EmployeeDto().validate(employeeDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("position", iPositionService.listPositons());
            model.addAttribute("education", iEducattionService.lisEducationDegree());
            model.addAttribute("division", divisionService.listDivisions());
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @GetMapping("/delete")
    public String deleteEmployee(Model model, @RequestParam Long id, RedirectAttributes redirectAttributes) {
        Employee employee = iEmployeeService.findById(id);
        iEmployeeService.remove(employee);
        redirectAttributes.addFlashAttribute("message", "remove one employee success ");
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit-employee")

    public String editEmployee(@PathVariable Long id, Model model) {
        Employee employee = iEmployeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }


    @PostMapping("/update-employee")
    public String edit(@ModelAttribute Employee employee, Model model, RedirectAttributes redirectAttributes) {
        iEmployeeService.update(employee);
        redirectAttributes.addFlashAttribute("message", "update success 🤣 ");
        return "redirect:/employee";
    }


}
