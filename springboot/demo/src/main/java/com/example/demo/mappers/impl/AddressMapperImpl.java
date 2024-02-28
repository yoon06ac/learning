package com.example.demo.mappers.impl;

import com.example.demo.domain.dtos.AddressDto;
import com.example.demo.domain.entities.AddressEntity;
import com.example.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements Mapper<AddressEntity, AddressDto> {

    private ModelMapper modelMapper;

    public AddressMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AddressDto mapTo(AddressEntity addressEntity) {return modelMapper.map(addressEntity, AddressDto.class);}

    @Override
    public AddressEntity mapFrom(AddressDto addressDto) { return modelMapper.map(addressDto, AddressEntity.class);}
}
