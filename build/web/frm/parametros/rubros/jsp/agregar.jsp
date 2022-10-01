

<%@page import="modelos.Rubros"%>
<%@page import="controladores.RubrosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
    String cli_nombre = request.getParameter("cli_nombre");
    String cli_apellido = request.getParameter("cli_apellido");
    int cli_ci = Integer.parseInt(request.getParameter("cli_ci"));
    int cli_dv = Integer.parseInt(request.getParameter("cli_dv"));
    String cli_ciudad = request.getParameter("cli_ciudad");
    String cli_departamento = request.getParameter("cli_departamento");
    String cli_direccion = request.getParameter("cli_direccion");
    
    

     
    String tipo = "error";
    String mensaje = "Datos no agregados.";
    
    Rubros rubro = new Rubros();
    
    rubro.setId_cliente(id_cliente);
    rubro.setCli_nombre(cli_nombre);
    rubro.setCli_apellido(cli_apellido);
    rubro.setCli_ci(cli_ci);
    rubro.setCli_dv(cli_dv);
    rubro.setCli_ciudad(cli_ciudad);
    rubro.setCli_departamento(cli_departamento);
    rubro.setCli_direccion(cli_direccion);
    
    if (RubrosControlador.agregar(rubro)) {
        tipo = "success";
        mensaje = "Datos agregados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>