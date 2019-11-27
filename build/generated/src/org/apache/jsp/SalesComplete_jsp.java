package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class SalesComplete_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>Sale Complete</title>\n");
      out.write("\n");
      out.write("        <!--Importar Bootstrap-->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <!--Importar Scripts-->\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/jquery-3.4.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            com.hardwareStore.models.Products product = (com.hardwareStore.models.Products) request.getAttribute("product");
        
      out.write("\n");
      out.write("        <!--COLUMNA DE LA INFO DEL PRODUCTO-->\n");
      out.write("        <div class=\"form-row\">\n");
      out.write("            <div class=\"col-md-8\">\n");
      out.write("                <br>\n");
      out.write("                <div class=\"card border-dark\">     \n");
      out.write("                    <div class=\"card-header text-center\">\n");
      out.write("                        Compras > Detalle de compra\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <ul class=\"list-group list-group-flush\">                         \n");
      out.write("                        <li class=\"list-group-item\"><b>Compra</b> # ");
      out.print( request.getAttribute("saleId"));
      out.write("</li> \n");
      out.write("                        <li class=\"list-group-item\"><b>Resumen de compra</b></li>   \n");
      out.write("                        <li class=\"list-group-item\"><b>Producto</b> $");
      out.print( product.getPrice());
      out.write("</li>   \n");
      out.write("                        <li class=\"list-group-item\"><b>Cargo de envío</b> $");
      out.print( product.getShippingCost());
      out.write("</li>   \n");
      out.write("                        <li class=\"list-group-item\"><b>Tu pago</b> $");
      out.print( (product.getPrice() + product.getShippingCost()));
      out.write("</li>   \n");
      out.write("                    </ul>                                 \n");
      out.write("                </div>\n");
      out.write("            </div>            \n");
      out.write("            <!-- COLUMNA IMG PRODUCTO  -->\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("                <br>\n");
      out.write("                <div class=\"card border-dark\">\n");
      out.write("                    <div class=\"card-header text-center\">\n");
      out.write("                        Compraste<br>\n");
      out.write("                        ");
      out.print( product.getName());
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <img src=\"img/products/");
      out.print( product.getGuid());
      out.write("\" style=\"max-height: 400px\" class=\"card-img\" alt=\"...\">                     \n");
      out.write("                    <ul class=\"list-group list-group-flush\">                         \n");
      out.write("                        <li class=\"list-group-item\">$");
      out.print( product.getPrice());
      out.write(" x ");
      out.print( product.getQuantity());
      out.write("</li> \n");
      out.write("                        <li class=\"list-group-item\">\n");
      out.write("                            <a href=\"ProductsController?optProductsIndex=true\" \n");
      out.write("                               class=\"btn btn-primary\">Finalizar</a>\n");
      out.write("                        </li>   \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>       \n");
      out.write("        </div>\n");
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
