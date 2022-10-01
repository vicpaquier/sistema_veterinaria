/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Mascotas;
import utiles.Conexion;
import utiles.Utiles;


/**
 *
 * @author Administrador
 */
public class MascotasControlador {
    
    public static boolean agregar(Mascotas mascota) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into mascotas(idmascota, nombre_mascota, apellido_mascota, celular_mascota, direccion_mascota, ruc_mascota) "
                    + "values('" + mascota.getIdmascota() + "',"
                    + "'" + mascota.getNombre_mascota()+ "',"
                    + "'" + mascota.getApellido_mascota()+ "',"
                    + "'" + mascota.getCelular_mascota()+ "',"
                    + "'" + mascota.getDireccion_mascota()+ "',"
                    + "'" + mascota.getRuc_mascota()+ "')";
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
    
        
    public static Mascotas buscarId(Mascotas mascota) {
        if (Conexion.conectar()) {
            String sql = "select * from mascotas where idmascota='" + mascota.getIdmascota() + "'";
                     
            System.out.println("dasd"+sql);
            
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
//                Rubros mascota = new Rubros();
//                Marcas marca = new Marcas();
                if (rs.next()) {
                    
                    mascota.setIdmascota(rs.getInt("idmascota"));
                    mascota.setNombre_mascota(rs.getString("nombre_mascota"));
                    mascota.setApellido_mascota(rs.getString("apellido_mascota"));
                    mascota.setCelular_mascota(rs.getString("celular_mascota"));
                    mascota.setDireccion_mascota(rs.getString("direccion_mascota"));
                    mascota.setRuc_mascota(rs.getString("ruc_mascota"));
                } else {
                    mascota.setIdmascota(0);
                    mascota.setNombre_mascota(" ");
                    mascota.setApellido_mascota(" ");
                    mascota.setCelular_mascota(" ");
                    mascota.setDireccion_mascota(" ");
                    mascota.setRuc_mascota(" ");
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return mascota;
    }
    

    public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from mascotas  where nombre_mascota like '%"+nombre+"%'";
                       // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                       // + " order by id_mascota offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {
                        
                        tabla += "<tr id=" + rs.getString("idmascota") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idmascota") + "\" id=\"id_tabla" + rs.getString("idmascota") + "\">" + rs.getString("idmascota") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("nombre_mascota") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("apellido_mascota") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("celular_mascota") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("ruc_mascota") + "</td>"
                                + "<td class=\"text-center\">\n" +
"              <div>\n" +
"                <button href=\"#\" onclick=\"mod()\" class=\"btn btn-info p-0\"  data-toggle=\"modal\"\n" +
"          data-target=\"#staticBackdrop\" data-placement=\"top\"\n" +
"                  title=\"Editar datos mascota\"><i class=\"p-1 bi bi-pencil\"></i></button>\n" +
"                <button href=\"#\" onclick=\"del()\" class=\"btn btn-danger p-0\" id=\"botonEliminarAlert\" name=\"botonEliminarAlert\" data-toggle=\"tooltip\" data-placement=\"top\"\n" +
"                  title=\"Eliminar datos mascota\"><i class=\"p-1 bi bi-trash\"></i></button>\n" +
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
    
    public static boolean eliminar(Mascotas mascota){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="delete from mascotas where idmascota="+mascota.getIdmascota();
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    
    public static boolean eliminarMascota(Mascotas mascota){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="delete from mascotas where idmascota="+mascota.getIdmascota();
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    
    public static boolean modificar(Mascotas mascota){
        boolean valor=false;
        if(Conexion.conectar()){
    String sql="update mascotas set nombre_mascota='"+mascota.getNombre_mascota()+"',"
                    + "apellido_mascota='"+mascota.getApellido_mascota()+"',"
                    + "celular_mascota='"+mascota.getCelular_mascota()+"',"
                    + "direccion_mascota='"+mascota.getDireccion_mascota()+"',"
                    + "ruc_mascota='"+mascota.getRuc_mascota()+"'"
                    + "where idmascota="+mascota.getIdmascota();
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
    
    public static String buscarNombreMascota(String nombre, int pagina, String idmascota) {
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                
                String sql = "select * from mascotas where nombre_mascota like '%%' AND idmascota='"+idmascota+"'";
                       // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                       // + " order by id_mascota offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
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

    public static boolean agregarMascota(Mascotas mascota) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into mascotas(idmascota, nombre_mascota, especie_mascota, raza_mascota, colorpelo_mascota, fechanacimiento_mascota, idmascota) "
                    + "values('" + mascota.getIdmascota() + "',"
                    + "'" + mascota.getNombre_mascota()+ "',"
                    + "'" + mascota.getEspecie_mascota()+ "',"
                    + "'" + mascota.getRaza_mascota()+ "',"
                    + "'" + mascota.getColorpelo_mascota()+ "',"
                    + "'" + mascota.getFechanacimiento_mascota()+ "',"
                    + "'" + mascota.getIdmascota()+ "')";
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
    
    public static boolean generarIdmascotass(Mascotas mascota){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="SELECT max(idmascota) FROM mascotas";
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    
    public static String generarIdmascota() {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                
                String sql = "SELECT max(idmascota) FROM mascotas";
                
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
//                        id += ""+ rs.getString("idmascota") +"";
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



