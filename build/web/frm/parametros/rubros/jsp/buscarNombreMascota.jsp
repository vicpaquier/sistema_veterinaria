

<%@page import="controladores.RubrosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    String nombre_mascota = request.getParameter("bcli_nombre");
    String id_cliente = request.getParameter("id_cliente");
    int pagina = 1;
    
    
    String mensaje = "Búsqueda exitosa.";
    String contenido = RubrosControlador.buscarNombreMascota(nombre_mascota, pagina, id_cliente);
    
    JSONObject obj = new JSONObject();
    obj.put("mensaje",mensaje);
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();
%>