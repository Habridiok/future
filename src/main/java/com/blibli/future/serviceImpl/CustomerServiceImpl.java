package com.blibli.future.serviceImpl;

import com.blibli.future.entity.Customer;
import com.blibli.future.repository.CustomerRepository;
import com.blibli.future.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRED) //Pake yang spring transaksional, Propagation.Requared biar 1 kali transaksional, jadi 1 method gagal ya gagal semua dan di ulang
public class CustomerServiceImpl implements CustomerService { // untuk test klik ctrl+shift+t

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer register(String name, String address) {

        Customer customer = new Customer();

        customer.setName(name);
        customer.setAddress(address);
        customer.setId(UUID.randomUUID().toString()); //UUID untuk keunikan ID

        return customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer findById(String idCustomer) {
        return customerRepository.findOne(idCustomer); //findOne ini Eager jadi semuanya langsung di ambil
        // kalo pake getOne bakal ambil 1 aja misal id nya aja
        //jadi kalo mau update pake findOne, kalo mau validasi di databse cukup getOne (lihat id nya aja)
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer edit(String id, String name, String address) {
        Customer c = customerRepository.findOne(id);
        c.setName(name);
        c.setAddress(address);
        return customerRepository.save(c);
    }

    @Override
    public Customer remove(String idCustomer) {
        Customer c = customerRepository.findOne(idCustomer);
        customerRepository.delete(c);
        return c;
    }
}
