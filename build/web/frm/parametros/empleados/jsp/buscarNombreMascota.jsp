

<%@page import="controladores.ClientesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    String nombre_mascota = request.getParameter("bcli_nombre");
    String idcliente = request.getParameter("idcliente");
    int pagina = 1;
    
    
    String mensaje = "Búsqueda exitosa.";
    String contenido = ClientesControlador.buscarNombreMascota(nombre_mascota, pagina, idcliente);
    
    JSONObject obj = new JSONObject();
    obj.put("mensaje",mensaje);
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();
%>