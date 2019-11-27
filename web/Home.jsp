<%-- 
    Document   : Home
    Created on : 25-ago-2019, 15:10:08
    Author     : EliteBook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/bootstrap.min.js" type="text/javascript"></script>        
        <script src="js/popper.min.js" type="text/javascript" ></script>

        <!-- jQuery -->
        <script src="js/jquery-3.4.1.min.js" type="text/javascript" ></script>

        <!-- Site -->
        <link rel="stylesheet" href="css/site.css">
        <script src="js/site.js"></script>

        <!-- FontAwesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

        <title>Home</title>

        <style>
            iframe{
                width: 100%;
                height: 900px;
            }
        </style>
    </head>
    <body>

        <div class="d-flex" id="wrapper">
            <!-- ============================================================== -->
            <!-- Sidebar -->
            <!-- ============================================================== -->
            <div class="bg-light border-right" id="sidebar-wrapper">
                <div class="sidebar-heading">
                    <img src="img/brand.png" alt="">                                  
                </div>
                <!--Cargar opciones-->
                <div class="list-group list-group-flush">
                    <!--llamamos la función loadOption, la cual le esta invocando 
                    el controlador de productos y le esta enviando la opcion optProductsIndex-->
                    <a class="nav-link"
                       onclick="loadOption('ProductsController?optProductsIndex=true')">
                        <!--icono de fontawesome-->
                        <i class="fa fa-shopping-cart"></i>
                        <span class="nav-link-text">Buscar Producto</span>
                    </a>
                    <a class="nav-link"
                       onclick="loadOption('ProductsController?optProductsCreate=true')">
                        <!--icono de fontawesome-->
                        <i class="fa fa-shopping-cart"></i>
                        <span class="nav-link-text">Vender</span>
                    </a>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Sidebar -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Page Content -->
            <!-- ============================================================== -->
            <div id="page-content-wrapper">
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <!--icono de fontawesome-->
                    <i class="fas fa-align-justify" id="menu-toggle"></i>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    
                    <div class="offset-md-9 collapse navbar-collapse" id="navbarSupportedContent">
                        <a class="nav-link " href="#"><%=request.getAttribute("userName")%></a>
                        <a class="nav-link text-danger" href="Login.jsp">Salir</a>
                    </div>
                </nav>
                <div class="container-fluid">
                    <!--iframe: etiqueta html que nos permite incrustar codigo 
                    html de otras paginas directamente en esta sección; ej: video de youtube-->
                    <iframe id="frame" frameborder="0"></iframe>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Page Content -->
            <!-- ============================================================== -->
        </div>

        <!-- ============================================================== -->
        <!-- Menu Toggle Script -->
        <!-- ============================================================== -->
        <script>
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#wrapper").toggleClass("toggled");
            });
            //cargar opcion 
            function loadOption(option) {
                document.getElementById('frame').src = option;
            }
        </script>

    </body>
</html>
