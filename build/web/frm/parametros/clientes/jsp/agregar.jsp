<%@page import="modelos.Clientes"%>
<%@page import="controladores.ClientesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idcliente = Integer.parseInt(request.getParameter("idcliente"));
    String nombre_cliente = request.getParameter("nombre_cliente");
    String apellido_cliente = request.getParameter("apellido_cliente");
    String celular_cliente = request.getParameter("celular_cliente");
    String direccion_cliente = request.getParameter("direccion_cliente");
    String ruc_cliente = request.getParameter("ruc_cliente");
    
    
    

     
    String tipo = "error";
    String mensaje = "Datos no agregados.";
    
    Clientes cliente = new Clientes();
    
    cliente.setIdcliente(idcliente);
    cliente.setNombre_cliente(nombre_cliente);
    cliente.setApellido_cliente(apellido_cliente);
    cliente.setCelular_cliente(celular_cliente);
    cliente.setDireccion_cliente(direccion_cliente);
    cliente.setRuc_cliente(ruc_cliente);
    
    if (ClientesControlador.agregar(cliente)) {
        tipo = "success";
        mensaje = "Datos agregados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>