<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%    
String path = request.getContextPath();    
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%> 
<html>
<head>
	<!-- base需要放到head中 -->    
	<base href=" <%=basePath%>">   
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>请假单列表</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/jquery.min.js"></script>
    <script type="text/javascript">
    	$(document).ready(function () {
			searchleavelist();
			searchleavelistByLikeReason();
			audit();
			deleteleavelist();
			
		});

    	//提交审核
    	function audit() {
    		$("#audit").click(function(){
				//判断是否至少选择一项				
				var checkedNum =$("input[name='ck_order']:checked").length;
				if(checkedNum==0){
					alert("请选择一项流程进行提交");
					return;
				}
				if(confirm("确定要提交审核的流程？")){
					var checkList= new Array();
					$("input[name='ck_order']:checked").each(function(){
						checkList.push($(this).val());
					});
				$.ajax({
						type:"POST",
						url:"leaveController/startLeaveFlow",
						data:{
							"orderlist":checkList.toString()
						},
						
						success:function(){
							$("[name ='ck_order']:checkbox").attr("checked", false); 
							searchleavelistByLikeReason();
							alert("提交成功");
						}
						
					}) 
					
				}
			});
		}
    	//根据请假理由模糊搜索假单
    	function searchleavelistByLikeReason(){
    		$.ajax({
    			url:"leaveTableController/queryLeaveTableAll",
    			data:{
    				reason:$('#reason').val()
    			},
    			type:"post",
    			cache:false,
    			dataType:"json",
    			success:function(data){
    				$("#tbody tr td").remove();//<tbody>的id为tbody,利用remove可以将上次的数据清除
                    var result=eval(data);//把json数据字符串转换为数组对象
    	       		 $.each(result,function (index , item ) {
    	       		//从JS对象中获取属性
    	       		var uname=item.uname;
    	       		var reasons=item.reasons;
    	       		var createtime=item.createtime;
    	       		var state=item.state;
    	       		var id=item.id;
    	       		console.log(id);
    	       		$("#tbody").append("<tr>"+"<td><input type='checkbox' name='ck_order' value='" + id + "'></td>"
    	       				 +"<td>"+id+"</td>"+"<td>"+uname+"</td>"
    	       				 +"<td>"+reasons+"<td>"+createtime+"</td>"+"<td>"+state+"</td>"+"</td>"
    	       				+"<td><a href='leaveTableController/updateEditLeaveTable?leaveId="+id+"'>修改假单</a></td>"+"</tr>")      				
    	       		 });
    			},
    			error : function() {  
                    
                    alert("异常！");  
               }  
    		});
    	}
    	
    	//模糊搜索假单列表
    	function searchleavelist(){
    	
    		$.ajax({
    			url:"leaveTableController/queryLeaveTable",
    			data:{
    				reason:$('#reason').val(),
    				leavetype:$('#leavetype').val() 
    			},
    			type:"post",
    			cache:false,
    			dataType:"json",
    			success:function(data){
    				$("#tbody tr td").remove();//<tbody>的id为tbody,利用remove可以将上次的数据清除
                    var result=eval(data);//把json数据字符串转换为数组对象
    	       		 $.each(result,function (index , item ) {
    	       		//从JS对象中获取属性
    	       		var uname=item.uname;
    	       		var reasons=item.reasons;
    	       		var createtime=item.createtime;
    	       		var state=item.state;
    	       		var id=item.id;
    	       		console.log(id);
    	       		$("#tbody").append("<tr>"+"<td><input type='checkbox' name='ck_order' value='" + id + "'></td>"
    	       				 +"<td>"+id+"</td>"+"<td>"+uname+"</td>"
    	       				 +"<td>"+reasons+"<td>"+createtime+"</td>"+"<td>"+state+"</td>"+"</td>"
    	       				+"<td><a href='leaveTableController/updateEditLeaveTable?leaveId="+id+"'>修改假单</a></td>"+"</tr>")      				
    	       		 });
    			},
    			error : function() {  
                    // view("异常！");  
                    alert("异常！");  
               }  
    		});
    	}
    	
    	// 批量删除用户
    	  function deleteleavelist(){
    			$("#delete").click(function(){
    				//判断是否至少选择一项				
    				var checkedNum =$("input[name='ck_order']:checked").length;
    				if(checkedNum==0){
    					alert("请至少选择一项");
    					return;
    				}
    				if(confirm("确定要删除所选项目？")){
    					var checkList= new Array();
    					$("input[name='ck_order']:checked").each(function(){
    						checkList.push($(this).val());
    					});
    					$.ajax({
    						type:"POST",
    						url:"leaveTableController/deleteLeaveTable",
    						data:{
    							"orderlist":checkList.toString()
    						},
    						
    						success:function(){
    							$("[name ='ck_order']:checkbox").attr("checked", false); 
    							searchleavelistByLikeReason();
    							alert("删除成功");
    						}
    						
    					})
    					
    				}
    			});
    	  	//全选
    			$("#checked_all").click(function(){
    				$("input[name='ck_order']").prop("checked",this.checked);
    			})

    	  }
    </script>
</head>
<body data-type="widgets">
<%
	//获得key
	String key=request.getParameter("key");
%>
    <script src="assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <header>
            <!-- logo -->
            <div class="am-fl tpl-header-logo">
                <a href="javascript:;"><img src="assets/img/logo.png" alt=""></a>
            </div>
            <!-- 右侧内容 -->
            <div class="tpl-header-fluid">
                <!-- 侧边切换 -->
                <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
                </div>
                <!-- 搜索 -->
                <div class="am-fl tpl-header-search">
                    <form class="tpl-header-search-form" action="javascript:;">
                        <button class="tpl-header-search-btn am-icon-search"></button>
                        <input class="tpl-header-search-box" type="text" placeholder="搜索内容...">
                    </form>
                </div>
                <!-- 其它功能-->
                <div class="am-fr tpl-header-navbar">
                    <ul>
                        <!-- 欢迎语 -->
                        <li class="am-text-sm tpl-header-navbar-welcome">
                            <a href="javascript:;">欢迎你, <span>${user.id}</span> </a>
                        </li>

                        <!-- 退出 -->
                        <li class="am-text-sm">
                            <a href="actIdUserController/logout">
                                <span class="am-icon-sign-out"></span> 退出
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </header>
        <!-- 风格切换 -->
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div class="tpl-skiner-content-title">
                    选择主题
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>
        <!-- 侧边导航栏 -->
        <div class="left-sidebar">
            <!-- 用户信息 -->
            <div class="tpl-sidebar-user-panel">
                <div class="tpl-user-panel-slide-toggleable">
                    <div class="tpl-user-panel-profile-picture">
                        <img src="assets/img/user.png" alt="">
                    </div>
                    <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
            ${user.id}
          </span>
                    <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
                </div>
            </div>

            <!-- 菜单 -->
            <ul class="sidebar-nav">
                <li class="sidebar-nav-heading">Components <span class="sidebar-nav-heading-info"> 主要组件</span></li>
                <li class="sidebar-nav-link">
                    <a href="index.jsp" class="active">
                        <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                    </a>
                </li>
                <li class="sidebar-nav-heading">Page<span class="sidebar-nav-heading-info"> 常用页面</span></li>
                                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 流程管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="processDeployManage.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 流程部署管理
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="processDefinitionManage.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 流程定义管理
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 人员管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="userManage.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 用户管理
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="userPermission.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 用户权限管理
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 请假管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="table-list.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 请假单列表
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="table-edit.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 编辑请假单
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 审批管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="unfinished-task.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 待办理任务
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="finished task.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 已办理任务
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="sign-up.jsp">
                        <i class="am-icon-clone sidebar-nav-link-logo"></i> 注册
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="login.jsp">
                        <i class="am-icon-key sidebar-nav-link-logo"></i> 登录
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="404.jsp">
                        <i class="am-icon-tv sidebar-nav-link-logo"></i> 404错误
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="500.jsp">
                        <i class="am-icon-tv sidebar-nav-link-logo"></i> 500错误
                    </a>
                </li>
            </ul>
        </div>


        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">
            <div class="row-content am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title  am-cf">请假单列表</div>
                            </div>
                            <div class="widget-body  am-fr">
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                    <div class="am-form-group">
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-success" onclick="window.open('table-edit.jsp')"><span class="am-icon-plus"></span> 新增</button>
												<button type="button" id="audit" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 提交审核</button>
												<button type="button" id="delete" class="am-btn am-btn-default am-btn-danger" ><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                             
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                    <div class="am-form-group tpl-table-list-select">
                                        <select id="leavetype" data-am-selected="{btnSize: 'sm'}">
                                              <option value="option1">请假类型</option>
                                              <option value="option2">年假</option>
                                              <option value="option3">事假</option>
                                              <option value="option3">病假</option>
                                        </select>
                                    </div>
                                </div>
                           
                                
                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input type="text" class="am-form-field " id="reason" name="reason">
                                        <span class="am-input-group-btn">
                                            <button  class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" onclick="searchleavelist()"></button>
                                        </span>
                                    </div>
                                </div>
                                
                                <div class="am-u-sm-12">
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                        <thead>
                                            <tr id="tr">
                                            	<th ><input type="checkbox"  name="checked_all" ></th>
                                                <th>请假单ID</th>
                                                <th>请假申请人</th>
                                                <th>请假原因</th>
                                                <th>时间</th>
                                                <th>当前状态</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tbody">

                                        </tbody>
                                    </table>
                                </div>
                                <div class="am-u-lg-12 am-cf">

                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                            <li class="am-disabled"><a href="#">«</a></li>
                                            <li class="am-active"><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">4</a></li>
                                            <li><a href="#">5</a></li>
                                            <li><a href="#">»</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/amazeui.datatables.min.js"></script>
    <script src="assets/js/dataTables.responsive.min.js"></script>
    <script src="assets/js/app.js"></script>

</body>
</html>