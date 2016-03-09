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
        <link href="../Estilos/validaciones.css" rel="stylesheet">
        <link href="../Estilos/imagenes.css" rel="stylesheet">
        <script src="../Jquery/jquery-1.12.1.min.js"></script>
        <script src="../Jquery/jquery-2.2.1.js"></script>
        <script src="../Estilos/js/bootstrap.min.js"></script>
        <script src="../js/perfil.js" type="text/javascript"></script>
        <title>Mi perfil</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse col-md-12">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Tienda Lemus</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="inicio.jsp">Inicio</a></li>
                        <li><a href="#">Acerca de..</a></li>
                        <li><a href="#">Contacto</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= usuario.getUsuario() %> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="active"><a href="perfil.jsp">Mi perfil</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#" id="CerrarSesion">Cerrar sesión</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="row">
            
        </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <center><h1>Mi perfil</h1></center>
                                    <hr/>
                                </div>
                            </div>
        <div class="row jumbotron">
            <div class="col-md-4">
                <center><img src="../Imagenes/perfil/eduardo.jpg" alt="..." class="img-thumbnail mediana"></center>
            </div>
            <div class="col-md-4">
                <span class="glyphicon glyphicon-user titulo" aria-hidden="true"> <%=usuario.getNombre()%> <%=usuario.getApellidoPaterno()%> <%=usuario.getApellidoMaterno()%> </span><br><br>
                <span class="glyphicon glyphicon-calendar titulo" aria-hidden="true"> <%=usuario.getFechaNac() %></span><br><br>
                <span class="glyphicon glyphicon-earphone titulo" aria-hidden="true"> <%= usuario.getTelefono() %> </span><br><br>
                <span class="glyphicon glyphicon-envelope titulo" aria-hidden="true"> <%= usuario.getEmail() %> </span><br><br>
                <button id="modificaInfo" type="button" class="btn btn-warning btn-lg btn-block">Modificar información</button>
            </div>
        </div>
        <form id="formUsuario">
        <div class="form-group row">
            <div class="col-md-4">
                <label for="nombreUsuario">Nombre:</label>
                <input type="text" class="form-control" id="nombreUsuario" placeholder="Nombre" required disabled>
            </div>
            <div class="col-md-4">
                <label for="apellidoPUsuario">Apellido Paterno:</label>
                <input type="text" class="form-control" id="apellidoPUsuario" placeholder="Apellido Paterno" required disabled>
            </div>
            <div class="col-md-4">
                <label for="apellidoMUsuario">Apellido Materno:</label>
                <input type="text" class="form-control" id="apellidoMUsuario" placeholder="Apellido Materno" required disabled>
            </div>
        </div>
        <hr/>
        <div class="form-group row">
            <div class="col-md-4">
                <label for="usuario">Usuario:</label>
                <input type="text" class="form-control" id="usuario" placeholder="Usuario" required disabled>
            </div>
            <div class="col-md-4">
                <label for="Password">Password:</label>
                <input type="password" class="form-control" id="Password" placeholder="Password" required disabled>
            </div>
            <div class="col-md-4">
                <label for="Password2">Repetir Password:</label>
                <input type="password" class="form-control" id="Password2" placeholder="Password" required disabled>
            </div>
        </div>
        <hr>
        <div class="form-group row">
            <div class="col-md-4">
                <label for="fNacimiento">Fecha de nacimiento:</label>
                <input type="date" class="form-control" id="fNacimiento" placeholder="Fecha de Nacimiento" required disabled>
            </div>
            <div class="col-md-4">
                <label for="telefono">Telefono:</label>
                <input type="text" class="form-control" id="telefono" placeholder="Telefono" required disabled>
            </div>
            <div class="col-md-4">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Email" required disabled>
            </div>
        </div>
        <hr>
        <div class="form-group row">
            <div class="col-md-12">
                <strong>Tipo de usuario:</strong>
            </div>
            <div class="col-md-12">
                <label class="radio-inline">
                    <input type="radio" name="radioForm" id="1" value="1" checked disabled> Administrador
                </label>
                <label class="radio-inline">
                    <input type="radio" name="radioForm" id="1" value="2" disabled> Cajero
                </label>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-12">
                <button type="submit" class="btn btn-success" id="GuardarCambios" disabled>Guardar Cambios</button>
                <button type="button" class="btn btn-danger" id="CancelarCambios" disabled>Cancelar Cambios</button>
            </div>
        </div>
        </form>
    </body>
</html>
