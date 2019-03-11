package com.gameloft9.demo.dataaccess.model.system;

import lombok.Data;

@Data
public class ProductDamage {
    private String id;
    private String productId;
    private String productType;
    private String productSize;
    private Integer productNumber;

}
