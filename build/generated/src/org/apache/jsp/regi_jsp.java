package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class regi_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title> Registration </title>\n");
      out.write("        <script type=\"text/javascript\" src=\"regi.js\">\n");
      out.write("            </script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function check(frm1)\n");
      out.write("            {\n");
      out.write("               \n");
      out.write("                with(frm1)\n");
      out.write("                {\n");
      out.write("                    if(!checkBlank(ntxt,\"Name field can't be blank\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkBlank(mtxt,\"Membership code can't be blank\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkBlank(etxt,\"Enter email\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkBlank(btxt,\"enter date of birth\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkBlank(atxt,\"Address field can't be blank\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkBlank(city,\"city can't be blank\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkBlank(state,\"state can't be blank\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkBlank(pcode,\"Enter postal code\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkBlank(no,\"Enter phone no\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkBlank(pass,\"enter password\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkPostal(pcode,\"Enter 6 digit no\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(!checkPhone(no,\"enter 10 digit number\"))\n");
      out.write("                    {\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"frm1\" method=\"post\" action=\"ProcessReg\">\n");
      out.write("            Name:-<input type=\"text\" name=\"ntxt\"></br>\n");
      out.write("            Select gender:-<input type=\"radio\" name=\"gender\" value=\"female\" checked>Female\n");
      out.write("                           <input type=\"radio\" name=\"gender\" value=\"male\">Male</br>\n");
      out.write("            Membership code:-<input type=\"text\" name=\"mtxt\"></br>\n");
      out.write("            Password:-<input type=\"password\" name=\"pass\"></br>\n");
      out.write("            Email:-<input type=\"email\" name=\"etxt\"></br>\n");
      out.write("            Date of Birth:-<input type=\"date\" name=\"btxt\"></br>\n");
      out.write("            Address:-<input type=\"text\" name=\"atxt\"></br>\n");
      out.write("            city:-<input type=\"text\" name=\"city\"></br>\n");
      out.write("            State:-<input type=\"text\" name=\"state\"></br>\n");
      out.write("            Postal code:-<input type=\"text\" name=\"pcode\"></br>\n");
      out.write("            contact No. :-<input type=\"text\" name=\"no\"></br>\n");
      out.write("            Upload your photo:-<input type=\"file\" name=\"pic\" required=\"\"></br>\n");
      out.write("            Residence proof:-<input type=\"file\" name=\"resi\" required=\"\"></br>\n");
      out.write("            Signature:-<input type=\"file\" name=\"sign\" required=\"\"></br>\n");
      out.write("            <input type=\"submit\" name=\"submit\" value=\"register\" onclick=\"return check(frm1)\"></br>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </form>\n");
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
