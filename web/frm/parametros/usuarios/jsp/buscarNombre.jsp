

<%@page import="controladores.UsuariosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    String cli_nombre = request.getParameter("bcli_nombre");
    int pagina = 1;
    
    
    String mensaje = "Búsqueda exitosa.";
    String contenido = UsuariosControlador.buscarNombre(cli_nombre, pagina);
    
    JSONObject obj = new JSONObject();
    obj.put("mensaje",mensaje);
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();
%>