
<%@page import="controladores.DetalleFacturacionControlador"%>
<%@page import="modelos.DetallesFacturacion"%>
<%@page import="controladores.EmpleadosControlador"%>
<%@page import="modelos.Empleados"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id = Integer.parseInt(request.getParameter("inputidDetalle"));
    //System.out.println(idempleado);
    String tipo = "error";
    String mensaje = "Datos no eliminados.";
    
    DetallesFacturacion detallesfacturacion = new DetallesFacturacion();
    detallesfacturacion.setIddetallefacturacion(id);
    
    if (DetalleFacturacionControlador.eliminar(detallesfacturacion)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();

%>