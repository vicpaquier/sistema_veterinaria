
<%@page import="controladores.AgendamientosControlador"%>
<%@page import="controladores.DetalleFacturacionControlador"%>
<%@page import="controladores.FacturacionControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    String cli_nombre = request.getParameter("bem_nombre");
    int pagina = 1;
    
    
    String mensaje = "Búsqueda exitosa.";
    String contenido = AgendamientosControlador.buscarEmpleados(cli_nombre, pagina);
    
    JSONObject obj = new JSONObject();
    obj.put("mensaje",mensaje);
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();
%>