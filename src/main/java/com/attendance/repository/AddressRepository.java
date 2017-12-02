package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
