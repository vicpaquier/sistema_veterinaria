<%@page import="modelos.DetallesCobros"%>
<%@page import="controladores.CobrosControlador"%>
<%@page import="modelos.DetallesFacturacion"%>
<%@page import="modelos.Servicios"%>
<%@page import="modelos.Usuarios"%>
<%@page import="modelos.Cobros"%>
<%@page import="utiles.Utiles"%>
<%@page import="controladores.DetalleFacturacionControlador"%>
<%@page import="modelos.Facturacion"%>
<%@page import="modelos.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%

   
    int idfacturacion = Integer.parseInt(request.getParameter("idfacturacion_cobro"));
    String metodo_pago = request.getParameter("rbnmetodo_pago");
    String estado = request.getParameter("estado");
    int idusuario = Integer.parseInt(request.getParameter("usuario"));
    
    String tipo = "error";
    String mensaje = "La factura ya está cobrada";

    DetallesFacturacion detallesfacturacion = new DetallesFacturacion();
    
    DetallesCobros detallescobros = new DetallesCobros();
    
    Usuarios usuarios = new Usuarios();
    usuarios.setIdusuario(idusuario);
    
    Facturacion facturacion = new Facturacion();
    detallesfacturacion.setFacturacion(facturacion);
    facturacion.setId_facturacion(idfacturacion);
    detallescobros.setFacturacion(facturacion);
    
    int total_factura = CobrosControlador.totales(detallescobros);
    
    
    
    Cobros cobros = new Cobros();
    cobros.setUsuarios(usuarios);
    
    detallescobros.setTotal_factura(total_factura);
    detallescobros.setMetodo_pago(metodo_pago);
    detallescobros.setDetallesfacturacion(detallesfacturacion);
    detallescobros.setCobro(cobros);
    
    System.out.println(estado);
    
    if(estado.equals("PENDIENTE")){
        if(CobrosControlador.agregar_cabecera(cobros)){
            if (CobrosControlador.agregar_detalle(detallescobros)) {
                tipo = "success";
                mensaje = "Cobrado correctamente";
                if(DetalleFacturacionControlador.modificar_estado(detallesfacturacion)){
                    estado = "COBRADO";
                }
            }
        }
    }
    

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("estado", estado);
    out.print(obj);
    out.flush();

%>