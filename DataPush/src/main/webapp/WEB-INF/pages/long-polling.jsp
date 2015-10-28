<%--
  Created by IntelliJ IDEA.
  User: C2-41
  Date: 15-10-28
  Time: 下午2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>长轮询</title>
    <script src="../../assets/js/jquery.js"></script>

</head>
<body>
<h1>Long-polling 长轮询- Comet</h1>
<div id="info"></div>
<script type="text/javascript">
    var updater={
        poll:function(){
            $.ajax({
                url:"/polling",
                type:"POST",
                dataType:"text",
                success:updater.onSuccess,
                error: updater.onerror
            });
        },
        onSuccess:function(data){
            $("#info").append(data);
            updater.poll();
        },
        error:function(){
            console.log("Poll error");
        }
    }
    updater.poll();
</script>
</body>
</html>
