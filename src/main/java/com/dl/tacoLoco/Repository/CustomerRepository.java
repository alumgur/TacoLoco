package com.dl.tacoLoco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dl.tacoLoco.Entity.CustomerEntity;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {}
	