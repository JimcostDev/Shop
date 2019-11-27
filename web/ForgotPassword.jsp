

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>ForgotPassword</title>

        <!--Importar Bootstrap-->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <!--Importar Scripts-->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
    </head>
    <body class="bg-info">
        <div class="container-fluid">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header card-header text-center" >Forgot Password</div>
                <br>
                <div class="form-row text-center">
                    <div class="col-md-4 offset-md-4">
                        <img src="img/login.jpeg"  alt="Login-Image">
                    </div>
                </div>
                <br>
                <div class="form-row text-center">
                    <div class="col-md-4 offset-md-4">
                        <p>Ingrese du direción de correo electrónico y le enviaremos
                            instrucciones sobre cómo recuperar su contraseña.</p>
                    </div>
                </div>
                <div class="card-body">
                    <form action="accountController" method="post">
                        <!--crear campo de formulario-->

                        <div class="form-group">
                            <div class="form-row"><!--una fila-->
                                <div class="col-md-1 offset-md-4"><!--width=6 columnas || width = 50%-->
                                    <label for="txtEmail">Email:</label>
                                </div>
                                <div class="col-md-3">
                                    <input 
                                        type="text" 
                                        id="txtEmail"
                                        name="txtEmail" 
                                        class="form-control" 
                                        placeholder="Enter email" 
                                        required="required">
                                </div>
                            </div>
                            <!--fin-->
                        </div>
                        <div class="form-row">
                            <div class="col-md-4 offset-md-4">
                                <input name="btnForgotPassword" type="submit" class="btn btn-info btn-block" value="Forgot"/>
                            </div>
                        </div>
                    </form>
                    <div class="text-center">
                        <a class="d-block small mt-3" href="Login.jsp">Login</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
