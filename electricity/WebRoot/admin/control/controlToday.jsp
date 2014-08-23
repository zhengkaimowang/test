<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*,zhuoyue.vo.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>巡检监控</title>
<script src="../../SpryAssets/SpryCollapsiblePanel.js" type="text/javascript"></script>
<link href="../../SpryAssets/SpryCollapsiblePanel.css" rel="stylesheet" type="text/css">
<script language="javascript">
timer = window.setInterval("update()",2000); //页面刷新
</script>
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
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.ridao1{
	border-radius:20px;
	width:15px;
	height:15px;
	border:1px solid;
	background:#03F; border-color:#03F;
	}
.ridao2{
	border-radius:20px;
	width:15px;
	height:15px;
	border:1px solid;
	background:#0F0; border-color:#0F0;
	}
.ridao3{
	border-radius:20px;
	width:15px;
	height:15px;
	border:1px solid;
	background:red; border-color:red;
	}
</style>
<body>
<%
	PlanProject plan = null;
	List<PlanProject> lplan = null;
	Equipment equip = null;
	List<Equipment> lequip = null;
	String sta = null;
	List<String> lsta = null;
	List<List<String>> state = (List<List<String>>)request.getAttribute("state");
	List<List<Equipment>> equipment = (List<List<Equipment>>)request.getAttribute("equipment");
	Map<String,List<PlanProject>> project = (Map<String,List<PlanProject>>)request.getAttribute("project");
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
                <td width="94%" valign="bottom"><span class="STYLE1"> 巡检管理 >> 巡检监控 </span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table>
    <div class="ridao1" style="float:left"></div><div style="float:left">:未巡检</div>&nbsp;&nbsp;<div class="ridao2" style="float:left"></div><div style="float:left">:正常</div>&nbsp;&nbsp;<div class="ridao3" style="float:left"></div><div style="float:left">:异常</div></td>
  </tr>
 <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="19%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">总项目</span>
        </div></td>
        <td width="81%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">子项目</span></div></td>
        </tr>
<%
	int count = 0; //状态总数 
	int num = 0;
	int snum = 0;
	Set set = project.entrySet();    //取出父项目
	Iterator iter1 = set.iterator();
	while(iter1.hasNext()){
		Map.Entry me = (Map.Entry)iter1.next();
		lplan = (List<PlanProject>)me.getValue();
		num++;
%>
     <tr>
        <th height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19"></span><%=me.getKey()%></div></th>
        <td height="30" bgcolor="#FFFFFF" class="STYLE6">
        <div id="CollapsiblePanel<%=num%>" class="CollapsiblePanel1">
          <div class="CollapsiblePanelTab" tabindex="0">点击查看子项目</div>
          <div class="CollapsiblePanelContent"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
<%
		int i = 0;
		Iterator<PlanProject> iter2 = lplan.iterator();
		while(iter2.hasNext()){
			plan = iter2.next();
			i++;
			snum++;
%>
  <tr>
    <th width="17%" bgcolor="#FFFFFF" scope="row"><%=plan.getSubProjectName()%></th>
    <td width="83%" bgcolor="#FFFFFF">
    <div id="CollapsiblePanel<%=num%><%=snum%>" class="CollapsiblePanel">
          <div class="CollapsiblePanelTab" tabindex="0">查看设备</div>
          <div class="CollapsiblePanelContent">
<%
			lequip = (List<Equipment>)equipment.get(i-1);
			lsta = (List<String>)state.get(i-1);
			Iterator<Equipment> iter3 = lequip.iterator();
			Iterator<String> iter4 = lsta.iterator();
			while(iter3.hasNext()){
				equip = iter3.next();
				sta = iter4.next();
				count++;
%>
	<table width="100%" border="0" cellspacing="1" bgcolor="#a8c7ce" cellpadding="0">
  <tr>
    <th width="32%" align="center" valign="middle" bgcolor="#FFFFFF" scope="row"><%=equip.getTypename()%></th>
    <td width="28%" align="center" valign="middle" bgcolor="#FFFFFF"><%=equip.getCode()%></td>
    <td width="16%" align="center" valign="middle" bgcolor="#FFFFFF"><%
			if(sta.equals("0")){
%>
			<div class="ridao1" id="<%=count%>"></div>
<%
			}else if(sta.equals("1")){
%>
			<div class="ridao2" id="<%=count%>"></div>
<%
			}else{
%>
			<div class="ridao3" id="<%=count%>"></div>
<%
			}
%>
 </td>
 <td width="24%" align="center" valign="middle" bgcolor="#FFFFFF"><a href="Detail?code=<%=equip.getCode()%>&planCode=<%=plan.getPlanCode()%>&typeCode=<%=equip.getTypecode()%>">查看详细</a></td>
  </tr>
</table>
<%		
				}
%>
          </div>
          </div></td>
  </tr>
<%
		}
%>
</table>
		</div>
        </div>
        </td>
      </tr>
<%
	}
%>
    </table></td>
  </tr>
</table>
<script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
var num = <%=num%>;
var snum = <%=snum%>;
for(var i=1;i<=num;i++){
	var con = "CollapsiblePanel"+i;
	if(i == 1){
	con = new Spry.Widget.CollapsiblePanel(con, {contentIsOpen:true, enableAnimation:false});
	for(var y=1;y<=snum;y++){
	con ="CollapsiblePanel"+i+y; 
	con = new Spry.Widget.CollapsiblePanel(con, {contentIsOpen:true, enableAnimation:false});
		}
	}else{
	con = new Spry.Widget.CollapsiblePanel(con, {contentIsOpen:false, enableAnimation:false});
	for(var y=1;y<=snum;y++){
	con ="CollapsiblePanel"+i+y; 
	con = new Spry.Widget.CollapsiblePanel(con, {contentIsOpen:false, enableAnimation:false});
	}
		}
}
</script>
<script language="javascript">
var xmlHttp;
function createXMLHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
function update(){
	createXMLHttp();
	xmlHttp.open("POST","Update");
	xmlHttp.onreadystatechange = updateCallback;
	xmlHttp.send(null);
	}
function updateCallback(){
	if(xmlHttp.readyState == 4){
		if(xmlHttp.status == 200){
			var text = xmlHttp.responseText;
			var length = text.length;
			var temp = 0;
			for(temp;temp<length;temp++){
				var state = text.substring(temp,temp+1);
				var tempCount = temp+1;
				if(state == 0){			
					$("#"+tempCount).removeClass();
					$("#"+tempCount).addClass("ridao1");
					}else if(state == 1){
					$("#"+tempCount).removeClass();
					$("#"+tempCount).addClass("ridao2");
					}else{
					$("#"+tempCount).removeClass();
					$("#"+tempCount).addClass("ridao3");	
						}
				}
			}
		}
	}
</script>
</body>
</html>
