package com.gameloft9.demo.controllers.system;


import com.gameloft9.demo.dataaccess.model.system.ProductFormula;
import com.gameloft9.demo.dataaccess.model.system.ProductFormulaDetail;
import com.gameloft9.demo.dataaccess.model.system.ProductproduceBean;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.ProductFormulaDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/productdetail")
public class ProductFormulaDetailController {

    @Autowired
    ProductFormulaDetailService productFormulaDetailService;

    /**
     * 分页模糊查询
     */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public IResult findAll(String page, String limit, String productFormulaId, String materialId){
        List<ProductproduceBean> list = productFormulaDetailService.findAll(page, limit, productFormulaId, materialId);

      return new PageResultBean<List>(list,productFormulaDetailService.dataCount());
    }
    /**
     * 删除配方明细
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public IResult deleteById(String id){

        productFormulaDetailService.deleteById(id);
         return new ResultBean<Boolean>();
    }

    /**
     * 获取明细id
     */
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    @ResponseBody
    public IResult getById(String id){
        ProductproduceBean byId = productFormulaDetailService.getById(id);
        return new ResultBean(byId);
    }

    /**
     * 修改明细
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public IResult update(ProductproduceBean productproduceBean){

        return new ResultBean(productFormulaDetailService.update(productproduceBean));
    }

    /**
     * 增加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public IResult add(ProductFormulaDetail productFormulaDetail){

        return new ResultBean(productFormulaDetailService.add(productFormulaDetail));
    }



}
