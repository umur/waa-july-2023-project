package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends ListCrudRepository<Address, Long> {
}
