

<%@page import="controladores.EmpleadosControlador"%>
<%@page import="modelos.Empleados"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
   
    
    Empleados empleado = new Empleados();
    //empleado.setIdmascota(idmascota);
    
    String contenido = EmpleadosControlador.generarIdempleado();
   
    
    JSONObject obj = new JSONObject();
    
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();    
%>