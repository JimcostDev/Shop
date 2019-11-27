

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login</title>
        <!--Importar Bootstrap-->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <!--Importar Scripts-->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>


    </head>
    <body class="bg-dark">
        <!--Sciptlets, codigo java embebido en html-->
        <%
            //si es diferente de nulo validamos que lo estan enviando
            if (request.getAttribute("status") != null) {
                if (Integer.parseInt(request.getAttribute("status").toString()) == 200) {
        %>  
        <script>
            alert('200 - Process was successful');
        </script>
        <%
        } else {
        %>
        <script>
            alert('500 - An error ocurred during process');
        </script>
        <% }
            }
        %>

        <div class="container-fluid">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header text-center">Iniciar Sesión</div>
                <br>
                <div class="form-row text-center">
                    <div class="col-md-4 offset-md-4">
                        <img src="img/brand.png"  alt="Login-Image">
                    </div>
                </div>
                <div class="card-body">
                    <form action="accountController" method="post">
                        <!--crear campo de formulario-->
                        <div class="form-group">
                            <div class="form-row"><!--una fila-->
                                <div class="col-md-1 offset-md-4"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->
                                    <label for="txtId">Usuario:</label>
                                </div>
                                <div class="col-md-3"><!--width=6 columnas || width = 50%, offset-md-4(centrar)-->

                                    <input 
                                        type="text" 
                                        id="txtEmail"
                                        name="txtEmail" 
                                        class="form-control" 
                                        placeholder="Ingresar email" 
                                        required="required">
                                </div>
                            </div>
                            <br>
                            <div class="form-row"><!--una fila-->
                                <div class="col-md-1 offset-md-4"><!--width=6 columnas || width = 50%-->
                                    <label for="txtPassword">contraseña:</label>

                                </div>
                                <div class="col-md-3"><!--width=6 columnas || width = 50%-->                                    
                                    <input 
                                        type="password" 
                                        id="txtPassword"
                                        name="txtPassword" 
                                        class="form-control" 
                                        placeholder="Ingresar contraseña" 
                                        required="required">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-md-4 offset-md-4">
                                <input name="btnLogin" type="submit" class="btn btn-primary btn-block" value="Iniciar Sesión"/>
                            </div>
                        </div>
                        
                        <div class="form-row text-center">
                            <div class="col-md-4 offset-md-4">
                                <br>
                                <input name="chkRemember" type="checkbox" id="chkRemember"/> Recuérdame?
                                <a class="d-block small mt-3" href="Register.jsp">Registrar cuenta</a>
                                <a class="d-block small" href="#ForgotPassword.jsp">¿Olvidaste tu contraseña?</a>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>



    </body>
</html>
