<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="Jquery/jquery-1.12.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="Estilos/styles6.css">
	<link rel="stylesheet" type="text/css" href="Estilos/validaciones.css">
	<script type="text/javascript" src="js/login.js"></script>
    </head>
    <body id="bodyLogin" BACKGROUND="Imagenes/Login/ImgFondo.jpg">
        <div class="container" id="loginDiv">
            <form method="post">
                <label for="inputNombre" class="label">Nombre:</label>
                <input type="text" id="inputNombre" class="input expantion" placeholder="prueba" required /><br/>
                <label for="inputPass" class="label">Password:</label><br/>
                <input type="password" id="inputPass" class="input expantion" placeholder="Password" required /><br/>
                <input id="inputCheck" type="checkbox" class="checkbox">
                <label for="inputCheck" class="label">Recordar mis datos</label><br/><br/>
                <button class="btnLogin" id="btnLgn">Presiona Aqui</button>
            </form>
        </div>
        <script type="text/javascript" src="Jquery/jquery-1.12.1.min.js"></script>
    </body>
</html>