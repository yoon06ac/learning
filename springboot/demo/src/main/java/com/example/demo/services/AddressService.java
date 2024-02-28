package com.example.demo.services;

import com.example.demo.domain.entities.AddressEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {

    AddressEntity save(AddressEntity addressEntity);

    List<AddressEntity> findAll();
}
