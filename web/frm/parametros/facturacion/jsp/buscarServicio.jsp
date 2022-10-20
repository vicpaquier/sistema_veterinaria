

<%@page import="controladores.DetalleFacturacionControlador"%>
<%@page import="controladores.FacturacionControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    String descripcion = request.getParameter("bcli_descripcion");
    int pagina = 1;
    
    
    String mensaje = "Búsqueda exitosa.";
    String contenido = DetalleFacturacionControlador.buscarServicio(descripcion, pagina);
    
    JSONObject obj = new JSONObject();
    obj.put("mensaje",mensaje);
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();
%>