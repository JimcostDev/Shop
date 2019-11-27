<%-- 
    Document   : ProductCreatePhoto
    Created on : 25-nov-2019, 8:56:08
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

        <title>Upload Photo</title>

        <!--Importar Bootstrap-->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <!--Importar Scripts-->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
    </head>
    <body>
        <form action="ProductsController" method="post" enctype="multipart/form-data">


            <div class="form-group">
                <div class="col-md-6 offset-md-2">
                    <div class="card border-dark">  
                        <div class="card-header text-center">
                            Foto del producto
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <input 
                                    type="file" 
                                    id="filePhoto"
                                    class="form-control-file"
                                    name="filePhoto">
                            </li>

                            <li class="list-group-item">
                                <input class="btn btn-primary btn-block" 
                                       type="submit" 
                                       name="btnLoad" 
                                       id="btnLoad" value="Cargar">
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>


