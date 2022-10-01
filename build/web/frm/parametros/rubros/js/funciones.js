function buscarIdCliente() {
    var datosFormulario = $("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url: 'rubros/jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_rubro").val(json.id_rubro);
            $("#cli_nombre").val(json.cli_nombre);
            $("#cli_apellido").val(json.cli_apellido);
            $("#cli_ci").val(json.cli_ci);
            $("#cli_dv").val(json.cli_dv);
            $("#cli_ciudad").val(json.cli_ciudad);
            $("#cli_departamento").val(json.cli_departamento);
            $("#cli_direccion").val(json.cli_direccion);
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
function buscarNombreCliente() {
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: 'rubros/jsp/buscarNombre.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            $("#contenidoBusqueda").css("display", "none");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusqueda").html(json.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
//            $("tbody tr").on("click", function () {
//                var id = $(this).find("td:first").html();
//                $("#panelBuscar").html("");
//                $("#id_cliente").val(id);
//                $("#nombre_rubro").focus();
//                buscarIdRubro();
//                $("#buscar").fadeOut("slow");
//                $("#panelPrograma").fadeIn("slow");
//            });
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
function agregarCliente() {
    var datosFormulario = $("#formPrograma").serialize();
    
    //alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: 'rubros/jsp/agregar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarFormulario();
            $("#id_cliente").focus();
            $("#id_cliente").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {
            $("#id_cliente").focus();
        }
    });
}
function modificarCliente() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'rubros/jsp/modificar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            //limpiarFormulario();
          $("#nombre_rubro").focus();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {

        }
    });
}
function eliminarCliente() {
    var datosFormulario = $("#formTabla").serialize();
    
    $.ajax({
        type: 'POST',
        url: 'rubros/jsp/eliminar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            
            limpiarFormulario();
            $("#id_rubro").focus();
            $("#id_rubro").select();

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

function eliminarMascota() {
    var datosFormulario = $("#formPrograma").serialize();
    
    $.ajax({
        type: 'POST',
        url: 'rubros/jsp/eliminarMascota.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            
            limpiarFormulario();
            $("#id_rubro").focus();
            $("#id_rubro").select();

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

function validarFormulario() {
    var valor = true;
    if ($("#nombre_rubro").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Nombre no puede estar vacio.");
        $("#nombre_rubro").focus();
    }
    return valor;
}
function limpiarFormulario() {

    $("#id_rubro").val("0");
    $("#nombre_rubro").val("");
    
}

function buscarNombreMascota() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'rubros/jsp/buscarNombreMascota.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            $("#contenidoBusquedaMascota").css("display", "none");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusquedaMascota").html(json.contenido);
            $("#contenidoBusquedaMascota").fadeIn("slow");
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

function agregarMascota() {
    var datosFormulario = $("#formProgramaMascota").serialize();
    
    //alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: 'rubros/jsp/agregarMascota.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            //alert(datosFormulario);
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarFormulario();
            $("#id_cliente").focus();
            $("#id_cliente").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {
            $("#id_cliente").focus();
        }
    });
}
