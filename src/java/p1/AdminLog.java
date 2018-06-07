/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Galaxy
 */
@WebServlet(name = "AdminLog", urlPatterns = {"/AdminLog"})
public class AdminLog extends HttpServlet 
{

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
                Connection cn = Cregi.getConnected();
                Statement st= cn.createStatement();
                String uid = request.getParameter("utxt");
                

                String pass = request.getParameter("ptxt");
                
                String qr = "select password,status from admin where userid ='"+uid+"'";

               // int r=st.executeUpdate(qr); update is for insert update delete
               // out.println(r);
                ResultSet rs=st.executeQuery(qr);
                rs.next();
               

                String password = rs.getString(1);
                out.println("pd:- " +password);
                if(pass.equals(password))
                {
                    HttpSession s1=null;
                    s1=request.getSession(true);
                    s1.setAttribute("nm","Mr Admin");
                    s1.setAttribute("userid", uid);
                    /*String s=(String)s1.getAttribute(uid);
                    out.println(s);  */
                    
                    String status = rs.getString(2);
                    if(status.equals("senior"))
                    {
                        
                        response.sendRedirect("addadmin.jsp");
                        
                    }
                    else
                    {
                        response.sendRedirect("addtrek.jsp");
                    }

                }
                else
                {
                    out.println("invalid userid/password");
                    response.sendRedirect("adminlogin.jsp");
                } 
                

           
        }
        catch(Exception e)
        {
           System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
