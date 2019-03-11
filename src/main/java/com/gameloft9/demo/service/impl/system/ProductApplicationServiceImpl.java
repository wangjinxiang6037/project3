package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.ProductApplicationMapper;
import com.gameloft9.demo.dataaccess.model.system.ProductApplication;
import com.gameloft9.demo.dataaccess.model.system.ProductFormulaDetail;
import com.gameloft9.demo.service.api.system.ProductApplicationService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductApplicationServiceImpl implements ProductApplicationService {
   @Autowired
    ProductApplicationMapper productApplicationMapper;

    /**
     * 分页模糊查询
     * @param page
     * @param limit
     * @param productId
     * @param productType
     * @return
     */
    @Override
    public List<ProductApplication> findAll(String page, String limit, String productId, String productType) {

        PageRange pageRange = new PageRange(page, limit);

        return  productApplicationMapper.findAll(pageRange.getStart(),pageRange.getEnd(),productId,productType);
    }

    /**
     * 获取个数
     * @param productId
     * @param productType
     * @return
     */
    @Override
    public int countGetAll(String productId, String productType) {

        return productApplicationMapper.countGetAll(productId,productType);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(String id) {
        return productApplicationMapper.deleteById(id);
    }

    /**
     * 获取id
     * @param id
     * @return
     */
    @Override
    public ProductApplication getById(String id) {
        return productApplicationMapper.getById(id);
    }

    /**
     * 修改
     * @param productApplication
     * @return
     */
    @Override
    public int update(ProductApplication productApplication) {
        return productApplicationMapper.update(productApplication);
    }

    /**
     * 增加
     * @param productApplication
     * @return
     */
    @Override
    public int add(ProductApplication productApplication) {
        return productApplicationMapper.add(productApplication);
    }
}
