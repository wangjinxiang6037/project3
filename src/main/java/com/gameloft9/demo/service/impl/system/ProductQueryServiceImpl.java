package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.ProductQueryMapper;
import com.gameloft9.demo.dataaccess.model.system.ProductQuery;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.service.api.system.ProductQueryService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductQueryServiceImpl implements ProductQueryService {

    @Autowired
    ProductQueryMapper productQueryMapper;

    /**
     * 分页
     * @param page
     * @param limit
     * @param productId
     * @param productDamageId
     * @return
     */
    @Override
    public List<ProductQuery> findAll(String page, String limit, String productId, String productDamageId) {

        PageRange pageRange = new PageRange(page, limit);
        return productQueryMapper.findAll(pageRange.getStart(),pageRange.getEnd(),productId,productDamageId);
    }

    /**
     * 获取条数
     * @param productId
     * @param productDamageId
     * @return
     */
    @Override
    public int countGetAll(String productId, String productDamageId) {
        return productQueryMapper.countGetAll(productId,productDamageId);
    }

    /**
     * 删除
     * @param id
     * @return
     */

    @Override
    public int deleteById(String id) {
        return productQueryMapper.deleteById(id);
    }

    @Override
    public ProductQuery getById(String id) {
        return productQueryMapper.getById(id);
    }

    /**
     * 修改
     * @param productQuery
     * @return
     */
    @Override
    public int update(ProductQuery productQuery) {
        return productQueryMapper.update(productQuery);
    }

    /**
     * 增加
     * @param productQuery
     * @return
     */
    @Override
    public int add(ProductQuery productQuery) {
        return productQueryMapper.add(productQuery);
    }
}
