package com.furama.rest_controller.contract;

import com.furama.model.Contract;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/rest")
@RestController
public class RestContractController {

    @Autowired
    IContractService iContractService;
    @GetMapping("list-contract")
    public ResponseEntity<List<Contract>> getListContract() {
        List<Contract> contracts = iContractService.listContract();
        System.err.println(contracts);
        if (contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }



}
