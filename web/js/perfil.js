$("document").ready(function(){
    cargarDatos();
    
    $("#modificaInfo").click(function(){
        alert("bien");
    });
    
    $("#CerrarSesion").click(function()
    {
        var Parametros = {seleccion: "CerrarSesion"};
        $.ajax({
            async:true,url: "../CierreSesionController",data: Parametros,type: "POST",dataType: "json",
            success: function (){
                alert("Hasta Luego!");
                location.href="../index.jsp";
            }
        });
    });
    
});

function cargarDatos()
{
    var parametros = {seleccion:"cargarDatos"};
    $.ajax({
        async:true, url:"../perfilController", data:parametros, type:"POST", dataType:"json",
        success:function(usuario)
        {
            document.getElementById("nombreUsuario").value = usuario.nombre;
            document.getElementById("apellidoPUsuario").value = usuario.apellidoPaterno;
            document.getElementById("apellidoMUsuario").value = usuario.apellidoMaterno;
            document.getElementById("usuario").value = usuario.usuario;
            document.getElementById("Password").value = usuario.password;
            document.getElementById("Password2").value = usuario.password;
            document.getElementById("fNacimiento").value = usuario.fechaNac;
            document.getElementById("telefono").value = usuario.telefono;
            document.getElementById("email").value = usuario.email;
            
        },
        error:function(err){alert("Error "+err);}
    });
}