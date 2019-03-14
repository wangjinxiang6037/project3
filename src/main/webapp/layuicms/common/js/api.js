/**
 * api接口列表
 * Created by gameloft9 on 2018/7/19.
 */
layui.define(['$tool','jquery'], function (exports) {

    var $tool = layui.$tool,
        $ = layui.jquery;// 拿到模块变量

    /**
     * 封装一个post
     * */
    function doPost(url,req,successCallback,errorCallback) {
        $.ajax({
            url:url,
            data:req,
            method:"post",
            success:function (data) {
                successCallback(data);
            },
            error:function (error) {
                errorCallback(error);
            }
        });
    }

    /**
     * 封装一个get
     * */
    function doGet(url,req,successCallback,errorCallback) {
        $.ajax({
            url:url,
            data:req,
            method:"get",
            success:function (data) {
                successCallback(data);
            },
            error:function (error) {
                errorCallback(error);
            }
        });
    }

    /**
     * 封装一个支持更多参数的post
     * */
    function doComplexPost(url,req,config,successCallback,errorCallback) {
        var defaultConfig = {
            url:url,
            data:req,
            method:"post",
            success:function (data) {
                successCallback(data);
            },
            error:function (error) {
                errorCallback(error);
            }
        };
        var ajaxConfig = $.extend({},config,defaultConfig); // 合并参数

        $.ajax(ajaxConfig);
    }

    // API列表,工程庞大臃肿后可以将API拆分到单独的模块中
    var API = {
        Login: function(req,successCallback,errorCallback){ // 登录
            doPost($tool.getContext() + "login",req,successCallback,errorCallback);
        },
        LogOut:function(req,successCallback,errorCallback){ // 登出
            doPost($tool.getContext() + 'logout.do',req,successCallback,errorCallback);
        },
        ChangePwd:function(req,successCallback,errorCallback){ // 更改密码
            doPost($tool.getContext() + 'personCenter/changePwd.do',req,successCallback,errorCallback);
        },
        GetRoleList:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'personCenter/roleList.do',req,successCallback,errorCallback);
        },
        DeleteLog:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'log/delete.do',req,successCallback,errorCallback);
        },
        BatchDeleteLog:function(req,config,successCallback,errorCallback){
            doComplexPost($tool.getContext() + 'log/batchDelete.do',req,config,successCallback,errorCallback);
        },
        GetFirstClassMenus:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'menu/firstClassMenus.do',req,successCallback,errorCallback);
        },
        AddMenu:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'menu/add.do',req,successCallback,errorCallback);
        },
        DeleteMenu:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'menu/delete.do',req,successCallback,errorCallback);
        },
        GetMenu:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'menu/get.do',req,successCallback,errorCallback);
        },
        UpdateMenu:function(req,config,successCallback,errorCallback){
            doComplexPost($tool.getContext()+'menu/update.do',req,config,successCallback,errorCallback);
        },
        GetAllOrg:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'org/getAll.do',req,successCallback,errorCallback);
        },
        GetOrg:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'org/get.do',req,successCallback,errorCallback);
        },
        AddOrg:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'org/add.do',req,successCallback,errorCallback);
        },
        UpdateOrg:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'org/update.do',req,successCallback,errorCallback);
        },
        DeleteOrg:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'org/delete.do',req,successCallback,errorCallback);
        },
        AddRole:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'role/add.do',req,successCallback,errorCallback);
        },
        DeleteRole:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'role/delete.do',req,successCallback,errorCallback);
        },
        GetRole:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'role/get.do',req,successCallback,errorCallback);
        },
        UpdateRole:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'role/update.do',req,successCallback,errorCallback);
        },
        AddUser:function(req,config,successCallback,errorCallback){
            doComplexPost($tool.getContext() + 'sysUser/add.do',req,config,successCallback,errorCallback);
        },
        DeleteUser:function(req,config,successCallback,errorCallback){
            doPost($tool.getContext() + 'sysUser/delete.do',req,config,successCallback,errorCallback);
        },
        InitPwd:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'sysUser/initPwd.do',req,successCallback,errorCallback);
        },
        GetUser:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'sysUser/get.do',req,successCallback,errorCallback);
        },
        UpdateUser:function(req,config,successCallback,errorCallback){
            doComplexPost($tool.getContext() + 'sysUser/update.do',req,config,successCallback,errorCallback);
        },
        GetUserInfo:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'personCenter/get.do',req,successCallback,errorCallback);
        },
        UpdateUserInfo:function(req,config,successCallback,errorCallback){
            doComplexPost($tool.getContext() + 'personCenter/update.do',req,config,successCallback,errorCallback);
        },//生产表删除
        Deleteaproduct:function(req,config,successCallback,errorCallback) {
            doPost($tool.getContext() + '/product/delete', req, config, successCallback, errorCallback);
        }
        ,//修改
        updateProduct:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'product/update',req,successCallback,errorCallback);
        },//获取产品ID
        GetProduct:function(req,successCallback,errorCallback){
             doPost($tool.getContext()+'product/get',req,successCallback,errorCallback);
        },
       /*GetProductList:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'product/list',req,successCallback,errorCallback);
        },*/
        AddProduct:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'product/add',req,successCallback,errorCallback);
        },//生产配方删除
        DeleteaproductFormula:function(req,config,successCallback,errorCallback) {
            doPost($tool.getContext() + 'productformula/delete', req, config, successCallback, errorCallback);
        },//获取生产配方ID
        GetProductFormula:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'productformula/get',req,successCallback,errorCallback);
        },//生产配方修改
        updateProductFormula:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'productformula/update',req,successCallback,errorCallback);
        },//生产配方添加
        AddProductFormula:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'productformula/add',req,successCallback,errorCallback);
        },//配方明细删除
        DeleteFormulaDetail:function(req,successCallback,errorCallback) {
            doPost($tool.getContext() + 'productdetail/delete', req,successCallback, errorCallback);
    },//获取配方明细ID
        GetFormulaDetail:function(req,successCallback,errorCallback) {
            doPost($tool.getContext() + 'productdetail/get', req, successCallback, errorCallback);
        },//生产配方明细修改
        updateFormulaDetail:function(req,successCallback,errorCallback) {
            doPost($tool.getContext() + 'productdetail/update', req, successCallback, errorCallback);
        },//生产配方添加
        AddFormulaDetail:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'productdetail/add',req,successCallback,errorCallback);
        },//入库申请单删除
        DeleteproducApplicacion:function(req,config,successCallback,errorCallback) {
            doPost($tool.getContext() + 'application/delete', req, config, successCallback, errorCallback);
        },//申请单修改
        updateProductApplication:function(req,successCallback,errorCallback) {
        doPost($tool.getContext() + 'application/update', req, successCallback, errorCallback);
        },//生产配方添加
        AddProductApplication:function(req,successCallback,errorCallback){
        doPost($tool.getContext() + 'application/add',req,successCallback,errorCallback);
        },//获取配方明细ID
        GetProductApplication:function(req,successCallback,errorCallback) {
            doPost($tool.getContext() + 'application/get', req, successCallback, errorCallback);
        },//破损申请单删除
        DeleteProductDamage:function(req,config,successCallback,errorCallback) {
        doPost($tool.getContext() + 'damage/delete', req, config, successCallback, errorCallback);
    },//获取破损ID
        GetProductDamage:function(req,successCallback,errorCallback) {
        doPost($tool.getContext() + 'damage/get', req, successCallback, errorCallback);
        },//破损单修改
        updateProductDamage:function(req,successCallback,errorCallback) {
        doPost($tool.getContext() + 'damage/update', req, successCallback, errorCallback);
    },//破损单添加
        AddProductDamage:function(req,successCallback,errorCallback){
        doPost($tool.getContext() + 'damage/add',req,successCallback,errorCallback);
    },//入库申请单删除
        DeleteProductQuery:function(req,successCallback,errorCallback) {
        doPost($tool.getContext() + 'query/delete', req, successCallback, errorCallback);
    },//生产配方添加
        AddProductQuery:function(req,successCallback,errorCallback){
        doPost($tool.getContext() + 'query/add',req,successCallback,errorCallback);
    },//获取ID
        GetProductQuery:function(req,successCallback,errorCallback) {
        doPost($tool.getContext() + 'query/get', req, successCallback, errorCallback);
    },//修改
        updateProductQuery:function(req,successCallback,errorCallback) {
        doPost($tool.getContext() + 'query/update', req, successCallback, errorCallback);
    },//获取生产配方ID
        GetFirstProductFormula:function(req,successCallback,errorCallback){
        doPost($tool.getContext()+'productformula/selectAll',req,successCallback,errorCallback);
        },//获取生产ID
        GetFirstProduct:function(req,successCallback,errorCallback){
        doPost($tool.getContext()+'product/selectAll',req,successCallback,errorCallback);
    },


    };




    //输出扩展模块
    exports('$api', API);
});


