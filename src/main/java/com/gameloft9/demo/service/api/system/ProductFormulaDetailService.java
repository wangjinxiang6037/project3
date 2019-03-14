package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.ProductFormula;
import com.gameloft9.demo.dataaccess.model.system.ProductFormulaDetail;
import com.gameloft9.demo.dataaccess.model.system.ProductproduceBean;

import java.util.List;

public interface ProductFormulaDetailService {

    /**
     * 分页获取所有列表信息
     */
    List<ProductproduceBean> findAll(String page, String limit, String productFormulaId, String materialId);

    /**
     * 获取所有角色个数
     * */
    //int countGetAll(String productFormulaId,String materialId);

    int dataCount();

    /**
     * 通过ID删除生产配方明细
     */
    int deleteById(String id);

    /**
     * 获取生产配方明细id
     */
    ProductproduceBean getById(String id);

    /**
     * 修改生产配方明细
     */
    int  update(ProductproduceBean productproduceBean);

    /**
     * 增加
     */
    int add(ProductFormulaDetail productFormulaDetail);

}
