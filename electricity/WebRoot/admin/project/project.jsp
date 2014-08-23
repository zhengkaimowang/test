<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="zhuoyue.vo.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>巡检项目</title>
</head>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
	height:100%;
	background: url(../../images/1.jpg);
	background-size: cover; 
	-moz-background-size: cover;
}
a:link {
    color:blue;
    text-decoration:none;
    }
a:visited {
    color:blue;
    text-decoration:none;
    }
a:active {
    color:blue;
    text-decoration:none;
    }
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.box{
	width:150px;
	height:180px;
	padding: 0px;
	margin:15px;
	float:left;}
.form_div{
	float:right;}
.img{
	height:150px;
	}
.load{
	width:150px;
	height:30px;
	padding:2px;
	}
.in{
	width:100px;
	height:28px;
	font-size:16px;
	line-height:28px;
	float:left;
	margin:2px;
	text-align:center;
	}
.del{
	height:28px;
	width:40px;
	line-height:28px;
	float:left;
	text-align:center;}
</style>
<body> 
<div class="big">
	<div class="top_div">
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="../../images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 设备管理 >> 巡检项目</span></td>
              </tr>
            </table></td>
            <td><div align="right"> <button id="add">添加</button><span class="STYLE1">
           </span></div> </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  </table>
 </div>
<div class="form_div"><input type="hidden" id="add_form"/></div>
<%
	Project project = null;
	List<Project> all = (List<Project>)request.getAttribute("all");
	Iterator<Project> iter = all.iterator();
	while(iter.hasNext()){
		project = iter.next();
%>
<div class="box">
	<div class="img"><a href="AllSubProject?supercode=<%=project.getProjectCode()%>&projectName=<%=project.getName()%>"><img src="../../images/1.png" /></a></div>
    <div class="load">
        <div class="in"><a href="AllSubProject?supercode=<%=project.getProjectCode()%>&projectName=<%=project.getName()%>"> <%=project.getName()%></a></div>
        <div class="del"><a href="ProjectRemove?projectcode=<%=project.getProjectCode()%>" onClick="return confirm('确定要删除么?')"><img src="../../images/2.png"/></a></div>
 	</div>
 </div>
<%
	}
%> 
</div>
</body>
<script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>
<script>
$(document).ready(function(){
  $("#add").click(function(){
    $("#add_form").before("<form action='ProjectInsert' method='post' onSubmit='return check()'>项目名：<input type='text' name='name' id='name'/><input type=\"submit\" value='确定'><button onClick='rem()'>取消</button></form>");
  });
});
</script>
<script language="javascript">
 function rem(){
   	$("form").remove();
  }
</script>
<script language="javascript">
  function check(){
	  if($("#name").val() != "" &&$("#name").val() != "项目名不能为空" && $("#name").val() != null){
		  return true;
		  } 
	$("#name").val("项目名不能为空");
	  return false;
	  }
</script>
</html>
