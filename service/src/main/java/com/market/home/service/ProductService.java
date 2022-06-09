package com.market.home.service;

import com.market.home.dto.ProductDto;
import com.market.home.mapper.ProductMapper;
import com.market.home.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public List<ProductDto> findAll(){
        return mapper.mapToObjectDtoList(productRepository.findAll());
    }
}
