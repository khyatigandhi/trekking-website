<%-- 
    Document   : addadmin
    Created on : Mar 27, 2018, 7:38:30 PM
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
        <a href="regadmin.jsp">Add Administer</a></br>
        <a href="addtrek.jsp">Add Trek</a>
        <form name="frm1" action="addadmin.jsp">
        <input type="submit" name="logout" value="logout"/></br>
       
        </form>
        <% 
             if(session.getAttribute("nm")==null)
                {
                    response.sendRedirect("index.jsp?msg=Sorry your session expires!");
                            
                }
            
            String resp = request.getParameter("logout");
            if(resp!= null)
        {
            HttpSession s1 = request.getSession(true);
            s1.invalidate();
            
            response.sendRedirect("regi.jsp?msg=sucessfully loged out");
        }   
            %>
    </body>
</html>
