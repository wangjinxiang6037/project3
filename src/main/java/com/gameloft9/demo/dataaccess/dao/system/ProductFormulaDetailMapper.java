package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.ProductFormulaDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductFormulaDetailMapper {

    /**
     * 生产配方明细分页模糊查询
     */
    List<ProductFormulaDetail> findAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("productFormulaId") String productFormulaId,
            @Param("materialId") String materialId);

    /**
     * 获取所有生产配方明细个数
     * */
    int countGetAll( @Param("productFormulaId") String productFormulaId,
                     @Param("materialId") String materialId);

   /**
    * 通过id删除生产配方信息
    */
    int deleteById(String id);

   /**
   * 获取生产配方明细id
   */
   ProductFormulaDetail getById(String id);

    /**
     * 修改生产配方明细
     */
    int update(ProductFormulaDetail productFormulaDetail);

    /**
     * 增加
     */
    int add(ProductFormulaDetail productFormulaDetail);
}
