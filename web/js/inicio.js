$("document").ready(function(){
    $('.carousel').carousel({
        interval: 3000
    });
    
    cargarMercancias();
    
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

function cargarMercancias()
{
    var parametro = {seleccion:"cargaTipoProductos"};
    $.ajax({
        async:true, data:parametro, url:"../InicioController", type:"POST", dataType:"JSON",
        success:function(productos){
            var html;
            for(var i=0; i<productos.length; i++)
                html +='<option id="'+productos[i].idProducto+'">'+productos[i].nombreProducto+'</option>';
            $("#selectTipoMercancia").html(html);
        },
        error:function(err){
            alert("Error en la carga de productos "+err);
        }
    });
}