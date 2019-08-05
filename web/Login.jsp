<%-- 
    Document   : login
    Created on : Jul 26, 2019, 4:40:41 PM
    Author     : tikko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="assets/css/login.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
		<br><br><br><br><br>
                <form name="form" action="<%=request.getContextPath()%>/LoginServlet" method="POST">
        <div class="login-block">
            <h1><div class="logo"></div></h1>
            <input type="text" placeholder="Username" name="username" />
            <input type="password" placeholder="Password" name="password" />
            <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
            <!--<button>Login</button>-->
            <input type="submit" value="Login"></input>
        </div>
                </form>
    </body>
</html>
