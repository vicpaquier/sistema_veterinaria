
<%@page import="controladores.ServiciosControlador"%>
<%@page import="modelos.Servicios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idservicio = Integer.parseInt(request.getParameter("idservicio"));
    String descripcion_servicio = request.getParameter("descripcion_servicio");
    String precio_servicio = request.getParameter("precio_servicio");
    String iva_servicio = request.getParameter("iva_servicio");
    
    String tipo = "error";
    String mensaje = "Datos no modificados.";
    
    Servicios servicio = new Servicios();
    
    servicio.setIdservicio(idservicio);
    servicio.setDescripcion_servicio(descripcion_servicio);
    servicio.setPrecio_servicio(precio_servicio);
    servicio.setIva_servicio(iva_servicio);
    
    if (ServiciosControlador.modificar(servicio)) {
        tipo = "success";
        mensaje = "Datos modificados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>