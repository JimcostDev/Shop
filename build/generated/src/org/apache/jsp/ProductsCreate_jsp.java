package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class ProductsCreate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>Products Create</title>\n");
      out.write("        <!--Importar Bootstrap-->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <!--Importar Scripts-->\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/jquery-3.4.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg-info\">\n");
      out.write("    \n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"card card-login mx-auto mt-5\">\n");
      out.write("                <form action=\"ProductsController\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                    <div class=\"card-header text-center\">Crear producto</div>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"form-row text-center\">\n");
      out.write("                        <div class=\"col-md-4 offset-md-4\">\n");
      out.write("                            <img src=\"img/brand.png\"  alt=\"Login-Image\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("\n");
      out.write("                        <!--crear campo de formulario-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"form-row\"><!--una fila-->\n");
      out.write("                                <div class=\"col-md-3 offset-md-3\"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->\n");
      out.write("                                    <label for=\"txtName\">Nombre:</label>                               \n");
      out.write("                                    <input \n");
      out.write("                                        type=\"text\" \n");
      out.write("                                        id=\"txtName\"\n");
      out.write("                                        name=\"txtName\" \n");
      out.write("                                        class=\"form-control\" \n");
      out.write("                                        placeholder=\"titulo del producto\" \n");
      out.write("                                        required=\"required\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-md-3\"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->\n");
      out.write("                                    <label for=\"txtWarranty\">Garantia:</label>\n");
      out.write("                                    <input \n");
      out.write("                                        type=\"text\" \n");
      out.write("                                        id=\"txtWarranty\"\n");
      out.write("                                        name=\"txtWarranty\" \n");
      out.write("                                        class=\"form-control\" \n");
      out.write("                                        placeholder=\"Tiempo garantia en meses\" \n");
      out.write("                                        required=\"required\">\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-md-1\"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->\n");
      out.write("                                    <label for=\"txtQuantity\">Cantidad:</label>\n");
      out.write("                                    <input \n");
      out.write("                                        type=\"number\" \n");
      out.write("                                        id=\"txtQuantity\"\n");
      out.write("                                        name=\"txtQuantity\" \n");
      out.write("                                        class=\"form-control\"\n");
      out.write("                                        min=\"0\"\n");
      out.write("                                        max=\"100\"\n");
      out.write("                                        placeholder=\"0-100\" \n");
      out.write("                                        required=\"required\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div class=\"form-row\"><!--una fila-->\n");
      out.write("                                <div class=\"col-md-7 offset-md-3\"><!--width=6 columnas || width = 50%-->\n");
      out.write("                                    <label for=\"txtDescription\">Descripción:</label>\n");
      out.write("\n");
      out.write("                                    <textarea \n");
      out.write("                                        name=\"txtDescription\" \n");
      out.write("                                        id=\"txtDescription\" cols=\"42\" \n");
      out.write("                                        rows=\"4\" \n");
      out.write("                                        class=\"form-control\"  \n");
      out.write("                                        placeholder=\" Escribe tu mensaje\">\n");
      out.write("                                    </textarea>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"form-row\"><!--una fila-->\n");
      out.write("                                <div class=\"col-md-3 offset-md-3\"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->\n");
      out.write("                                    <label for=\"txtPrice\">Precio</label>\n");
      out.write("\n");
      out.write("                                    <input \n");
      out.write("                                        type=\"text\" \n");
      out.write("                                        id=\"txtPrice\"\n");
      out.write("                                        name=\"txtPrice\" \n");
      out.write("                                        class=\"form-control\"\n");
      out.write("                                        placeholder=\"$\"\n");
      out.write("                                        required=\"required\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-md-4\"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->\n");
      out.write("                                    <label for=\"txtShippingCost\">Costo de envio</label>                               \n");
      out.write("                                    <input \n");
      out.write("                                        type=\"text\" \n");
      out.write("                                        id=\"txtShippingCost\"\n");
      out.write("                                        name=\"txtShippingCost\" \n");
      out.write("                                        class=\"form-control\"\n");
      out.write("                                        placeholder=\"$\"\n");
      out.write("                                        required=\"required\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        <!--****************CATEGORIAS Y ESTADO********************************-->\n");
      out.write("                        <div class=\"form-row\">                                                                  \n");
      out.write("                            <div class=\"col-md-3 offset-md-3\">\n");
      out.write("                                <label>Categoria:</label>\n");
      out.write("                                <select id=\"ddlCategories\"\n");
      out.write("                                        name=\"ddlCategories\"\n");
      out.write("                                        class=\"form-control\">\n");
      out.write("                                    <option value=\"-1\">--Seleccione--</option>\n");
      out.write("                                    ");

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
      out.write("                                    <!--las listas desplejables se componen de una llave-valor (la llave = value [dev] y valor = vista [user])-->\n");
      out.write("                                    <!--mostrar categorias disponibles-->\n");
      out.write("                                    <option value=\"");
      out.print( item.getId());
      out.write("\"> ");
      out.print( item.getName());
      out.write(" </option>\n");
      out.write("                                    ");

                                            }
                                        }
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <!--****************ESTADOS********************************-->                                                                \n");
      out.write("                            <div class=\"col-md-3 offset-md-1\">\n");
      out.write("                                <label>Estado:</label>\n");
      out.write("                                <select id=\"ddlStates\"\n");
      out.write("                                        name=\"ddlStates\"\n");
      out.write("                                        class=\"form-control\">\n");
      out.write("                                    <option value=\"-1\">--Seleccione--</option>\n");
      out.write("                                    ");

                                        if (request.getAttribute("listStates") != null) {
                                            //foreach (for mejorado) - recorrer el objeto - tambien realizamos un casteo
                                            for (com.hardwareStore.models.States item : (List<com.hardwareStore.models.States>) request.getAttribute("States")) {
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( item.getId());
      out.write("\"> ");
      out.print( item.getName());
      out.write(" </option>\n");
      out.write("                                    ");

                                            }
                                        }
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!--************************************************-->\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"form-row\"><!--una fila-->\n");
      out.write("                            <div class=\"col-md-7 offset-md-3\"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->\n");
      out.write("                                <label for=\"filePhoto\">Foto:</label>\n");
      out.write("                                <input \n");
      out.write("                                    type=\"file\" \n");
      out.write("                                    id=\"filePhoto\"\n");
      out.write("                                    class=\"form-control-file\"\n");
      out.write("                                    name=\"filePhoto\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-row\">\n");
      out.write("                        <div class=\"col-md-7 offset-md-3\">\n");
      out.write("                            <input name=\"btnSave\" type=\"submit\" class=\"btn btn-info btn-block\" value=\"Guardar\"/>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-row text-center\">\n");
      out.write("                        <div class=\"col-md-3 offset-md-5\">\n");
      out.write("                            <br>\n");
      out.write("                            <input name=\"chkRemember\" type=\"checkbox\" id=\"chkRemember\"/> Recuérdame?\n");
      out.write("                            <a class=\"d-block small mt-3\" href=\"Register.jsp\">Registrar cuenta</a>\n");
      out.write("                            <a class=\"d-block small\" href=\"#ForgotPassword.jsp\">¿Olvidaste tu contraseña?</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
