package com.gameloft9.demo.dataaccess.dao.system;


import com.gameloft9.demo.dataaccess.model.system.ProductFormula;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductFromulaMapper {
    /**
     * 获取所有产品表信息
     * @param start 开始
     * @param end 结束
     *
     */
    List<ProductFormula> findAll(
    @Param("start") int start,
    @Param("end") int end,
    @Param("productId") String productId,
    @Param("createUser") String createUser);

    /**
     * 获取所有角色个数
     * */
    int countGetAll( @Param("productId") String productId,
                     @Param("createUser") String createUser);

    /**
     * 通过id删除生产配方信息
     */
    int deleteById(String id);

    /**
     * 修改生产配方信息
     */
    int update(ProductFormula productFormula);

    /**
     * 获取生产配方id
     */
    ProductFormula getById(String id);

    /**
     * 增加生产配方信息
     */
    int add(ProductFormula productFormula);
}
