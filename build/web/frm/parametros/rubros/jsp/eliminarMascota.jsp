

<%@page import="controladores.RubrosControlador"%>
<%@page import="modelos.Rubros"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_mascota = Integer.parseInt(request.getParameter("inputidMascota"));

    String tipo = "error";
    String mensaje = "Datos no eliminados.";
    
    Rubros rubro = new Rubros();
    rubro.setId_mascota(id_mascota);
    
    if (RubrosControlador.eliminarMascota(rubro)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();

%>