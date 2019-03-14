package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.ProductFormula;
import com.gameloft9.demo.dataaccess.model.system.ProductFormulaDetail;
import com.gameloft9.demo.dataaccess.model.system.ProductproduceBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductFormulaDetailMapper {

    /**
     * 生产配方明细分页模糊查询
     */
    List<ProductproduceBean> findAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("productFormulaId") String productFormulaId,
            @Param("materialId") String materialId);

    /**
     * 获取所有加工单个数
     * */
    /*int countGetAll( @Param("productFormulaId") String productFormulaId,
                     @Param("materialId") String materialId);*/

    int dataCount();

   /**
    * 通过id删除信息
    */
    int deleteById(String id);

   /**
   * 获取id
   */
   ProductproduceBean getById(String id);

    /**
     * 修改
     */
    int update(ProductproduceBean productproduceBean);

    /**
     * 增加
     */
    int add(ProductFormulaDetail productFormulaDetail);


}
