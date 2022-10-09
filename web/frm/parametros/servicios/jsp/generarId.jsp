

<%@page import="controladores.ServiciosControlador"%>
<%@page import="modelos.Servicios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
   
    
    //Servicios servicio = new Servicios();
    //servicio.setIdmascota(idmascota);
    
    String contenido = ServiciosControlador.generarIdservicio();
   
    
    JSONObject obj = new JSONObject();
    
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();    
%>