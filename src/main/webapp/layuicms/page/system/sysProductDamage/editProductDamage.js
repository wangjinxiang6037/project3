layui.config({
    base: $config.resUrl+'layuicms/common/js/'//定义基目录
}).extend({
    ajaxExtention: 'ajaxExtention',//加载自定义扩展，每个业务js都需要加载这个ajax扩展
    $tool: 'tool',
    $api:'api'
}).use(['form', 'layer','$api', 'tree', 'jquery', 'ajaxExtention', '$tool'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery,
        $tool = layui.$tool,
        $api = layui.$api;

    var orgId;
    var orgName;
    var roleIdList = new Array();//所有的角色id列表
    var user_roleIds =[];//用户所属角色列表

    /**
     * 页面初始化
     * */
    function init() {
        //初始化机构树
      //  initOrgTree();
        //初始化用户信息

    }

    init();

    /**
     * 初始化组织机构树
     * */
   /* function initOrgTree() {
        //获取所有组织机构树

          $api.GetAllOrg(null,function (res) {
              renderTree('#org-tree', res.data);
          });

      }

        /!**
         * 绘制树
         * @param id dom id
         * @param nodes 树节点数据
         * *!/
        function renderTree(id, nodes) {
            //绘制前先清空
            $(id).empty();

            //绘制
             layui.tree({
                 elem: id
                 , nodes: nodes
                 , click: function (node) {//显示组织机构数据
                     console.log(node); //node即为当前点击的节点数据
                     orgId = node.id;//保存机构id
                     orgName = node.name;

                     $('[name="orgName"]').val(orgName);//显示机构名称
                 }
             });
         }
            /!**
             * 加载产品列表
             * *!/
            function loadRoleList() {
                var req = {
                    page: 1,
                    limit: 999
                };

                $api.GetProduct(req, function (res) {
                    var data = res.data;
                    if (data.length > 0) {
                        var roleHtml = "";
                        for (var i = 0; i < data.length; i++) {
                            //是否初始化选中
                            if ($.inArray(data[i].id, user_roleIds) != -1) {
                                roleHtml += '<input type="checkbox" checked name="' + data[i].id + '" title="' + data[i].roleName + '">';
                            } else {
                                roleHtml += '<input type="checkbox" name="' + data[i].id + '" title="' + data[i].roleName + '">';
                            }
                            roleIdList.push(data[i].id);//保存id列表
                        }

                        $('.role-check-list').append($(roleHtml));
                        form.render();//重新绘制表单，让修改生效
                    }
                });
            }
*/
            /**
             * 初始化用户信息
             * */
            function initUserInfo() {
                var queryArgs = $tool.getQueryParam();//获取查询参数
                var id = queryArgs['id'];

                var url = $tool.getContext()+'damage/get';
                var req = {
                    id: id
                };

                $api.GetProductDamage(req, function (res) {
                    var data = res.data;
                    console.log(data)

                    $("[name='id']").val(data.id);
                    $("[name='productId']").val(data.productId);
                    $("[name='productType']").val(data.productType);
                    $("[name='productSize']").val(data.productSize);
                    $("[name='productNumber']").val(data.productNumber)
                    /*orgId = data.orgId;
                    orgName = data.orgName;*/
                   // user_roleIds = data.roleIdList;//保存用户所属角色id列表，初始化选中时用
                    //加载角色列表
                  //  loadRoleList();
                    form.render();//重新绘制表单，让修改生效
                });
            }
                    initUserInfo();
            /**
             * 表单提交
             * */
            form.on("submit(editProductDamage)", function (data) {
                var queryArgs = $tool.getQueryParam();//获取查询参数
                var id = queryArgs['id'];
                console.log(data)
                var id = data.field.id;
                var productId = data.field.productId;
                var productType = data.field.productType;
                var productSize = data.field.productSize;

                var productNumber = data.field.productNumber
                /*if ($tool.isBlank(orgId) || $tool.isBlank(orgName)) {
                    layer.msg("请选择所属组织机构");
                    return false;
                }*/

                //获取选中的产品列表
               /* for (var i = 0; i < roleIdList.length; i++) {
                    if (data.field[roleIdList[i]] === 'on') {
                        idList.push(roleIdList[i]);
                    }
                }*/

                //请求
                var req = {
                    id: id,
                    productId: productId,
                    productType: productType,
                    productSize: productSize,
                    productNumber: productNumber
                };

                $api.updateProductDamage(req, function (data) {
                    //top.layer.close(index);(关闭遮罩已经放在了ajaxExtention里面了)
                    layer.msg("用户更新成功！", {time: 1000}, function () {
                        layer.closeAll("iframe");
                        //刷新父页面
                        parent.location.reload();
                    });
                });

                return false;
            })

        });


