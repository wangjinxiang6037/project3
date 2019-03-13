package com.gameloft9.demo.dataaccess.model.system;


import lombok.Data;



@Data
public class ProductproduceBean {
    private String id;
    private String materialId;

    private String productName;
    private String productType;

    private String productFormulaId;
    private String productId;
    private String type;

    private String materialNumber;

 /*   @Override
    public String toString() {
        return "ProductproduceBean{" +
                "id='" + id + '\'' +
                ", materialId='" + materialId + '\'' +
                ", productName='" + productName + '\'' +
                ", productType=" + productType +
                ", productFormulaId='" + productFormulaId + '\'' +
                ", productId='" + productId + '\'' +
                ", type='" + type + '\'' +
                ", materialNumber='" + materialNumber + '\'' +
                '}';
    }*/
}
