package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class ProductsIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Products Index</title>\n");
      out.write("\n");
      out.write("        <!--Importar Bootstrap-->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <!--Importar Scripts-->\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/jquery-3.4.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"ProductsController\" method=\"post\" >\n");
      out.write("            ");

                if (request.getAttribute("userName") != null) {
            
      out.write("\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <div class=\"col-md-1 offset-8\">\n");
      out.write("                    <label class=\"\"> <b> Hola! <i style=\"color: buttonshadow;\">");
      out.print(request.getAttribute("userName"));
      out.write("</i></b></label>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

            }
            
else {
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            
      out.write("\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"form-row\">\n");
      out.write("                        <div class=\"col-md-1 offset-3\">\n");
      out.write("                            <label class=\"\"><b>Buscar:</b></label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3\">\n");
      out.write("                            <input \n");
      out.write("                                type=\"search\" \n");
      out.write("                                id=\"txtProductName\"\n");
      out.write("                                name=\"txtProductName\" \n");
      out.write("                                class=\"form-control\" \n");
      out.write("                                placeholder=\" Buscar productos, marcas y más...\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"form-row\">\n");
      out.write("                        <div class=\"col-md-1 offset-md-3\">\n");
      out.write("                            <label><b>Categoria:</b></label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3\">\n");
      out.write("                            <select id=\"ddlCategories\"\n");
      out.write("                                    name=\"ddlCategories\"\n");
      out.write("                                    class=\"form-control\">\n");
      out.write("                                <option value=\"-1\">--Seleccione--</option>\n");
      out.write("                                ");

                                    /*si listCategories es difernte de nulo, entonces recorra todo lo que encuentre.
                                    (request.getAttribute("listCtegories"), este atributo no sabemos de que tipo es, 
                                    ese tipo de dato que esta recibiendo en ese atributo es de este tipo(List<com.hardwareStore.models.Categories>),
                                    una lista de categorias. Toma la lista y dentro del for encontramos el objeto a rrecorrer (que es una categoria)
                                    y a cada categoria le damos el nombre item
                                     */
                                    //si es diferente de nulo validamos que lo estan enviando
                                    if (request.getAttribute("listCategories") != null) {
                                        //foreach (for mejorado) - recorrer el objeto - tambien realizamos un casteo
                                        for (com.hardwareStore.models.Categories item : (List<com.hardwareStore.models.Categories>) request.getAttribute("listCategories")) {
                                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <!--las listas desplejables se componen de una llave-valor (la llave = value [dev] y valor = vista [user])-->\n");
      out.write("                                <!--mostrar categorias disponibles-->\n");
      out.write("                                <option value=\"");
      out.print( item.getId());
      out.write("\"> ");
      out.print( item.getName());
      out.write(" </option>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-1\">\n");
      out.write("                            <input name=\"btnSearch\" type=\"submit\" class=\"btn btn-info btn-block\" value=\"Search\"/>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                ");

                                    if (request.getAttribute("listProducts") != null) {
                                        int column = 1;
                                        for (com.hardwareStore.models.Products item : (List<com.hardwareStore.models.Products>) request.getAttribute("listProducts")) {
                                            if (column == 1) {
                                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <div class=\"form-row \">\n");
      out.write("                                    ");
  }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <div class=\"col-md-4\">\n");
      out.write("                                        <div class=\"card\" style=\"width: 18rem;\">\n");
      out.write("                                            <img width=\"180px\" height=\"180px\" src=\"img/products/");
      out.print( item.getGuid());
      out.write("\" class=\"card-img-top\" alt=\"...\">\n");
      out.write("                                            <div class=\"card-body\">\n");
      out.write("                                                <p class=\"card-text\">");
      out.print( item.getName());
      out.write("</p>\n");
      out.write("                                            </div>\n");
      out.write("                                            <ul class=\"list-group list-group-flush\">\n");
      out.write("                                                <li class=\"list-group-item\"> $ ");
      out.print( item.getPrice());
      out.write("</li>\n");
      out.write("                                            </ul>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    ");
 if (column == 3) {
                                            column = 0;
                                    
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                ");
  }
      out.write("\n");
      out.write("\n");
      out.write("                                ");

                                            column++;
                                        }
                                    }
                                
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("       \n");
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
