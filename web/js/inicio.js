$("document").ready(function(){
    $('.carousel').carousel({
        interval: 3000
    });
    
    $("#formModalUsuarios").submit(function(event)
    {
        event.preventDefault();
        alert("Exito");
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

