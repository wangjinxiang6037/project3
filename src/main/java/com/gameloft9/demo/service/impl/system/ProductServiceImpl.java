package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.ProductMapper;
import com.gameloft9.demo.dataaccess.model.system.Product;
import com.gameloft9.demo.dataaccess.model.system.SysRoleTest;
import com.gameloft9.demo.mgrframework.utils.CheckUtil;
import com.gameloft9.demo.service.api.system.ProductService;
import com.gameloft9.demo.service.beans.system.PageRange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional


public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    /**
     * 分页模糊查询
     * @param page
     * @param limit
     * @param productName
     * @param productType
     * @return
     */
    @Override
    public List<Product> findAll(String page,String limit,String productName,String productType) {
        PageRange pageRange = new PageRange(page,limit);

        return  productMapper.findAll(pageRange.getStart(),pageRange.getEnd(),productName,productType);
    }

    /**
     * 条数
     * @param productName
     * @param productType
     * @return
     */
    @Override
    public int countGetAll(String productName, String productType) {
        return productMapper.countGetAll(productName,productType);
    }


    /**
     * 根据ID删除
     * @param id
     */
    @Override
    public void deleteById(String id) {
        productMapper.deleteById(id);
    }


    /**
     * 获取产品ID
     * @param id
     * @return
     */
    @Override
    public Product getProduct(String id) {
        return productMapper.getProduct(id);
    }

    /**
     * 修改
     * @param
     */
    @Override
    public Boolean update(Product product) {

        productMapper.update(product);
     return true;
    }

    /**
     * 增加
     * @param product
     */
    @Override
    public String add(Product product) {

        productMapper.add(product);

        return product.getId();
    }


}
