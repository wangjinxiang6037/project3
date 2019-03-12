package com.gameloft9.demo.dataaccess.model.system;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ProductFormula {

private String id;
private String productId;
private String type;
private String createUser;
@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
private Date createTime;
}
