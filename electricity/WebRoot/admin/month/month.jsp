<%@ page contentType="text/html;charset=GBK"%>	
<%@ page import = "java.util.*,tubiao.*,zhuoyue.vo.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import = "other.GetExcel"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�±���</title>
</head>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
	background:url(../../images/6.jpg) no-repeat;
	background-size: cover; 
	-moz-background-size: cover;
}
.month{
	margin-top:20px;
	text-align:center;}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.top_css{
	background: url(../../images/report.png) no-repeat;
	background-size: cover; 
	-moz-background-size: cover;
	height:75px;
	padding-left:40px;
	}
a{
	text-decoration:none;}
.top_css a:link {
    color:#FFF;
    }
.top_css a:visited {
    color:#FFF;
    }
.radio{
	width:80px;
	height:25px;
	background:#436A91;
	line-height:25px;
	text-align:center;}
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
                <td width="94%" valign="bottom"><span class="STYLE1">ͳ�Ʒ��� >> �±���</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
 </table>
<div>
    <div class="top_css">
        <form action="ProjectForMonth" method="post">
        <select name="year">
          	<option value="2014" selected="selected">2014</option>
            <option value="2013">2013</option>
            <option value="2012">2012</option>
            <option value="2011">2011</option>
            <option value="2010">2010</option>
          </select>
          <select name="month">
          	<option value="01" selected="selected">��ѡ���·�</option>
          	<option value="01">һ��</option>
            <option value="02">����</option>
            <option value="03">����</option>
            <option value="04">����</option>
            <option value="05">����</option>
            <option value="06">����</option>
            <option value="07">����</option>
            <option value="08">����</option>
            <option value="09">����</option>
            <option value="10">ʮ��</option>
            <option value="11">ʮһ��</option>
            <option value="12">ʮ����</option>
          </select>    
          <input type="submit" value="ȷ��" />
        </form>
        <div class="radio"><a href="MonthExcel">��������</a></div>
    </div>
<%
	Project pro = null;
	List<Integer> res = null;
	List<List<Integer>> result = (List<List<Integer>>) request.getAttribute("result");
	List<Project> project = (List<Project>)request.getAttribute("project");
	session.setAttribute("result",result);
	session.setAttribute("project",project);
	String year = (String)request.getAttribute("year");
	String month = (String)request.getAttribute("month");
	Iterator<List<Integer>> iter = result.iterator();
	Iterator<Project> iter1 = project.iterator();
	while(iter.hasNext()){
		res = iter.next();
		pro = iter1.next();		
%>
<%
//������ͳ��ʱ����
BaoBiao yb = new BaoBiao();
JFreeChart chart1 = yb.getMonth(res,Integer.parseInt(month),Integer.parseInt(year),pro.getName());
String filename1 = ServletUtilities.saveChartAsPNG(chart1, 800, 300, null, session);
String graphURL1 = request.getContextPath() + "/DisplayChart?filename=" + filename1;
%>
<div class="month"><img src="<%= graphURL1 %>"width=800 height=300 border=0 usemap="#<%= filename1 %>"><p><a href="SubProjectForMonth?code=<%=pro.getProjectCode()%>&year=<%=year%>&month=<%=month%>&superName=<%=pro.getName()%>">����鿴<%=pro.getName()%>����Ŀ����</a></p></div>
<%
	}
%>
</div>
</body>
</html>
