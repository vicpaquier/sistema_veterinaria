

<%@page import="controladores.RubrosControlador"%>
<%@page import="modelos.Rubros"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_cliente = Integer.parseInt(request.getParameter("inputid"));

    System.out.println(id_cliente);
    String tipo = "error";
    String mensaje = "Datos no eliminados.";
    
    Rubros rubro = new Rubros();
    rubro.setId_cliente(id_cliente);
    
    if (RubrosControlador.eliminar(rubro)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();

%>