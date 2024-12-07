package com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.ProductEntity;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.TagEntity;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDto(Long productId,
                                 String productName,
                                 List<TagResponseDto> tags) {

    public static ProductResponseDto fromEntity(ProductEntity product) {

        return new ProductResponseDto(
                product.getProductId(),
                product.getProductName(),
                getTags(product.getTags())
        );
    }

    private static List<TagResponseDto> getTags(List<TagEntity> tags) {
        return tags.stream()
                .map(TagResponseDto::fromEntity).toList();
    }
}
