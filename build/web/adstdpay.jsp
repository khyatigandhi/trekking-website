<%-- 
    Document   : adstdpay
    Created on : Apr 7, 2018, 12:27:01 PM
    Author     : Galaxy
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="p1.Cregi"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        if(session.getAttribute("nm")==null)
                {
                    response.sendRedirect("index.jsp?msg=Sorry your session expires!");
                            
                }
        
            String m ="";
            
                if(request.getParameter("msg")!=null)
                {
                        m = request.getParameter("msg");
                }
         
        
          Connection cn = Cregi.getConnected();
          
         Statement st = cn.createStatement();
          
          String qr="select name,email,address,phone,sp.mcode,track_name,total_amt from registration r1,stdpay sp where r1.mcode = sp.mcode";
          
          ResultSet rs = st.executeQuery(qr);
          
          
          
        
        %>
    <body>
        <table align="center" border="1">
            
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone No.</th>
                <th>Membership code</th>
                <th>Track Name</th>
                <th>Amount</th>
                
                
               
            </tr>
            <%
          
            while(rs.next())
            {
                
                String name =  rs.getString(1);
          %>
            <tr>
                <td><%= name %></td>
                <td><%= rs.getString(2) %></td>
                <td><%= rs.getString(3) %></td>
                <td><%= rs.getDouble(4) %></td>
                <td><%= rs.getString(5) %></td>
                <td><%= rs.getString(6) %></td>
                <td><%= rs.getDouble(7) %></td>
                 </tr>
          
          
          
          <%
          
            }
          %>
            
            
            
            
        </table>
        
          
    <center>
       <%=m%>
        
    </center>
            
    </body>
</html>
