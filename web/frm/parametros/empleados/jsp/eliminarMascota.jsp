

<%@page import="controladores.ClientesControlador"%>
<%@page import="modelos.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idmascota = Integer.parseInt(request.getParameter("inputidMascota"));

    String tipo = "error";
    String mensaje = "Datos no eliminados.";
    
    Clientes cliente = new Clientes();
    cliente.setIdmascota(idmascota);
    
    if (ClientesControlador.eliminarMascota(cliente)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();

%>