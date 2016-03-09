$("document").ready(function(){
    cargarDatos();
    
    $("#modificaInfo").click(function(){
        document.getElementById("nombreUsuario").disabled=false;
        document.getElementById("apellidoPUsuario").disabled=false;
        document.getElementById("apellidoMUsuario").disabled=false;
        document.getElementById("usuario").disabled=false;
        document.getElementById("Password").disabled=false;
        document.getElementById("Password2").disabled=false;
        document.getElementById("fNacimiento").disabled=false;
        document.getElementById("telefono").disabled=false;
        document.getElementById("email").disabled=false;
        document.getElementById("GuardarCambios").disabled=false;
        document.getElementById("CancelarCambios").disabled=false;
    });
    
    $("#formUsuario").submit(function(event){
        event.preventDefault();
        if($("#Password").val()===$("#Password2").val())
        {
            var fecha = $("#fNacimiento").val().toString();
            var parametros = { seleccion: "ModificaUsuarios",nombre:""+$("#nombreUsuario").val(), 
                apellidoP:""+$("#apellidoPUsuario").val(), apellidoM:""+$("#apellidoMUsuario").val(),
                usuario:""+$("#usuario").val(),password:""+$("#Password").val(),fecha:""+fecha,
                telefono:""+$("#telefono").val(),email:""+$("#email").val()};
            $.ajax({
                async:true, url:"../perfilController", data:parametros,type:"POST", dataType:"json",
                success:function(exito){
                    if(exito === 1)
                    {
                        alert("Tus datos han sido actualizados con exito");
                        location.href="perfil.jsp";
                    }
                },
                error:function(err){
                    alert("Error en la inserción de datos "+err);
                }
            });
        }
        else
            alert("Las contraseñas no son iguales.");
    });
    
    $("#CancelarCambios").click(function(ev){
        location.href="perfil.jsp";
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