package com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos;

import java.util.List;

public record ApiPageResponse<T>(List<T> data, PaginationResponse pagination) {
}
