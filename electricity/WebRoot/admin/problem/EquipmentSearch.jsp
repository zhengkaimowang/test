<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*,zhuoyue.vo.*"%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>���ϱ���</title>
<link type="text/css" rel="stylesheet" href="calendar.css" >
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
                <td width="94%" valign="bottom"><span class="STYLE1">�豸���� >> ���ϱ���</span></td>
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
    <form action="AllProblem" method="post">
		��ѡ������:<input type="text" name="date" id="EntTime" value="" onClick="return showCalendar('EntTime', 'y-mm-dd');"/>
        <input type="submit" value="����" style="background:url(../../images/anniu.png) left top no-repeat; width:80px; height:26px; border:none;"/>
	</form>
     </td>
    </tr>
    </table></td>
 </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">������</span>
        </div></td>
        <td width="13%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">�豸����</span></div></td>
        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">������Ŀ</span></div></td>
        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">��������Ŀ</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center">��������</div></td>
		 <td width="16%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">��������</span></div></td>
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
	Problem pro = null;
	List<Problem> info = (List<Problem>)request.getAttribute("allproblem"); 
	if(info != null){
		count = info.size();
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
		Iterator<Problem> iter = info.iterator();
		while(iter.hasNext()){
			pro = iter.next();
			pageContext.setAttribute("problem",pro);
			tempCount ++;
			if((tempCount>(pageNow-1)*COUNT_PER_PAGE)&&(tempCount<=pageNow*COUNT_PER_PAGE))
			{
%>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19">${problem.equipmentcode}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${problem.typename}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${problem.project}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${problem.subproject}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${problem.date}</div></td>
		<td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21"><a href="SearchRecordForProblem?typeName=<%=pro.getTypename()%>&code=<%=pro.getEquipmentcode()%>&date=<%=pro.getDate()%>">�鿴����</a></div></td>
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
	<a href = "AllProblem?pageNow=<%=pageBefore%>">��һҳ</a>
	<%
	}
	%>
    </div></td>
            <td width="49"><div align="center">
    <%
	if(pageNow != pageCount)
	{
	%>
	<a href = "AllProblem?pageNow=<%=pageNext%>">��һҳ</a>
	<%
	}
	%></div></td>
            <td width="37" class="STYLE22"><div align="center">ת��</div></td>
         <form action = "AllProblem" method = "post">
            <td width="22"><div align="center">
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
	</select> 
            </div></td>
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
