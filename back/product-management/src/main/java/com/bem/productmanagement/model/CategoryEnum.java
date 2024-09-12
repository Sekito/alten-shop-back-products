package com.bem.productmanagement.model;

import com.bem.productmanagement.exception.BadRequestException;

public enum CategoryEnum {
    Accessories,
    Clothing,
    Electronics,
    Fitness;

    public static CategoryEnum fromString(String status)  {
        try {
            return CategoryEnum.valueOf(status);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid Category : " + status);
        }
    }

}