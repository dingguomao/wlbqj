<%@page import="com.entity.Page"%>
<%@page import="com.entity.student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" title="" rel="stylesheet" />
		<link rel="shortcut icon" href="/img/icon.png" /> 
		<link rel="stylesheet" href="css/toastr.min.css" />
		<link href="css/font-awesome.min.css" rel="stylesheet">
		<link href="css /animate.css" rel="stylesheet">
		<link rel="stylesheet" href="css/" />
		<link rel="stylesheet" href="css/my_TiBaoJiLu.css" />
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		    <script src="public/html5shiv.min.js"></script>
		    <script src="public/respond.min.js"></script>
		<![endif]-->
		<title>信息管理系统</title>
	</head>

	<body>

	
	
	<%
	
	List<student> students = (List<student>) request.getAttribute("students");
	Page pages = (Page)request.getAttribute("page");
	
	
	%>
		<div id="wrapper" class="container">
			<!--标编辑-->
			<div id="biaobj" class=" wrapper wrapper-content animated fadeInRight">
				<h3>我的提报记录</h3>
				<div class="right_box" id="right_box">
					<!--表格部分-->
					
					<div class="ibox-content">
						<div class="tab_list">
							<ul class='tab_box'>
								<li class="select_tab">已处理</li>
								<li>未处理</li>
								<li>待处理</li>
							</ul>
							<div class="col-lg-2 col-md-2 col-sm-2 search_inp">
								<input placeholder="搜索" style="margin-left:-80px;" type="text" class="form-control" />
							</div>
						</div>
							<div class="tab_content">
								<div class="yiChuLi active">
									<div  class="row">
									
										<div id="page-content" class="col-sm-12">
											
											<table  class="table table-striped table-bordered table-hover dataTables-example">
											
												<thead>
													<tr>
														<th>序号</th>
														<th>学号</th>
														<th>姓名</th>
														<th>班级</th>
														<th>部门</th>
														<th>第一次提交时间</th>
														<th>最近一次修改时间</th>
														<th>提交ip地址</th>
														<th>提交地点</th>
													</tr>
												</thead>
												<form action ="deleteStudentServlet" method = "post" >
												<tbody>
												<%
												int i = 1;
												for(student student:students){ 
												
												%>
													<tr>
														<td><%=i%></td>
														<td>
															<input type="checkbox" value="<%=student.getSno()%>" name="sno" ><%=student.getSno()%>
														</td>
														<td><%=student.getSname()%></td>
														<td><%=student.getSclass()%></td>
														<td><%=student.getDepartment()%></td>
														<td><%=student.getCreate_time()%></td>
														<td><%=student.getUpdate_time() %></td>
														<td><%=student.getIp() %></td>
														<td><%=student.getAddress() %></td>
													</tr>
													<%  i=i+1; } %>
												</tbody>
												
												<tfoot>
													<tr>
														<td colspan="5">
															<button onclick="javascrtpt:window.location.href='./sno.jsp'" style="margin-left:10px;" type="button" class="btn btn-success"> <i class="fa fa-plus"></i> 修改信息</button>
															<button onclick="javascrtpt:window.location.href='./index.jsp'" style="margin-left:10px;" type="button" class="btn btn-success"> <i class="fa fa-plus"></i> 新增信息</button>
															<button style="margin-left:10px;" type="submit" class="btn btn-success"> <i class="fa fa-plus"></i> 批量删除</button>
															<button style="margin-left:10px;" type="submit" class="btn btn-success"> <i class="fa fa-plus"></i> <a style="text-decoration:none; color:#fff;" class="word-export" href="javascript:void(0)"> 导出xls </a></button>
														
														
																												
														</td>
													</tr>
												</tfoot>
												</form>
											</table>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-5">
											<div class="dataTables_info" id="editable_info" role="status" aria-live="polite">每页<%=pages.getPageSize() %>条，共<%=pages.getTotality() %>条,  共<%=pages.getPages() %>页</div>
										</div>
										<div style="height:27px;" class="col-sm-7">
											<div class="dataTables_paginate paging_simple_numbers" id="editable_paginate">
												<ul class="pagination pull-right" style="margin:-3px 0;">
													<li class="paginate_button previous" id="editable_previous">
														<a href="./queryAllStudent?page=<%=pages.getPage()-1 %>" aria-controls="editable" data-dt-idx="0" tabindex="0">上一页</a>
													</li>
													<%
													for(int j=0;j<pages.getPages();j++){
														if(j == pages.getPage()){
													%>
													<li class="paginate_button previous" id="editable_previous">
														<a href="./queryAllStudent?page=<%=j %>"  style='color:red;background:#acafb3'  aria-controls="editable" data-dt-idx="0" tabindex="<%=j+1%>"><%=j+1%></a>
													</li>
													<%}else{ %>
													<li class="paginate_button previous" id="editable_previous">
														<a href="./queryAllStudent?page=<%=j %>"    aria-controls="editable" data-dt-idx="0" tabindex="<%=j+1%>"><%=j+1%></a>
													</li>
													<%}} %>
													<li class="paginate_button previous" id="editable_previous">
														<a href="./queryAllStudent?page=<%=pages.getPage()+1 %>" aria-controls="editable" data-dt-idx="0" tabindex="0">下一页</a>
													</li>
												</ul>
											</div>
										</div>
									</div>
								</div>
								<div class="daiChuLi">
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-striped table-bordered table-hover dataTables-example">
												<thead>
													<tr>
														<th>学号</th>
														<th>姓名</th>
														<th>班级</th>
														<th>部门</th>
														<th>第一次提交时间</th>
														<th>最近一次修改时间</th>
														<th>提交ip地址</th>
														<th>提交地点</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>
															<a onclick="javascript:r_swiper(this)" style="color:#0D8DDB !important;" href="javascript:void(0)">20160808000301</a>
														</td>
														<td>王</td>
														<td>表编辑</td>
														<td>担保</td>
														<td>担保标</td>
													</tr>
													<tr>
														<td>
															<a onclick="javascript:r_swiper(this)" style="color:#0D8DDB !important;" href="javascript:void(0)">20160808000301</a>
														</td>
														<td>王</td>
														<td>表编辑</td>
														<td>担保</td>
														<td>担保标</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-5">
											<div class="dataTables_info" id="editable_info" role="status" aria-live="polite">显示从1到8，总8条</div>
										</div>
										<div style="height:27px;" class="col-sm-7">
											<div class="dataTables_paginate paging_simple_numbers" id="editable_paginate">
												<ul class="pagination pull-right" style="margin:-3px 0;">
													<li class="paginate_button previous" id="editable_previous">
														<a href="#" aria-controls="editable" data-dt-idx="0" tabindex="0">上一页</a>
													</li>
													<li class="paginate_button previous" id="editable_previous">
														<a href="#" aria-controls="editable" data-dt-idx="0" tabindex="1">1</a>
													</li>
													<li class="paginate_button previous" id="editable_previous">
														<a href="#" aria-controls="editable" data-dt-idx="0" tabindex="2">2</a>
													</li>
													<li class="paginate_button previous" id="editable_previous">
														<a href="#" aria-controls="editable" data-dt-idx="0" tabindex="3">3</a>
													</li>
													<li class="paginate_button previous" id="editable_previous">
														<a href="#" aria-controls="editable" data-dt-idx="0" tabindex="4">4</a>
													</li>
													<li class="paginate_button previous" id="editable_previous">
														<a href="#" aria-controls="editable" data-dt-idx="0" tabindex="5">下一页</a>
													</li>
												</ul>
											</div>
										</div>
									</div>
								</div>
								<div class="weiChuLi">
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-striped table-bordered table-hover dataTables-example">
												<thead>
													<tr>
														<th>学号</th>
														<th>姓名</th>
														<th>班级</th>
														<th>部门</th>
														<th>第一次提交时间</th>
														<th>最近一次修改时间</th>
														<th>提交ip地址</th>
														<th>提交地点</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>
															<a onclick="javascript:r_swiper(this)" style="color:#0D8DDB !important;" href="javascript:void(0)">20160808000301</a>
														</td>
														<td>王</td>
														<td>表编辑</td>
														<td>担保</td>
														<td>担保标</td>
													</tr>
													<tr>
														<td>
															<a onclick="javascript:r_swiper(this)" style="color:#0D8DDB !important;" href="javascript:void(0)">20160808000301</a>
														</td>
														<td>王</td>
														<td>表编辑</td>
														<td>担保</td>
														<td>担保标</td>
													</tr>
													<tr>
														<td>
															<a onclick="javascript:r_swiper(this)" style="color:#0D8DDB !important;" href="javascript:void(0)">20160808000301</a>
														</td>
														<td>王</td>
														<td>表编辑</td>
														<td>担保</td>
														<td>担保标</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-5">
											<div class="dataTables_info" id="editable_info" role="status" aria-live="polite">显示从1到8，总8条</div>
										</div>
										<div style="height:27px;" class="col-sm-7">
											<div class="dataTables_paginate paging_simple_numbers" id="editable_paginate">
												<ul class="pagination pull-right" style="margin:-3px 0;">
													<li class="paginate_button previous" id="editable_previous">
														<a href="#" aria-controls="editable" data-dt-idx="0" tabindex="0">上一页</a>
													</li>
													<li class="paginate_button previous" id="editable_previous">
														<a href="#" aria-controls="editable" data-dt-idx="0" tabindex="1">1</a>
													</li>
													<li class="paginate_button previous" id="editable_previous">
														<a href="#" aria-controls="editable" data-dt-idx="0" tabindex="2">2</a>
													</li>
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
		<script src="js/jquery-1.11.3.js"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/lhgdialog.js"></script>
		<!-- 弹出警示框 -->
		<script src="js/toastr.min.js"></script>
		<!-- 弹出确认框 -->
		<script src="js /artDialog.js?skin=blue"></script>
    	<script src="js /plugins/iframeTools.js"></script>
    	
    	<script src="js/my_TiBaoJiLu.js"></script>
    	<script>
    		$('.tab_box>li').click(function(){
    			$(this).addClass('select_tab').siblings().removeClass('select_tab');
    			var index=$(this).index();
    			$('.tab_content>div:eq('+index+')').addClass('active').siblings().removeClass('active');
    		})
    	</script>
    	<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>
   		 <script>
        L2Dwidget.init({
            "model": {

                //(切换模型需要改动)
    //				"https://unpkg.com/(live2d-widget-model-koharu)@1.0.5/assets/(koharu).model.json"
                jsonPath: "https://unpkg.com/live2d-widget-model-koharu@1.0.5/assets/koharu.model.json",
                "scale": 1
            },
            "display": {
                "position": "right", //看板娘的表现位置
                "width": 80,  //小萝莉的宽度
                "height": 160, //小萝莉的高度
                "hOffset": 100,
                "vOffset": -50
            },
            "mobile": {
                "show": true,
                "scale": 0.5
            },
            "react": {
                "opacityDefault": 1,
                "opacityOnHover": 1
            }
        });
    </script>
	<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>		
	    <script src="./js/FileSaver.js"></script>
	    <script src="./js/jquery.wordexport.js"></script>
<script type="text/javascript">
    $(document).ready(function ($) {
        $("a.word-export").click(function (event) {
            var data = {
                fileName: "测试文档",//文档名
                fileType: ".xls",//文档类型  经测试  可以doc xls html 其他的自己去试
                isHeader:false,//是否显示页眉  *xls  不要设置页眉页脚  改为false
                isFooter:false,//是否显示页脚  *xls  不要设置页眉页脚  改为false
                header: "测试页眉",//页眉标题
                styles: $("#wordExPortCss"),//要导出的内容style
                updateExportCss:$("#updateExportCss")//需要修改导出的word样式  宽度高度 margin之类的
            }
            $("#page-content").wordExport(data);
        });
    });
</script>
	</body>

</html>