package com.blibli.future.entity;

import javax.persistence.*;

@Table(name = "customer")
@Entity
public class Customer {

    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = true)
    private String address;

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
