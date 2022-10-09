
<%@page import="controladores.EmpleadosControlador"%>
<%@page import="modelos.Empleados"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idempleado = Integer.parseInt(request.getParameter("idempleado"));
    String nombre_empleado = request.getParameter("nombre_empleado");
    String apellido_empleado = request.getParameter("apellido_empleado");
    String celular_empleado = request.getParameter("celular_empleado");
    String ruc_empleado = request.getParameter("ruc_empleado");
    
    String tipo = "error";
    String mensaje = "Datos no modificados.";
    
    Empleados empleado = new Empleados();
    
    empleado.setIdempleado(idempleado);
    empleado.setNombre_empleado(nombre_empleado);
    empleado.setApellido_empleado(apellido_empleado);
    empleado.setCelular_empleado(celular_empleado);
    empleado.setRuc_empleado(ruc_empleado);
    
    if (EmpleadosControlador.modificar(empleado)) {
        tipo = "success";
        mensaje = "Datos modificados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>