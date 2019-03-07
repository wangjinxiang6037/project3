package com.gameloft9.demo.controllers.system;


import com.gameloft9.demo.dataaccess.model.system.Product;
import com.gameloft9.demo.dataaccess.model.system.SysRoleTest;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.ProductService;
import com.gameloft9.demo.service.beans.system.OrgNodeResponse;
import com.gameloft9.demo.service.impl.system.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.Collection;

import java.util.List;


@Controller
@Slf4j
@RequestMapping("/product")
public class ProductController {
@Autowired
    ProductService productService;

    /**
     * 列表查找
    */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public IResult findAll(String page,String limit,String productName,String productType){

    List<Product> list = productService.findAll(page,limit,productName,productType);
     return new PageResultBean<Collection<Product>>(list,productService.countGetAll(productName,productType));

}
    /**
    *通过ID删除
    */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public IResult deleteById( String ID){
    productService.deleteById(ID);

    return new ResultBean<Boolean>();

}
     /**
     * 修改产品列表
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public IResult update(Product product){

    return new ResultBean<Boolean>(productService.update(product));
}
    /**
    * 增加产品列表
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public IResult add(Product product){

        return new ResultBean<String>(productService.add(product));

    }


    /**
     * 获取角色id
     * */
    @RequestMapping("/get")
    @ResponseBody
    public IResult getProduct(String id){
        //返回json至前端的均返回ResultBean或者PageRe   sultBean
        Product product = productService.getProduct(id);
        return new ResultBean(product);
    }

}
