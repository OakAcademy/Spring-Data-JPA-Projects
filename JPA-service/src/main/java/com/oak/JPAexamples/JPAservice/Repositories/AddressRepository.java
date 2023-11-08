package com.oak.JPAexamples.JPAservice.Repositories;

import com.oak.JPAexamples.JPAservice.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
