package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.ProductApplication;
import com.gameloft9.demo.dataaccess.model.system.ProductQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductQueryMapper {
    /**
     * 获取所有查询表信息
     * @param start 开始
     * @param end 结束
     *
     */
    List<ProductQuery> findAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("productId") String productId,
            @Param("productDamageId") String productDamageId);

    /**
     * 获取所有查询表个数
     * */
    int countGetAll( @Param("productId") String productId,
                     @Param("productDamageId") String productDamageId);

    /**
     * 通过ID删除查询表信息
     */
    int deleteById(String id);

    /**
     * 修改查询表信息
     */
    int update(ProductQuery productQuery);

    /**
     * 增加查询表信息
     */
    int add(ProductQuery productQuery);


    /**
     * 获取查询表id
     */
    ProductQuery getById(String id);


}
