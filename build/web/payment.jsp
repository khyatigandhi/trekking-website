<%-- 
    Document   : payment
    Created on : Apr 5, 2018, 1:25:46 PM
    Author     : Galaxy
--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <sql:setDataSource var="db1" driver="sun.jdbc.odbc.JdbcOdbcDriver" 
                       url="Jdbc:Odbc:Driver={SQL Server Native Client 10.0};Server=.\\SQL2008;Database=trek" user="sa" password="123456"/>
    <body>
        <% 
             if(session.getAttribute("mcode")==null)
                {
                    response.sendRedirect("index.jsp?msg=Sorry your session expires!");
                            
                }
             
            String mcode="";
            String ctxt="";
            
            %>
            
        <form name="frm1" method="post" action="">
            Payment type:-<input type="radio" name="payment" value="credit"/>credit</br>
            <input type="radio" name="payment" value="debit"/>Debit</br>
            
            <% 
            Cookie c2[]=request.getCookies();
                for(int i=0;i<c2.length;i++)
                {
                   if(c2[i].getName().equals("mcode"))
                   {
                      mcode = c2[i].getValue();
                   }
                }
            out.println(mcode);
            %>
            
            Membership code:-<input type="text" enable="false" name="mcode" value=" <%= mcode %>"/><br>
            
            Card No:-<input type="text" name="ctxt"/></br>
            
            <% double a=Double.parseDouble(request.getParameter("cost"));
               String name=request.getParameter("name");
            %>
            
            Cost:-<input type="text" readonly="readonly" name="amt" value="<%=a%>"/><br> 
            <input type="submit" name="pay" value="Pay Now"/></br>
             
        </form>    
        
        <c:set var="btn1" value="${param.pay}"/>
        <c:if test="${btn1 eq 'Pay Now'}">
            <c:set var="mcode" value="${param.mcode}"/>
            <c:set var="crd" value="${param.ctxt}"/>
            <c:set var="amt" value="${param.amt}"/>
            <c:set var="treknm" value="${param.name}"/>
            
            <c:out value="${amt}"/>
            
            <c:catch var="catchExp">
                
                <sql:transaction dataSource="${db1}">
                    
                    <sql:query  var="result">
                        SELECT * from payment where cdno=?
                        <sql:param value="${crd}"/>
                    </sql:query>    
                        <c:forEach var="row" items="${result.rows}">
                            <c:set var="dcrd" value="${row.cdno}"/>
                            <c:set var="damt" value="${row.amount}"/>
                            <c:out value="${dcrd}"/>
                            <c:out value="${damt}"/>
                            
                        </c:forEach>
                    
                        <c:if test="${damt >= amt}">
                        <sql:update var="count">
                            UPDATE payment set amount=amount-? where cdno=?
                        <sql:param value="${amt}"/>
                        <sql:param value="${crd}"/>
                        
                        </sql:update>
                        <c:out value="${count}"/>
                        
                        <sql:update var="a">
                            INSERT into stdpay(mcode,track_name,total_amt) values(?,?,?) 
                            <sql:param value="${mcode}"/>
                            <sql:param value="${treknm}"/> 
                            <sql:param value="${amt}"/>
                        </sql:update>
                            
                            
                            
                        </c:if>
                </sql:transaction>
            </c:catch>
             <c:if test="${catchExp!=null}">
                        <p>
                            <c:out value="${catchExp}"/></br>
                            
                        </p>
                    </c:if>
        </c:if>
        
        
    </body>
</html>
