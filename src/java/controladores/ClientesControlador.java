/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Clientes;
import utiles.Conexion;
import utiles.Utiles;


/**
 *
 * @author Administrador
 */
public class ClientesControlador {
    
    public static boolean agregar(Clientes cliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into clientes(idcliente, nombre_cliente, apellido_cliente, celular_cliente, direccion_cliente, ruc_cliente) "
                    + "values('" + cliente.getIdcliente() + "',"
                    + "'" + cliente.getNombre_cliente()+ "',"
                    + "'" + cliente.getApellido_cliente()+ "',"
                    + "'" + cliente.getCelular_cliente()+ "',"
                    + "'" + cliente.getDireccion_cliente()+ "',"
                    + "'" + cliente.getRuc_cliente()+ "')";
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
    
        
    public static Clientes buscarId(Clientes cliente) {
        if (Conexion.conectar()) {
            String sql = "select * from clientes where idcliente='" + cliente.getIdcliente() + "'";
                     
            System.out.println("dasd"+sql);
            
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
//                Rubros cliente = new Rubros();
//                Marcas marca = new Marcas();
                if (rs.next()) {
                    
                    cliente.setIdcliente(rs.getInt("idcliente"));
                    cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                    cliente.setApellido_cliente(rs.getString("apellido_cliente"));
                    cliente.setCelular_cliente(rs.getString("celular_cliente"));
                    cliente.setDireccion_cliente(rs.getString("direccion_cliente"));
                    cliente.setRuc_cliente(rs.getString("ruc_cliente"));
                } else {
                    cliente.setIdcliente(0);
                    cliente.setNombre_cliente(" ");
                    cliente.setApellido_cliente(" ");
                    cliente.setCelular_cliente(" ");
                    cliente.setDireccion_cliente(" ");
                    cliente.setRuc_cliente(" ");
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return cliente;
    }
    

    public static String buscarNombre(String nombre, int pagina) {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from clientes  where nombre_cliente like '%"+nombre+"%' ORDER BY idcliente DESC";
                       // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                       // + " order by id_cliente offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {
                        
                        tabla += "<tr id=" + rs.getString("idcliente") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idcliente") + "\" id=\"id_tabla" + rs.getString("idcliente") + "\">" + rs.getString("idcliente") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("nombre_cliente") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("apellido_cliente") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("celular_cliente") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("direccion_cliente") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("ruc_cliente") + "</td>"
                                + "<td class=\"text-center\">\n" +
"              <div>\n" +
"                <button href=\"#\" onclick=\"mod()\" class=\"btn btn-info p-0\"  data-toggle=\"modal\"\n" +
"          data-target=\"#staticBackdrop\" data-placement=\"top\"\n" +
"                  title=\"Editar datos cliente\"><i class=\"p-1 bi bi-pencil\"></i></button>\n" +
"                <button href=\"#\" onclick=\"del()\" class=\"btn btn-danger p-0\" id=\"botonEliminarAlert\" name=\"botonEliminarAlert\" data-toggle=\"tooltip\" data-placement=\"top\"\n" +
"                  title=\"Eliminar datos cliente\"><i class=\"p-1 bi bi-trash\"></i></button>\n" +
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
    
    public static boolean eliminar(Clientes cliente){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="delete from clientes where idcliente="+cliente.getIdcliente();
            try{
                int a = Conexion.getSt().executeUpdate(sql);
                System.out.println(a);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
                valor=false;
            }
        }
        return valor;
    }
    
    public static boolean eliminarMascota(Clientes cliente){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="delete from mascotas where idmascota="+cliente.getIdmascota();
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    
    public static boolean modificar(Clientes cliente){
        boolean valor=false;
        if(Conexion.conectar()){
    String sql="update clientes set nombre_cliente='"+cliente.getNombre_cliente()+"',"
                    + "apellido_cliente='"+cliente.getApellido_cliente()+"',"
                    + "celular_cliente='"+cliente.getCelular_cliente()+"',"
                    + "direccion_cliente='"+cliente.getDireccion_cliente()+"',"
                    + "ruc_cliente='"+cliente.getRuc_cliente()+"'"
                    + "where idcliente="+cliente.getIdcliente();
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
    
    public static String buscarNombreMascota(String nombre, String idcliente) {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                
                String sql = "select * from mascotas where nombre_mascota like '%%' AND idcliente='"+idcliente+"'";
                       // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                       // + " order by id_cliente offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
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

    public static boolean agregarMascota(Clientes cliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into mascotas(idmascota, nombre_mascota, especie_mascota, raza_mascota, colorpelo_mascota, fechanacimiento_mascota, idcliente) "
                    + "values('" + cliente.getIdmascota() + "',"
                    + "'" + cliente.getNombre_mascota()+ "',"
                    + "'" + cliente.getEspecie_mascota()+ "',"
                    + "'" + cliente.getRaza_mascota()+ "',"
                    + "'" + cliente.getColorpelo_mascota()+ "',"
                    + "'" + cliente.getFechanacimiento_mascota()+ "',"
                    + "'" + cliente.getIdcliente()+ "')";
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
    
  
    
    public static String generarIdcliente() {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                
                String sql = "SELECT max(idcliente) FROM clientes";
                
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



