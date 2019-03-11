package com.gameloft9.demo.controllers.system;


import com.gameloft9.demo.dataaccess.model.system.ProductApplication;

import com.gameloft9.demo.dataaccess.model.system.ProductFormula;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.ProductApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/application")
public class productApplicationController {
    @Autowired
    ProductApplicationService productApplicationService;

    /**
     * 分页模糊查询
     */
    @RequestMapping("list")
    @ResponseBody
    public IResult findAll(String page, String limit, String productId, String productType){
        List<ProductApplication> list = productApplicationService.findAll(page, limit, productId, productType);
        System.out.println(list);
        return new PageResultBean<Collection<ProductApplication>>(list,productApplicationService.countGetAll(productId,productType));
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public IResult deleteById(String id){

        productApplicationService.deleteById(id);
        return new ResultBean<Boolean>();
    }

    /**
     * 获取id
     */
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    @ResponseBody
    public IResult getById(String id){
        ProductApplication byId = productApplicationService.getById(id);
        return new ResultBean(byId);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public IResult update(ProductApplication productApplication){

        return new ResultBean(productApplicationService.update(productApplication));
    }

    /**
     * 增加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public IResult add(ProductApplication productApplication){

        return new ResultBean(productApplicationService.add(productApplication));
    }


}
