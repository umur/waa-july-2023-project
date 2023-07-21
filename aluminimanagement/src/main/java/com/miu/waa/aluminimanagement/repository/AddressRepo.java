package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
