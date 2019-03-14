package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.Product;
import com.gameloft9.demo.dataaccess.model.system.SysRoleTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {


    /**
     * 获取所有产品表信息
     * @param start 开始
     * @param end 结束
     *
     */
    List<Product> findAll(
    @Param("start") int start,
    @Param("end") int end,
    @Param("productName") String productName,
    @Param("productType") String productType);

    /**
     * 获取所有角色个数
     * */
    int countGetAll( @Param("productName") String productName,
                     @Param("productType") String productType);

    /**
     * 通过ID删除产品表信息
     */
    void deleteById(String id);

    /**
     * 修改产品表信息
     */
     int update(Product product);

    /**
     * 增加产品表信息
     */
    int add(Product product);


    /**
     * 获取角色id
     */
    Product getProduct(String id);

    /**
     * 获取所有类表信息
     */
    List<Product> selectAll();
}
