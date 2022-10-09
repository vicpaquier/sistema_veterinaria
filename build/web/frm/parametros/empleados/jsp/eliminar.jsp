

<%@page import="controladores.EmpleadosControlador"%>
<%@page import="modelos.Empleados"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idempleado = Integer.parseInt(request.getParameter("inputid"));

    System.out.println(idempleado);
    String tipo = "error";
    String mensaje = "Datos no eliminados.";
    
    Empleados empleado = new Empleados();
    empleado.setIdempleado(idempleado);
    
    if (EmpleadosControlador.eliminar(empleado)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();

%>