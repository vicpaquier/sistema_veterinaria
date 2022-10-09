

function buscarIdUsuario() {
    var datosFormulario = $("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url: '../usuarios/jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            alert(datosFormulario);
        },
        success: function (json) {
            
            $("#mensajes").html(json.mensaje);
            $("#idusuario").val(json.idusuario);
            $("#nombre_usuario").val(json.nombre_usuario);
            $("#tipo_usuario").val(json.tipo_usuario);
            $("#login_usuario").val(json.login_usuario);
            $("#contrasena_usuario").val(json.contrasena_usuario);
            $("#idempleado").val(json.idempleado);
            if (json.nuevo === "true") {
                $("#botonAgregar").prop('disabled', false);
                $("#botonModificar").prop('disabled', true);
                $("#botonEliminar").prop('disabled', true);
                //siguienteCampo("#nombre_rubro", "#botonAgregar", true);
            } else {
                $("#botonAgregar").prop('disabled', true);
                //alert("hola");
                $("#botonModificar").prop('disabled', false);
                $("#botonEliminar").prop('disabled', false);
               // siguienteCampo("#nombre_rubro", "#botonModificar", true);
            }
        },
        error: function (e) {
            $("#mensajes").html("No se pudo recuperar los datos.");
            alert(datosFormulario);
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}
function buscarNombreUsuario() {
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: '../usuarios/jsp/buscarNombre.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            $("#contenidoBusqueda").css("display", "none");
            $("#formPrograma").validate();
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusqueda").html(json.contenido);
            
            $("#contenidoBusqueda").fadeIn("slow");
            
        },
        error: function (e) {
            $("#mensajes").html("No se pudo buscar registros.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}
function agregarUsuario() {
    var datosFormulario = $("#formPrograma").serialize();
    alert(datosFormulario);
    
    $.ajax({
        type: 'POST',
        url: '../usuarios/jsp/agregar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            //validarFormulario();
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarFormulario();
            $("#id_Usuario").focus();
            $("#id_Usuario").select();
            $.notify("Agregado correctamente", "success");
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
            $.notify("No se pudo agregar", "error");
        },
        complete: function (objeto, exito, error) {
            $("#id_Usuario").focus();
        }
    });
}
function modificarUsuario() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: '../usuarios/jsp/modificar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $.notify("Modificado correctamente", "success");
            //limpiarFormulario();
          $("#nombre_rubro").focus();
        },
        error: function (e) {
            $.notify("No se pudo modificar", "error");
        },
        complete: function (objeto, exito, error) {

        }
    });
}
function eliminarUsuario() {
    var datosFormulario = $("#formTabla").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../usuarios/jsp/eliminar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            //$.notify("Enviando datos al servidor", "success");
            
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            
            limpiarFormulario();
            $("#id_rubro").focus();
            $("#id_rubro").select();
            $.notify("Borrado correctamente", "success");
            

        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
            $.notify("Error del servidor", "error");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}




function limpiarFormulario() {

    //$("#idusuarioss").val("0");
    $("#nombre_Usuario").val("");
    $("#apellido_Usuario").val("");
    $("#celular_Usuario").val("");
    $("#ruc_Usuario").val("");
    $("#direccion_Usuario").val("");
    
}



function validarForm1(){
    var validacion = $("#formPrograma").validate();
    $("#botonCancelar").click(function(){
        validacion.destroy(); 
    });
                
    $("#botonCerrarModal1").click(function(){
        validacion.destroy(); 
    });
}

function generarId() {
    var datosFormulario = $("#formPrograma").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../usuarios/jsp/generarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            
        },
        success: function (json) {
            limpiarFormulario();
            $("#nombre_Usuario").focus();
            $("#nombre_Usuario").select();
            $("#idusuario").val(json.contenido);

        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}

function buscarNombreEmpleado() {
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: '../usuarios/jsp/buscarNombreEmpleado.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            $("#contenidoBusqueda").css("display", "none");
            $("#formPrograma").validate();
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusquedaEmpleados").html(json.contenido);
            
            $("#contenidoBusquedaEmpleados").fadeIn("slow");
            
        },
        error: function (e) {
            $("#mensajes").html("No se pudo buscar registros.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}