package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.ProductDamageMapper;
import com.gameloft9.demo.dataaccess.model.system.ProductDamage;
import com.gameloft9.demo.service.api.system.ProductDamageService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductDamageServiceImpl implements ProductDamageService {
    @Autowired
    ProductDamageMapper productDamageMapper;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @param productId
     * @param productType
     * @return
     */
    @Override
    public List<ProductDamage> findAll(String page, String limit, String productId, String productType) {
        PageRange pageRange = new PageRange(page,limit);
        return productDamageMapper.findAll(pageRange.getStart(),pageRange.getEnd(),productId,productType);
    }

    /**
     * 获取个数
     * @param productId
     * @param productType
     * @return
     */
    @Override
    public int countGetAll(String productId, String productType) {
        return productDamageMapper.countGetAll(productId,productType);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(String id) {
        return productDamageMapper.deleteById(id);
    }

    /**
     * 获取id
     * @param id
     * @return
     */
    @Override
    public ProductDamage getById(String id) {
        return productDamageMapper.getById(id);
    }

    /**
     * 修改
     * @param productDamage
     * @return
     */
    @Override
    public int update(ProductDamage productDamage) {
        return productDamageMapper.update(productDamage);
    }

    /**
     * 增加
     * @param productDamage
     * @return
     */
    @Override
    public int add(ProductDamage productDamage) {
        return productDamageMapper.add(productDamage);
    }
}
