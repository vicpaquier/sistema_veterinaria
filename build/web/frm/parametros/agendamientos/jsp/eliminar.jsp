

<%@page import="controladores.UsuariosControlador"%>
<%@page import="modelos.Usuarios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idusuario = Integer.parseInt(request.getParameter("inputid"));

    System.out.println(idusuario);
    String tipo = "error";
    String mensaje = "Datos no eliminados.";
    
    Usuarios usuario = new Usuarios();
    usuario.setIdusuario(idusuario);
    
    if (UsuariosControlador.eliminar(usuario)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();

%>