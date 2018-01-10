package com.blibli.future.requests;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class RegisterCustomerRequest {

    @Length(max = 50) //validasi max input 50 , namanya BeanValidation
    @NotBlank // validasi g boleh null inputnya
    private String name;

    @Length(max = 50)
    @NotBlank
    private String address;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
