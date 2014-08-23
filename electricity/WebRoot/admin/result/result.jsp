<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*,zhuoyue.vo.Equipment,zhuoyue.vo.PlanProject"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>巡检结果查看</title>
</head>
<link type="text/css" rel="stylesheet" href="resources/css/lTREE.default.css"/>
<link type="text/css" rel="stylesheet" href="calendar.css" >
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
.STYLE6 {color: #000000; font-size: 12; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.big{
	height:100%;
	width:1100px;}
#right{
	margin-top:-400px;
	width:450px;
	float:right;
	text-align:left;
	margin-right:100px;
	border:#FFFFFF solid 1px;
	background: url(../../images/11.jpg);
	background-size: cover; 
	-moz-background-size: cover;}
a:link {
    color:bule;
    text-decoration:none;
    }
a:visited {
    color:bule;
    text-decoration:none;
    }
a:hover {
    color:bule;
    text-decoration:none;
    }
a:active {
    color:bule;
    text-decoration:none;
    }
</style>
<body onLoad= "linkClick()">
<%
	String today = (String)request.getAttribute("today");
	Equipment equ = null;
	PlanProject pro = null;
	List<Equipment> equip = null;
	List<PlanProject> plan = null;	
	Map<String,List<PlanProject>> project = (Map<String,List<PlanProject>>)request.getAttribute("project");
	List<List> equipment = (List<List>)request.getAttribute("equipment");
	Set set = project.entrySet();
	Iterator iter1 = set.iterator();
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
                <td width="94%" valign="bottom"><span class="STYLE1"> 巡检管理 >> 巡检结果查看</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
 </table>
 <div class="big">
 	<div class="date">
    	<form action="SearchResult" method="post">
        选择日期:<input type="text" name="date" id="EntTime" value="<%=today%>" onClick="return showCalendar('EntTime', 'y-mm-dd');"/>
        <input type="submit" value="确定" />
        </form>
    </div>
<div class="lTREEMenu lTREENormal" id="lTREEMenuDEMO">
<span id="TreeHeader">项目</span>
 <dl id="TopDL">
<%
	//第一层
	int i = 0;
	while(iter1.hasNext()){
		Map.Entry me = (Map.Entry)iter1.next();	
		plan = (List<PlanProject>)me.getValue();
%>
        <dd><%=me.getKey()%>
        	<dl>
<%
	//第二层
	Iterator<PlanProject> iter3 = plan.iterator();
	while(iter3.hasNext()){
		pro = iter3.next();
		i++;
%>
            	<dd><%=pro.getSubProjectName()%>
            		<dl>
<%
			//第三层
			equip = (List<Equipment>)equipment.get(i-1);
			Iterator<Equipment> iter2 =equip.iterator();
				while(iter2.hasNext()){
					equ = iter2.next();
%>
                <dt><a href="#" id="<%=i%>" onClick="subProject(<%=equ.getTypecode()%>,<%=pro.getPlanCode()%>,<%=equ.getCode()%>,'<%=equ.getTypename()%>')"><%=equ.getTypename()%>[<%=equ.getCode()%>]</a><dt>
<%
		}
%>
                	</dl>
                </dd>
<%
	}
%>
            </dl>
        </dd>
<%
	}
%>
    </dl> </div>
   <div id="right"></div>
   </div>
</body>
<script type="text/javascript" src="calendar.js" ></script>  
<script type="text/javascript" src="calendar-zh.js" ></script>
<script type="text/javascript" src="calendar-setup.js"></script>
<script type="text/javascript" src="js/lTREE.js">
    </script>
	<script class="lJSFDemo" type="text/javascript">
var lTree = new lTREE();


lTree.build("lTREEMenuDEMO");
//lTree.changAll(0);

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
function subProject(name,planCode,code,typeName){
	createXMLHttp(); 
	xmlHttp.open("POST","SearchParameter?name="+name+"&planCode="+planCode+"&code="+code+"&typeName="+typeName);
	xmlHttp.onreadystatechange = subProjectCallback;
	xmlHttp.send(null);
	}
function subProjectCallback(){
	if(xmlHttp.readyState == 4){
		if(xmlHttp.status == 200){
			var table = xmlHttp.responseText;
			document.getElementById("right").innerHTML = "";
			document.getElementById("right").innerHTML = table;
			}
		}
	}
</script>
<script language="javascript">
function linkClick(){
	var ink = document.getElementById("1");
	ink.click();
	}
</script>
</html>
