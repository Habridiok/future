package com.blibli.future.serviceImpl;

import com.blibli.future.entity.Customer;
import com.blibli.future.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class CustomerServiceImplTest {

    @Rule //ini untuk JUnit ngenali @Mock dan @InjectModks, jadi waktu ada @Mock langsung di Mock, dan di inject ke @InjectMocks
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void testRegisterSuccess(){
        //given
        Mockito.when(customerRepository
                .save(Mockito.any(Customer.class)))
                .then(invocation -> { //ini ada di java 8 namanya lamda
                    return invocation.getArguments()[0];
                });

        Customer customer = customerService.register("Dio","Malang");

        Assert.assertNotNull(customer.getId());
        Assert.assertEquals("Dio", customer.getName());
        Assert.assertEquals("Malang", customer.getAddress());

        //Verify // Mastiin kalo customerRepository maanggil 1 kali method save untuk ngesave kelas Customer
        Mockito.verify(customerRepository, Mockito.times(1))
                .save(Mockito.any(Customer.class));

    }

    @Test(expected = RuntimeException.class)
    public void testRegisterError(){
        Mockito.when(customerRepository.save(Mockito.any(Customer.class)))
                .thenThrow(new RuntimeException());

        customerService.register("Dio", "Jakarta");
    }

}