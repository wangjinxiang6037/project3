package com.gameloft9.demo.service.api.system;


import com.gameloft9.demo.dataaccess.model.system.Product;
import com.gameloft9.demo.dataaccess.model.system.ProductFormula;

import java.util.List;

public interface ProductFormulaService {
    /**
     * 获取所有产品表信息
     */
    List<ProductFormula> findAll(String page, String limit, String productId, String createUser);

    /**
     * 获取所有角色个数
     * */
    int countGetAll(String productId,String createUser);

    /**
     * 通过id删除生产配方信息
     */
    int deleteById(String id);

    /**
     * 修改生产配方信息
     */
    Boolean update(ProductFormula productFormula);

    /**
     * 获取生产配方id
     */
    ProductFormula getById(String id);

    /**
     * 增加生产配方信息
     */
    String add(ProductFormula productFormula);


}
