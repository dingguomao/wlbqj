<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.entity.student" %>
<%@ page language="java" import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息修改界面</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="iconfont/style.css" type="text/css" rel="stylesheet">
<link rel="shortcut icon" href="/img/icon.png" /> 
<style>
	body{color:#fff; font-family:"微软雅黑"; font-size:14px;}
	.wrap1{position:absolute; top:0; right:0; bottom:0; left:0; margin:auto }/*把整个屏幕真正撑开--而且能自己实现居中*/
	.main_content{background:url(images/main_bg.png) repeat; margin-left:auto; margin-right:auto; text-align:left; float:none; border-radius:8px;}
	.form-group{position:relative;}
	.login_btn{display:block; background:#3872f6; color:#fff; font-size:15px; width:100%; line-height:50px; border-radius:3px; border:none; }
	.login_input{width:100%; border:1px solid #3872f6; border-radius:3px; line-height:40px; padding:2px 5px 2px 30px; background:none;}
	.icon_font{position:absolute; bottom:15px; left:10px; font-size:18px; color:#3872f6;}
	.font16{font-size:16px;}
	.mg-t20{margin-top:20px;}
	@media (min-width:200px){.pd-xs-20{padding:20px;}}
	@media (min-width:768px){.pd-sm-50{padding:50px;}}
	#grad {
	  background: -webkit-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Safari 5.1 - 6.0 */
	  background: -o-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Opera 11.1 - 12.0 */
	  background: -moz-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Firefox 3.6 - 15 */
	  background: linear-gradient(#4990c1, #52a3d2, #6186a3); /* 标准的语法 */
	}
</style>

</head>

<body style="background:url(images/bg.jpg) no-repeat;">
<script type="text/javascript">
if(<%=request.getAttribute("update") %>=="0")
	{
	alert("修改失败，请重试！！！");
	<%
	request.removeAttribute("update");
	
	%>
	}


</script>

<%
student student=(student) request.getAttribute("info");






%>

<div class="container wrap1" style="height:450px;">
            <h2 class="mg-b20 text-center">信息修改页面</h2>
            <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
                <p class="text-center font16">信息修改</p>
                <form action="./alertStudentServlet" method="post" onsubmit="return check()">
                    <div class="form-group mg-t20">
                        <a href="">姓名</a>
                        <input type="text" class="login_input" value=<%=student.getSname() %> name="name" placeholder="请输入你的姓名" />
                    </div>
                    <div class="form-group mg-t20">
                        <a href="">学号</a>
                        <input type="text" class="login_input" value=<%=student.getSno() %> name="sno" readonly="true" placeholder="请输入学号 如：2018xxxxxx" />
                    </div> 
                    <div class="form-group mg-t20">
                        <a href="">班级</a>
                        <input type="text" class="login_input" value=<%=student.getSclass() %> name="class" placeholder="请输入班级，如：软件开发班" />
                    </div> 
                    <div class="form-group mg-t20">
                        <a href="">部门</a>
                        <input type="text" class="login_input" value=<%=student.getDepartment() %> name="department" placeholder="输入培训部门 如：网络部维修组" />
                    </div><br>
                   
                    <button style="submit" class="login_btn">提交修改</button>
               </form><br>
              
        </div><!--row end-->
    </div><!--container end-->
      <%

request.removeAttribute("info");
%>   
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
    <script type="text/javascript">
    
    function check(){
    	

        var input = ["姓名","学号","班级","部门"];
        for(var i =0;i<=4;i++){
        	
            var b = document.getElementsByClassName("login_input")[i];
            
            if(b.value=="" || b.value==null){
            	
            	alert(input[i] + "不能为空！");
            	return false;
            }

        	
        }
        return true;
        }
        
        
    
    
    </script>
</body>
</html>
