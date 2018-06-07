/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Galaxy
 */
@WebServlet(name = "ProcessReg", urlPatterns = {"/ProcessReg"})
public class ProcessReg extends HttpServlet {

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
           int pcode=Integer.parseInt(request.getParameter("pcode"));
           int phone=Integer.parseInt(request.getParameter("no"));
           String pic=request.getParameter("pic");
           String resip=request.getParameter("resi");
           String sign=request.getParameter("sign");
           
           String ppath="f:\\khyati\\my project\\trek\\"+pic;
           String rpath="f:\\khyati\\my project\\trek\\"+resip;
           String spath="f:\\khyati\\my project\\trek\\"+sign;
           
           File f1 = new File(ppath);
           File f2 = new File(rpath);
           File f3 = new File(spath);
            
            FileInputStream fis1 = new FileInputStream(f1);
            FileInputStream fis2 = new FileInputStream(f2);
            FileInputStream fis3 = new FileInputStream(f3);
            
           
            PreparedStatement ps = cn.prepareStatement("insert into registration values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, mcode);
            ps.setString(4, pass);
            ps.setString(5, email);
            ps.setString(6, dob);
            ps.setString(7, address);
            ps.setString(8, city);
            ps.setString(9, state);
            ps.setInt(10, pcode);
            ps.setInt(11, phone);
            ps.setString(12, pic);
            ps.setBinaryStream(13, fis1, (int)f1.length());
            ps.setString(14, resip);
            ps.setBinaryStream(15, fis2, (int)f2.length());
            ps.setString(16, sign);
            ps.setBinaryStream(17, fis3, (int)f3.length());
            int r =ps.executeUpdate();
           
            if(r==1)
            {
                out.print("File uploaded in database!");
            }
            else
            {
                out.println("Problem in uploading!");
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
