
<%@page import="modelos.Usuarios"%>
<%@page import="utiles.Utiles"%>
<%@page import="controladores.FacturacionControlador"%>
<%@page import="modelos.Facturacion"%>
<%@page import="modelos.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%

    int id_usuario = Integer.parseInt(request.getParameter("idusuario"));
    int id_cliente = Integer.parseInt(request.getParameter("idcliente"));
    //String condicion_facturacion = request.getParameter("condicion_facturacion");
    String estado_facturacion = request.getParameter("estado_facturacion");
    String numero_facturacion = request.getParameter("numero_facturacion");
    String fecha_facturacion = request.getParameter("fecha_facturacion");
    String condicion_facturacion = request.getParameter("rbncondicion");
        
    
    //java.sql.Date fecha_pedido = Utiles.stringToSqlDate(sfecha_pedido);

    String tipo = "error";
    String mensaje = "Datos no agregados.";

    Clientes cliente = new Clientes();
    cliente.setIdcliente(id_cliente);
    
    Usuarios usuario = new Usuarios();
    usuario.setIdusuario(id_usuario);

    Facturacion facturacion = new Facturacion();
    facturacion.setNumero_facturacion(numero_facturacion);
    facturacion.setEstado_facturacion(estado_facturacion);
    facturacion.setFecha_facturacion(fecha_facturacion);
    facturacion.setCondicion_facturacion(condicion_facturacion);
    facturacion.setCliente(cliente);
    facturacion.setUsuario(usuario);

    if (FacturacionControlador.agregar(facturacion)) {
        tipo = "success";
        mensaje = "Datos agregados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("id_pedido", String.valueOf(facturacion.getId_facturacion()));
    out.print(obj);
    out.flush();

%>