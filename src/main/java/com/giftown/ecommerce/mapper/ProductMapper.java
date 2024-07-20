package com.giftown.ecommerce.mapper;

import com.giftown.ecommerce.dto.product.ProductResponse;
import com.giftown.ecommerce.service.Implementation.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductMapper {

    private final CommonMapper commonMapper;
    private final ProductService productService;

    public ProductMapper(CommonMapper commonMapper, ProductService productService) {
        this.commonMapper = commonMapper;
        this.productService = productService;
    }

    public ProductResponse getProductById(Long productId) {
        return commonMapper.convertToResponse(productService.getProductById(productId), ProductResponse.class);
    }

    public List<ProductResponse> getProductsByIds(List<Long> productIds) {
        return commonMapper.convertToResponseList(productService.getProductsByIds(productIds), ProductResponse.class);
    }

//    public HeaderResponse<ProductResponse> getAllProducts(Pageable pageable) {
//        Page<Product> products = productService.getAllProducts(pageable);
//        return commonMapper.getHeaderResponse(products.getContent(), products.getTotalPages(), products.getTotalElements(), ProductResponse.class);
//    }
//
//    public HeaderResponse<ProductResponse> findProductsByFilterParams(ProductSearchRequest filter, Pageable pageable) {
//        Page<Product> products = productService.findProductsByFilterParams(filter, pageable);
//        return commonMapper.getHeaderResponse(products.getContent(), products.getTotalPages(), products.getTotalElements(), ProductResponse.class);
//    }
//
//    public List<ProductResponse> findByCategory(String category) {
//        return commonMapper.convertToResponseList(productService.findByCategory(category), ProductResponse.class);
//    }
//
//    public List<ProductResponse> findByBrand(String brand) {
//        return commonMapper.convertToResponseList(productService.findByBrand(brand), ProductResponse.class);
//    }
//
//    public HeaderResponse<ProductResponse> findByInputText(SearchProduct searchType, String text, Pageable pageable) {
//        Page<Product> products = productService.findByInputText(searchType, text, pageable);
//        return commonMapper.getHeaderResponse(products.getContent(), products.getTotalPages(), products.getTotalElements(), ProductResponse.class);
//    }
//
//    public FullProductResponse saveProduct(ProductRequest productRequest, MultipartFile file, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new InputFieldException(bindingResult);
//        }
//        Product product = commonMapper.convertToEntity(productRequest, Product.class);
//        return commonMapper.convertToResponse(productService.saveProduct(product, file), FullProductResponse.class);
//    }
//
//    public String deleteProduct(Long productId) {
//        return productService.deleteProduct(productId);
//    }
}
