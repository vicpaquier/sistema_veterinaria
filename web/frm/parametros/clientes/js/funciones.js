

function buscarIdCliente() {
    var datosFormulario = $("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url: '../clientes/jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#idcliente").val(json.idcliente);
            $("#nombre_cliente").val(json.nombre_cliente);
            $("#apellido_cliente").val(json.apellido_cliente);
            $("#celular_cliente").val(json.celular_cliente);
            $("#ruc_cliente").val(json.ruc_cliente);
            $("#direccion_cliente").val(json.direccion_cliente);
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
        url: '../clientes/jsp/buscarNombre.jsp',
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
function agregarCliente() {
    var datosFormulario = $("#formPrograma").serialize();
    
    
    $.ajax({
        type: 'POST',
        url: '../clientes/jsp/agregar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            //validarFormulario();
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarFormulario();
            $("#id_cliente").focus();
            $("#id_cliente").select();
            $.notify("Agregado correctamente", "success");
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
            $.notify("No se pudo agregar", "error");
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
        url: '../clientes/jsp/modificar.jsp',
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
function eliminarCliente() {
    var datosFormulario = $("#formTabla").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../clientes/jsp/eliminar.jsp',
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
            //$.notify("Borrado correctamente", "success");
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

function eliminarMascota() {
    var datosFormulario = $("#formPrograma").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../clientes/jsp/eliminarMascota.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            
        },
        success: function (json) {
            $.notify("Borrado correctamente", "success");
            
            limpiarFormulario();
            $("#id_rubro").focus();
            $("#id_rubro").select();

        },
        error: function (e) {
            $.notify("No se pudo eliminar", "error");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}


function limpiarFormulario() {

    //$("#idclientess").val("0");
    $("#nombre_cliente").val("");
    $("#apellido_cliente").val("");
    $("#celular_cliente").val("");
    $("#ruc_cliente").val("");
    $("#direccion_cliente").val("");
    
}

function buscarNombreMascota() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: '../clientes/jsp/buscarNombreMascota.jsp',
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
        url: '../clientes/jsp/agregarMascota.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            //alert(datosFormulario);
        },
        success: function (json) {
            $.notify("Agregado correctamente correctamente", "success");
            //limpiarFormulario();
            $("#id_cliente").focus();
            $("#id_cliente").select();
        },
        error: function (e) {
            $.notify("No se pudo agregar", "error");
        },
        complete: function (objeto, exito, error) {
            $("#id_cliente").focus();
        }
    });
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

function validarForm2(){
    var validacion = $("#formProgramaMascota").validate();
    $("#botonCancelarMascota").click(function(){
        validacion.destroy(); 
    });
                
    $("#botonCerrarModal2").click(function(){
        validacion.destroy(); 
    });
}

function generarId() {
    var datosFormulario = $("#formPrograma").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../clientes/jsp/generarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            
        },
        success: function (json) {
            limpiarFormulario();
            $("#nombre_cliente").focus();
            $("#nombre_cliente").select();
            $("#idcliente").val(json.contenido);

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

function generarIdMascota() {
    var datosFormulario = $("#formProgramaMascota").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../clientes/jsp/generarIdMascota.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            
        },
        success: function (json) {
            limpiarFormulario();
            
            $("#idmascota").val(json.contenido);

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

