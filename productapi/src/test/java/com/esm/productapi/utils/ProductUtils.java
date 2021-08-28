package com.esm.productapi.utils;


import dto.request.ProductDTO;
import entities.Product;

public class ProductUtils {

    private static final String PRODUCT_NAME = "Caneta";
    private static final String DESCRICAO = "Colorida";
    private static final long PRODUCT_ID = 1L;

    public static ProductDTO createFakeDTO() {
        return ProductDTO.builder()
                .productName(PRODUCT_NAME)
                .descricao(DESCRICAO)
                .build();
    }

    public static Product createFakeEntity() {
        return Product.builder()
                .id(PRODUCT_ID)
                .productName(PRODUCT_NAME)
                .descricao(DESCRICAO)
                .build();
    }

}
