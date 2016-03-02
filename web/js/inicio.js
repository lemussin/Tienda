$("document").ready(function(){
    $('.carousel').carousel({
        interval: 3000
    });
    
    $("#formModalUsuarios").submit(function(event)
    {
        event.preventDefault();
        if($("#Password").val()===$("#Password2").val())
        {
            var elementos = document.getElementsByName("radioForm");
            var usuario;
            for(var i=0; i<elementos.length; i++) 
            {
                if(elementos[i].checked)
                    usuario = elementos[i].value;
            }
            var fecha = $("#fNacimiento").val().toString();
            var parametros = { seleccion: "RegistroUsuarios",nombre:""+$("#nombreUsuario").val(), 
                apellidoP:""+$("#apellidoPUsuario").val(), apellidoM:""+$("#apellidoMUsuario").val(),
                usuario:""+$("#usuario").val(),password:""+$("#Password").val(),fecha:""+fecha,
                telefono:""+$("#telefono").val(),email:""+$("#email").val(),tipoUsuario:""+usuario};
            $.ajax({
                async: true, url:"../InicioController", data:parametros, type:"POST", dataType:"json",
                success: function(status)
                {
                    if(status===1)
                        alert("Registro Exitoso");
                    if(status===2)
                        alert("El nombre de usuario ya existe. Ingresa uno diferente");
                },
                error:function(err){alert("Lo sentimos hubo un error: "+err);}
            });
        }
        else
            alert("Las contraseñas no son iguales.");
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

