package tech.anubislab.ProductService.service;

import tech.anubislab.ProductService.model.ProductRequest;
import tech.anubislab.ProductService.model.ProductResponse;

public interface ProductService {

    Long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long productId);
    
}
