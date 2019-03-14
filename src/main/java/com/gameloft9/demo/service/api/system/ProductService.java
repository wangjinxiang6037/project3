package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.Product;
import com.gameloft9.demo.dataaccess.model.system.SysRoleTest;

import java.util.List;

public interface ProductService {

    /**
     * 获取所有产品表信息
     */
    List<Product> findAll(String page,String limit,String productName,String productType);

    /**
     * 获取所有角色个数
     * */
    int countGetAll(String productName,String productType);

    /**
     * 通过ID删除产品表信息
     */
    void deleteById(String id);

    /**
     * 修改产品表信息
     */
    Boolean update(Product product);

    /**
     * 增加产品表信息
     */
    String add(Product product);

    /**
     * 获取角色id
     */
    Product getProduct(String id);

    /**
     * 获取所有列表信息
     */
    List<Product> selectAll();

}
