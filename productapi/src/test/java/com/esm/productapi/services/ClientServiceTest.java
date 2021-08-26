package com.esm.productapi.services;


import dto.mapper.ClientMapper;
import dto.request.ClientDTO;
import dto.response.MessageResponseDTO;
import entities.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.ClientRepository;
import services.ClientService;

import static com.esm.productapi.utils.ClientUtils.createFakeDTO;
import static com.esm.productapi.utils.ClientUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService clientService;

    @Test
    void testGivenClientDTOThenReturnSuccessSavedMessage() {
        ClientDTO clientDTO = createFakeDTO();
        Client expectedSavedPerson = createFakeEntity();

        when(clientMapper.toModel(clientDTO)).thenReturn(expectedSavedPerson);
        when(clientRepository.save(any(Client.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = clientService.create(clientDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedClientId) {
        return MessageResponseDTO.builder()
                .message("Client successfully created with ID " + savedClientId)
                .build();
    }
}
