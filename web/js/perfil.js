$("document").ready(function(){
    cargarDatos();
});

function cargarDatos()
{
    var parametros = {seleccion:"cargarDatos"};
    $.ajax({
        async:true, url:"../perfilController", data:parametros, type:"POST", dataType:"json",
        success:function(usuario)
        {
            document.getElementById("nombreUsuario").value = usuario.nombre;
        },
        error:function(err){alert("Error "+err);}
    });
}