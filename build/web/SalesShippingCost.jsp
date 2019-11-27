<%-- 
    Document   : SalesShipppingCost
    Created on : 12-nov-2019, 15:30:55
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

        <title>Sales ShippingCost</title>

        <!--Importar Bootstrap-->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <!--Importar Scripts-->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
         <!-- FontAwesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    </head>
    <body>
        <%
            com.hardwareStore.models.Products product = (com.hardwareStore.models.Products) request.getAttribute("product");
            com.hardwareStore.models.Customer customer = (com.hardwareStore.models.Customer) request.getAttribute("customer");
        %>
        <!--COLUMNA DE LA INFO DEL PRODUCTO-->
        <div class="form-row">
            <div class="col-md-8">
                
                <div class="card border-dark">  
                    <div class="card-header text-center">
                        ¿Cómo quieres recibir o retirar tu compra?
                    </div>
                    <div class="card-body">                               
                        <p class="card-text">
                            <%= customer.getAddress()%>
                        </p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <a href="SalesController?btnMethodPayment=true&shippingCost=0">
                                <i class="fa fa-map-marker-alt"></i>
                                <span class="nav-link-text">Retiro en domicilio del vendedor</span>
                            </a>
                        </li>     
                        <li class="list-group-item">
                            <a href="SalesController?btnMethodPayment=true&shippingCost=<%= product.getShippingCost()%>">
                                <i class="fa fa-map-marker-alt"></i>
                                <span class="nav-link-text">Normal a domicilio  $<%= product.getShippingCost()%></span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--COLUMNA DE LA IMG DEL PRODUCTO-->

            <div class="col-md-4">
                <div class="card border-dark">
                    <div class="card-header text-center">
                        <%= product.getName()%>
                    </div>
                        <img style="max-height: 400px"  src="img/products/<%= product.getGuid()%>"  class="card-img" alt="...">                     
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>Cantidad</b> 1</li>     
                        <li class="list-group-item"><b>Producto</b> $<%= product.getPrice()%></li>     
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
