<%@ page contentType="text/html;charset=GBK"%>	
<%@ page import = "java.util.*,tubiao.*,zhuoyue.vo.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.servlet.ServletUtilities"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>设备报表</title>
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
	margin-left:50px;
	text-align:center;
	float:left;}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
</style>
<body>
<%
	String subName = (String)request.getAttribute("subName");
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
                <td width="94%" valign="bottom"><span class="STYLE1">统计分析 >> 月报表 >> <%=superName%> >> <%=subName%></span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
 </table>
<div class="big">
<%
	Equipment equ = null;
	List<String> pra = null;
	List<Integer> res = null;
	List<List<Integer>> result = (List<List<Integer>>) request.getAttribute("result");
	List<Equipment> equipment = (List<Equipment>)request.getAttribute("equipment");
	List<List<String>> parameter = (List<List<String>>)request.getAttribute("parameter");
	String year = (String)request.getAttribute("year");
	String month = (String)request.getAttribute("month");
	Iterator<List<Integer>> iter1 = result.iterator();
	Iterator<List<String>> iter2 = parameter.iterator();
	Iterator<Equipment> iter3 = equipment.iterator();
	while(iter1.hasNext()){
		res = iter1.next();
		pra = iter2.next();	
		equ = iter3.next();
%>
<%
//访问量统计时间线
BaoBiao yb = new BaoBiao();
JFreeChart chart1 = yb.getEquipment(pra,res,equ.getTypename());
String filename1 = ServletUtilities.saveChartAsPNG(chart1, 500, 300, null, session);
String graphURL1 = request.getContextPath() + "/DisplayChart?filename=" + filename1;
%>
<div class="month"><img src="<%= graphURL1 %>"width=500 height=300 border=0 usemap="#<%= filename1 %>"></div>
<%
	}
%>
</div>
</body>
</html>

