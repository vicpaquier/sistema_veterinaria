<%@page import="controladores.AgendamientosControlador"%>
<%@page import="modelos.Agendamientos"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    
    
    String contenido = AgendamientosControlador.vencimientos();
   
    
JSONObject obj = new JSONObject();
obj.put("mensaje", "Sesi�n del Usuario cerrada.");
obj.put("contenido", contenido);
out.print(obj);
out.flush();
%>
