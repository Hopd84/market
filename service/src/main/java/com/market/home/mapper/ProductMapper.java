package com.market.home.mapper;

import com.market.home.dto.ProductDto;
import com.market.home.entity.Product;
import com.market.home.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductMapper {
    private final ProductRepository productRepository;

    public Product mapToObject(ProductDto productDto){
        int departmentId = productRepository.getDepartmentId(productDto.getDepartmentName());
        return Product.builder()
                      .id(productDto.getId())
                      .name(productDto.getName())
                      .cost(productDto.getCost())
                      .departmentId(departmentId)
                      .build();
    }

    public ProductDto mapToDto(Product product){
        String departmentName = productRepository.getDepartmentName(product.getDepartmentId());
        return ProductDto.builder()
                      .id(product.getId())
                      .name(product.getName())
                      .cost(product.getCost())
                      .departmentName(departmentName)
                      .build();
    }

    public List<Product> mapToObjectList(List<ProductDto> productDtoList){
        return productDtoList.stream().map(this::mapToObject).collect(Collectors.toList());
    }

    public List<ProductDto> mapToObjectDtoList(List<Product> productList){
        return productList.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
