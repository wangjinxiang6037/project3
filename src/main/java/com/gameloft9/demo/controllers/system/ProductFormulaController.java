package com.gameloft9.demo.controllers.system;


import com.gameloft9.demo.dataaccess.model.system.Product;
import com.gameloft9.demo.dataaccess.model.system.ProductFormula;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.ProductFormulaService;
import com.gameloft9.demo.service.api.system.ProductService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

  @Controller
  @Slf4j
  @RequestMapping("/productformula")
   public class ProductFormulaController {

    @Autowired
    ProductFormulaService productFormulaService;

      /**
       * 处理时间
       * @param binder
       * @param request
       */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
    //转换日期
    DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    // CustomDateEditor为自定义日期编辑器
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 列表分页模糊查询
     */
    @RequestMapping("/list")
    @ResponseBody

   public IResult findAll(String page,String limit,String productId,String createUser){
        List<ProductFormula> list = productFormulaService.findAll(page, limit, productId, createUser);
       return new PageResultBean<Collection<ProductFormula>>(list,productFormulaService.countGetAll(productId,createUser));
    }

      /**
       * 通过id删除生产配方信息
       */
      @RequestMapping(value = "/delete",method = RequestMethod.POST)
      @ResponseBody
      public IResult deleteById(String id){
          productFormulaService.deleteById(id);
          return new ResultBean<Boolean>();
      }
      /**
       * 修改生产配方信息
       */
      @RequestMapping(value = "/update",method = RequestMethod.POST)
      @ResponseBody
      public IResult update(ProductFormula productFormula){

          return new ResultBean<Boolean>(productFormulaService.update(productFormula));
      }

      /**
       * 获取生产配方id
       */
      @RequestMapping(value = "/get",method = RequestMethod.POST)
      @ResponseBody
      public IResult getById(String id){
          ProductFormula byId = productFormulaService.getById(id);
          return new ResultBean(byId);
      }

      /**
       * 增加生产配方信息
       */
      @RequestMapping(value = "/add",method = RequestMethod.POST)
      @ResponseBody
      public IResult add(ProductFormula productFormula){

          return new ResultBean<String>(productFormulaService.add(productFormula));
      }

  }
