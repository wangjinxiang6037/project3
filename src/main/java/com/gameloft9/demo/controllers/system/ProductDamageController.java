package com.gameloft9.demo.controllers.system;


import com.gameloft9.demo.dataaccess.model.system.ProductApplication;
import com.gameloft9.demo.dataaccess.model.system.ProductDamage;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.ProductDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/damage")
public class ProductDamageController {

    @Autowired
    ProductDamageService productDamageService;

    /**
     * 分页模糊查询
     */
    @RequestMapping("list")
    @ResponseBody
    public IResult findAll(String page, String limit, String productId, String productType){
        List<ProductDamage> list = productDamageService.findAll(page, limit, productId, productType);

        return new PageResultBean<Collection<ProductDamage>>(list,productDamageService.countGetAll(productId,productType));
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public IResult deleteById(String id){

        productDamageService.deleteById(id);
        return new ResultBean<Boolean>();
    }

    /**
     * 获取id
     */
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    @ResponseBody
    public IResult getById(String id){
        ProductDamage byId = productDamageService.getById(id);
        return new ResultBean(byId);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public IResult update(ProductDamage productDamage){

        return new ResultBean(productDamageService.update(productDamage));
    }

    /**
     * 增加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public IResult add(ProductDamage productDamage){

        return new ResultBean(productDamageService.add(productDamage));
    }




}
