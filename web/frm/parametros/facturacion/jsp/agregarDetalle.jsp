<%@page import="modelos.DetallesFacturacion"%>
<%@page import="modelos.Servicios"%>
<%@page import="modelos.Usuarios"%>
<%@page import="utiles.Utiles"%>
<%@page import="controladores.DetalleFacturacionControlador"%>
<%@page import="modelos.Facturacion"%>
<%@page import="modelos.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%

    int idservicio = Integer.parseInt(request.getParameter("idservicio"));
    int cantidad = Integer.parseInt(request.getParameter("cantidad"));
    int idcabecera = Integer.parseInt(request.getParameter("idcabecera"));
    
    //java.sql.Date fecha_pedido = Utiles.stringToSqlDate(sfecha_pedido);

    String tipo = "error";
    String mensaje = "Datos no agregados.";

    Servicios servicio = new Servicios();
    servicio.setIdservicio(idservicio);
    
    Facturacion facturacion = new Facturacion();
    facturacion.setId_facturacion(idcabecera);
    
    
    DetallesFacturacion detallesfacturacion = new DetallesFacturacion();
    detallesfacturacion.setCantidad_detallefacturacion(cantidad);
    detallesfacturacion.setFacturacion(facturacion);
    detallesfacturacion.setServicio(servicio);

    if (DetalleFacturacionControlador.agregar(detallesfacturacion)) {
        tipo = "success";
        mensaje = "Datos agregados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();

%>