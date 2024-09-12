package com.bem.productmanagement.mappers;

import com.bem.productmanagement.dto.ProductDTO;
import com.bem.productmanagement.model.CategoryEnum;
import com.bem.productmanagement.model.InventoryStatusEnum;
import com.bem.productmanagement.model.Product;

public class ProductMapper {

    public static Product toEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setCode(productDTO.getCode());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setInventoryStatus(InventoryStatusEnum.fromString(productDTO.getInventoryStatus()));
        product.setImage(productDTO.getImage());
        product.setRating(productDTO.getRating());
        product.setCategory(CategoryEnum.fromString(productDTO.getCategory()));

        return product;
    }

    public static ProductDTO toDto(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setCode(product.getCode());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setInventoryStatus(product.getInventoryStatus().name());
        productDTO.setImage(product.getImage());
        productDTO.setRating(product.getRating());
        productDTO.setCategory(product.getCategory().name());

        return productDTO;
    }
}
