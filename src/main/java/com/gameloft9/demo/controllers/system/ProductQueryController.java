package com.gameloft9.demo.controllers.system;


import com.gameloft9.demo.dataaccess.model.system.ProductApplication;
import com.gameloft9.demo.dataaccess.model.system.ProductQuery;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.ProductQueryService;
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
@RequestMapping("/query")
public class ProductQueryController {
    @Autowired
    ProductQueryService productQueryService;

    /**
     * 分页模糊查询
     */
    @RequestMapping("list")
    @ResponseBody
    public IResult findAll(String page, String limit, String productId, String productDamageId){
        List<ProductQuery> list = productQueryService.findAll(page, limit, productId, productDamageId);

        return new PageResultBean<Collection<ProductQuery>>(list,productQueryService.countGetAll(productId,productDamageId));
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public IResult deleteById(String id){

        productQueryService.deleteById(id);
        return new ResultBean<Boolean>();
    }

    /**
     * 获取id
     */
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    @ResponseBody
    public IResult getById(String id){
        ProductQuery byId = productQueryService.getById(id);
        return new ResultBean(byId);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public IResult update(ProductQuery productQuery){

        return new ResultBean(productQueryService.update(productQuery));
    }

    /**
     * 增加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public IResult add(ProductQuery productQuery){

        return new ResultBean(productQueryService.add(productQuery));
    }


}
