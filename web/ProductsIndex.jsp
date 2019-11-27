<%-- 
    Document   : ProductsIndex
    Created on : 30-sep-2019, 22:28:00
    Author     : Ronaldo Jimenez
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Products Index</title>

        <!--Importar Bootstrap-->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <!--Importar Scripts-->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
    </head>
    <body>


        <div class="container-fluid">
            <form action="ProductsController" method="post" >
                <div class="form-row">
                    <div class="col-md-1 offset-3">
                        <label class=""><b>Buscar:</b></label>
                    </div>
                    <div class="col-md-3">
                        <input 
                            type="search" 
                            id="txtProductName"
                            name="txtProductName" 
                            class="form-control" 
                            placeholder=" Buscar productos, marcas y más...">
                    </div>

                </div>
                <br>
                <div class="form-row">
                    <div class="col-md-1 offset-md-3">
                        <label><b>Categoria:</b></label>
                    </div>
                    <div class="col-md-3">
                        <select id="ddlCategories"
                                name="ddlCategories"
                                class="form-control">
                            <option value="-1">--Seleccione--</option>

                            <%
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
                            %>


                            <!--las listas desplejables se componen de una llave-valor (la llave = value [dev] y valor = vista [user])-->
                            <!--mostrar categorias disponibles-->

                            <option value="<%= item.getId()%>"> <%= item.getName()%> </option>
                            <%
                                    }
                                }
                            %>

                        </select>
                        <br>
                    </div>
                    <div class="col-md-1">
                        <input name="btnSearch" type="submit" class="btn btn-primary btn-block" value="Search"/>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-12">
                        <%
                            if (request.getAttribute("listProducts") != null) {
                                int column = 1;
                                for (com.hardwareStore.models.Products item : (List<com.hardwareStore.models.Products>) request.getAttribute("listProducts")) {
                                    if (column == 1) {
                        %>


                        <div class="form-row ">
                            <%  }%>

                            <div class="col-md-4">
                                <br>
                                <div class="card border-dark" style="width: 18rem;">
                                    <div class="card-header text-center" >
                                        <%= item.getName()%>
                                    </div>
                                    <img width="300px" height="300px" src="img/products/<%= item.getGuid()%>" class="card-img-top" alt="...">

                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item"> $ <%= item.getPrice()%></li>
                                        <li class="list-group-item"> 
                                            <a href="ProductsController?btnDetailsProduct=true&productId=<%= item.getId()%>"
                                               id="btnDetailsProduct" 
                                               name="btnDetailsProduct"
                                               class="btn btn-primary">Comprar</a>
                                        </li>
                                    </ul>
                                </div> 
                            </div>


                            <% if (column == 3) {
                                    column = 0;
                            %>
                        </div>
                        <%  }%>

                        <%
                                    column++;
                                }
                            }
                        %>
                    </div>
                </div>
            </form>
        </div>


    </body>
</html>
