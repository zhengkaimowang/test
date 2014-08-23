<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>电力巡检系统</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/js.js"></script>
</head>
    <style type="text/css">  
        .code  
        {  
             
            font-family:Arial;  
            font-style:italic;  
            color:Red;  
            border:0;  
            padding:2px 3px;  
            letter-spacing:3px;  
            font-weight:bolder;  
        }   
    </style>   
<body onLoad="createCode()">
<div id="top"> </div>
<form action="Login" method="post" id="login" onSubmit="return validate()">
  <div id="center">
    <div id="center_left"></div>
    <div id="center_middle">
      <div class="user">
        <label>用户名：
        <input type="text" name="userCode" id="user" />
        </label>
      </div>
      <div class="user">
        <label>密　码：
        <input type="password" name="pwd" id="pwd" />
		<input type="hidden" name="path" value="main.html" />
        </label>
      </div>
      <div class="chknumber">
        <label>验证码：
        <input name="chknumber" type="text" id="input1"maxlength="4" class="chknumber_input" />
        </label>
          <input type="text" onClick="createCode()" readonly="readonly" id="checkCode" class="unchanged" style="width: 50px; height:20px"  />
      </div>
    </div>
    <div id="center_middle_right"></div>
    <div id="center_submit">
      <div class="button"> <img src="${pageContext.request.contextPath}/images/dl.gif" width="57" height="20" onClick="form_submit()" > </div>
      <div class="button"> <img src="${pageContext.request.contextPath}/images/cz.gif" width="57" height="20" onClick="form_reset()"> </div>
    </div>
    <div id="center_right"></div>
  </div>
</form>
<div id="footer"></div>
</body>
</html>
