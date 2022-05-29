package com.furama.controller;

import com.furama.dto.ContractDetailDto;
import com.furama.model.ContractDetail;
import com.furama.service.IAttachSrevice;
import com.furama.service.IContractDetailService;
import com.furama.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/detail")
public class ContractDetailController {

    @Autowired
    private IContractService iContractService;
    @Autowired
    private   IAttachSrevice iAttachSrevice;
    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("/contract-detail")
    public String goHomeContractDetail(Model model, Pageable pageable) {
        model.addAttribute("contractDetail", iContractDetailService.lisContractDetails(pageable));
        return "contract/contractDetail";
    }

    @GetMapping("/add-new-contract-detail")
    public String goCreateContractDetail(Model model, Pageable pageable) {
        model.addAttribute("attach", iAttachSrevice.listAttachServices());
        model.addAttribute("contract", iContractService.listContract());
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "contract/createContractDetail";
    }


    @PostMapping("/create-contract-detail")
    public String createContractDetail(@ModelAttribute ContractDetailDto contractDetailDto) {

        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        iContractDetailService.saveContractDetail(contractDetail);
        return "contract/contractDetail";
    }

}
