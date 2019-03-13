package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.ProductFromulaMapper;
import com.gameloft9.demo.dataaccess.dao.system.ProductMapper;
import com.gameloft9.demo.dataaccess.model.system.Product;
import com.gameloft9.demo.dataaccess.model.system.ProductFormula;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.service.api.system.ProductFormulaService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
@Service
@Transactional
public class ProductFormulaServiceImpl implements ProductFormulaService {
   @Autowired
    ProductFromulaMapper productFromulaMapper;
   @Autowired
    ProductMapper productMapper;

    /**
     * 分页模糊查询
     * @param page
     * @param limit
     * @param productId
     * @param createUser
     * @return
     */
    @Override
    public List<ProductFormula> findAll(String page, String limit, String productId, String createUser) {

        PageRange pageRange = new PageRange(page,limit);

        return productFromulaMapper.findAll(pageRange.getStart(),pageRange.getEnd(),productId,createUser);
    }
    /**
     * 获取个数
     * @param productId
     * @param createUser
     * @return
     */
    @Override
    public int countGetAll(String productId, String createUser) {
        return productFromulaMapper.countGetAll(productId,createUser);
    }



    /**
     * 通过id删除生产配方信息
     */
    @Override
    public int deleteById(String id) {
       productFromulaMapper.deleteById(id);

       return productFromulaMapper.deleteById(id);
    }

    /**
     * 修改生产配方信息
     * @param productFormula
     * @return
     */

    @Override
    public Boolean update(ProductFormula productFormula) {

        productFromulaMapper.update(productFormula);

        return true;
    }

    /**
     * 获取生产配方id
     * @param id
     * @return
     */
    @Override
    public ProductFormula getById(String id) {

        return productFromulaMapper.getById(id);
    }

    /**
     * 增加
     * @param productFormula
     * @return
     */
    @Override
    public String add(ProductFormula productFormula) {

        productFromulaMapper.add(productFormula);

        return  productFormula.getId();
    }

    /**
     * 获取所有类表信息
     * @return
     */
    @Override
    public List<ProductFormula> selectAll() {


        return productFromulaMapper.selectAll();
    }


}
