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

        <title>Products Create</title>
        <!--Importar Bootstrap-->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <!--Importar Scripts-->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>


    </head>
    <body class="bg-dark">
    

        <div class="container-fluid">
            <div class="card card-login mx-auto mt-5">
                <form action="ProductsController" method="post">
                    <div class="card-header text-center">Crear producto</div>
                    <br>
                    <div class="form-row text-center">
                        <div class="col-md-4 offset-md-4">
                            <img src="img/brand.png"  alt="Login-Image">
                        </div>
                    </div>
                    <div class="card-body">

                        <!--crear campo de formulario-->
                        <div class="form-group">
                            <div class="form-row"><!--una fila-->
                                <div class="col-md-3 offset-md-3"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->
                                    <label for="txtName">Nombre:</label>                               
                                    <input 
                                        type="text" 
                                        id="txtName"
                                        name="txtName" 
                                        class="form-control" 
                                        placeholder="titulo del producto" 
                                        required="required">
                                </div>

                                <div class="col-md-3"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->
                                    <label for="txtWarranty">Garantia:</label>
                                    <input 
                                        type="text" 
                                        id="txtWarranty"
                                        name="txtWarranty" 
                                        class="form-control" 
                                        placeholder="Tiempo garantia en meses" 
                                        required="required">

                                </div>

                                <div class="col-md-1"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->
                                    <label for="txtQuantity">Cantidad:</label>
                                    <input 
                                        type="number" 
                                        id="txtQuantity"
                                        name="txtQuantity" 
                                        class="form-control"
                                        min="0"
                                        max="100"
                                        placeholder="0-100" 
                                        required="required">
                                </div>

                            </div>
                            <br>
                            <div class="form-row"><!--una fila-->
                                <div class="col-md-7 offset-md-3"><!--width=6 columnas || width = 50%-->
                                    <label for="txtDescription">Descripción:</label>

                                    <textarea 
                                        name="txtDescription" 
                                        id="txtDescription" cols="42" 
                                        rows="4" 
                                        class="form-control"  
                                        placeholder=" Escribe tu mensaje">
                                    </textarea>
                                </div>
                            </div>
                            <br>



                            <div class="form-row"><!--una fila-->
                                <div class="col-md-3 offset-md-3"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->
                                    <label for="txtPrice">Precio</label>

                                    <input 
                                        type="text" 
                                        id="txtPrice"
                                        name="txtPrice" 
                                        class="form-control"
                                        placeholder="$"
                                        required="required">
                                </div>

                                <div class="col-md-4"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->
                                    <label for="txtShippingCost">Costo de envio</label>                               
                                    <input 
                                        type="text" 
                                        id="txtShippingCost"
                                        name="txtShippingCost" 
                                        class="form-control"
                                        placeholder="$"
                                        required="required">
                                </div>

                            </div>
                        </div>

                        <br>
                        <!--****************CATEGORIAS Y ESTADO********************************-->
                        <div class="form-row">                                                                  
                            <div class="col-md-3 offset-md-3">
                                <label>Categoria:</label>
                                <select id="ddlCategories"
                                        name="ddlCategories"
                                        class="form-control">
                                    <option value="-1">--Seleccione--</option>
                                    <%
                                       
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
                            </div>
                            <!--****************ESTADOS********************************-->                                                                
                            <div class="col-md-3 offset-md-1">
                                <label>Estado:</label>
                                <select id="ddlStates"
                                        name="ddlStates"
                                        class="form-control">
                                    <option value="-1">--Seleccione--</option>
                                    <%
                                        if (request.getAttribute("listStates") != null) {
                                            //foreach (for mejorado) - recorrer el objeto - tambien realizamos un casteo
                                            for (com.hardwareStore.models.States item : (List<com.hardwareStore.models.States>) request.getAttribute("listStates")) {
                                    %>

                                    <option value="<%= item.getId()%>"> <%= item.getName()%> </option>
                                    <%
                                            }
                                        }
                                    %>

                                </select>
                            </div>
                        </div>

                        <!--************************************************-->
                        <br>
                        <!--<div class="form-row"><!--una fila
                            
                                <label for="filePhoto">Foto:</label>
                                <input 
                                    type="file" 
                                    id="filePhoto"
                                    class="form-control-file"
                                    name="filePhoto">
                            </div>
                        </div>-->


                    </div>
                    <div class="form-row">
                        <div class="col-md-7 offset-md-3">
                            <input name="btnCreateProduct" id="btnCreateProduct" type="submit" class="btn btn-primary btn-block" value="Guardar"/>
                        </div>
                    </div>

                    <div class="form-row text-center">
                        <div class="col-md-3 offset-md-5">
                            <br>
                            <input name="chkRemember" type="checkbox" id="chkRemember"/> Recuérdame?
                            <a class="d-block small mt-3" href="Register.jsp">Registrar cuenta</a>
                            <a class="d-block small" href="#ForgotPassword.jsp">¿Olvidaste tu contraseña?</a>
                        </div>
                    </div>
                </form>

            </div>
        </div>


    </body>
</html>
