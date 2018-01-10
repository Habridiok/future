package com.blibli.future.repository;

import com.blibli.future.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

//terdapat proxy di balik ini yang di kontrol oleh spring (spring proxy) yang ngebuat interface dapat jalan otomatis tanpa object,
// disini ada mekanisme yang isinya query dll



}
