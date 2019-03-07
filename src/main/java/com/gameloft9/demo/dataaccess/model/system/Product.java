package com.gameloft9.demo.dataaccess.model.system;


import lombok.Data;

@Data
public class Product {

    private String id;
    private String productName;
    private String productType;
    private String productDescribe;
    private String productPrice;
    private String productAddress;

}