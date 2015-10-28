<%--
  Created by IntelliJ IDEA.
  User: C2-41
  Date: 15-10-28
  Time: 上午9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Comet -流 -数据推送</title>
    <script src="../../assets/js/jquery.js"></script>

</head>
<body>
Comet （streaming）-数据推送 无法兼容IE
<div id="info"></div>
<script type="text/javascript">
    try{
        var ajax=new XMLHttpRequest();
    }catch(e){
        alert("Browser doesn't support XMLHttpRequest");
    }
    var pos=0;
    ajax.onreadystatechange=function(){
        if(ajax.readyState==3){
            var data=ajax.responseText;
            $("#info").append(data.substring(pos));
            console.log(data);
            pos=data.length;
        }
    };
    ajax.open("post","/streaming",true);
    ajax.send(null);

</script>
</body>
</html>
