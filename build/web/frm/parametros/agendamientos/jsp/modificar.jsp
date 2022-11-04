
<%@page import="controladores.UsuariosControlador"%>
<%@page import="modelos.Usuarios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idusuario = Integer.parseInt(request.getParameter("idusuario"));
    String nombre_usuario = request.getParameter("nombre_usuario");
    String apellido_usuario = request.getParameter("apellido_usuario");
    String celular_usuario = request.getParameter("celular_usuario");
    String ruc_usuario = request.getParameter("ruc_usuario");
    
    String tipo = "error";
    String mensaje = "Datos no modificados.";
    
    Usuarios usuario = new Usuarios();
    
    usuario.setIdusuario(idusuario);
    usuario.setNombre_usuario(nombre_usuario);
    usuario.setApellido_usuario(apellido_usuario);
    usuario.setCelular_usuario(celular_usuario);
    usuario.setRuc_usuario(ruc_usuario);
    
    if (UsuariosControlador.modificar(usuario)) {
        tipo = "success";
        mensaje = "Datos modificados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>