package com.example.demo.controllers;

import com.example.demo.domain.entities.AddressEntity;
import com.example.demo.domain.dtos.AddressDto;
import com.example.demo.mappers.Mapper;
import com.example.demo.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AddressController {

    private AddressService addressService;

    private Mapper<AddressEntity, AddressDto> addressMapper;

    public AddressController(AddressService addressService, Mapper<AddressEntity, AddressDto> addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @PostMapping(path = "/addresses")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto address) {
        AddressEntity addressEntity = addressMapper.mapFrom(address);
        AddressEntity savedAddressEntity = addressService.save(addressEntity);
        return new ResponseEntity<>(addressMapper.mapTo(savedAddressEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/addresses")
    public List<AddressDto> listAddresses() {
        List<AddressEntity> addresses = addressService.findAll();
        return addresses.stream()
                .map(addressMapper::mapTo)
                .collect(Collectors.toList());
    }
}
