<%@page import="modelos.Clientes"%>
<%@page import="modelos.Empleados"%>
<%@page import="modelos.Agendamientos"%>
<%@page import="controladores.AgendamientosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    //int idagendamiento = Integer.parseInt(request.getParameter("idagendamiento"));
    int idempleado = Integer.parseInt(request.getParameter("idempleado"));
    int idcliente = Integer.parseInt(request.getParameter("idcliente"));
    String fecha_agendamiento = request.getParameter("fecha_agendamiento");
    
    String fecha_formateado = fecha_agendamiento.replace("T", " ");
    
    
    
    String tipo = "error";
    String mensaje = "Datos no agregados.";
    
    Empleados empleados = new Empleados();
    empleados.setIdempleado(idempleado);
    
    Clientes clientes = new Clientes();
    clientes.setIdcliente(idcliente);
    
    Agendamientos agendamiento = new Agendamientos();
    //agendamiento.setIdagendamiento(idagendamiento);
    agendamiento.setFecha_agendamiento(fecha_formateado);
    agendamiento.setEmpleados(empleados);
    agendamiento.setClientes(clientes);
    if (AgendamientosControlador.agregar(agendamiento)) {
        tipo = "success";
        mensaje = "Datos agregados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>