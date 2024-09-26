package com.giftown.ecommerce.mapper;

import com.giftown.ecommerce.dto.product.ProductResponseModel;
import com.giftown.ecommerce.dto.product.ProductReviewResponseModel;
import com.giftown.ecommerce.dto.product.ProductSizeResponseModel;
import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.entity.ProductReview;
import com.giftown.ecommerce.entity.ProductSize;
import com.giftown.ecommerce.service.IProductService;
import com.giftown.ecommerce.service.Implementation.ProductService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductService productService;

    public ProductResponseModel getProductById(Long productId) {
        return this.convertToModel(productService.getProductById(productId));
    }

    public List<ProductResponseModel> getAllProducts(List<Product> products) {
        return products.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    private ProductResponseModel convertToModel(Product product) {
       if (product == null) {
           throw new IllegalArgumentException("Product cannot be null");
       }
           modelMapper.typeMap(Product.class, ProductResponseModel.class).addMappings(mapper -> {
               mapper.map(Product::getId, ProductResponseModel::setId);
               mapper.map(Product::getProductCode, ProductResponseModel::setProductCode);
               mapper.map(Product::getName, ProductResponseModel::setName);
               mapper.map(src -> src.getCategory().getCategoryname(), ProductResponseModel::setCategory);
               mapper.map(src -> src.getMetadata().getBrand(), ProductResponseModel::setBrand);
               mapper.map(src -> src.getMetadata().getDescription(), ProductResponseModel::setDescription);
               mapper.map(src -> src.getMetadata().getPrice(), ProductResponseModel::setPrice);
               mapper.map(src -> src.getMetadata().getQuantity(), ProductResponseModel::setQuantity);
               mapper.map(src -> src.getMetadata().getImageUrl(), ProductResponseModel::setImageUrl);
               mapper.map(src -> src.getMetadata().getSku(), ProductResponseModel::setSku);
               mapper.map(src -> src.getMetadata().getWeight(), ProductResponseModel::setWeight);
               mapper.map(src -> src.getMetadata().getColor(), ProductResponseModel::setColor);
               mapper.map(src -> src.getMetadata().getMaterial(), ProductResponseModel::setMaterial);
               mapper.map(src -> src.getMetadata().getManufacturer(), ProductResponseModel::setManufacturer);
               mapper.map(src -> src.getMetadata().isAvailability(), ProductResponseModel::setAvailability);
               mapper.map(src -> src.getReviews(), ProductResponseModel::setReviews);
               mapper.map(src -> src.getSizes(), ProductResponseModel::setSizes);
//               mapper.using(reviewConverter).map(src -> src.getReviews(), ProductResponseModel::setReviews);
//               mapper.using(sizeConverter).map(src -> src.getSizes(), ProductResponseModel::setSizes);
           });
           return modelMapper.map(product, ProductResponseModel.class);
    }

//    private final Converter<List<ProductReview>, List<ProductReviewResponseModel>> reviewConverter = new Converter<List<ProductReview>, List<ProductReviewResponseModel>>() {
//        @Override
//    public List<ProductReviewResponseModel> convert(MappingContext<List<ProductReview>, List<ProductReviewResponseModel>> context) {
//        return context.getSource() == null ? null : context.getSource().stream()
//                .map(review -> new ProductReviewResponseModel(review.getId(), review.getAuthor(), review.getMessage(), review.getRating()))
//                .collect(Collectors.toList());
//    }
//};
//
//private final Converter<List<ProductSize>, List<ProductSizeResponseModel>> sizeConverter = new Converter<List<ProductSize>, List<ProductSizeResponseModel>>() {
//    @Override
//    public List<ProductSizeResponseModel> convert(MappingContext<List<ProductSize>, List<ProductSizeResponseModel>> context) {
//        return context.getSource() == null ? null : context.getSource().stream()
//                .map(size -> new ProductSizeResponseModel(size.getId(), size.getSize(), size.getAdditionalPrice()))
//                .collect(Collectors.toList());
//    }
//};
}
