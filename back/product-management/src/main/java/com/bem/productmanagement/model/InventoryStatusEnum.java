package com.bem.productmanagement.model;

import com.bem.productmanagement.exception.BadRequestException;

public enum InventoryStatusEnum {
    INSTOCK,
    OUTOFSTOCK,
    LOWSTOCK;

    public static InventoryStatusEnum fromString(String status)  {
        try {
            return InventoryStatusEnum.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid inventory status: " + status);
        }
    }
}
