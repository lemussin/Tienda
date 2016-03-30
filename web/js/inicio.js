var idMercanciaModicar;
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
    
    $("#formModalAgregarMerc").submit(function(event){
        event.preventDefault();
        var mercancia = document.getElementById("selectTipoMercancia")[$("#selectTipoMercancia").val()-1].id;
        var sexo = document.getElementById("selectGenero")[$("#selectGenero").val()-1].id;
        var marcaP = document.getElementById("selectMarca")[$("#selectMarca").val()-1].id;
        var color = document.getElementById("selectColor")[$("#selectColor").val()-1].id;
        var nombreMercancia = mercancia +" "+sexo+" "+" "+color+" marca "+marcaP;
        var parametros={seleccion:"registrarMercancia",tipoMercancia:""+$("#selectTipoMercancia").val(),genero:""+$("#selectGenero").val(),
        cantidad:""+$("#inputCantidad").val(),marca:""+$("#selectMarca").val(),colorBase:""+$("#selectColor").val(),
        precio:""+$("#inputPrecio").val(),descripcion:""+$("#descripcion").val(),nombreMerc:""+nombreMercancia};
       $.ajax({
            async:true, url:"../InicioController", data:parametros, type:"POST", dataType:"json",
            success:function(exito){
                alert("La mercancia fue registrada exitosamente");
                $("#resetRegistrarMercancia").click();
                $("#CerrarGuardarMercancia").click();
            },
            error:function(err){
                alert("Hubo un error en el registro de la mercancia "+err);
            }
        });
    });
    
    $("#modificarProducto").click(function(){
        var parametros ={seleccion:"cargaMercancias"};
        $.ajax({
            async:true,url:"../InicioController",type:"POST",dataType:"json", data:parametros,
            success:function(mercancia){
                var html = '<option id="seleccionaProdMod" value="0">Selecciona un producto</option>';
                for(var i=0; i<mercancia.length; i++)
                    html += '<option id="'+mercancia[i].nombreMercancia+'" value="'+mercancia[i].idMercanciaRegistrada+'">'+mercancia[i].nombreMercancia+'</option>';
                $("#selectProductoMod").html(html);
            },
            error:function(err){
                alert("Error en la carga de productos "+err);
            }
        });
    });
    
    $("#selectProductoMod").change(function(){
        if($("#selectProductoMod").val()!=="0")
        {
            var parametros ={seleccion:"cargaProductoModificar",idMercancia:$("#selectProductoMod").val()};
            $.ajax({
                async:true, url:"../InicioController",dataType:"json", type:"POST",data:parametros,
                success:function(mercancia){
                    document.getElementById("selectTipoMercanciaMod").selectedIndex=mercancia.idMercancia-1;
                    $("#selectTipoMercanciaMod").attr("disabled",false);
                    document.getElementById("selectGeneroMod").selectedIndex=mercancia.idGenero-1;
                    $("#selectGeneroMod").attr("disabled",false);
                    $("#inputCantidadMod").val(mercancia.cantidad);
                    $("#inputCantidadMod").attr("disabled",false);
                    document.getElementById("selectMarcaMod").selectedIndex=mercancia.idMarca-1;
                    $("#selectMarcaMod").attr("disabled",false);
                    document.getElementById("selectColorMod").selectedIndex=mercancia.idColorBase-1;
                    $("#selectColorMod").attr("disabled",false);
                    $("#inputPrecioMod").val(mercancia.precio);
                    $("#inputPrecioMod").attr("disabled",false);
                    $("#descripcionMod").val(mercancia.descripcion);
                    $("#descripcionMod").attr("disabled",false);
                    idMercanciaModicar = mercancia.idMercanciaRegistrada;
                },
                error:function(err){
                    alert("Error en la carga de datos del producto "+err);
                }
            });
            $("#GuardarModificarMercancia").attr("disabled",false);
        }
        else
            $("#GuardarModificarMercancia").attr("disabled",true);
    });
    
    $("#formModalModificarMerc").submit(function(event){
        event.preventDefault();
        var mercancia = document.getElementById("selectTipoMercanciaMod")[$("#selectTipoMercanciaMod").val()-1].id;
        var sexo = document.getElementById("selectGeneroMod")[$("#selectGeneroMod").val()-1].id;
        var marcaP = document.getElementById("selectMarcaMod")[$("#selectMarcaMod").val()-1].id;
        var color = document.getElementById("selectColorMod")[$("#selectColorMod").val()-1].id;
        var nombreMercancia = mercancia +" "+sexo+" "+" "+color+" marca "+marcaP;
        var parametros={seleccion:"ModificarMercancia",tipoMercancia:""+$("#selectTipoMercanciaMod").val(),genero:""+$("#selectGeneroMod").val(),
        cantidad:""+$("#inputCantidadMod").val(),marca:""+$("#selectMarcaMod").val(),colorBase:""+$("#selectColorMod").val(),
        precio:""+$("#inputPrecioMod").val(),descripcion:""+$("#descripcionMod").val(),nombreMerc:""+nombreMercancia, mercanciaModificar:""+idMercanciaModicar};
        $.ajax({
            async:true, data:parametros, url:"../InicioController", dataType:"json", type:"POST",
            success:function(exito){
                if(exito===1)
                {
                    alert("Tus modificaciones se registraron exitosamente");
                    $("#resetModificarMercancia").click();
                    $("#btnCerrarModificarMercancia").click();
                }
            },
            error:function(err){
                alert("Error en modificación de mercancia "+err);
            }
        });
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
            var html="";
            for(var i=0; i<productos.length; i++)
                html +='<option id="'+productos[i].nombreProducto+'" value="'+productos[i].idProducto+'" >'+productos[i].nombreProducto+'</option>';
            $("#selectTipoMercancia").html(html);
            $("#selectTipoMercanciaMod").html(html);
            cargarMarcas();
        },
        error:function(err){
            alert("Error en la carga de productos "+err);
        }
    });
}

function cargarMarcas()
{
    var parametros ={seleccion:"cargarMarcas"};
    $.ajax({
        async:true, url:"../InicioController", data:parametros, type:"POST", dataType:"JSON",
        success:function(marca){
            var html="";
            for(var i=0; i<marca.length; i++)
                html +='<option id="'+marca[i].nombreMarca+'" value="'+marca[i].idMarca+'" >'+marca[i].nombreMarca+'</option>';
            $("#selectMarca").html(html);
            $("#selectMarcaMod").html(html);
            cargarColores();
        },
        error:function(err){alert("Error en la carga de Marcas "+err);}
    });
}

function cargarColores()
{
    var parametros ={seleccion:"cargarColores"};
    $.ajax({
        async:true, url:"../InicioController", data:parametros, type:"POST", dataType:"JSON",
        success:function(colores){
            var html="";
            for(var i=0; i<colores.length; i++)
                html +='<option id="'+colores[i].color+'" value="'+colores[i].idColor+'" >'+colores[i].color+'</option>';
            $("#selectColor").html(html);
            $("#selectColorMod").html(html);
        },
        error:function(err){alert("Error en la carga de Marcas "+err);}
    });
}