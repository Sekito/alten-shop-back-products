package com.bem.productmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    @NotNull(message = "Code cannot be null")
    @NotBlank(message = "Code cannot be empty or blank")
    private String code;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty or blank")
    private String name;
    private String description;
    @NotNull(message = "Price cannot be null")
    private Double price;
    @NotNull(message = "Quantity cannot be null")
    private Integer quantity;
    @NotNull(message = "Inventory status cannot be null")
    @NotBlank(message = "Inventory status cannot be empty or blank")
    private String inventoryStatus;
    @NotNull(message = "Category cannot be null")
    @NotBlank(message = "Category cannot be empty or blank")
    private String category;
    private String image;
    private Double rating;


    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }
}
