<%@page import="modelos.Empleados"%>
<%@page import="modelos.Usuarios"%>
<%@page import="controladores.UsuariosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idusuario = Integer.parseInt(request.getParameter("idusuario"));
    int empleado_idempleados_fk = Integer.parseInt(request.getParameter("idempleado"));
    String tipo_usuario = request.getParameter("tipo_usuario");
    String contra_usuario = request.getParameter("contrasena_usuario");
    String login_usuario = request.getParameter("login_usuario");
    
    
    
    String tipo = "error";
    String mensaje = "Datos no agregados.";
    
    Empleados empleados = new Empleados();
    empleados.setIdempleado(empleado_idempleados_fk);
    
    Usuarios usuario = new Usuarios();
    usuario.setIdusuario(idusuario);
    usuario.setTipo_usuario(tipo_usuario);
    usuario.setContra_usuario(contra_usuario);
    usuario.setLogin_usuario(login_usuario);
    usuario.setEmpleados(empleados);
    if (UsuariosControlador.agregar(usuario)) {
        tipo = "success";
        mensaje = "Datos agregados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>