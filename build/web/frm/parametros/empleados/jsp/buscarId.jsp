
<%@page import="controladores.ClientesControlador"%>
<%@page import="modelos.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idcliente = Integer.parseInt(request.getParameter("idcliente"));
    
   
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    Clientes cliente=new Clientes();
    cliente.setIdcliente(idcliente);
    cliente=ClientesControlador.buscarId(cliente);
    if(cliente.getIdcliente()!=0){
        tipo="success";
        mensaje="Datos encontrados";
        nuevo="false";
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    obj.put("idcliente", cliente.getIdcliente());
    obj.put("nombre_cliente", cliente.getNombre_cliente());
    obj.put("apellido_cliente", cliente.getApellido_cliente());
    obj.put("celular_cliente", cliente.getCelular_cliente());
    obj.put("ruc_cliente", cliente.getRuc_cliente());
    obj.put("direccion_cliente", cliente.getDireccion_cliente());
    
    out.print(obj);
    out.flush();
%>