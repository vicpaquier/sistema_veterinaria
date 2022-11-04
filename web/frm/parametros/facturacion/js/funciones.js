
function verificarSesion(programa) {
    var url = '../../../jsp/verificarSesion.jsp';
    if (programa) {
        url = '../../../jsp/verificarSesion.jsp';
    }
    var datosFormulario = $("#formAcceso").serialize();
    $.ajax({
        type: 'POST',
        url: url,
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            if (json.activo === "false") {
                if (programa) {
                    location.href = "../../../index.html";
                } else {
                    location.href = "index.html";
                }
            }
            $("#snombre_empresa").html(json.nombre_empresa);
            $("#susuario_usuario").html(json.nombre_usuario);
            $("#idusuario").html(json.id_usuario);
            $("#mensajes").html(json.mensaje);
        },
        error: function (e) {
            $("#mensajes").html("ERROR: No se pudo recuperar la sesión.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}

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

function agregarDetalleFacturacion() {
    var datosFormulario = $("#formDetalle").serialize();
    alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: '../facturacion/jsp/agregarDetalle.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {

            $("#mensajes").html("Enviando datos al Servidor ...");
            

        },
        success: function (json) {
            
            $("#mensajes").html(json.mensaje);
            $('#btnguardar').removeAttr('disabled');
            
            
            $.notify("Servicio Agregado", "success");

        },
        error: function (e) {
            $("#mensajes").html("No se pudo agregar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}

function agregarCabeceraFacturacion() {
    var datosFormulario = $("#formCabecera").serialize();
    alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: '../facturacion/jsp/agregar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {

            $("#mensajes").html("Enviando datos al Servidor ...");

        },
        success: function (json) {
            //limpiarFormulario();
            $("#mensajes").html(json.mensaje);
            //$("#botonAgregar").prop('disabled', true);
            // $("#detalle").prop('hidden', false);
            $("#idfacturacion").val(json.id_pedido);
            $("#idcabecera").val(json.id_pedido);
            
//            habilitar detalle
            $("#container-detalle").css("background-color", "white");
            $('#servicio').removeAttr('disabled'); //Enable
            $('#cantidad').removeAttr('disabled');
            $('#btnagregar').removeAttr('disabled');
            
            
            $.notify("Cabecera Guardado", "success");
        },
        error: function (e) {
            $("#mensajes").html("No se pudo agregar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}

function buscar() {
    var datosFormulario = $("#formBuscar").serialize();
    alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: '../facturacion/jsp/buscarServicio.jsp',
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
            $("#mensajes").html("No se pudo agregar los datos.");
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

function buscarCliente() {
    var datosFormulario = $("#formBuscarCliente").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../facturacion/jsp/buscarCliente.jsp',
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

function buscarServicio() {
    var datosFormulario = $("#formBuscar").serialize();
    
    $.ajax({
        type: 'POST',
        url: '../facturacion/jsp/buscarServicio.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            //$("#contenidoBusquedaMascota").css("display", "none");
        },
        success: function (json) {
            //alert(json.contenido);
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

function agregarMascota() {
    var datosFormulario = $("#formProgramaMascota").serialize();

    alert(datosFormulario);
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


function validarForm1() {
    var validacion = $("#formPrograma").validate();
    $("#botonCancelar").click(function () {
        validacion.destroy();
    });

    $("#botonCerrarModal1").click(function () {
        validacion.destroy();
    });
}

function validarForm2() {
    var validacion = $("#formProgramaMascota").validate();
    $("#botonCancelarMascota").click(function () {
        validacion.destroy();
    });

    $("#botonCerrarModal2").click(function () {
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

