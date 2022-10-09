<%@page import="modelos.Servicios"%>
<%@page import="controladores.ServiciosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idservicio = Integer.parseInt(request.getParameter("idservicio"));
    String descripcion_servicio = request.getParameter("descripcion_servicio");
    int precio_servicio = Integer.parseInt(request.getParameter("precio_servicio"));
    String iva_servicio = request.getParameter("iva_servicio");
    
    
    String tipo = "error";
    String mensaje = "Datos no agregados.";
    
    Servicios servicio = new Servicios();
    
    servicio.setIdservicio(idservicio);
    servicio.setDescripcion_servicio(descripcion_servicio);
    servicio.setPrecio_servicio(precio_servicio);
    servicio.setIva_servicio(iva_servicio);
    
    if (ServiciosControlador.agregar(servicio)) {
        tipo = "success";
        mensaje = "Datos agregados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>