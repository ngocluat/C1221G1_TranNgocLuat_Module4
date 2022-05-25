package com.furama.controller;

import com.furama.dto.ContractDto;
import com.furama.model.Contract;
import com.furama.service.IContractService;
import com.furama.service.ICustomerService;
import com.furama.service.IEmployeeService;
import com.furama.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContractController {

    @Autowired
   private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private  IServiceService iServiceService;


    @GetMapping("/contract")
    public String goHomeContract(Model model) {
        model.addAttribute("contract", iContractService.listContract());
        return "contract/home";
    }

    @RequestMapping(value = "/create-contract", method = RequestMethod.GET)
    public String goCreateContract(Model model, Pageable pageable) {
        model.addAttribute("contract", new ContractDto());
        model.addAttribute("service",iServiceService.listService(pageable));
        model.addAttribute("customer",iCustomerService.findAllCustomer(pageable) );
        model.addAttribute("employee",iEmployeeService.findEmployees(pageable) );
        return "contract/create";
    }

    @RequestMapping(value = "/create-contract", method = RequestMethod.POST)
    public String createContract(@ModelAttribute ContractDto contractDto, Model model, RedirectAttributes redirectAttributes) {

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);

        iContractService.saveContract(contract);
        redirectAttributes.addFlashAttribute("messager", "add new one contract success !! congratulations !!");
        return "redirect:/contract";
    }

}
