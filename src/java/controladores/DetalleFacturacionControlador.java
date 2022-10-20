/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;




import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import modelos.DetallesFacturacion;
import modelos.Facturacion;
import utiles.Conexion;

public class DetalleFacturacionControlador {
    
//    public static DetallesPedidos buscarId(int id) {
//        DetallesPedidos detallepedido = null;
//        if (Conexion.conectar()) {
//            try {
//                String sql = "select * from detallespedidos dp "+
//                             "left join pedidos p on p.id_pedido=dp.id_pedido "+
//                             "left join articulos a on a.id_articulo=dp.id_articulo "+
//                             "where dp.id_detallepedido=?";
//                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
//                    ps.setInt(1, id);
//                    ResultSet rs = ps.executeQuery();
//                    if (rs.next()) {
//                        detallepedido = new DetallesPedidos();
//                        detallepedido.setId_detallepedido(rs.getInt("id_detallepedido"));
//                        detallepedido.setCantidad_articulopedido(rs.getInt("cantidad_articulopedido"));
//                        
//                        Articulos articulo = new Articulos();
//                        articulo.setId_articulo(rs.getInt("id_articulo"));
//                        articulo.setNombre_articulo(rs.getString("nombre_articulo"));
//                        detallepedido.setArticulo(articulo);
//                        
//                        Pedidos pedido = new Pedidos();
//                        pedido.setId_pedido(rs.getInt("id_pedido"));
//                        detallepedido.setPedido(pedido);
//                        
//                    }
//                    ps.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println("--> " + ex.getLocalizedMessage());
//            }
//        }
//        Conexion.cerrar();
//        return detallepedido;
//    }
    public static boolean agregar(DetallesFacturacion detallesfacturacion) {
        boolean valor = false;
        if (Conexion.conectar()) {
            //System.out.println("condicion---"+facturacion.getCondicion_facturacion());
            String sql = "insert into detallefacturacion(cantidad_detallefacturacion, idservicio, idfacturacion)"
                    + "values("+detallesfacturacion.getCantidad_detallefacturacion()+","+detallesfacturacion.getServicio().getIdservicio()+",'"+detallesfacturacion.getFacturacion().getId_facturacion()+"');";
            System.out.println("--> " + sql);
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
            Conexion.cerrar();
        }

        return valor;
    }
    
    public static String buscarClientes(String nombre, int pagina) {
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
    
    public static String buscarServicio(String descripcion, int pagina) {
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
                        
                        tabla += "<tr id=" + rs.getString("idservicio") + "class=" + rs.getString("descripcion_servicio") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idservicio") + "\" id=\"id_tabla" + rs.getString("idservicio") + "\">" + rs.getString("idservicio") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("descripcion_servicio") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getInt("precio_servicio") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("iva_servicio") + "</td>"
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
    
    public static String buscarIdPedido(int id) {
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from detallespedidos dp "+
                        "left join pedidos p on p.id_pedido=dp.id_pedido "+
                        "left join articulos a on a.id_articulo=dp.id_articulo "+
                        "where dp.id_pedido="+id+" "+
                        "order by id_detallepedido";
                System.out.println("--> "+sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    DecimalFormat df = new DecimalFormat( "#,###.00" );
                    String tabla = "";
                    BigDecimal total = BigDecimal.ZERO;
                    while (rs.next()) {
                        BigDecimal cantidad = rs.getBigDecimal("cantidad_articulopedido");
                        total = total.add(cantidad);
                       // System.out.println("total"+total);
                        tabla += "<tr>"
                               + "<td>" + rs.getString("id_detallepedido") + "</td>"
                               + "<td>" + rs.getString("id_articulo") + "</td>"
                               + "<td>" + rs.getString("nombre_articulo") + "</td>" 
                               + "<td class='centrado'>" + df.format(cantidad) + "</td>"
                               + "<td class='centrado'>"
                                + "<button onclick='editarLinea("+rs.getString("id_detallepedido")+")'"
                                + " type='button' class='btn btn-primary btn-sm'><span class='glyphicon glyphicon-pencil'>"
                                + "</span></button></td>"
                               + "</tr>";
                    }
                    if(tabla.equals("")){
                        tabla = "<tr><td  colspan=6>No existen registros ...</td></tr>";
                    }else{
                        tabla += "<tr><td colspan=3>TOTAL</td><td class='centrado'>"+df.format(total)+"</td></tr>";
                    }
                    ps.close();
                    valor = tabla;
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return valor;
    }
    
//    public static String buscarNombre(String nombre, int pagina ) {
//        int offset=(pagina-1)*Utiles.REGISTROS_PAGINA;
//        String valor = "";
//        if (Conexion.conectar()) {
//            try {
//                String sql = "select * from detallespedidos dp "+
//                        "left join pedidos p on p.id_pedido=dp.id_pedido "+
//                        "left join articulos a on a.id_articulo=dp.id_articulo "+
//                        "where upper(a.nombre_articulo) like '%" + 
//                        nombre.toUpperCase() + 
//                        "%' "+
//                        "order by id_detallepedido "+
//                        "offset "+ offset + " limit "+ Utiles.REGISTROS_PAGINA;
//                System.out.println("--> "+sql);
//                try (PreparedStatement ps = utiles.Conexion.getConn().prepareStatement(sql)) {
//                    ResultSet rs = ps.executeQuery();
//                    String tabla = "";
//                    while (rs.next()) {
//                        tabla += "<tr>"
//                               + "<td>" + rs.getString("id_detallepedido") + "</td>"
//                               + "<td>" + rs.getString("id_pedido") + "</td>"
//                               + "<td>" + rs.getString("id_articulo") + "</td>"
//                               + "<td>" + rs.getString("nombre_articulo") + "</td>"
//                               + "<td>" + rs.getInt("cantidad_articulopedido") + "</td>" 
//                               + "</tr>";
//                    }
//                    if(tabla.equals("")){
//                        tabla = "<tr><td  colspan=6>No existen registros ...</td></tr>";
//                    }
//                    ps.close();
//                    valor = tabla;
//                }
//            } catch (SQLException ex) {
//                System.out.println("--> " + ex.getLocalizedMessage());
//            }
//        }
//        Conexion.cerrar();
//        return valor;
//    }
//
//    public static boolean agregar(DetallesPedidos detallepedido) {
//        boolean valor = false;
//        if (Conexion.conectar()) {
//            String sql = "insert into detallespedidos "
//                    + "(id_pedido,id_articulo,cantidad_articulopedido) "
//                    + "values (?,?,?)";
//            try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
//                ps.setInt(1, detallepedido.getPedido().getId_pedido());
//                ps.setInt(2, detallepedido.getArticulo().getId_articulo());
//                ps.setInt(3, detallepedido.getCantidad_articulopedido());
//                ps.executeUpdate();
//                ps.close();
//                Conexion.getConn().commit();
//                valor = true;
//            } catch (SQLException ex) {
//                System.out.println("--> " + ex.getLocalizedMessage());
//                try {
//                    Conexion.getConn().rollback();
//                } catch (SQLException ex1) {
//                    System.out.println("--> " + ex1.getLocalizedMessage());
//                }
//            }
//        }
//        Conexion.cerrar();
//        return valor;
//    }
//
//    public static boolean modificar(DetallesPedidos detallepedido) {
//        boolean valor = false;
//        if (Conexion.conectar()) {
//            String sql = "update detallespedidos set "
//                    + "id_pedido=?,"
//                    + "id_articulo=?,"
//                    + "cantidad_articulopedido=? "
//                    + "where id_detallepedido=?";
//            try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
//                ps.setInt(1, detallepedido.getPedido().getId_pedido());
//                ps.setInt(2, detallepedido.getArticulo().getId_articulo());
//                ps.setInt(3, detallepedido.getCantidad_articulopedido());
//                ps.setInt(4,detallepedido.getId_detallepedido());
//                ps.executeUpdate();
//                ps.close();
//                Conexion.getConn().commit();
//                System.out.println("--> Grabado");
//                valor = true;
//            } catch (SQLException ex) {
//                System.out.println("--> " + ex.getLocalizedMessage());
//                try {
//                    Conexion.getConn().rollback();
//                } catch (SQLException ex1) {
//                    System.out.println("--> " + ex1.getLocalizedMessage());
//                }
//            }
//        }
//        Conexion.cerrar();
//        return valor;
//    }
//
//    public static boolean eliminar(DetallesPedidos detallepedido) {
//        boolean valor = false;
//        if (Conexion.conectar()) {
//            String sql = "delete from detallespedidos where id_detallepedido=?";
//            try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
//                ps.setInt(1, detallepedido.getId_detallepedido());
//                ps.executeUpdate();
//                ps.close();
//                Conexion.getConn().commit();
//                valor = true;
//            } catch (SQLException ex) {
//                System.out.println("--> " + ex.getLocalizedMessage());
//                try {
//                    Conexion.getConn().rollback();
//                } catch (SQLException ex1) {
//                    System.out.println("--> " + ex1.getLocalizedMessage());
//                }
//            }
//        }
//        Conexion.cerrar();
//        return valor;
//    }
//    
//    public static boolean eliminarArticuloPedido(Pedidos pedido) {
//        boolean valor = false;
//        if (Conexion.conectar()) {
//            String sql = "delete from detallespedidos where id_pedido=?";
//            try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
//                ps.setInt(1, pedido.getId_pedido());
//                ps.executeUpdate();
//                ps.close();
//                Conexion.getConn().commit();
//                System.out.println("--> " + pedido.getId_pedido());
//                valor = true;
//            } catch (SQLException ex) {
//                System.out.println("--> " + ex.getLocalizedMessage());
//                try {
//                    Conexion.getConn().rollback();
//                } catch (SQLException ex1) {
//                    System.out.println("--> " + ex1.getLocalizedMessage());
//                }
//            }
//        }
//        Conexion.cerrar();
//        return valor;
//    }
//    
    
}
