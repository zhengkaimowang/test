<%@ page contentType="text/html;charset=GBK"%>	
<%@ page import = "java.util.*,tubiao.*,zhuoyue.vo.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.servlet.ServletUtilities"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>子项目周报表</title>
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
a{
	text-decoration:none;}
.radio a:link {
    color:#FFF;
    }
.radio a:visited {
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
<%
	String superName = (String)request.getAttribute("superName");
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
                <td width="94%" valign="bottom"><span class="STYLE1">统计分析 >> 周报表 >> <%=superName%></span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
 </table>
  
<div>
	<div class="radio"><a href="WeekExcel">导出报表</a></div>
<%
	Project pro = null;
	List<Integer> res = null;
	List<List<Integer>> result = (List<List<Integer>>) request.getAttribute("result");
	List<Project> project = (List<Project>)request.getAttribute("project");
	session.setAttribute("result",result);
	session.setAttribute("project",project);
	String year = (String)request.getAttribute("year");
	String month = (String)request.getAttribute("month");
	String week = (String)request.getAttribute("week");
	Iterator<List<Integer>> iter = result.iterator();
	Iterator<Project> iter1 = project.iterator();
	while(iter.hasNext()){
		res = iter.next();
		pro = iter1.next();		
%>
<%
//访问量统计时间线
BaoBiao yb = new BaoBiao();
JFreeChart chart1 = yb.getWeek(res,Integer.parseInt(month),Integer.parseInt(year),Integer.parseInt(week),pro.getName());
String filename1 = ServletUtilities.saveChartAsPNG(chart1, 800, 300, null, session);
String graphURL1 = request.getContextPath() + "/DisplayChart?filename=" + filename1;
%>
<div class="month"><img src="<%= graphURL1 %>"width=800 height=300 border=0 usemap="#<%= filename1 %>"><p><a href="EquipmentForWeek?year=<%=year%>&month=<%=month%>&subName=<%=pro.getName()%>&week=<%=week%>&superName=<%=superName%>">点击查看<%=pro.getName()%>设备报表</a></p></div>
<%
	}
%>
</div>
</body>
</html>