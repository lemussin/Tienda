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
        <nav class="navbar navbar-inverse col-md-12">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Tienda Lemus</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Inicio</a></li>
                        <li><a href="#">Acerca de..</a></li>
                        <li><a href="#">Contacto</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= usuario.getNombre() %> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Mi perfil</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Cerrar sesión</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="carousel-example-generic" class="carousel slide col-md-12" data-ride="carousel">
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
                            <br/>
                            <div class="row">
                                <div class="col-md-12">
                                    <center>
                                        <h1>¡A trabajar se ha dicho!</h1>
                                        <hr/>
                                    </center>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="caption">
                                        <center>
                                            <img src="../Imagenes/Inicio/mercancia.jpg" alt="Agregar Mercancia">
                                            <h3>Agregar Mercancia</h3>
                                            <p>Manten el control de tu inventario y agrega <br/>tu mercancia desde un formulario sencillo y practico</p>
                                            <p><a href="#" class="btn btn-info" role="button">Agregar</a></p>
                                        </center>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="caption">
                                        <center>
                                            <img src="../Imagenes/Inicio/Cajas.jpg" alt="Modificar Mercancia">
                                            <h3>Modificar Inventario</h3>
                                            <p>¿Hubo un error en el registro? <br/>¡No te preocupes! Puedes corregirlo aquí</p>
                                            <p><a href="#" class="btn btn-info" role="button">Modificar</a></p>
                                        </center>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="caption">
                                        <center>
                                            <img src="../Imagenes/Inicio/distribuidor1.jpg" alt="Venta de mercancia">
                                            <h3>Mercancia Vendida</h3>
                                            <p>¿Venta de mercancia fuera de caja? <br/>¡Grandioso! Registralo justo aquí</p>
                                            <p><a href="#" class="btn btn-info" role="button">Registrar Venta</a></p>
                                        </center>
                                    </div>
                                </div>
                            </div>
                            <hr/>
                            <div class="row featurette">
                                <div class="col-md-7">
                                    <h2 class="featurette-heading"><br/>Registro de usuarios</h2>
                                    <p class="lead">En este apartado podras registrar usuarios administradores o cajeros.<br><br>
                                        <mark>Usuario Administrador:</mark><span class="text-muted">Es aquel usuario que podra ingresar al administrador del sistema o modulo de cajas, por lo que podra dar de alta o modificar mercancia y registrar ventas fuera de cajas.</span><br><br>
                                        <mark>Cajero:</mark><span class="text-muted">Es aquel usuario que utilizara unicamente el modulo de cajas.</span>
                                        <br><br>
                                        Generar el registro <button class="btn btn-info" type="button">Aquí</button>
                                    </p>
                                </div>
                                <div class="col-md-5">
                                    <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500" src="../Imagenes/Inicio/registro.png" data-holder-rendered="true">
                                </div>
                            </div>
                            <footer>
                                <p class="pull-right"><a href="#"><span class="glyphicon glyphicon-arrow-up"></span>Arriba</a></p>
                                <p>© 2016 Lemus Estudios</p>
                            </footer>
    </body>
</html>