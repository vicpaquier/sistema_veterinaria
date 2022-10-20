
package controladores;

//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import modelos.Facturacion;
//import modelos.Usuarios;
import modelos.Facturacion;
import utiles.Conexion;
//import utiles.Utiles;

public class FacturacionControlador {

//    public static Facturacion buscarId(int id) {
//        Facturacion pedidos = null;
//        if (Conexion.conectar()) {
//            try {
//                String sql = "select * from pedidos c "
//                        + "left join clientes a on c.id_cliente=a.id_cliente "
//                        + "where id_pedido=?";
//                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
//                    ps.setInt(1, id);
//                    ResultSet rs = ps.executeQuery();
//                    if (rs.next()) {
//                        pedidos = new Facturacion();
//                        pedidos.setId_pedido(rs.getInt("id_pedido"));
//                        Clientes cliente = new Clientes();
//                        cliente.setId_cliente(rs.getInt("id_cliente"));
//                        cliente.setNombre_cliente(rs.getString("nombre_cliente"));
//                        pedidos.setCliente(cliente);
//                        pedidos.setFecha_pedido(rs.getDate("fecha_pedido"));
//                    }
//                    ps.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println("--> " + ex.getLocalizedMessage());
//            }
//        }
//        Conexion.cerrar();
//        return pedidos;
//    }
//
//    public static String buscarNombre(String nombre, int pagina) {
//        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
//        String valor = "";
//        if (Conexion.conectar()) {
//            try {
//                String sql = "select * from pedidos p "
//                        + "left join clientes c on c.id_cliente=p.id_cliente "
//                        + "where upper(nombre_cliente) like '%"
//                        + nombre.toUpperCase()
//                        + "%' "
//                        + "order by id_pedido "
//                        + "offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
//                System.out.println("--> " + sql);
//                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
//                    ResultSet rs = ps.executeQuery();
//                    String tabla = "";
//                    while (rs.next()) {
//                        tabla += "<tr>"
//                                + "<td>" + rs.getString("id_pedido") + "</td>"
//                                + "<td>" + rs.getString("id_cliente") + "</td>"
//                                + "<td>" + rs.getString("nombre_cliente") + "</td>"
//                                + "</tr>";
//                    }
//                    if (tabla.equals("")) {
//                        tabla = "<tr><td  colspan=5>No existen registros ...</td></tr>";
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

    public static boolean agregar(Facturacion facturacion) {
        boolean valor = false;
        if (Conexion.conectar()) {
            System.out.println("condicion---"+facturacion.getCondicion_facturacion());
            String sql = "insert into facturacion(idcliente, idusuario, fecha_facturacion, numero_facturacion, estado_facturacion,  condicion_facturacion) "
                    + "values("+facturacion.getCliente().getIdcliente()+","+facturacion.getUsuario().getIdusuario()+",'"+facturacion.getFecha_facturacion()+"','"+facturacion.getNumero_facturacion()+"','"+facturacion.getEstado_facturacion()+"','"+facturacion.getCondicion_facturacion()+"');";
            System.out.println("--> " + sql);
            try {
                Conexion.getSt().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet keyset = Conexion.getSt().getGeneratedKeys();
                if (keyset.next()) {
                    int id_facturacion = keyset.getInt(1);
                    facturacion.setId_facturacion(id_facturacion);
                    Conexion.getConn().commit();
                }
                valor = true;
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
            Conexion.cerrar();
        }

        return valor;
    }

//    public static boolean modificar(Facturacion pedido) {
//        boolean valor = false;
//        if (Conexion.conectar()) {
//            String sql = "update pedidos set id_cliente=? "
//                    + "where id_pedido=?";
//            try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
//
//                ps.setInt(1, pedido.getCliente().getId_cliente());
//                ps.setInt(2, pedido.getId_pedido());
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
//    public static boolean eliminar(Facturacion pedido) {
//        boolean valor = false;
//        if (Conexion.conectar()) {
//            String sql = "delete from pedidos where id_pedido=?";
//            try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
//                ps.setInt(1, pedido.getId_pedido());
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
}
