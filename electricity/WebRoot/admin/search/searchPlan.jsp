<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*,zhuoyue.vo.Userinfo"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ƻ��鿴</title>
<link type="text/css" rel="stylesheet" href="calendar.css" >
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
                <td width="94%" valign="bottom"><span class="STYLE1"> Ѳ����� >> Ѳ��ƻ��鿴</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
<%
	Userinfo us = null;
	List<Userinfo> user = (List<Userinfo>)request.getAttribute("user");
	Iterator<Userinfo> iu = user.iterator();
%>
  <tr>
 	<td> <table width="100%" border="0" cellspacing="0" cellpadding="0"  background="../../images/search.png"> 
    <tr>
    	<td height="70px" valign="middle">
    <form action="PlanSearch" method="post">
		��ѡ������:<input type="text" name="date" id="EntTime" value="" onClick="return showCalendar('EntTime', 'y-mm-dd');"/>
        <select name="userCode">
        <option value="" selected="selected">����������</option>
<%
	while(iu.hasNext()){
		us = iu.next();
%>
     <option value="<%=us.getUserCode()%>"><%=us.getUserName()%></option>      
<%
	}
%>
	 </select>
        <input type="submit" value="����" style="border:none;background:url('../../images/anniu.png') left top no-repeat;width:80px; height:26px;"/>
	</form>
    </td>
    </tr>
    </table></td>
 </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="18%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">Ѳ������</span>
        </div></td>
        <td width="21%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">Ѳ����</span></div></td>
        <td width="21%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">��ʼʱ��</span></div></td>
        <td width="23%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">����ʱ��</span></div></td>
         <td width="17%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">Ѳ������</span></div></td>
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
	List plan = (List)request.getAttribute("plan");
	if(plan != null){
	Iterator iter = plan.iterator();
	//��ҳ
		count = plan.size();
		pageCount = count/COUNT_PER_PAGE;//���һҳ
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
	//��ҳ
		while(iter.hasNext()){
			pageContext.setAttribute("plan",iter.next());
			tempCount ++;
			if((tempCount>(pageNow-1)*COUNT_PER_PAGE)&&(tempCount<=pageNow*COUNT_PER_PAGE))
			{
%>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19">${plan.type}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${plan.userName}</span></div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19">${plan.startTime}</span></div>
        </td>
         <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19">${plan.endTime}</span></div>
        </td>
         <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19">${plan.subProjectName}</span></div>
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
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="49"><div align="center">
    <%
  	if(pageNow!=1)
	{
	%>
	<a href = "PlanSearch?pageNow=<%=pageBefore%>">��һҳ</a>
	<%
	}
	%>
    </div></td>
            <td width="49"><div align="center">
    <%
	if(pageNow!=pageCount)
	{
	%>
	<a href = "PlanSearch?pageNow=<%=pageNext%>">��һҳ</a>
	<%
	}
	%>
    </div></td>
              <td width="37" class="STYLE22"><div align="center">ת��</div></td>
          <form action = "PlanSearch" method = "post">
              <td width="22" class="STYLE22"><div align="center">
              <select name = "pageNow">
		<%
		for(int i=1;i<pageCount+1;i++)
		{
			if(i == pageNow)
			{
		%>
				<option value = <%=i%> selected = "selected"><%="��"+i%></option>
		<%
			}
			else
			{
		%>
				<option value = <%=i%>><%="��"+i%></option>
		<%
			}
		}
		%>
	</select></div></td>

            <td width="22" class="STYLE22"><div align="center">ҳ</div></td>
            <td width="35"><input type = "submit" value = "��ת"></td>
            </form>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
<script type="text/javascript" src="calendar.js" ></script>  
<script type="text/javascript" src="calendar-zh.js" ></script>
<script type="text/javascript" src="calendar-setup.js"></script>
</html>
