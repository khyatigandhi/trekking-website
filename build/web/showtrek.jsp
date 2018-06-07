<%-- 
    Document   : showtrek
    Created on : Apr 6, 2018, 1:51:17 PM
    Author     : Galaxy
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
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
        
                if(session.getAttribute("mcode")==null)
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
          
          String qr="select * from addtrek";
          
          ResultSet rs = st.executeQuery(qr);
          
          
          
        
        %>
    <body>
        <table align="center" border="1">
            
            <tr>
                
                <th>Name</th>
                <th>Description</th>
                <th>Cost</th>
                <th>Image</th>
                <th>BOOK NOW </th>  
            </tr>
            
            <%
          
            while(rs.next())
            {
                
                
          %>
          
           
            <tr>
                <% String name=rs.getString(1); %>
                <td><%= name %></td>
                <td><%= rs.getString(2) %></td>
                <% double cost=rs.getDouble(3);  %>
                <td><%= cost %></td>
                <% 
                
                String path = session.getServletContext().getRealPath("uploads");
                String fnm = rs.getString(4);
                       
                       path = path + "\\"+fnm;
                       
                       File f = new File(path);
                       
                       byte b1[] = new byte[10000];
                       
                       InputStream is = rs.getBinaryStream(5); 
                       OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
                       
                       int len=0;
                       
                       while((len=is.read(b1))!=-1)
                       {
                           os.write(b1,0,len);
                       }
                        
                       os.close();
                       is.close();
                
                
                
                
                
                %>
                <td><img src="uploads/<%= fnm%>" ></td>
                <td><a href="payment.jsp?cost=<%=cost%>&name=<%=name%>">Book now</a></td>

              
               
              
              
                
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
