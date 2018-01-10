package com.blibli.future.controller;

import com.blibli.future.entity.Customer;
import com.blibli.future.requests.RegisterCustomerRequest;
import com.blibli.future.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController //Gabungan Controller dan ResponBody
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(
            value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, // dari client ke except
            consumes = MediaType.APPLICATION_JSON_VALUE //Dia consume dari client berupa Content Type
    )
    public Customer register(@Valid @RequestBody RegisterCustomerRequest request){
        return customerService.register(request.getName(), request.getAddress());
    }

    @RequestMapping(
            value = "/customers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Customer> customers(){
        return customerService.customers();
    }

    @RequestMapping(
            value = "/customer/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer showById(@PathVariable String id){
        return customerService.findById(id);
    }

    @RequestMapping(
            value = "/customer/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE

    )
    public Customer edit(@Valid @RequestBody RegisterCustomerRequest request , @PathVariable String id){
        return customerService.edit(id, request.getName(), request.getAddress());
    }

    @RequestMapping(
            value = "/customer/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE, //Dia consume dari client berupa Content Type
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer remove(@PathVariable String id){
        return customerService.remove(id);
    }



}
