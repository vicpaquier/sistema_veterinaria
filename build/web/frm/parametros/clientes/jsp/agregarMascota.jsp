

<%@page import="modelos.Clientes"%>
<%@page import="controladores.ClientesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    
    int idmascota = Integer.parseInt(request.getParameter("idmascota"));
    String nombre_mascota = request.getParameter("nombre_mascota");
    String especie_mascota = request.getParameter("especie_mascota");
    String raza_mascota = request.getParameter("raza_mascota");
    String colorpelo_mascota = request.getParameter("colorpelo_mascota");
    String fechanacimiento_mascota = request.getParameter("fechanacimiento_mascota");
    int idcliente = Integer.parseInt(request.getParameter("idcliente_mascota"));
    
    
    

     
    String tipo = "error";
    String mensaje = "Datos no agregados.";
    
    Clientes cliente = new Clientes();
    
    cliente.setIdmascota(idmascota);
    cliente.setNombre_mascota(nombre_mascota);
    cliente.setEspecie_mascota(especie_mascota);
    cliente.setRaza_mascota(raza_mascota);
    cliente.setColorpelo_mascota(colorpelo_mascota);
    cliente.setFechanacimiento_mascota(fechanacimiento_mascota);
    cliente.setIdcliente(idcliente);
    
    
    
    
    if (ClientesControlador.agregarMascota(cliente)) {
        tipo = "success";
        mensaje = "Datos agregados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>