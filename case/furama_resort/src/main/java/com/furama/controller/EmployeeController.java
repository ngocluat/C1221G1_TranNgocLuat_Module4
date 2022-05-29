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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private  IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IEducattionService iEducattionService;

    @GetMapping("")
    public String goHoneEmployee(Model model,
                                 @RequestParam Optional<String> name,
                                 @RequestParam Optional<String> address,
                                 @RequestParam Optional<String> phone,
                                 @RequestParam Optional<String> idDivision,
                                 @RequestParam(defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "6") Integer pageSize,
                                 @RequestParam Optional<String> sort,
                                 @RequestParam Optional<String> dir
    ) {
        Pageable pageable;
        String key1 = name.orElse("");
        String key2 = address.orElse("");
        String key3 = phone.orElse("");
        String key4 = idDivision.orElse("%");
        String sortVal = sort.orElse("");
        String dirVal = dir.orElse("");

        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        } else if (dir.equals("asc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).descending());
        }
        model.addAttribute("division", divisionService.listDivisions());
        model.addAttribute("employee", iEmployeeService.findAllAndSerchEmployees(key1, key2, key3, key4, pageable));
        model.addAttribute("sort", sortVal);
        model.addAttribute("dir", dirVal);
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
            employee.setFlag(1);

            iEmployeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @GetMapping("/delete")
    public String deleteEmployee(Model model, @RequestParam Long id, RedirectAttributes redirectAttributes) {
//        Employee employee = iEmployeeService.findById(id);
        iEmployeeService.remove(id);
        redirectAttributes.addFlashAttribute("message", "remove one employee success ");
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit-employee")
    public String editEmployee(@PathVariable Long id, Model model) {

        Employee employee = iEmployeeService.findById(id);
        model.addAttribute("position", iPositionService.listPositons());
        model.addAttribute("education", iEducattionService.lisEducationDegree());
        model.addAttribute("division", divisionService.listDivisions());
        model.addAttribute("employee", employee);
        return "employee/edit";
    }


    @PostMapping("/update-employee")
    public String edit(@ModelAttribute Employee employee,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        iEmployeeService.update(employee);
        redirectAttributes.addFlashAttribute("message", "update success 🤣 ");
        return "redirect:/employee";
    }


}
