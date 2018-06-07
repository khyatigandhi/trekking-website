<%-- 
    Document   : adminstdreg
    Created on : Apr 6, 2018, 12:47:45 PM
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
          
          String qr="select * from registration";
          
          ResultSet rs = st.executeQuery(qr);
          
          
          
        
        %>
    <body>
        <body>

        <table align="center" border="1">
            
            <tr>
                <th>Serial No.</th>
                <th>Name</th>
                <th>gender</th>
                <th>mcode</th>
                <th>pass</th>
                <th>email</th>
                <th>dob</th>
                <th>address</th>
                <th>city</th>
                <th>state</th>
                <th>postal code</th>
                <th>Contact No.</th>
                <th>pic</th>
               
            </tr>
            
            <%
          
            while(rs.next())
            {
                
                int srno =  rs.getInt(1);
          %>
          
           
            <tr>
                <td><%= srno %></td>
                <td><%= rs.getString(2) %></td>
                <td><%= rs.getString(3) %></td>
               <td><%= rs.getString(4) %></td>
               <td><%= rs.getString(5) %></td>
               <td><%= rs.getString(6) %></td>
               <td><%= rs.getString(7) %></td>
               <td><%= rs.getString(8) %></td>
               <td><%= rs.getString(9) %></td>
               <td><%= rs.getString(10) %></td>
               <td><%= rs.getInt(11) %></td>
               <td><%= rs.getInt(12) %></td>
              <% 
                
                String path = session.getServletContext().getRealPath("student_regi");
                String fnm = rs.getString(13);
                       
                       path = path + "\\"+fnm;
                       
                       File f = new File(path);
                       
                       byte b1[] = new byte[10000];
                       
                       InputStream is = rs.getBinaryStream(14); 
                       OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
                       
                       int len=0;
                       
                       while((len=is.read(b1))!=-1)
                       {
                           os.write(b1,0,len);
                       }
                        
                       os.close();
                       is.close();
                
                
                
                
                
                %>
                <td><img src="student_regi/<%= fnm%>" ></td>
              
                
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
