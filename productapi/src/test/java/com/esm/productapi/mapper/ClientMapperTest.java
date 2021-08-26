package com.esm.productapi.mapper;

import com.esm.productapi.utils.ClientUtils;
import dto.mapper.ClientMapper;
import dto.request.ClientDTO;
import dto.request.PhoneDTO;
import entities.Client;
import entities.Phone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClientMapperTest {
    @Autowired
    private ClientMapper clientMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        ClientDTO clientDTO = ClientUtils.createFakeDTO();
        Client client = clientMapper.toModel(clientDTO);

        assertEquals(clientDTO.getFirstName(), client.getFirstName());
        assertEquals(clientDTO.getLastName(), client.getLastName());
        assertEquals(clientDTO.getCpf(), client.getCpf());

        Phone phone = client.getPhones().get(0);
        PhoneDTO phoneDTO = clientDTO.getPhones().get(0);

        assertEquals(phoneDTO.getType(), phone.getType());
        assertEquals(phoneDTO.getNumber(), phone.getNumber());
    }

    @Test
    void testGivenClientEntityThenReturnClientDTO() {
        Client client = ClientUtils.createFakeEntity();
        ClientDTO clientDTO = clientMapper.toDTO(client);

        assertEquals(client.getFirstName(), clientDTO.getFirstName());
        assertEquals(client.getLastName(), clientDTO.getLastName());
        assertEquals(client.getCpf(), clientDTO.getCpf());

        Phone phone = client.getPhones().get(0);
        PhoneDTO phoneDTO = clientDTO.getPhones().get(0);

        assertEquals(phone.getType(), phoneDTO.getType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());
    }

}
