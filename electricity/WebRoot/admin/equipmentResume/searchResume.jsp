<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*,zhuoyue.vo.*"%>
<html"><head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>查看巡检记录</title>
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
.STYLE8{color:#0F0; font-size: 12px;}
.STYLE9{color: #F00; font-size: 12px;}
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
<%!
	public static final int COUNT_PER_PAGE = 3;
%>
<%
	String code = (String)request.getAttribute("code");
	String typeCode = (String)request.getAttribute("typeCode");
	int pageBefore = 0;
	int pageNext = 0;
	int tempCount = 0;
	int pageNow = 0;
	int count = 0;
	int pageCount = 0;
	Record re = null;
	List<Record> info =(List<Record>)request.getAttribute("info");
	List parameter = (List)request.getAttribute("parameter");
	Iterator iter1 = parameter.iterator();
	count = info.size();
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
	Iterator<Record> iter2 = info.iterator();
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
                <td width="94%" valign="bottom"><span class="STYLE1">设备管理 >> 设备履历 >> 查看巡检记录</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
 <%
 	int num =0;
	while(iter2.hasNext()){
		re = iter2.next();
		num++;
		if(re != null){
			List<String> pa = re.getParameter();
			int state = re.getState();
			tempCount ++;
			if((tempCount>(pageNow-1)*COUNT_PER_PAGE)&&(tempCount<=pageNow*COUNT_PER_PAGE))
			{
%> 
<%
				if(num>1 && (num%COUNT_PER_PAGE-1) != 0){
%>
                      <tr>
                        <td bgcolor="#FFFFFF" height="10px">&nbsp;</td>
                      </tr>
<%
				}
%>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
      <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">条形码</span>
        </div></td>
        <td width="12%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">巡检日期</span>
        </div></td>
        <td width="11%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">巡检人</span></div></td>
        <td width="26%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">备注</span></div></td>
        <td width="11%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">状态</span></div></td>
        </tr> 
<tr>
      <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19"><%=re.getCode()%></span></div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19"><%=re.getDate()%></span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19"><%=re.getUserName()%></span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19"><%=re.getRemark()%></span></div></td>
         <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">
<%
			if(state == 0){
%>
			未巡检
<%
			}else if(state == 1){
%>
			已巡检，正常
<%
			}else if(state == 2){
%>
			有异常
<%
			}else{
%>
			异常，已处理
<%				
				}
%> 
       	</span></div></td>
</tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
    <tr>
<%
	while(iter1.hasNext()){
		pageContext.setAttribute("parameter",iter1.next());
%>
          <td width="5%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">${parameter}</span></div></td>
<%
	}
	iter1 =	parameter.iterator();
%>
    </tr>
    <tr>
<%
		for(int i=0;i<pa.size();i++){
			if(pa.get(i).equals("正常")){
%>
          <td height="20" bgcolor="#FFFFFF" class="STYLE8"><div align="center"><span class="STYLE8"><%=pa.get(i)%></span></div></td>
<%
		}else{
%>
        <td height="20" bgcolor="#FFFFFF" class="STYLE9"><div align="center"><span class="STYLE9"><%=pa.get(i)%></span></div></td>
<%			
			}
		}
%>
    </tr>
    </table></td>
  </tr>
<%
			}
			
		}
	}
%>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="65"><div align="center">
   <%
  	if(pageNow!=1)
	{
	%>
	<a href = "SearchRecordForEquipment?code=<%=code%>&typeCode=<%=typeCode%>&pageNow=<%=pageBefore%>">上一页</a>
	<%
	}
	%>
    </div></td>
            <td width="63"><div align="center">
     <%
	if(pageNow!=pageCount)
	{
	%>
	<a href = "SearchRecordForEquipment?code=<%=code%>&typeCode=<%=typeCode%>&pageNow=<%=pageNext%>">下一页</a>
	<%
	}
	%>
    </div></td>
            <td width="46" class="STYLE22"><div align="center">转到</div></td>
          <form action = "SearchRecordForEquipment?code=<%=code%>&typeCode=<%=typeCode%>&" method = "post">
              <td width="52" class="STYLE22"><div align="center">
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
	</select></div></td>
            <td width="28" class="STYLE22"><div align="center">页</div></td>
            <td width="58"><input type = "submit" value = "跳转"></td>
            </form>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
