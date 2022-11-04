package controladores;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import modelos.Empleados;
import modelos.Agendamientos;
import modelos.Clientes;
import utiles.Conexion;
import utiles.Utiles;

public class AgendamientosControlador {

    public static boolean agregar(Agendamientos agendamiento) {
        boolean valor = false;
        int estado = 1;
        if (Conexion.conectar()) {
            String sql = "insert into agendamientos(fecha_agendamiento, idempleado, idcliente, idestadoagendamiento) values("
                    + "'" + agendamiento.getFecha_agendamiento() + "',"
                    + "'" + agendamiento.getEmpleados().getIdempleado() + "',"
                    + "'" + agendamiento.getClientes().getIdcliente() + "',"
                    + "'" + estado + "')";
            try {
                Conexion.getSt().executeUpdate(sql);
                System.out.println("-->" + sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
            System.out.println("valor" + valor);
        }
        return valor;

    }

    public static Agendamientos buscarId(Agendamientos agendamiento) {
        if (Conexion.conectar()) {
            String sql = "select * from agendamientos a, empleados e, clientes c where"
                    + " a.idempleado=e.idempleado and a.idcliente=c.idcliente and idagendamiento='" + agendamiento.getIdagendamiento() + "'";

            System.out.println("-->" + sql);

            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                Empleados empleado = new Empleados();
                Clientes cliente = new Clientes();
//                Marcas marca = new Marcas();
                if (rs.next()) {
                    agendamiento.setIdagendamiento(rs.getInt("idagendamiento"));
                    agendamiento.setFecha_agendamiento(rs.getString("tipo_agendamiento"));
                    empleado.setIdempleado(rs.getInt("empleados_idempleados_fk"));
                    cliente.setIdcliente(rs.getInt("empleados_idempleados_fk"));
                } else {
                    agendamiento.setIdagendamiento(0);
                    agendamiento.setFecha_agendamiento(" ");
                    empleado.setIdempleado(0);
                    cliente.setIdcliente(0);
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return agendamiento;
    }

    public static String buscarNombre(String fecha_desde, String fecha_hasta, int pagina) {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from agendamientos a, empleados e, clientes c, estadoagendamiento ea  where \n"
                        + "a.idempleado=e.idempleado and a.idcliente=c.idcliente and a.idestadoagendamiento=ea.idestado_agendamiento and\n"
                        + "fecha_agendamiento BETWEEN '%" + fecha_desde + "%'::DATE AND '%" + fecha_hasta + "%'::DATE ORDER BY fecha_agendamiento DESC";
                // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                // + " order by id_agendamiento offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try ( PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();

                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {
                        String nombre_empleado = rs.getString("nombre_empleado");
                        String apellido_empleado = rs.getString("apellido_empleado");
                        String nombre_cliente = rs.getString("nombre_cliente");
                        String apellido_cliente = rs.getString("apellido_cliente");
                        tabla += "<tr id=" + rs.getString("idagendamiento") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idagendamiento") + "\" id=\"id_tabla" + rs.getString("idagendamiento") + "\">" + rs.getString("idagendamiento") + "</td>"
                                + "<td class=\"row-data\" >" + (nombre_cliente + " " + apellido_cliente) + "</td>"
                                + "<td class=\"row-data\" >" + (nombre_empleado + " " + apellido_empleado) + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("fecha_agendamiento") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("descripcion_estadoagendamiento") + "</td>"
                                + "<td class=\"text-center\">\n"
                                + "              <div>\n"
                                + "                <button href=\"#\" onclick=\"mod()\" class=\"btn btn-info p-0\"  data-toggle=\"modal\"\n"
                                + "          data-target=\"#staticBackdrop\" data-placement=\"top\"\n"
                                + "                  title=\"Editar datos agendamiento\"><i class=\"p-1 bi bi-pencil\"></i></button>\n"
                                + "                <button href=\"#\" onclick=\"del()\" class=\"btn btn-danger p-0\" id=\"botonEliminarAlert\" name=\"botonEliminarAlert\" data-toggle=\"tooltip\" data-placement=\"top\"\n"
                                + "                  title=\"Eliminar datos agendamiento\"><i class=\"p-1 bi bi-trash\"></i></button>\n"
                                + "              </div>\n"
                                + "            </td>"
                                + "</tr>";
                        //id = id+1;

                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td colspan=2>No existen registros...</td></tr>";
                    }
                    ps.close();
                    valor = tabla;
                } catch (SQLException ex) {
                    System.err.println("Error:" + ex);
                }
                Conexion.cerrar();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        Conexion.cerrar();
        return valor;
    }

    public static boolean eliminar(Agendamientos agendamiento) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from agendamientos where idagendamiento=" + agendamiento.getIdagendamiento();
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

    public static boolean modificar(Agendamientos agendamiento) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update agendamientos set fecha_agendamiento='" + agendamiento.getFecha_agendamiento() + "',"
                    + "idempleado='" + agendamiento.getEmpleados().getIdempleado() + "',"
                    + "idcliente='" + agendamiento.getClientes().getIdcliente() + "'"
                    + "where idagendamiento=" + agendamiento.getIdagendamiento();
            System.out.println("sql: " + sql);
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

    public static String generarIdagendamiento() {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {

                String sql = "SELECT max(idagendamiento) FROM agendamientos";

                System.out.println("--->" + sql);
                try ( PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    Integer id = 0;

                    //Integer id = 1;
                    //id += rs.getInt(1);
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                    System.out.println(id);
//                    while (rs.next()) {
//                        
//                        id += ""+ rs.getString("idagendamiento") +"";
//                        //id = id+1;
//                        
//                    }

                    ps.close();
                    id++;
                    valor = Integer.toString(id);
                } catch (SQLException ex) {
                    System.err.println("Error:" + ex);
                }
                Conexion.cerrar();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        Conexion.cerrar();
        return valor;
    }

    public static String buscarNombreEmpleado(String nombre, int pagina) {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from empleados ORDER BY idempleado DESC";
                // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                // + " order by id_empleado offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try ( PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {

                        tabla += "<tr id=" + rs.getString("idempleado") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idempleado") + "\" id=\"id_tabla" + rs.getString("idempleado") + "\">" + rs.getString("idempleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("nombre_empleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("apellido_empleado") + "</td>";
                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td colspan=2>No existen registros...</td></tr>";
                    }
                    ps.close();
                    valor = tabla;
                } catch (SQLException ex) {
                    System.err.println("Error:" + ex);
                }
                Conexion.cerrar();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        Conexion.cerrar();
        return valor;
    }

    public static String buscarClientes(String nombre, int pagina) {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from clientes  where nombre_cliente like '%" + nombre + "%' ORDER BY idcliente DESC";
                // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                // + " order by id_cliente offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try ( PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {

                        tabla += "<tr id=C" + rs.getString("idcliente") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idcliente") + "\" id=\"id_tabla" + rs.getString("idcliente") + "\">" + rs.getString("idcliente") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("nombre_cliente") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("apellido_cliente") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("direccion_cliente") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("ruc_cliente") + "</td>"
                                + "</tr>";
                        //id = id+1;

                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td colspan=2>No existen registros...</td></tr>";
                    }
                    ps.close();
                    valor = tabla;
                } catch (SQLException ex) {
                    System.err.println("Error:" + ex);
                }
                Conexion.cerrar();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        Conexion.cerrar();
        return valor;
    }

    public static String buscarEmpleados(String nombre, int pagina) {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from empleados  where nombre_empleado like '%" + nombre + "%' ORDER BY idempleado DESC";
                // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                // + " order by id_cliente offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try ( PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {

                        tabla += "<tr id=E" + rs.getString("idempleado") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idempleado") + "\" id=\"id_tabla" + rs.getString("idempleado") + "\">" + rs.getString("idempleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("nombre_empleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("apellido_empleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("celular_empleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("ruc_empleado") + "</td>"
                                + "</tr>";
                        //id = id+1;

                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td colspan=2>No existen registros...</td></tr>";
                    }
                    ps.close();
                    valor = tabla;
                } catch (SQLException ex) {
                    System.err.println("Error:" + ex);
                }
                Conexion.cerrar();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        Conexion.cerrar();
        return valor;
    }

    //vencer citas

    public static String vencimientos(){
        String row;
        int cont=0;
        if(Conexion.conectar()){
    String sql="update agendamientos\n" +
                "set idestadoagendamiento = 2\n" +
                "where idestadoagendamiento = 1 AND fecha_agendamiento < current_date";
            System.out.println("sql-update->: "+sql);
            try{
                
                cont = Conexion.getSt().executeUpdate(sql);
                
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        row = Integer.toString(cont);
        return row;
    }
}
