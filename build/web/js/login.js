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
                        if(obj.permiso===1)
                        {
                            alert("Exito!! Tus datos son veridicos "+obj.nombre);
                            location.href="vistas/inicio.jsp";
                        }
                        else
                            alert("Tu información es incorrecta. Intenta de nuevo");
                    },
                    error:function(obj){alert("error "+obj);}
                });
            }
        });
});