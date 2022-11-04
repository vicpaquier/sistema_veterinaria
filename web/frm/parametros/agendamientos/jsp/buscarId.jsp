
<%@page import="modelos.Empleados"%>
<%@page import="controladores.UsuariosControlador"%>
<%@page import="modelos.Usuarios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int idusuario = Integer.parseInt(request.getParameter("idusuario"));
    
   
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    Usuarios usuario=new Usuarios();
    //Empleados empleado=new Empleados();
    usuario.setIdusuario(idusuario);
    usuario=UsuariosControlador.buscarId(usuario);
    if(usuario.getIdusuario()!=0){
        tipo="success";
        mensaje="Datos encontrados";
        nuevo="false";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    obj.put("idusuario", usuario.getIdusuario());
    obj.put("login_usuario", usuario.getLogin_usuario());
    String login = usuario.getLogin_usuario();
    System.out.println(login);
    obj.put("contrasena_usuario", usuario.getContra_usuario());
    obj.put("tipo_usuario", usuario.getTipo_usuario());
    obj.put("idempleado", usuario.getEmpleados().getIdempleado());
    
    out.print(obj);
    out.flush();
%>