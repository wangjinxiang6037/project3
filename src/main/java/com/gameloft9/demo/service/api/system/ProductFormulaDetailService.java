package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.ProductFormulaDetail;

import java.util.List;

public interface ProductFormulaDetailService {

    /**
     * 分页获取所有列表信息
     */
    List<ProductFormulaDetail> findAll(String page,String limit,String productFormulaId,String materialId);

    /**
     * 获取所有角色个数
     * */
    int countGetAll(String productFormulaId,String materialId);
}
