

function buscarIdEmpleado() {
    var datosFormulario = $("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url: '../empleados/jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#idempleado").val(json.idempleado);
            $("#nombre_empleado").val(json.nombre_empleado);
            $("#apellido_empleado").val(json.apellido_empleado);
            $("#celular_empleado").val(json.celular_empleado);
            $("#ruc_empleado").val(json.ruc_empleado);
            $("#direccion_empleado").val(json.direccion_empleado);
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
        url: '../empleados/jsp/buscarNombre.jsp',
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
function agregarEmpleado() {
    var datosFormulario = $("#formPrograma").serialize();
    
    
    $.ajax({
        type: 'POST',
        url: '../empleados/jsp/agregar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            //validarFormulario();
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarFormulario();
            $("#id_empleado").focus();
            $("#id_empleado").select();
            $.notify("Agregado correctamente", "success");
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
            $.notify("No se pudo agregar", "error");
        },
        complete: function (objeto, exito, error) {
            $("#id_empleado").focus();
        }
    });
}
function modificarEmpleado() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: '../empleados/jsp/modificar.jsp',
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
function eliminarEmpleado() {
    var datosFormulario = $("#formTabla").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../empleados/jsp/eliminar.jsp',
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

    //$("#idempleadoss").val("0");
    $("#nombre_empleado").val("");
    $("#apellido_empleado").val("");
    $("#celular_empleado").val("");
    $("#ruc_empleado").val("");
    $("#direccion_empleado").val("");
    
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
        url: '../empleados/jsp/generarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            
        },
        success: function (json) {
            limpiarFormulario();
            $("#nombre_empleado").focus();
            $("#nombre_empleado").select();
            $("#idempleado").val(json.contenido);

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