package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.ProductApplication;
import com.gameloft9.demo.dataaccess.model.system.ProductFormulaDetail;

import java.util.List;

public interface ProductApplicationService {

    /**
     * 分页获取所有列表信息
     */
    List<ProductApplication> findAll(String page, String limit, String productId, String productType);

    /**
     * 获取所有角色个数
     * */
    int countGetAll(String productId,String productType);

    /**
     * 通过ID删除生产配方明细
     */
    int deleteById(String id);

    /**
     * 获取生产配方明细id
     */
    ProductApplication getById(String id);

    /**
     * 修改生产配方明细
     */
    int  update(ProductApplication productApplication);

    /**
     * 增加
     */
    int add(ProductApplication productApplication);


}
