package com.gameloft9.demo.service.api.system;


import com.gameloft9.demo.dataaccess.model.system.ProductQuery;

import java.util.List;

public interface ProductQueryService {

    /**
     * 分页获取所有列表信息
     */
    List<ProductQuery> findAll(String page, String limit, String productId, String productDamageId);

    /**
     * 获取所有查询表个数
     * */
    int countGetAll(String productId,String productDamageId);

    /**
     * 通过ID删除
     */
    int deleteById(String id);

    /**
     * 获取id
     */
    ProductQuery getById(String id);

    /**
     * 修改
     */
    int  update(ProductQuery productQuery);

    /**
     * 增加
     */
    int add(ProductQuery productQuery);

}
