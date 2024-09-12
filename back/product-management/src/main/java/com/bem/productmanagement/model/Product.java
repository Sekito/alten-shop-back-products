package com.bem.productmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private InventoryStatusEnum inventoryStatus;
    //private String inventoryStatus;
    private String image;
    private Double rating;
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    //private String category;
    //@ManyToOne
    //private Category category;

    /*public void setInventoryStatus(String status) {
        this.inventoryStatus = InventoryStatus.fromString(status);
    }*/

}
