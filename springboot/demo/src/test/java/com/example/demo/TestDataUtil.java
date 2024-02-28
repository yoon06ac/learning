package com.example.demo;

import com.example.demo.domain.dtos.AddressDto;
import com.example.demo.domain.entities.AddressEntity;

public final class TestDataUtil {

    private TestDataUtil() {}

    public static AddressEntity createTestAddressEntityA() {
        return AddressEntity.builder()
                .id(1L)
                .name("Steve Jobs")
                .address("1 Apple Way")
                .phone(1234567890)
                .build();
    }

    public static AddressDto createTestAddressDtoA() {
        return AddressDto.builder()
                .id(1L)
                .name("Elon Musk")
                .address("69 Tesla lane")
                .phone(987654321)
                .build();
    }

    public static AddressEntity createTestAddressB() {
        return AddressEntity.builder()
                .id(2L)
                .name("Bill Gates")
                .address("100 dollar bill blvd")
                .phone(10000000)
                .build();
    }
}
