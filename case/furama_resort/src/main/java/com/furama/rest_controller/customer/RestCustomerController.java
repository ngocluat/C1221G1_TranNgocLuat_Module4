package com.furama.rest_controller.customer;

import com.furama.dto.CustomerDto;
import com.furama.model.Customer;
import com.furama.service.ICustomerService;
import com.furama.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/rest")
@RestController
public class RestCustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

// ok
    @GetMapping("list-customer")
    public ResponseEntity<List<Customer>> getLisstBlog() {
        List<Customer> customers = iCustomerService.findAll();
        System.err.println(customers);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @GetMapping("customer/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId) {
        Optional<Customer> categoryOptional = Optional.ofNullable(iCustomerService.findById(customerId));
        return categoryOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // ok
    @PostMapping("/save-customer")
    public ResponseEntity<?> saveCustomer(@Validated @RequestBody CustomerDto customerDto,
                                                 BindingResult bindingResult) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setFlag(1);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Customer customerVlue = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setFlag(1);
            iCustomerService.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);

        }
    }


    @DeleteMapping("/deleteCustomer/{customerID}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("customerID") Long id) {
        try {
            Customer customer = this.iCustomerService.findById(id);
            this.iCustomerService.remove(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

