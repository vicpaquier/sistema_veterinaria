<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
HttpSession sesion=request.getSession();
sesion.invalidate();
JSONObject obj = new JSONObject();
obj.put("mensaje", "Sesi�n del Usuario cerrada.");
out.print(obj);
out.flush();
%>
