package tech.anubislab.ProductService.service;

import static org.springframework.beans.BeanUtils.copyProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import tech.anubislab.ProductService.entity.Product;
import tech.anubislab.ProductService.exception.ProductServiceCustomerException;
import tech.anubislab.ProductService.model.ProductRequest;
import tech.anubislab.ProductService.model.ProductResponse;
import tech.anubislab.ProductService.repository.ProductRepository;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Long addProduct(ProductRequest productRequest) {
        log.info("Enregistrement du produit..");
        
        Product product = 
                Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        
        productRepository.save(product);

        log.info("Produit ajoute avec succes");

        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        log.info("Recuperation du produit");
        Product product
            = productRepository.findById(productId)
            .orElseThrow(
                ()-> new ProductServiceCustomerException("Le produit avec identifiant donnee est introuvable", "PRODUCT_NOT_FOUND"));

            ProductResponse productResponse 
                = new ProductResponse();

            copyProperties(product, productResponse);

        log.info("Produit recuperee");
        return productResponse;
    }
    
}
