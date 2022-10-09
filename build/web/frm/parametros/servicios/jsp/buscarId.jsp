
<%@page import="controladores.ServiciosControlador"%>
<%@page import="modelos.Servicios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idservicio = Integer.parseInt(request.getParameter("idservicio"));
    
   
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    Servicios servicio=new Servicios();
    servicio.setIdservicio(idservicio);
    servicio=ServiciosControlador.buscarId(servicio);
    if(servicio.getIdservicio()!=0){
        tipo="success";
        mensaje="Datos encontrados";
        nuevo="false";
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    obj.put("idservicio", servicio.getIdservicio());
    obj.put("descripcion_servicio", servicio.getDescripcion_servicio());
    obj.put("precio_servicio", servicio.getPrecio_servicio());
    obj.put("iva_servicio", servicio.getIva_servicio());
    
    out.print(obj);
    out.flush();
%>