package com.example.demo.contollers;

import com.example.demo.TestDataUtil;
import com.example.demo.domain.entities.AddressEntity;
import com.example.demo.services.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AddressControllerIntegrationTests {

    private AddressService addressService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    public AddressControllerIntegrationTests(MockMvc mockMvc, AddressService addressService) {
        this.mockMvc = mockMvc;
        this.addressService = addressService;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testThatCreateAuthorSuccessfullyReturnsHttp201Created() throws Exception {
        AddressEntity testAddressA = TestDataUtil.createTestAddressEntityA();
        testAddressA.setId(null);
        String addressJson = objectMapper.writeValueAsString(testAddressA);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(addressJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }
}
