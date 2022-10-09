/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Servicios;
import utiles.Conexion;
//import utiles.Utiles;


/**
 *
 * @author Administrador
 */
public class ServiciosControlador {
    
    public static boolean agregar(Servicios servicio) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into servicios(idservicio, descripcion_servicio, precio_servicio, iva_servicio) "
                    + "values('" + servicio.getIdservicio() + "',"
                    + "'" + servicio.getDescripcion_servicio()+ "',"
                    + "'" + servicio.getPrecio_servicio()+ "',"
                    + "'" + servicio.getIva_servicio()+ "')";
            System.out.println("--->" + sql);
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
    
        
    public static Servicios buscarId(Servicios servicio) {
        if (Conexion.conectar()) {
            String sql = "select * from servicios where idservicio='" + servicio.getIdservicio() + "'";
                     
            System.out.println("dasd"+sql);
            
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
//                Rubros servicio = new Rubros();
//                Marcas marca = new Marcas();
                if (rs.next()) {
                    
                    servicio.setIdservicio(rs.getInt("idservicio"));
                    servicio.setDescripcion_servicio(rs.getString("descripcion_servicio"));
                    servicio.setPrecio_servicio(rs.getInt("precio_servicio"));
                    servicio.setIva_servicio(rs.getString("iva_servicio"));
                } else {
                    servicio.setIdservicio(0);
                    servicio.setDescripcion_servicio(" ");
                    servicio.setPrecio_servicio(0);
                    servicio.setIva_servicio(" ");
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return servicio;
    }
    

    public static String buscarDescripcion(String descripcion, int pagina) {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from servicios  where descripcion_servicio like '%"+descripcion+"%'ORDER BY idservicio DESC";
                       // + "upper(cli_descripcion) like '%" + descripcion.toUpperCase() + "%'"
                       // + " order by id_servicio offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {
                        
                        tabla += "<tr id=" + rs.getString("idservicio") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idservicio") + "\" id=\"id_tabla" + rs.getString("idservicio") + "\">" + rs.getString("idservicio") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("descripcion_servicio") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getInt("precio_servicio") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("iva_servicio") + "</td>"
                                + "<td class=\"text-center\">\n" +
"              <div>\n" +
"                <button href=\"#\" onclick=\"mod()\" class=\"btn btn-info p-0\"  data-toggle=\"modal\"\n" +
"          data-target=\"#staticBackdrop\" data-placement=\"top\"\n" +
"                  title=\"Editar datos servicio\"><i class=\"p-1 bi bi-pencil\"></i></button>\n" +
"                <button href=\"#\" onclick=\"del()\" class=\"btn btn-danger p-0\" id=\"botonEliminarAlert\" name=\"botonEliminarAlert\" data-toggle=\"tooltip\" data-placement=\"top\"\n" +
"                  title=\"Eliminar datos servicio\"><i class=\"p-1 bi bi-trash\"></i></button>\n" +
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
    
    public static boolean eliminar(Servicios servicio){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="delete from servicios where idservicio="+servicio.getIdservicio();
            System.out.println("--->" + sql);
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    
   
    
    public static boolean modificar(Servicios servicio){
        boolean valor=false;
        if(Conexion.conectar()){
    String sql="update servicios set descripcion_servicio='"+servicio.getDescripcion_servicio()+"',"
                    + "precio_servicio='"+servicio.getPrecio_servicio()+"',"
                    + "iva_servicio='"+servicio.getIva_servicio()+"'"
                    + "where idservicio="+servicio.getIdservicio();
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
    
    public static String generarIdservicio() {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                
                String sql = "SELECT max(idservicio) FROM servicios";
                
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
//                        id += ""+ rs.getString("idservicio") +"";
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



