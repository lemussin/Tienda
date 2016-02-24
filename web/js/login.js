$("document").ready(function ()
{
	$("#btnLgn").submit(function(event)
	{
            event.preventDefault();
            var nombre = $("#inputNombre").val();
            var pass = $("#inputPass").val();
            if(nombre!=="" && pass!=="")
            {
                var Parametros = {seleccion: "inicioSesion", nombre: ""+nombre, pass:""+pass};
                $.ajax({
                    async:true,url: "LoginController",data: Parametros,type: "POST",dataType: "json",
                    success: function (obj)
                    {
                        alert("Exito "+obj.nombre);
                    },
                    error:function(obj){alert("error "+obj);}
                });
            }
        });
});