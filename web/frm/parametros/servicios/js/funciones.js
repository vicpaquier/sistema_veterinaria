function buscarIdServicio() {
    var datosFormulario = $("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url: '../servicios/jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#idservicio").val(json.idservicio);
            $("#descripcion_servicio").val(json.descripcion_servicio);
            $("#precio_servicio").val(json.precio_servicio);
            $("#iva_servicio").val(json.iva_servicio);
            if (json.nuevo === "true") {
                $("#botonAgregar").prop('disabled', false);
                $("#botonModificar").prop('disabled', true);
                $("#botonEliminar").prop('disabled', true);
                //siguienteCampo("#descripcion_rubro", "#botonAgregar", true);
            } else {
                $("#botonAgregar").prop('disabled', true);
                //alert("hola");
                $("#botonModificar").prop('disabled', false);
                $("#botonEliminar").prop('disabled', false);
               // siguienteCampo("#descripcion_rubro", "#botonModificar", true);
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
function buscarDescripcionServicio() {
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: '../servicios/jsp/buscarDescripcion.jsp',
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
function agregarServicio() {
    var datosFormulario = $("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url: '../servicios/jsp/agregar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            //validarFormulario();
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarFormulario();
            $("#id_servicio").focus();
            $("#id_servicio").select();
            $.notify("Agregado correctamente", "success");
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
            $.notify("No se pudo agregar", "error");
        },
        complete: function (objeto, exito, error) {
            $("#id_servicio").focus();
        }
    });
}
function modificarServicio() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: '../servicios/jsp/modificar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $.notify("Modificado correctamente", "success");
            //limpiarFormulario();
          $("#descripcion_rubro").focus();
        },
        error: function (e) {
            $.notify("No se pudo modificar", "error");
        },
        complete: function (objeto, exito, error) {

        }
    });
}
function eliminarServicio() {
    var datosFormulario = $("#formTabla").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../servicios/jsp/eliminar.jsp',
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
            $.notify(json.mensaje, json.tipo);
            

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

    //$("#idservicioss").val("0");
    $("#descripcion_servicio").val("");
    $("#apellido_servicio").val("");
    $("#celular_servicio").val("");
    $("#ruc_servicio").val("");
    $("#direccion_servicio").val("");
    
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
        url: '../servicios/jsp/generarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            
        },
        success: function (json) {
            limpiarFormulario();
            $("#descripcion_servicio").focus();
            $("#descripcion_servicio").select();
            $("#idservicio").val(json.contenido);

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