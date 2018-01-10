package com.blibli.future.service;

import com.blibli.future.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer register(String name, String address);

    public Customer findById(String idCustomer);

    public List<Customer> customers();

    public Customer edit(String id, String name, String address);

    public Customer remove(String idCustomer);
}
