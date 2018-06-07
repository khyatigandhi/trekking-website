package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import p1.Cregi;
import java.sql.Connection;

public final class adstdpay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    ");

        
        
            String m ="";
            
                if(request.getParameter("msg")!=null)
                {
                        m = request.getParameter("msg");
                }
         
        
          Connection cn = Cregi.getConnected();
          
         Statement st = cn.createStatement();
          
          String qr="select name,email,address,phone,sp.mcode,track_name,total_amt from registration r1,stdpay sp where r1.mcode = sp.mcode";
          
          ResultSet rs = st.executeQuery(qr);
          
          
          
        
        
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <table align=\"center\" border=\"1\">\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Email</th>\n");
      out.write("                <th>Address</th>\n");
      out.write("                <th>Phone No.</th>\n");
      out.write("                <th>Membership code</th>\n");
      out.write("                <th>Track Name</th>\n");
      out.write("                <th>Amount</th>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("               \n");
      out.write("            </tr>\n");
      out.write("            ");

          
            while(rs.next())
            {
                
                String name =  rs.getString(1);
          
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( name );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( rs.getString(2) );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( rs.getString(3) );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( rs.getDouble(4) );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( rs.getString(5) );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( rs.getString(6) );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( rs.getDouble(7) );
      out.write("</td>\n");
      out.write("                 </tr>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          \n");
      out.write("          ");

          
            }
          
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("          \n");
      out.write("    <center>\n");
      out.write("       ");
      out.print(m);
      out.write("\n");
      out.write("        \n");
      out.write("    </center>\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
