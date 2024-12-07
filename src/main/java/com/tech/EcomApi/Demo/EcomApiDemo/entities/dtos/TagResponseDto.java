package com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.TagEntity;

public record TagResponseDto(Long id, String name) {
    public static TagResponseDto fromEntity(TagEntity tagEntity) {
        return new TagResponseDto(
                tagEntity.getId(),
                tagEntity.getName());
    }
}
