package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap -->\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>        \r\n");
      out.write("        <script src=\"js/popper.min.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- jQuery -->\r\n");
      out.write("        <script src=\"js/jquery-3.4.1.min.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Site -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/site.css\">\r\n");
      out.write("        <script src=\"js/site.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- FontAwesome -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" integrity=\"sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("        <title>Home</title>\r\n");
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("            iframe{\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                height: 900px;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"d-flex\" id=\"wrapper\">\r\n");
      out.write("            <!-- ============================================================== -->\r\n");
      out.write("            <!-- Sidebar -->\r\n");
      out.write("            <!-- ============================================================== -->\r\n");
      out.write("            <div class=\"bg-light border-right\" id=\"sidebar-wrapper\">\r\n");
      out.write("                <div class=\"sidebar-heading\">\r\n");
      out.write("                    <img src=\"img/brand.png\" alt=\"\">                                  \r\n");
      out.write("                </div>\r\n");
      out.write("                <!--Cargar opciones-->\r\n");
      out.write("                <div class=\"list-group list-group-flush\">\r\n");
      out.write("                    <!--llamamos la función loadOption, la cual le esta invocando \r\n");
      out.write("                    el controlador de productos y le esta enviando la opcion optProductsIndex-->\r\n");
      out.write("                    <a class=\"nav-link\"\r\n");
      out.write("                       onclick=\"loadOption('ProductsController?optProductsIndex=true')\">\r\n");
      out.write("                        <!--icono de fontawesome-->\r\n");
      out.write("                        <i class=\"fa fa-shopping-cart\"></i>\r\n");
      out.write("                        <span class=\"nav-link-text\">Buscar Producto</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a class=\"nav-link\"\r\n");
      out.write("                       onclick=\"loadOption('ProductsController?optProductsCreate=true')\">\r\n");
      out.write("                        <!--icono de fontawesome-->\r\n");
      out.write("                        <i class=\"fa fa-shopping-cart\"></i>\r\n");
      out.write("                        <span class=\"nav-link-text\">Vender</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- ============================================================== -->\r\n");
      out.write("            <!-- End Sidebar -->\r\n");
      out.write("            <!-- ============================================================== -->\r\n");
      out.write("            <!-- ============================================================== -->\r\n");
      out.write("            <!-- Page Content -->\r\n");
      out.write("            <!-- ============================================================== -->\r\n");
      out.write("            <div id=\"page-content-wrapper\">\r\n");
      out.write("                <nav class=\"navbar navbar-expand-lg navbar-light bg-light border-bottom\">\r\n");
      out.write("                    <!--icono de fontawesome-->\r\n");
      out.write("                    <i class=\"fas fa-align-justify\" id=\"menu-toggle\"></i>\r\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"offset-md-9 collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("                        <a class=\"nav-link \" href=\"#\">");
      out.print(request.getAttribute("userName"));
      out.write("</a>\r\n");
      out.write("                        <a class=\"nav-link text-danger\" href=\"Login.jsp\">Salir</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("                <div class=\"container-fluid\">\r\n");
      out.write("                    <!--iframe: etiqueta html que nos permite incrustar codigo \r\n");
      out.write("                    html de otras paginas directamente en esta sección; ej: video de youtube-->\r\n");
      out.write("                    <iframe id=\"frame\" frameborder=\"0\"></iframe>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- ============================================================== -->\r\n");
      out.write("            <!-- End Page Content -->\r\n");
      out.write("            <!-- ============================================================== -->\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- ============================================================== -->\r\n");
      out.write("        <!-- Menu Toggle Script -->\r\n");
      out.write("        <!-- ============================================================== -->\r\n");
      out.write("        <script>\r\n");
      out.write("            $(\"#menu-toggle\").click(function (e) {\r\n");
      out.write("                e.preventDefault();\r\n");
      out.write("                $(\"#wrapper\").toggleClass(\"toggled\");\r\n");
      out.write("            });\r\n");
      out.write("            //cargar opcion \r\n");
      out.write("            function loadOption(option) {\r\n");
      out.write("                document.getElementById('frame').src = option;\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
