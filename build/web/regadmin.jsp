<%-- 
    Document   : regiadmin
    Created on : Mar 26, 2018, 6:00:32 PM
    Author     : Galaxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registration </title>
        <script type="text/javascript" src="regi.js">
            </script>
        <script type="text/javascript">
            function check(frm1)
            {
               
                with(frm1)
                {
                    if(!checkBlank(ntxt,"Name field can't be blank"))
                    {
                        return false;
                    }
                    if(!checkBlank(mtxt,"Membership code can't be blank"))
                    {
                        return false;
                    }
                    if(!checkBlank(etxt,"Enter email"))
                    {
                        return false;
                    }
                    if(!checkBlank(btxt,"enter date of birth"))
                    {
                        return false;
                    }
                    if(!checkBlank(atxt,"Address field can't be blank"))
                    {
                        return false;
                    }
                    if(!checkBlank(city,"city can't be blank"))
                    {
                        return false;
                    }
                    if(!checkBlank(state,"state can't be blank"))
                    {
                        return false;
                    }
                    if(!checkBlank(pcode,"Enter postal code"))
                    {
                        return false;
                    }
                    if(!checkBlank(no,"Enter phone no"))
                    {
                        return false;
                    }
                    if(!checkBlank(pass,"enter password"))
                    {
                        return false;
                    }
                    if(!checkPhone(no,"enter 10 digit number"))
                    {
                        return false;
                    }
                }
            }
        </script>
    </head>
    <%
         if(session.getAttribute("nm")==null)
                {
                    response.sendRedirect("index.jsp?msg=Sorry your session expires!");
                            
                }
    %>
    <body>
        <form name="frm1" method="post" action="RegAdmin">
            Name:-<input type="text" name="ntxt"></br>
            Select gender:-<input type="radio" name="gender" value="female" checked>Female
                           <input type="radio" name="gender" value="male">Male</br>
            User id:-<input type="text" name="mtxt"></br>
            Password:-<input type="password" name="pass"></br>
            Email:-<input type="email" name="etxt"></br>
            Date of Birth:-<input type="date" name="btxt"></br>
            Address:-<input type="text" name="atxt"></br>
            city:-<input type="text" name="city"></br>
            State:-<input type="text" name="state"></br>
            contact No. :-<input type="text" name="no"></br>
            <input type="submit" name="submit" value="register" onclick="return check(frm1)"></br>
            
            
            
        </form>
    </body>
</html>
