/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Galaxy
 */
@WebServlet(name = "RegAdmin", urlPatterns = {"/RegAdmin"})
public class RegAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            Connection cn = Cregi.getConnected();
           
           String name=request.getParameter("ntxt");
           String gender=request.getParameter("gender");
           String mcode=request.getParameter("mtxt");
           String pass=request.getParameter("pass");
           String email=request.getParameter("etxt");
           String dob=request.getParameter("btxt");
           String address=request.getParameter("atxt");
           String city=request.getParameter("city");
           String state=request.getParameter("state");
           int phone=Integer.parseInt(request.getParameter("no"));
           
           String qr = "insert into adminreg (name,gender,userid,password,email,DOB,address,city,state,phone,status) values('"+name+"','"+gender+"','"+mcode+"','"+pass+"','"+email+"','"+dob+"','"+address+"','"+city+"','"+state+"','"+phone+"','junior')";
           Statement st =cn.createStatement();
           out.println(qr);
       
           int r=st.executeUpdate(qr);
           out.println("record"+r+"saved");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
