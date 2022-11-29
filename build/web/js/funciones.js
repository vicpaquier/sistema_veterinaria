function siguienteCampo(actual, siguiente, preventDefault) {
    $(actual).keydown(function (event) {
        if (event.which === 13) {
            if (preventDefault) {
                event.preventDefault();
            }
            $(siguiente).focus();
            $(siguiente).select();
        }
    });
}
function enterCampo(actual, ejecutar) {
    $(actual).keydown(function (event) {
        if (event.which === 13) {
            eval(ejecutar);
        }
    });
}
function validarAcceso() {
    $("mensajes").html("Mensajes del Sistema");
    if ($("usuario_usuario").val() === "") {
        $("mensajes").html("Usuario no debe estar vacio.");
        setTimeout(' location.reload()', 1500);
    } else if ($("password_usuario").val() === "") {
        $("mensajes").html("Clave no debe estar vacio.");
        setTimeout(' location.reload()', 1500);
    } else {
        validarAccesoAjax();
    }
}
function validarAccesoAjax() {
    var datosFormulario = $("#formAcceso").serialize();
    //alert(datosFormulario);
//alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: 'jsp/validarAcceso.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            if (json.acceso === "true") {
                location.href = "menu.html";
            } else {
                $("#mensajes").html("Credencial Invalida");
                setTimeout(' location.reload()', 1500);
            }
        },
        error: function (e) {
            $("#mensajes").html("No se pudo conectar con el servidor Error:" + e.status);
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}
function verificarSesion(programa) {
    var url = 'jsp/verificarSesion.jsp';
    if (programa) {
        url = '../../../../jsp/verificarSesion.jsp';
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
            $("#idusuario").val(json.id_usuario);
            $("#usuario_nombre").val(json.id_usuario);
            $("#mensajes").html(json.mensaje);
            $("#usu_form").val(json.idusuario);
            $("#usu_form2").val(json.nombre_usuario);
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
function cerrarSesion() {
    var datosFormulario = $("#formAcceso").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/cerrarSesion.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html("Sesión Cerrada.");
        },
        error: function (e) {
            $("#mensajes").html("No se pudo cerrar la sesión.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}

//verificar citas vencidas
function  verificarAgenda() {
    var datosFormulario = $("#formAcceso").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/verificarAgenda.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html("Sesión Cerrada.");
            $("#valor").val(json.contenido);
            $("#contenido").html("Agendamientos vencidos: "+json.contenido);
        },
        error: function (e) {
            $("#mensajes").html("No se pudo cerrar la sesión.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}