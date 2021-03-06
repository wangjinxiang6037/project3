package com.gameloft9.demo.dataaccess.dao.system;


import com.gameloft9.demo.dataaccess.model.system.ProductDamage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDamageMapper {

    /**
     * 获取所有产品表信息
     * @param start 开始
     * @param end 结束
     *
     */
        List<ProductDamage> findAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("productId") String productId,
            @Param("productType") String productType);

    /**
     * 获取所有角色个数
     * */
    int countGetAll( @Param("productId") String productId,
                     @Param("productType") String productType);

    /**
     * 通过ID删除产品表信息
     */
    int deleteById(String id);

    /**
     * 修改产品表信息
     */
    int update(ProductDamage productDamage);

    /**
     * 增加产品表信息
     */
    int add(ProductDamage productDamage);


    /**
     * 获取角色id
     */
    ProductDamage getById(String id);


}
