

<%@page import="modelos.Rubros"%>
<%@page import="controladores.RubrosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    
    int id_mascota = Integer.parseInt(request.getParameter("id_mascota"));
    String nombre_mascota = request.getParameter("nombre_mascota");
    int id_cliente_fk = Integer.parseInt(request.getParameter("id_cliente_fk"));
    
    
    

     
    String tipo = "error";
    String mensaje = "Datos no agregados.";
    
    Rubros rubro = new Rubros();
    
    rubro.setId_mascota(id_mascota);
    rubro.setNombre_mascota(nombre_mascota);
    rubro.setId_cliente_fk(id_cliente_fk);
    
    
    
    
    if (RubrosControlador.agregarMascota(rubro)) {
        tipo = "success";
        mensaje = "Datos agregados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>