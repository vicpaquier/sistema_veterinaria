

<%@page import="modelos.Usuarios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
HttpSession sesion=request.getSession();
int id_usuario = 0;
String login_usuario="";
String nombre_usuario="";
String activo="false";
String mensaje="La sesi�n est� cerrada.";
Usuarios usuarioLogueado = (Usuarios) sesion.getAttribute("usuarioLogueado");
if(usuarioLogueado!=null){
id_usuario = usuarioLogueado.getIdusuario();
login_usuario = usuarioLogueado.getLogin_usuario();
nombre_usuario = usuarioLogueado.getNombre_usuario();
activo = "true";
mensaje="La sesi�n est� abierta.";
}

//String parseado = Integer.toString(id_usuario);
//out.println("---> "+id_usuario);
JSONObject obj = new JSONObject();
obj.put("mensaje", mensaje);
obj.put("activo", activo);
obj.put("idusuario",id_usuario);
obj.put("login_usuario",login_usuario);
obj.put("nombre_usuario",nombre_usuario);
out.print(obj);
out.flush();
%>
