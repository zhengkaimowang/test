<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>首页</title>
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE8{
		background:#436b92;
		text-align:center;
		color:#FFF;
		font-family: "黑体";
		height:20px;
		text-align:center;
		font-size:18px;}
.STYLE9{
		height:22px;
		text-align:center;
		font-family: "黑体";
		background:#436b92;
		text-align:left;
		color:#FFF;
		background:url(../images/lan.png); background-repeat:no-repeat;
		font-size:18px;}
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
	border-radius:5px;
	border: solid 1px #68A8E8;
}
 a:link {
    color:#000;
    text-decoration:none;
    }
    a:visited {
    color:#000;
    text-decoration:none;
    }
    a:hover {
    color:#000;
    text-decoration:none;
    }
    a:active {
    color:#000;
    text-decoration:none;
    }
.textarea{
	color:#3D4A50;
	background:#E1ECEE;
	resize: none;
	border:0;
	font-size:14px;
	font-family:"黑体";}
ul li{
	margin:4px;
	list-style-type:none;
	overflow:hidden;
	text-overflow:ellipsis;
	white-space:nowrap;
	}
-->
</style>
</head>

<body>
<%
  if(request.getParameter("error")!=null){
	  if(request.getParameter("error").equals("error"))
	  {
%>
<script language="javascript">
	alert("您权限不足");
</script>
<%
	  }
  }
%>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" height="480">
  <tr>
    <td height="26"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="../images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 首页</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="456"><table width="100%" border="0" cellpadding="0" cellspacing="1">
    <tr>
        <td width="22%" height="455" align="center" valign="top">
        <table>
        <tr>
          <td width="240" height="236" valign="top">
            <table border="0" cellpadding="0" cellspacing="0" >
                <tr>
                    <td width="257" height="228" align="center" valign="top" bgcolor="#E1ECEE"><div class="STYLE8" style="margin-bottom:10px">企业简介</div>
                    <textarea cols="30" rows="9" class="textarea" readonly="readonly" >   公司作为关系国家能源安全和国民经济命脉的国有重要骨干企业，以建设和运营电网为核心业务，承担着保障更安全、更经济、更清洁、可持续的电力供应的基本使命，经营区域覆盖全国26个省（自治区、直辖市），覆盖国土面积的88%，供电人口超过11亿人，公司用工总量超过186万人。公司在菲律宾、巴西、葡萄牙、澳大利亚等国家和地区开展业务。</textarea>
                    </td>
                </tr>
            </table></td>
            </tr>
            <tr>
            <td height="205">
            <table border="0" cellpadding="0" cellspacing="0" >
                <tr>
                    <td width="260" height="205" align="center" valign="top" bgcolor="#E1ECEE"><div class="STYLE8" style="margin-bottom:10px">公告栏</div> <textarea cols="30" rows="8" class="textarea" readonly="readonly">   "奉献社会"，是指关爱社会、服务社会、回报社会和履行社会责任。公司坚持发展公司、服务社会的社会责任目标，以公司的发展实现员工成长、客户满意、政府放心，促进经济发展、社会和谐。公司及员工热心社会公益，遵守社会公德，引领社会良好风尚，树立公司开放、进取、诚信、负责的企业形象</textarea></td>
                </tr>
                </table></td>
          	</tr>
          </table>
        </td>
        <td width="50%" align="center" valign="top">
        <table height="455" border="0" cellpadding="0" cellspacing="2">
        	<tr>
            	<td width="590" height="135" valign="top">
                <div class="STYLE9">&nbsp;计划总结</div>
                <ul>
                	<li><a href="#"><img src="../images/dian.png" />&nbsp;2014年4月23日计划总结</a>............................<a href="#">评语，检查意见</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2014年3月4日计划总结</a>.............................<a href="#">评语，检查意见</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2013年11月22日计划总结</a>...........................<a href="#">评语，检查意见</a></li>
                  </ul>
                <div style="text-align:right;"><a href="#">更多&nbsp;&nbsp;</a></div>
                </td>
            </tr>
            <tr>
            	<td height="141" valign="top">
                <div class="STYLE9">&nbsp;安全活动</div>
                <ul>
                	<li><a href="#"><img src="../images/dian.png" />&nbsp;2014年4月23日安全活动</a>............................<a href="#">评语，检查意见</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2014年3月4日安全活动</a>.............................<a href="#">评语，检查意见</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2013年11月22日安全活动</a>...........................<a href="#">评语，检查意见</a></li>
                </ul>
                <div style="text-align:right;"><a href="#">更多&nbsp;&nbsp;</a></div>
                </td>
            </tr>
            <tr>
            	<td height="149" valign="top">
                <div class="STYLE9">&nbsp;技术培训</div>
                <ul>
                	<li><a href="#"><img src="../images/dian.png" />&nbsp;2014年4月23日技术培训</a>............................<a href="#">评语，检查意见</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2014年3月4日技术培训</a>.............................<a href="#">评语，检查意见</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2013年11月22日技术培训</a>...........................<a href="#">评语，检查意见</a></li>
                </ul>
                <div style="text-align:right;"><a href="#">更多&nbsp;&nbsp;</a></div>
                </td>
            </tr>
        </table>
        </td>
        <td width="28%" align="center" valign="top">
        <table>
        	<tr>
            	<td width="328" height="242" valign="top">
                <div style="width:320px;height:240px; margin:0 3px;">
                	<div class="STYLE8">企业图片</div>
                    <div style="height:200px; margin:10px 10px;"><script src="../js/picture.js" type="text/javascript"></script> </div>
                </div>
                </td>
            </tr>
            <tr>
            	<td height="190" align="center" valign="top">
                <div style="width:320px;height:190px; margin:0 3px; background:#E1ECEE;">
                <div class="STYLE8" style="margin-bottom:10px;">专用记录</div>
                <textarea cols="39" rows="7" class="textarea" readonly="readonly">  2014-03-12:萧山1变 控制室 母线人为损坏
  2014-03-23:下沙1变 主设备区 电缆意外损坏
  2014-03-28:下沙1变 主设备区 SF6断路器意外损坏
  2014-04-12:萧山1变 主设备区 真空断路器意外损坏
  2014-04-15:萧山1变 控制室 隔离开关意外损坏
                </textarea>
                </div></td>
            </tr>
        </table>
        </td>
    </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
