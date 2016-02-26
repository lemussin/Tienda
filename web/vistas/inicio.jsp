<%-- 
    Document   : inicio
    Created on : 25/02/2016, 11:03:14 PM
    Author     : Eduardo Lemus Zavala
--%>
<%@page import="tienda.Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
   Usuario usuario= (Usuario) session.getAttribute("Usuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../Estilos/css/bootstrap.min.css" rel="stylesheet">
        <script src="../Jquery/jquery-1.12.1.min.js"></script>
        <script src="../Estilos/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/inicio.js"></script>
        <title>Bienvenido Tienda Lemus</title>
    </head>
    <body>
        <div class="row">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                          <span class="sr-only">Toggle navigation</span>
                          <span class="icon-bar"></span>
                          <span class="icon-bar"></span>
                          <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Tienda Lemus</a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Inicio</a></li>
                            <li><a href="#">Contacto</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= usuario.getNombre() %> <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Acerca de..</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Cerrar sesión</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicadores -->
                <ol class="carousel-indicators">
                  <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>
                <!-- Imagenes para slider(de prueba) -->
                <div class="carousel-inner" role="listbox">
                  <div class="item active">
                    <img src="../Imagenes/Inicio/Carousel/london.jpg" alt="Londres">
                    <div class="carousel-caption">
                      Londres
                    </div>
                  </div>
                  <div class="item">
                    <img src="../Imagenes/Inicio/Carousel/paris.jpg" alt="Paris">
                    <div class="carousel-caption">
                      Paris
                    </div>
                  </div>
                    <div class="item">
                    <img src="../Imagenes/Inicio/Carousel/winter.jpg" alt="Winter">
                    <div class="carousel-caption">
                      Winter
                    </div>
                  </div>
                </div>
                <!-- Controles -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </body>
</html>
