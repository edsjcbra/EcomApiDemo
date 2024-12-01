package com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos;

public record PaginationResponse(Integer page,
                                 Integer pageSize,
                                 Long totalElements,
                                 Integer totalPages) {
}
