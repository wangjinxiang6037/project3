package com.gameloft9.demo.dataaccess.model.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ProductproduceFormula {
    private String id;
    private String productFormulaId;
    private String materialId;
    private Integer materialNumber;

    private String productId;
    private String type;

    private String productName;
    private String productType;


}
