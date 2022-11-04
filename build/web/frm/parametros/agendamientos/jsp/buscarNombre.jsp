

<%@page import="controladores.AgendamientosControlador"%>
<%@page import="controladores.UsuariosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    String cli_nombre = request.getParameter("bag_nombre");
    String cli_nombre2 = request.getParameter("bag_nombre2");
    int pagina = 1;
    
    
    String mensaje = "Búsqueda exitosa.";
    String contenido = AgendamientosControlador.buscarNombre(cli_nombre, cli_nombre2,pagina);
    
    JSONObject obj = new JSONObject();
    obj.put("mensaje",mensaje);
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();
%>