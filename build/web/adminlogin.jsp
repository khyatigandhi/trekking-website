<%-- 
    Document   : adminlogin
    Created on : Mar 27, 2018, 4:26:15 PM
    Author     : Galaxy
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="p1.Cregi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Admin login</title

    </head>
    <body>
        <form name="frm1" method="post" action="AdminLog">
            User Id:-<input type="text" name="utxt"/></br>
            Password:-<input type="password" name="ptxt"/></br>
            <input type="submit" name="submit" value="login" />
            
            
            
        </form>
    </body>
</html>
