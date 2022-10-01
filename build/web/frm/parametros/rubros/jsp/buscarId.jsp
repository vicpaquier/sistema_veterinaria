
<%@page import="controladores.RubrosControlador"%>
<%@page import="modelos.Rubros"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
    
   
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    Rubros cliente=new Rubros();
    cliente.setId_cliente(id_cliente);
    cliente=RubrosControlador.buscarId(cliente);
    if(cliente.getId_cliente()!=0){
        tipo="success";
        mensaje="Datos encontrados";
        nuevo="false";
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    obj.put("id_cliente", cliente.getId_cliente());
    obj.put("cli_nombre", cliente.getCli_nombre());
    obj.put("cli_apellido", cliente.getCli_apellido());
    obj.put("cli_ci", cliente.getCli_ci());
    obj.put("cli_dv", cliente.getCli_dv());
    obj.put("cli_ciudad", cliente.getCli_ciudad());
    obj.put("cli_departamento", cliente.getCli_departamento());
    obj.put("cli_direccion", cliente.getCli_direccion());
    
    out.print(obj);
    out.flush();
%>