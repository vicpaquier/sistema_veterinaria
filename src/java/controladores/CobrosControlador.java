
package controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Cobros;
import modelos.DetallesCobros;
import utiles.Conexion;


public class CobrosControlador {
    
    
    public static int totales(DetallesCobros detallecobro) {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        int valor=0;
        if (Conexion.conectar()) {
            try {
                
                String sql = "SELECT  SUM(d.cantidad_detallefacturacion * s.precio_servicio) as total_factura " +
                        "FROM detallefacturacion d, servicios s " +
                        "where d.idservicio = s.idservicio and d.idfacturacion='"+detallecobro.getFacturacion().getId_facturacion()+"'";
                
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    //Integer id = 0;

                    if ( rs.next() ){
                        valor = rs.getInt(1);  
                     }
                    System.out.println("total factura: " +valor);
                    ps.close();
                    
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
    
    
    public static boolean agregar_cabecera(Cobros cobro) {
        boolean valor = false;
        
        if (Conexion.conectar()) {
            String sql = "DO \n" +
                            "$do$ \n" +
                            "BEGIN\n" +
                            " IF (EXISTS (SELECT * FROM cobros WHERE fecha_cobro = current_date))=FALSE THEN\n" +
                            " \n" +
                            "	INSERT INTO cobros(fecha_cobro, usuario_cobro) values(current_date,"+cobro.getUsuarios().getIdusuario()+");\n" +
                            "	\n" +
                            "  END IF;\n" +
                            "END \n" +
                            "$do$";
                          System.out.println("-->asssssssa"+sql);  
            try {
                Conexion.getSt().executeUpdate(sql);
                System.out.println("-->"+sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
             System.out.println("valor" + valor);
        }
        return valor;
       
    }
    
    
    public static boolean agregar_detalle(DetallesCobros detallecobro) {
        boolean valor = false;
        
        if (Conexion.conectar()) {
            String sql = "insert into detalle_cobros(idcobro, idfacturacion, total_factura, metodo_pago)\n" +
                            "SELECT max(idcobro), "+detallecobro.getFacturacion().getId_facturacion()+", "+detallecobro.getTotal_factura()+", '"+detallecobro.getMetodo_pago()+"'\n" +
                            " FROM cobros\n" +
                            " WHERE fecha_cobro=current_date";
                          System.out.println("-->asssssssa"+sql);  
            try {
                Conexion.getSt().executeUpdate(sql);
                System.out.println("-->"+sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
             System.out.println("valor" + valor);
        }
        return valor;
    }
}
