package com.dl.tacoLoco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dl.tacoLoco.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
