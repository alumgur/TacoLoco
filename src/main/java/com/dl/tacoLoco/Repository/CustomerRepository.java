package com.dl.tacoLoco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dl.tacoLoco.Entity.Customer;

// Extending JpaRepository to gain access to simple crud method already available
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
