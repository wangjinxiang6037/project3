package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.ProductFormulaDetailMapper;
import com.gameloft9.demo.dataaccess.model.system.ProductFormulaDetail;
import com.gameloft9.demo.service.api.system.ProductFormulaDetailService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class ProductFormulaDetailServiceImpl implements ProductFormulaDetailService {
    @Autowired
    ProductFormulaDetailMapper productFormulaDetailMapper;

    /**
     * 分页模糊查询
     * @param page
     * @param limit
     * @param productFormulaId
     * @param materialId
     * @return
     */
    @Override
    public List<ProductFormulaDetail> findAll(String page, String limit, String productFormulaId, String materialId) {
        PageRange pageRange = new PageRange(page, limit);

        return productFormulaDetailMapper.findAll(pageRange.getStart(),pageRange.getEnd(),productFormulaId,materialId);
    }

    /**
     * 获取个数
     * @param productFormulaId
     * @param materialId
     * @return
     */
    @Override
    public int countGetAll(String productFormulaId, String materialId) {
        return productFormulaDetailMapper.countGetAll(productFormulaId,materialId);
    }

    /**
     * 通过ID删除生产配方明细
     * @param id
     * @return
     */
    @Override
    public int deleteById(String id) {
        return productFormulaDetailMapper.deleteById(id);
    }

    /**
     * 获取id
     * @param id
     * @return
     */
    @Override
    public ProductFormulaDetail getById(String id) {
        return productFormulaDetailMapper.getById(id);
    }

    /**
     * 修改明细
     * @param productFormulaDetail
     * @return
     */
    @Override
    public int update(ProductFormulaDetail productFormulaDetail) {
        return productFormulaDetailMapper.update(productFormulaDetail);
    }

    /**
     * 增加
     * @param productFormulaDetail
     * @return
     */
    @Override
    public int add(ProductFormulaDetail productFormulaDetail) {

        return productFormulaDetailMapper.add(productFormulaDetail);
    }
}
