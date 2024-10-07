package com.giftown.ecommerce.mapper;

import com.giftown.ecommerce.dto.HeaderResponse;
import com.giftown.ecommerce.dto.order.OrderResponseModel;
import com.giftown.ecommerce.dto.product.ProductResponseModel;
import com.giftown.ecommerce.dto.product.ProductReviewResponseModel;
import com.giftown.ecommerce.dto.product.ProductSizeResponseModel;
import com.giftown.ecommerce.entity.Order;
import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.entity.ProductReview;
import com.giftown.ecommerce.entity.ProductSize;
import com.giftown.ecommerce.service.IProductService;
import com.giftown.ecommerce.service.Implementation.ProductService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private IProductService productService;

    public ProductResponseModel getProductById(Long productId) {
      //  return this.convertToModel(productService.getProductById(productId), ProductResponseModel.class);
        return null;
    }

    public HeaderResponse<ProductResponseModel> getAllProducts(Pageable pageable) {

        Page<Product> products = productService.getAllProducts(pageable);
        return commonMapper.getHeaderResponse(products.getContent(), products.getTotalPages(), products.getTotalElements(), ProductResponseModel.class);

    }

    public List<ProductSizeResponseModel> getAvailableSizes(Long productId, Long subCategoryId) {
        return commonMapper.convertToResponseList(productService.getAvailableSizes(productId, subCategoryId), ProductSizeResponseModel.class);
    }
//
//     HeaderResponse<ProductResponseModel> getHeaderResponse(List<Product> products, Integer totalPages, Long totalElements, Class<ProductResponseModel> type) {
//        List<ProductResponseModel> response = products.stream().map(product -> this.convertToModel(product, ProductResponseModel.class))
//              .collect(Collectors.toList());
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.add("page-total-count", String.valueOf(totalPages));
//        responseHeaders.add("page-total-elements", String.valueOf(totalElements));
//        return new HeaderResponse<ProductResponseModel>(response, responseHeaders);
//    }

//    private <S, T> T convertToModel(S source, Class<T> targetClass) {
//       if (source == null) {
//           throw new IllegalArgumentException("Product cannot be null");
//       }
//        if (source instanceof Product && targetClass == ProductResponseModel.class) {
//            modelMapper.typeMap(Product.class, ProductResponseModel.class).addMappings(mapper -> {
//                mapper.map(Product::getId, ProductResponseModel::setId);
//                mapper.map(Product::getProductCode, ProductResponseModel::setProductCode);
//                mapper.map(Product::getName, ProductResponseModel::setName);
////                mapper.map(src -> src.getCategory().getCategoryname(), ProductResponseModel::setCategory);
////                mapper.map(src -> src.getCategory().getImageUrl(), ProductResponseModel::setCategoryImageUrl);
////                mapper.map(src -> src.getCategory().getSubCategoryImageUrl(), ProductResponseModel::setSubCategoryImageUrl);
//                mapper.map(src -> src.getMetadata().getBrand(), ProductResponseModel::setBrand);
//                mapper.map(src -> src.getMetadata().getDescription(), ProductResponseModel::setDescription);
//                mapper.map(src -> src.getMetadata().getAddInformation(), ProductResponseModel::setAddInformation);
//                mapper.map(src -> src.getMetadata().getPrice(), ProductResponseModel::setPrice);
//                mapper.map(src -> src.getMetadata().getQuantity(), ProductResponseModel::setQuantity);
//                mapper.map(src -> src.getMetadata().getImageUrl(), ProductResponseModel::setImageUrl);
//                mapper.map(src -> src.getMetadata().getSku(), ProductResponseModel::setSku);
//                mapper.map(src -> src.getMetadata().getWeight(), ProductResponseModel::setWeight);
//                mapper.map(src -> src.getMetadata().getColor(), ProductResponseModel::setColor);
//                mapper.map(src -> src.getMetadata().getMaterial(), ProductResponseModel::setMaterial);
//                mapper.map(src -> src.getMetadata().getManufacturer(), ProductResponseModel::setManufacturer);
//                mapper.map(src -> src.getMetadata().isAvailability(), ProductResponseModel::setAvailability);
//                mapper.map(src -> src.getMetadata().isTrending(), ProductResponseModel::setIsTrending);
//                mapper.map(src -> src.getReviews(), ProductResponseModel::setReviews);
//                mapper.map(src -> src.getSizes(), ProductResponseModel::setSizes);
//                mapper.map(src -> src.getCategory(), ProductResponseModel::setCategory);
//                mapper.map(src -> src.getSubCategory(), ProductResponseModel::setSubCategory);
//            });
//        }
//           return modelMapper.map(source, targetClass);
//    }
}
