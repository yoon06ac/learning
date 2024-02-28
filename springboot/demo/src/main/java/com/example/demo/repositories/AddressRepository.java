package com.example.demo.repositories;

import com.example.demo.domain.entities.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
}
