<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ page import="com.cn.zk.access.bean.UserBean"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>/WEB-INF/">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
  </head>
  <SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="<%=basePath%>access_registerSkip.action";
   document.getElementById("fom").submit();
}

</SCRIPT>
<body>
<s:debug></s:debug>

<form name="fom" id="fom" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<!--   <tr> -->
<!--     <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0"> -->
<!--         <tr> -->
<!--           <td height="62" background="../images/nav04.gif"> -->
            
<!-- 		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0"> -->
<!-- 		    <tr> -->
<!-- 			  <td width="21"><img src="../images/ico07.gif" width="20" height="18" /></td> -->
<!-- 			  <td width="538">查看内容：按时间： -->
<!-- 				<input name="textfield" type="text" size="12" readonly="readonly"/> -->
<%-- 				<span class="newfont06">至</span> --%>
<!-- 				<input name="textfield" type="text" size="12" readonly="readonly"/> -->
<!-- 				<input name="Submit4" type="button" class="right-button02" value="查 询" /></td> -->
<!-- 			   <td width="144" align="left"><a href="#" onclick="sousuo()"> -->
<!-- 			     <input name="Submit3" type="button" class="right-button07" value="高级搜索" /> -->
<!-- 			   </a></td>	 -->
<!-- 		    </tr> -->
<!--           </table></td> -->
<!--         </tr> -->
<!--     </table> -->
<!--     </td> -->
<!--     </tr> -->
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">
<!--                	选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a> -->
<%--                	</span> --%>
	              <input name="Submit2" type="button" class="right-button08" value="add user" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
                
                
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td height="22" colspan="7" align="center" style="font-size:16px">用户列表</td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
				    <td width="4%" align="center" height="30">选择</td>
                    <td width="20%">用户昵称</td>
					<td width="20%">用户帐号</td>
					<td width="12%">操作</td>
                  </tr>
                  
                  <%
                  	List<UserBean> list = (List<UserBean>)request.getAttribute("userListsss");
                  for(UserBean ub : list){
					                  
                  %>
                     <tr bgcolor="#FFFFFF">
				    <td height="20"><input type="checkbox" name="delid"/></td>
                    <td ><a href="listmokuaimingxi.htm" onclick=""></a><%=ub.getUserName() %></td>
					<td><%=ub.getAccount() %></td>
                    <td>
<%--                     <a href="<%=basePath%>access_changePassword.action?id=<%=ub.getId() %>">编辑|</a> --%>
					<a href="<%=basePath%>access_removeUser.action?id=<%=ub.getId() %>">删除</a></td>
                  </tr>
                  <%
                  	}
                  %>
<!-- 				  <tr bgcolor="#FFFFFF"> -->
<!-- 				    <td height="20"><input type="checkbox" name="delid"/></td> -->
<!--                     <td ><a href="listmokuaimingxi.htm" onclick=""></a>任务XXX</td> -->
<!-- 					<td>2007-11-11</td> -->
<!--                     <td>XXXXXX</td> -->
<!--                     <td>XXXXXX</td> -->
<!--                     <td>急</td> -->
<!--                     <td><a href="editrenwu.htm">编辑|</a><a href="listrenwumingxi.htm">查看|</a> -->
<!-- 					<a href="#">删除</a></td> -->
<!--                   </tr> -->
            </table>
            
            
            
            
            </td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">5</span> 页 | 第 <span class="right-text09">1</span> 页</td>
                <td width="49%" align="right">[<a href="#" class="right-font08">首页</a> | <a href="#" class="right-font08"> 上一页</a> | <a href="#" class="right-font08">下一页</a> | <a href="#" class="right-font08">末页</a>] 转至：</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
