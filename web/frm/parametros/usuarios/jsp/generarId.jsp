

<%@page import="controladores.UsuariosControlador"%>
<%@page import="modelos.Usuarios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
   
    
    Usuarios usuario = new Usuarios();
    //usuario.setIdmascota(idmascota);
    
    String contenido = UsuariosControlador.generarIdusuario();
   
    
    JSONObject obj = new JSONObject();
    
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();    
%>