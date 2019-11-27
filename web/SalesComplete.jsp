<%-- 
    Document   : SalesComplete
    Created on : 19-nov-2019, 17:47:49
    Author     : Ronaldo Jiménez
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

        <title>Sale Complete</title>

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
        <!--COLUMNA DE LA INFO DEL PRODUCTO-->
        <div class="form-row">
            <div class="col-md-8">
                <br>
                <div class="card border-dark">     
                    <div class="card-header text-center">
                        Compras > Detalle de compra
                    </div>

                    <ul class="list-group list-group-flush">                         
                        <li class="list-group-item"><b>Compra</b> # <%= request.getAttribute("saleId")%></li> 
                        <li class="list-group-item"><b>Resumen de compra</b></li>   
                        <li class="list-group-item"><b>Producto</b> $<%= product.getPrice()%></li>   
                        <li class="list-group-item"><b>Cargo de envío</b> $<%= product.getShippingCost()%></li>   
                        <li class="list-group-item"><b>Tu pago</b> $<%= (product.getPrice() + product.getShippingCost())%></li>   
                    </ul>                                 
                </div>
            </div>            
            <!-- COLUMNA IMG PRODUCTO  -->
            <div class="col-md-4">
                <br>
                <div class="card border-dark">
                    <div class="card-header text-center">
                        Compraste<br>
                        <%= product.getName()%>
                    </div>
                    <img src="img/products/<%= product.getGuid()%>" style="max-height: 400px" class="card-img" alt="...">                     
                    <ul class="list-group list-group-flush">                         
                        <li class="list-group-item">$<%= product.getPrice()%> x <%= product.getQuantity()%></li> 
                        <li class="list-group-item">
                            <a href="ProductsController?optProductsIndex=true" 
                               class="btn btn-primary">Finalizar</a>
                        </li>   
                    </ul>
                </div>
            </div>       
        </div>
    </body>
</html>
