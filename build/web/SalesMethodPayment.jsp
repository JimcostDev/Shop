<%-- 
    Document   : SalesMethodPayment
    Created on : 18-nov-2019, 11:27:19
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

        <title>Sales Methods Payment</title>

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
                <div class="card border-dark" >
                    <div class="card-header text-center">
                        ¿Cómo quieres pagar?
                    </div>
                        <form name="frm-sale" action="SalesController" method="post">
                            <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                            <select id="ddlMethodPayment"
                                    name="ddlMethodPayment"
                                    class="form-control">
                                <option value="-1">--Seleccione--</option>

                                <%
                                    //si es diferente de nulo validamos que lo estan enviando
                                    if (request.getAttribute("listMethodsPayment") != null) {
                                        //foreach (for mejorado) - recorrer el objeto - tambien realizamos un casteo
                                        for (com.hardwareStore.models.MethodPayment item : (List<com.hardwareStore.models.MethodPayment>) request.getAttribute("listMethodsPayment")) {
                                %>


                                <!--las listas desplejables se componen de una llave-valor (la llave = value [dev] y valor = vista [user])-->
                                <!--mostrar metodos de pago disponibles-->
                                <option value="<%= item.getId()%>"> <%= item.getName()%> </option>
                                <%
                                        }
                                    }
                                %>

                            </select>

                            </li>     
                            <li class="list-group-item">
                                <input type="submit" 
                                       value="Continuar" 
                                       id="btnSale"
                                       name="btnSale"
                                       class="btn btn-primary btn-block"/>
                            </li>    
                        </ul>
                    </form>                   
                </div>
            </div>            
            <!--COLUMNA DE LA IMG DEL PRODUCTO-->

            <div class="col-md-4">
                <br>
                <div class="card border-dark">
                    <div class="card-header text-center">
                        <%= product.getName()%>
                    </div>
                    <img src="img/products/<%= product.getGuid()%>" style="max-height: 400px" class="card-img" alt="...">                      
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>Cantidad</b> 1</li>     
                        <li class="list-group-item"><b>Producto</b> $<%= product.getPrice()%></li>    
                        <li class="list-group-item"><b>Envío</b> $<%= product.getShippingCost()%></li> 
                        <li class="list-group-item"><b>Pagas</b> $<%= (product.getPrice() + product.getShippingCost())%></li> 
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>

