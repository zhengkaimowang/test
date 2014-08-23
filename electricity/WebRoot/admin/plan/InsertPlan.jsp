<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*,zhuoyue.vo.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>计划发布</title>
<script src="../../SpryAssets/SpryCollapsiblePanel.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="calendar.css" >
<script type="text/javascript" src="calendar.js" ></script>  
<script type="text/javascript" src="calendar-zh.js" ></script>
<script type="text/javascript" src="calendar-setup.js"></script>
<link href="../../SpryAssets/SpryCollapsiblePanel.css" rel="stylesheet" type="text/css">
</head>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
	background:url(../../images/1.jpg);
	background-size: cover; 
	-moz-background-size: cover;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12px; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
</style>
<body>
<%
	List<Project> all = (List<Project>)request.getAttribute("all");
	List<Userinfo> user = (List<Userinfo>)request.getAttribute("user");
	Iterator<Project> itera = all.iterator();
	Iterator<Userinfo> iteru = user.iterator();
%>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="../../images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 巡检计划 >> <%=(String)request.getAttribute("projectName")%></span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="23%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">项目名</span>
        </div></td>
        <td width="57%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">填写计划</span></div></td>
        </tr>

<%
  int num = 0;
  Project pro = null;
  Userinfo us = null;
 	while(itera.hasNext()){
		pro = itera.next();
		num++;
%>
<form action="InsetPlan" method="post" onSubmit="return insert(this)">
      <tr>
        <td height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19"></span><%=pro.getName()%></div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE6">
          <div id="CollapsiblePanel<%=num%>" class="CollapsiblePanel">
            <div class="CollapsiblePanelTab" tabindex="0">点击填写计划</div>
            <div class="CollapsiblePanelContent">
            <select name="userCode" id="userCode" >
            <option value="">请选择巡检人</option>.
<%
	while(iteru.hasNext()){ 
		us = iteru.next();
%>
            <option value="<%=us.getUserCode()%>"><%=us.getUserName()%></option>
<%
	}
	iteru = user.iterator();
%>		
		</select>
        <select name="projectType">
        <option value="日巡" selected="selected">日巡</option>
        <option value="夜巡">夜巡</option>
        </select>
       开始时间： <input type="text" name="startTime" id="EntTime1<%=num%>" value="" onClick="return showCalendar('EntTime1<%=num%>', 'y-mm-dd');"/>
       结束时间：<input type="text" name="endTime" id="EntTime2<%=num%>" value="" onClick="return showCalendar('EntTime2<%=num%>', 'y-mm-dd');"/>
       <input type="hidden" name="projectCode" value="<%=pro.getProjectCode()%>" />
       <input type="hidden" name="projectName" value="<%=pro.getName()%>" />
    <input type="submit" value="确定" />
            </div>
          </div></td>
      </tr>
        
 </form>
 <%
 	}
 %>
  
    </table></td>
  </tr>	
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="49"><div align="center">
    </div></td>
            <td width="49"><div align="center">
 
    </div></td>
              <td width="37" class="STYLE22"><div align="center"></div></td>
              <td width="22" class="STYLE22"><div align="center">
        </div></td>
            <td width="22" class="STYLE22"><div align="center"></div></td>
            <td width="35"></td
          ></tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<script type="text/javascript">
var num = <%=num%>;
for(var i=1;i<=num;i++){
	var coll = "CollapsiblePanel"+i;
	coll =  new Spry.Widget.CollapsiblePanel("CollapsiblePanel"+i, {contentIsOpen:false, enableAnimation:false});
	}
</script>
<script src="../../js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script language="javascript">
var xmlHttp;
function createXMLHttp()
{
	if(window.XMLHttpRequest)
	{
		xmlHttp = new XMLHttpRequest();
	}
	else
	{
		xmlHttp = new AcriveXObject("Microsoft.XMLHTTP");
	}
}
function insert(form)
{
	createXMLHttp();
	var projectType = form.projectType.value;
	var userCode =  form.userCode.value;
	var startTime = form.startTime.value;
	var endTime = form.endTime.value;
	var projectCode = form.projectCode.value;
	var projectName = form.projectName.value;
	xmlHttp.open("post","InsertPlan?userCode="+userCode+"&startTime="+startTime+"&endTime="+endTime+"&projectCode="+projectCode+"&projectName="+projectName+"&projectType="+projectType);
	xmlHttp.onreadystatechange = function(){insertCallback(form);};
	xmlHttp.send(null);
	return false;
}
function insertCallback(form){
	if(xmlHttp.readyState == 4){
		if(xmlHttp.status == 200){
			var text = xmlHttp.responseText;
			if(text == "true"){
				$(form.userCode).parent('div').text("已成功发布");
				}
			else{
				alert("发布失败");
				}
			}
		}
	}
</script>
</body>
</html>
