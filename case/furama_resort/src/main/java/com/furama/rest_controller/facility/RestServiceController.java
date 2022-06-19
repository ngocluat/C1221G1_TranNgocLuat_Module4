package com.furama.rest_controller.facility;

import com.furama.model.Customer;
import com.furama.model.Service;
import com.furama.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/rest")
@RestController
public class RestServiceController {


    @Autowired
    IServiceService  iServiceService;
    @GetMapping("list-service")
    public ResponseEntity<Page<Service>> getLisstBlog(Pageable pageable) {

        Page<Service> services = iServiceService.listService(pageable);
        System.err.println(services);
        if (!services.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

}
