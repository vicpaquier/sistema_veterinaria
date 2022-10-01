

<%@page import="controladores.ClientesControlador"%>
<%@page import="modelos.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idcliente = Integer.parseInt(request.getParameter("inputid"));

    System.out.println(idcliente);
    String tipo = "error";
    String mensaje = "Datos no eliminados.";
    
    Clientes cliente = new Clientes();
    cliente.setIdcliente(idcliente);
    
    if (ClientesControlador.eliminar(cliente)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();

%>