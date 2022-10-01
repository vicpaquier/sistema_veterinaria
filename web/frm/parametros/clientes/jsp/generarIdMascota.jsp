

<%@page import="controladores.ClientesControlador"%>
<%@page import="modelos.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
   
    
    Clientes cliente = new Clientes();
    //cliente.setIdmascota(idmascota);
    
    String contenido = ClientesControlador.generarIdmascota();
   
    
    JSONObject obj = new JSONObject();
    
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();    
%>