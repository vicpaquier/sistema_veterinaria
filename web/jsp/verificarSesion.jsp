

<%@page import="modelos.Usuarios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
HttpSession sesion=request.getSession();
int id_usuario = 0;
String login_usuario="";
String nombre_usuario="";
String activo="false";
String mensaje="La sesión está cerrada.";
Usuarios usuarioLogueado = (Usuarios) sesion.getAttribute("usuarioLogueado");
if(usuarioLogueado!=null){
id_usuario = usuarioLogueado.getId_usuario();
login_usuario = usuarioLogueado.getLogin_usuario();
nombre_usuario = usuarioLogueado.getNombre_usuario();
activo = "true";
mensaje="La sesión está abierta.";
}
JSONObject obj = new JSONObject();
obj.put("mensaje", mensaje);
obj.put("activo", activo);
obj.put("id_usuario",id_usuario);
obj.put("login_usuario",login_usuario);
obj.put("nombre_usuario",nombre_usuario);
out.print(obj);
out.flush();
%>
