function buscarCliente() {
    var datosFormulario = $("#formBuscarCliente").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../agendamientos/jsp/buscarCliente.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            //$("#contenidoBusquedaMascota").css("display", "none");
        },
        success: function (json) {
            
            //alert(json.contenido);
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusquedaClientes").html(json.contenido);
            
            $("#contenidoBusquedaClientes").fadeIn("slow");
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

function buscarEmpleado() {
    var datosFormulario = $("#formBuscarEmpleado").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../agendamientos/jsp/buscarEmpleado.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            //$("#contenidoBusquedaMascota").css("display", "none");
        },
        success: function (json) {
            
            //alert(json.contenido);
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

function buscarIdAgendamiento() {
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
function buscarNombreAgendamiento() {
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: '../agendamientos/jsp/buscarNombre.jsp',
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
function agregarAgendamiento() {
    var datosFormulario = $("#formPrograma").serialize();
    alert(datosFormulario);
    
    $.ajax({
        type: 'POST',
        url: '../agendamientos/jsp/agregar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            //validarFormulario();
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            //limpiarFormulario();
            $("#id_Agendamiento").focus();
            $("#id_Agendamiento").select();
            $.notify("Agregado correctamente", "success");
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
            $.notify("No se pudo agregar", "error");
        },
        complete: function (objeto, exito, error) {
            $("#id_Agendamiento").focus();
        }
    });
}
function modificarAgendamiento() {
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
function eliminarAgendamiento() {
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
    $("#nombre_Agendamiento").val("");
    $("#apellido_Agendamiento").val("");
    $("#celular_Agendamiento").val("");
    $("#ruc_Agendamiento").val("");
    $("#direccion_Agendamiento").val("");
    
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
            $("#nombre_Agendamiento").focus();
            $("#nombre_Agendamiento").select();
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