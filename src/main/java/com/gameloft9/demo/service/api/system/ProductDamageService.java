package com.gameloft9.demo.service.api.system;


import com.gameloft9.demo.dataaccess.model.system.ProductDamage;

import java.util.List;

public interface ProductDamageService {

    /**
     * 分页获取所有列表信息
     */
    List<ProductDamage> findAll(String page, String limit, String productId, String productType);

    /**
     * 获取所有角色个数
     * */
    int countGetAll(String productId,String productType);

    /**
     * 通过ID删除
     */
    int deleteById(String id);

    /**
     * 获取破损id
     */
    ProductDamage getById(String id);

    /**
     * 修改破损明细
     */
    int  update(ProductDamage productDamage);

    /**
     * 增加
     */
    int add(ProductDamage productDamage);



}
