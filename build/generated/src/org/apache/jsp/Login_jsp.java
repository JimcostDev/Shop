package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>Login</title>\n");
      out.write("        <!--Importar Bootstrap-->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <!--Importar Scripts-->\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/jquery-3.4.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg-dark\">\n");
      out.write("        <!--Sciptlets, codigo java embebido en html-->\n");
      out.write("        ");

            //si es diferente de nulo validamos que lo estan enviando
            if (request.getAttribute("status") != null) {
                if (Integer.parseInt(request.getAttribute("status").toString()) == 200) {
        
      out.write("  \n");
      out.write("        <script>\n");
      out.write("            alert('200 - Process was successful');\n");
      out.write("        </script>\n");
      out.write("        ");

        } else {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert('500 - An error ocurred during process');\n");
      out.write("        </script>\n");
      out.write("        ");
 }
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"card card-login mx-auto mt-5\">\n");
      out.write("                <div class=\"card-header text-center\">Iniciar Sesión</div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"form-row text-center\">\n");
      out.write("                    <div class=\"col-md-4 offset-md-4\">\n");
      out.write("                        <img src=\"img/brand.png\"  alt=\"Login-Image\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form action=\"accountController\" method=\"post\">\n");
      out.write("                        <!--crear campo de formulario-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"form-row\"><!--una fila-->\n");
      out.write("                                <div class=\"col-md-1 offset-md-4\"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->\n");
      out.write("                                    <label for=\"txtId\">Usuario:</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-3\"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->\n");
      out.write("\n");
      out.write("                                    <input \n");
      out.write("                                        type=\"text\" \n");
      out.write("                                        id=\"txtEmail\"\n");
      out.write("                                        name=\"txtEmail\" \n");
      out.write("                                        class=\"form-control\" \n");
      out.write("                                        placeholder=\"Ingresar email\" \n");
      out.write("                                        required=\"required\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div class=\"form-row\"><!--una fila-->\n");
      out.write("                                <div class=\"col-md-1 offset-md-4\"><!--width=6 columnas || width = 50%-->\n");
      out.write("                                    <label for=\"txtPassword\">contraseña:</label>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-3\"><!--width=6 columnas || width = 50%-->                                    \n");
      out.write("                                    <input \n");
      out.write("                                        type=\"password\" \n");
      out.write("                                        id=\"txtPassword\"\n");
      out.write("                                        name=\"txtPassword\" \n");
      out.write("                                        class=\"form-control\" \n");
      out.write("                                        placeholder=\"Ingresar contraseña\" \n");
      out.write("                                        required=\"required\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"col-md-4 offset-md-4\">\n");
      out.write("                                <input name=\"btnLogin\" type=\"submit\" class=\"btn btn-primary btn-block\" value=\"Iniciar Sesión\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"form-row text-center\">\n");
      out.write("                            <div class=\"col-md-4 offset-md-4\">\n");
      out.write("                                <br>\n");
      out.write("                                <input name=\"chkRemember\" type=\"checkbox\" id=\"chkRemember\"/> Recuérdame?\n");
      out.write("                                <a class=\"d-block small mt-3\" href=\"Register.jsp\">Registrar cuenta</a>\n");
      out.write("                                <a class=\"d-block small\" href=\"#ForgotPassword.jsp\">¿Olvidaste tu contraseña?</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
