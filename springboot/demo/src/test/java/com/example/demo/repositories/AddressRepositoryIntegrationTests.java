package com.example.demo.repositories;

import com.example.demo.TestDataUtil;
import com.example.demo.contollers.AddressControllerIntegrationTests;
import com.example.demo.domain.entities.AddressEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AddressRepositoryIntegrationTests {

    private AddressRepository underTest;

    @Autowired
    public void AddressEntityRepositoryIntegrationTests(AddressRepository underTest) {
        this.underTest = underTest;
    }
}

