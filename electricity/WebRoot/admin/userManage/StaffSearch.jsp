<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head>
<title>用户信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
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
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="../../images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 用户基本信息列表</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1"><button onClick="add()">添加</button>
           </span></div> </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
 <tr>
 	<td><table width="100%" border="0" cellspacing="0" cellpadding="0"  background="../../images/search.png"> 
    <tr>
    	<td height="70px" valign="middle">
        <form action="StaffSearch" method="post">
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
        <td width="8%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用户代码</span>
        </div></td>
        <td width="11%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用户名</span></div></td>
        <td width="8%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">所属部门</span></div></td>
        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">QQ</span></div></td>
        <td width="13%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center">Email</div></td>
        <td width="11%" bgcolor="d3eaef" class="STYLE6"><div align="center">联系电话</div></td>
        <td width="26%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">家庭地址</span></div></td>
        <td width="13%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
<%!
	public static final int COUNT_PER_PAGE = 9;
%>
<%
	int pageBefore = 0;
	int pageNext = 0;
	int tempCount = 0;
	int pageNow = 0;
	int count = 0;
	int pageCount = 0;
	List userinfo = (List)request.getAttribute("info"); 
	if(userinfo != null)
	{
		count = userinfo.size();
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
		Iterator iter = userinfo.iterator();
		while(iter.hasNext())
		{
			pageContext.setAttribute("user",iter.next());
			tempCount ++;
			if((tempCount>(pageNow-1)*COUNT_PER_PAGE)&&(tempCount<=pageNow*COUNT_PER_PAGE))
			{
			
%>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19">${user.userCode}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${user.userName}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${user.deptName}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${user.QQ}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${user.email}</div></td>
        <td bgcolor="#FFFFFF" class="STYLE19"><div align="center">${user.telephone}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${user.address}</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21"><a href="DeleteStaff?UserCode=${user.userCode}" onClick="return confirm('确定要删除么!')">删除</a> | <a href="GetInfoForAlterStaff?path=updateUser.jsp&code=${user.userCode}">修改</a></div></td>
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
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="49"><div align="center">
    <%
	if(pageNow!=1)
	{
	%>
	<a href = "StaffSearch?pageNow=<%=pageBefore%>">上一页</a>
	<%
	}
	%>
    </div></td>
            <td width="49"><div align="center">
    <%
	if(pageNow!=pageCount)
	{
	%>
	<a href = "StaffSearch?pageNow=<%=pageNext%>">下一页</a>
	<%
	}
	%>
            </div></td>
            <td width="37" class="STYLE22"><div align="center">转到</div></td>
   <form action = "StaffSearch" method = "post">
            <td width="22"><div align="center">
     
	<select name = "pageNow">
		<%
		for(int i=1;i<pageCount+1;i++)
		{
			if(i == pageNow)
			{
		%>
				<option value = <%=i%> selected = "selected"><%="第"+i%>
		<%
			}
			else
			{
		%>
				<option value = <%=i%>><%="第"+i%>
		<%
			}
		}
		%>
	</select> </div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
            <td width="35"><input type = "submit" value = "跳转"></td>
            </form>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
<script language="javascript">
	function add(){
		window.parent.rightFrame.location.href = " GetInfoForAlterStaff?path=addUser.jsp";
		}
</script>
<script type="text/javascript" src="../../js/jquery-1.9.1.min.js" ></script>
<script language="javascript">
	$(document).ready(function(){
		$("#SEARCH").click(function(){
			$("#SEARCH").val("");}
		)
	});
</script>
</html>
