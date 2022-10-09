

<%@page import="controladores.ServiciosControlador"%>
<%@page import="modelos.Servicios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idservicio = Integer.parseInt(request.getParameter("inputid"));

    System.out.println(idservicio);
    String tipo = "error";
    String mensaje = "Datos no eliminados.";
    
    Servicios servicio = new Servicios();
    servicio.setIdservicio(idservicio);
    
    if (ServiciosControlador.eliminar(servicio)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();

%>