/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Empleados;
import utiles.Conexion;
import utiles.Utiles;


/**
 *
 * @author Administrador
 */
public class EmpleadosControlador {
    
    public static boolean agregar(Empleados empleado) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into empleados(idempleado, nombre_empleado, apellido_empleado, celular_empleado, direccion_empleado, ruc_empleado) "
                    + "values('" + empleado.getIdempleado() + "',"
                    + "'" + empleado.getNombre_empleado()+ "',"
                    + "'" + empleado.getApellido_empleado()+ "',"
                    + "'" + empleado.getCelular_empleado()+ "',"
                    + "'" + empleado.getDireccion_empleado()+ "',"
                    + "'" + empleado.getRuc_empleado()+ "')";
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
             System.out.println("valor" + valor);
        }
        return valor;
       
    }
    
        
    public static Empleados buscarId(Empleados empleado) {
        if (Conexion.conectar()) {
            String sql = "select * from empleados where idempleado='" + empleado.getIdempleado() + "'";
                     
            System.out.println("dasd"+sql);
            
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
//                Rubros empleado = new Rubros();
//                Marcas marca = new Marcas();
                if (rs.next()) {
                    
                    empleado.setIdempleado(rs.getInt("idempleado"));
                    empleado.setNombre_empleado(rs.getString("nombre_empleado"));
                    empleado.setApellido_empleado(rs.getString("apellido_empleado"));
                    empleado.setCelular_empleado(rs.getString("celular_empleado"));
                    empleado.setDireccion_empleado(rs.getString("direccion_empleado"));
                    empleado.setRuc_empleado(rs.getString("ruc_empleado"));
                } else {
                    empleado.setIdempleado(0);
                    empleado.setNombre_empleado(" ");
                    empleado.setApellido_empleado(" ");
                    empleado.setCelular_empleado(" ");
                    empleado.setDireccion_empleado(" ");
                    empleado.setRuc_empleado(" ");
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return empleado;
    }
    

    public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from empleados  where nombre_empleado like '%"+nombre+"%'";
                       // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                       // + " order by id_empleado offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {
                        
                        tabla += "<tr id=" + rs.getString("idempleado") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idempleado") + "\" id=\"id_tabla" + rs.getString("idempleado") + "\">" + rs.getString("idempleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("nombre_empleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("apellido_empleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("celular_empleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("ruc_empleado") + "</td>"
                                + "<td class=\"text-center\">\n" +
"              <div>\n" +
"                <button href=\"#\" onclick=\"mod()\" class=\"btn btn-info p-0\"  data-toggle=\"modal\"\n" +
"          data-target=\"#staticBackdrop\" data-placement=\"top\"\n" +
"                  title=\"Editar datos empleado\"><i class=\"p-1 bi bi-pencil\"></i></button>\n" +
"                <button href=\"#\" onclick=\"del()\" class=\"btn btn-danger p-0\" id=\"botonEliminarAlert\" name=\"botonEliminarAlert\" data-toggle=\"tooltip\" data-placement=\"top\"\n" +
"                  title=\"Eliminar datos empleado\"><i class=\"p-1 bi bi-trash\"></i></button>\n" +
"              </div>\n" +
"            </td>"
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
    
    public static boolean eliminar(Empleados empleado){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="delete from empleados where idempleado="+empleado.getIdempleado();
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    
    public static boolean eliminarMascota(Empleados empleado){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="delete from mascotas where idmascota="+empleado.getIdmascota();
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    
    public static boolean modificar(Empleados empleado){
        boolean valor=false;
        if(Conexion.conectar()){
    String sql="update empleados set nombre_empleado='"+empleado.getNombre_empleado()+"',"
                    + "apellido_empleado='"+empleado.getApellido_empleado()+"',"
                    + "celular_empleado='"+empleado.getCelular_empleado()+"',"
                    + "direccion_empleado='"+empleado.getDireccion_empleado()+"',"
                    + "ruc_empleado='"+empleado.getRuc_empleado()+"'"
                    + "where idempleado="+empleado.getIdempleado();
            System.out.println("sql: "+sql);
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    
    public static String buscarNombreMascota(String nombre, int pagina, String idempleado) {
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                
                String sql = "select * from mascotas where nombre_mascota like '%%' AND idempleado='"+idempleado+"'";
                       // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                       // + " order by id_empleado offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {
                        
                        tabla += "<tr id=" + rs.getString("idmascota") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idmascota") + "\" id=\"id_tabla" + rs.getString("idmascota") + "\">" + rs.getString("idmascota") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("nombre_mascota") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("especie_mascota") + "</td>"
                                + "<td class=\"text-center\">\n" +
"              <div>\n" +
"                <button href=\"#\" onclick=\"modMascota()\" class=\"btn btn-info p-0\"  data-toggle=\"modal\"\n" +
"          data-target=\"#staticBackdrop\" data-placement=\"top\"\n" +
"                  title=\"Editar mascota\"><i class=\"p-1 bi bi-pencil\"></i></button>\n" +
"                <button href=\"#\" onclick=\"delMascota()\" class=\"btn btn-danger p-0\" id=\"botonEliminarAlertMascota\" name=\"botonEliminarAlertMascota\" data-toggle=\"tooltip\" data-placement=\"top\"\n" +
"                  title=\"Eliminar mascota\"><i class=\"p-1 bi bi-trash\"></i></button>\n" +
"              </div>\n" +
"            </td>"
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

    public static boolean agregarMascota(Empleados empleado) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into mascotas(idmascota, nombre_mascota, especie_mascota, raza_mascota, colorpelo_mascota, fechanacimiento_mascota, idempleado) "
                    + "values('" + empleado.getIdmascota() + "',"
                    + "'" + empleado.getNombre_mascota()+ "',"
                    + "'" + empleado.getEspecie_mascota()+ "',"
                    + "'" + empleado.getRaza_mascota()+ "',"
                    + "'" + empleado.getColorpelo_mascota()+ "',"
                    + "'" + empleado.getFechanacimiento_mascota()+ "',"
                    + "'" + empleado.getIdempleado()+ "')";
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
             System.out.println("valor" + valor);
        }
        return valor;
       
    }
    
    public static boolean generarIdempleadoss(Empleados empleado){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="SELECT max(idempleado) FROM empleados";
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    
    public static String generarIdempleado() {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                
                String sql = "SELECT max(idempleado) FROM empleados";
                
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    Integer id = 0;
                    
                    //Integer id = 1;
                    //id += rs.getInt(1);
                    
                    
                    if ( rs.next() ){
                        id = rs.getInt(1);  
                     }
                    System.out.println(id);
//                    while (rs.next()) {
//                        
//                        id += ""+ rs.getString("idempleado") +"";
//                        //id = id+1;
//                        
//                    }
                    
                    ps.close();
                    id ++;
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
    
}



