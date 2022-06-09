package com.market.home.dto;

import com.market.home.entity.StoreDepartment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private long id;
    private String name;
    private double cost;
    private String departmentName;
}
