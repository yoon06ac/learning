package com.example.demo.services.impl;

import com.example.demo.domain.entities.AddressEntity;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressEntity save(AddressEntity addressEntity) { return addressRepository.save(addressEntity);}

    @Override
    public List<AddressEntity> findAll() {
        return StreamSupport.stream(addressRepository
                .findAll()
                .spliterator(),
                false)
                .collect(Collectors.toList());
    }


}
