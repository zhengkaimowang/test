<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="zhuoyue.vo.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>权限修改</title>
<link href="../../SpryAssets/SpryCollapsiblePanel.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
	background:url(../../images/1.jpg) no-repeat;
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
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
#SEARCH{
	font-size:12px;
	color:#999;
	width:200px;}
-->
</style>
<body>
<%!
	public static final int COUNT_PER_PAGE = 9;
%>
<%
	int num =0;
	int pageBefore = 0;
	int pageNext = 0;
	int tempCount = 0;
	int pageNow = 0;
	int count = 0;
	int pageCount = 0;
	String[] privilegeName = {"用户管理","组织机构管理","密码修改","设备类型","巡检项目","设备履历","故障报告","巡检计划","巡检监控","巡检计划查看","巡检结果查看","月报表","周报表","厂商对比","设备故障分析"};
	String[] privilege = {"*000101","*000103","*000104","*000201","*000202","*000203","*000204","*000301","*000302","*000303","*000304","*000401","*000402","*000403","*000404"}; 
	List<Userinfo> info = (List<Userinfo>)request.getAttribute("info");
	if(info != null)
	{
		count = info.size()-1;
		pageCount = count/COUNT_PER_PAGE;//最后一页
		if(count%COUNT_PER_PAGE != 0)
		{
			pageCount ++;
		}
		if(request.getAttribute("pageNow") == null)
		{
			pageNow = 1;
		}
		else
		{
			pageNow = new Integer((String)request.getAttribute("pageNow")).intValue();
		}
		pageBefore = pageNow - 1;
		pageNext = pageNow + 1;
		Iterator<Userinfo> iter = info.iterator();
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
                <td width="94%" valign="bottom"><span class="STYLE1"> 用户权限添加</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
   <tr>
 	<td> <table width="100%" border="0" cellspacing="0" cellpadding="0"  background="../../images/search.png"> 
    <tr>
    	<td height="70px" valign="middle">
    <form action="GetInfoForChangePrivilege" method="post">
		<input type="text" name="keyWord" value="输入用户姓名或代号或所在部门查询" id="SEARCH"/>
        <input type="submit" value="搜索" style="border:none;background:url('../../images/anniu.png') left top no-repeat;width:80px; height:26px;"/>
	</form>
    </td>
    </tr>
    </table></td>
 </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="17%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用户代码</span>
        </div></td>
        <td width="17%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用户名</span></div></td>
        <td width="17%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">所属部门</span></div></td>
        <td width="49%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用户权限</span></div></td>
      </tr>
<%
	Userinfo user = null;
	while(iter.hasNext())
		{
			user = iter.next();
			String userprivilege = user.getFunctionPrivilege();
			if(userprivilege.equals("*00")){
				user = iter.next();
				userprivilege = user.getFunctionPrivilege();
				}
			num +=1;
			tempCount ++;
			if((tempCount>(pageNow-1)*COUNT_PER_PAGE)&&(tempCount<=pageNow*COUNT_PER_PAGE))
			{
%>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19"><%=user.getUserCode()%></span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19"><%=user.getUserName()%></span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><%=user.getDeptName()%></div></td>
        <td height="20" bgcolor="#FFFFFF"><div id="CollapsiblePanel<%=num%>" class="CollapsiblePanel">
          <div class="CollapsiblePanelTab" tabindex="0">点击修改</div>
          <div class="CollapsiblePanelContent">
          <form action="ChangePrivilege" method="post" onSubmit="return update(this)">
<%
	for(int i=0;i<privilege.length;i++)
{
				int cou = i+1;
				if((cou%5)==0)
				{
%>
			<br/>
<%	
				}
				
%>
<%
			if(userprivilege.contains(privilege[i]))
			{
%>
<input type="checkbox" name="privileged" checked="checked" value="<%=privilege[i]%>" /><%=privilegeName[i]%>
<%
			}
			else
			{
%>
		 <input type="checkbox" name="privileged" value="<%=privilege[i]%>" /><%=privilegeName[i]%>
<%
			}
}
%>
<br/>	<input type="hidden" name="privilege" id="privilege" />
	<input type="hidden" name="path" value="GetInfoForChangePrivilege" />
    <input type="hidden" name="userCode" value="<%=user.getUserCode()%>" />
	<input type="submit" value="确定" />
          </form>
          </div>
        </div>
        </td>
      </tr>
<%
			}
		}
	}
%>
    </table></td>
  </tr>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22"></span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="49"><div align="center">
    <%
	if(pageNow!=1)
	{
	%>
	<a href = "GetInfoForChangePrivilege?pageNow=<%=pageBefore%>">上一页</a>
	<%
	}
	%>
    </div></td>
            <td width="49"><div align="center">
    <%
	if(pageNow!=pageCount)
	{
	%>
	<a href = "GetInfoForChangePrivilege?pageNow=<%=pageNext%>">下一页</a>
	<%
	}
	%>
    </div></td>
  <form action = "GetInfoForChangePrivilege" method = "post">
            <td width="37" class="STYLE22"><div align="center">
     
	<select name = "pageNow">
		<%
		for(int i=1;i<pageCount+1;i++)
		{
			if(i == pageNow)
			{
		%>
				<option value = <%=i%> selected = "selected"><%="第"+i%></option>
		<%
			}
			else
			{
		%>
				<option value = <%=i%>><%="第"+i%></option>
		<%
			}
		}
		%>
	</select> </div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
            <td width="35"><input type = "submit" value = "跳转"></td> </form>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
<script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>
<script src="../../SpryAssets/SpryCollapsiblePanel.js" type="text/javascript"></script>
<script type="text/javascript">
var pageNow = <%=pageNow%>;
var count = <%=COUNT_PER_PAGE%>;
for(var i=(pageNow-1)*count+1;i<=pageNow*count;i++){
	var coll = "CollapsiblePanel"+i;
	coll =  new Spry.Widget.CollapsiblePanel("CollapsiblePanel"+i, {contentIsOpen:false, enableAnimation:false});
	}
</script>
<script language="javascript">
function update(form){
	var str="";  
	 $(form).find('input[name="privileged"]:checked').each(function(){  
	str+=$(this).val();  
	});  
	$(form).find("#privilege").val(str);
	return true;
}
</script>
<script language="javascript">
	$(document).ready(function(){
		$("#SEARCH").click(function(){
			$("#SEARCH").val("");}
		)
	});
</script>
</html>
