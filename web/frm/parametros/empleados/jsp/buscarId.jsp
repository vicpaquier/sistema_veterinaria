
<%@page import="controladores.EmpleadosControlador"%>
<%@page import="modelos.Empleados"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idempleado = Integer.parseInt(request.getParameter("idempleado"));
    
   
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    Empleados empleado=new Empleados();
    empleado.setIdempleado(idempleado);
    empleado=EmpleadosControlador.buscarId(empleado);
    if(empleado.getIdempleado()!=0){
        tipo="success";
        mensaje="Datos encontrados";
        nuevo="false";
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    obj.put("idempleado", empleado.getIdempleado());
    obj.put("nombre_empleado", empleado.getNombre_empleado());
    obj.put("apellido_empleado", empleado.getApellido_empleado());
    obj.put("celular_empleado", empleado.getCelular_empleado());
    obj.put("ruc_empleado", empleado.getRuc_empleado());
    
    out.print(obj);
    out.flush();
%>