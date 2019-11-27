<%-- 
    Document   : ProductDetails
    Created on : 12-nov-2019, 11:39:27
    Author     : Ronaldo Jiménez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Details Products</title>

        <!--Importar Bootstrap-->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <!--Importar Scripts-->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            com.hardwareStore.models.Products product = (com.hardwareStore.models.Products) request.getAttribute("product");
        %>
        <!--COLUMNA DE LA IMG DEL PRODUCTO-->
        <div class="card border-dark">
            <br>
            <div class="row no-gutters">
                <div class="col-md-4">
                    <div>
                        <img src="img/products/<%= product.getGuid()%>" class="card-img-top" alt="...">
                    </div>
                </div>
                <!--COLUMNA DE LA INFO DEL PRODUCTO-->
                <div class="col-md-8">
                    <div class="card-header text-center">
                        <%= product.getName()%>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">$ <%= product.getPrice()%></li>
                        <li class="list-group-item"><b>Costo de envío</b>  $<%= product.getShippingCost()%></li>
                        <li class="list-group-item"><b>Cantidad</b> 1</li>
                        <li class="list-group-item"><b>Garantía</b></li>
                        <li class="list-group-item"><%= product.getWarranty()%></li>
                        <li class="list-group-item"><b>Estado</b> <%= product.getStates().getName()%></li>
                        <li class="list-group-item"><b>Descripción</b></li>
                        <li class="list-group-item"><%= product.getDescription()%></li>

                        <li class="list-group-item">
                            <a href="SalesController?btnShippingCost=true"
                               id="btnShippingCost" 
                               name="btnShippingCost"
                               class="btn btn-primary">Comprar</a>
                        </li>
                    </ul> 
                </div>
            </div>
    </body>
</html>
