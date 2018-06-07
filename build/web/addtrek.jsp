<%-- 
    Document   : addtrek
    Created on : Mar 27, 2018, 7:39:20 PM
    Author     : Galaxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="frm1" method="post" action="Addtrek1"/>
        Trek Name:-<input type="text" name="ntxt" /></br>
        Description:-<input type="text" name="dtxt"/></br>
        cost:-<input type="text" name="cost"/></br>
        Image:-<input type="file" name="f"/></br>
        <input type="submit" name="submit" value="save"/></br>
        
        
    </form>
        <%
             if(session.getAttribute("nm")==null)
                {
                    response.sendRedirect("index.jsp?msg=Sorry your session expires!");
                            
                }
        %>
    </body>
</html>
