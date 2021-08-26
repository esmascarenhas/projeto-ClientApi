package com.esm.productapi.utils;

import dto.request.ClientDTO;
import entities.Client;

import java.time.LocalDate;
import java.util.Collections;

public class ClientUtils {
    private static final String FIRST_NAME = "Emerson";
    private static final String LAST_NAME = "Mascarenhas";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1977, 8, 28);

    public static ClientDTO createFakeDTO() {
        return ClientDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Client createFakeEntity() {
        return Client.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }

}