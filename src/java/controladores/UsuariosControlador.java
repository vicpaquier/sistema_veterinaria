
package controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import modelos.Empleados;
import modelos.Usuarios;
import utiles.Conexion;
import utiles.Utiles;


public class UsuariosControlador {
    public static boolean agregar(Usuarios usuario) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into usuarios(idusuario, tipo_usuario, contra_usuario, empleados_idempleados_fk, login_usuario) "
                    + "values('" + usuario.getIdusuario() + "',"
                    + "'" + usuario.getTipo_usuario()+ "',"
                    + "'" + utiles.Utiles.md5(usuario.getContra_usuario())+ "',"
                    + "'" + usuario.getEmpleados().getIdempleado()+ "',"
                    + "'" + usuario.getLogin_usuario()+ "')";
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
    
        
    public static Usuarios buscarId(Usuarios usuario) {
        if (Conexion.conectar()) {
            String sql = "select * from usuarios u, empleados e where" +
            " u.empleados_idempleados_fk=e.idempleado and idusuario='"+usuario.getIdusuario()+"'";
                     
            System.out.println("-->"+sql);
            
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                Empleados empleado = new Empleados();
//                Marcas marca = new Marcas();
                if (rs.next()) {
                    usuario.setIdusuario(rs.getInt("idusuario"));
                    usuario.setTipo_usuario(rs.getString("tipo_usuario"));
                    usuario.setContra_usuario(rs.getString("contra_usuario"));
                    empleado.setIdempleado(rs.getInt("empleados_idempleados_fk"));
                    usuario.setLogin_usuario(rs.getString("login_usuario"));
                } else {
                    usuario.setIdusuario(0);
                    usuario.setTipo_usuario(" ");
                    usuario.setContra_usuario(" ");
                    empleado.setIdempleado(0);
                    usuario.setLogin_usuario(" ");
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return usuario;
    }
    

     public static String buscarNombre(String nombre, int pagina) {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from usuarios u, empleados e  where \n" +
                "u.empleados_idempleados_fk=e.idempleado and\n" +
                "login_usuario like '%"+nombre+"%' ORDER BY idusuario DESC";
                       // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                       // + " order by id_usuario offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    
                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {
                        
                        tabla += "<tr id=" + rs.getString("idusuario") + " >"
                                + "<td class=\"row-data\"  scope=\"row\" name=\"id_tabla" + rs.getString("idusuario") + "\" id=\"id_tabla" + rs.getString("idusuario") + "\">" + rs.getString("idusuario") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("nombre_empleado") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("login_usuario") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("contra_usuario") + "</td>"
                                + "<td class=\"row-data\" >" + rs.getString("tipo_usuario") + "</td>"
                                + "<td class=\"text-center\">\n" +
"              <div>\n" +
"                <button href=\"#\" onclick=\"mod()\" class=\"btn btn-info p-0\"  data-toggle=\"modal\"\n" +
"          data-target=\"#staticBackdrop\" data-placement=\"top\"\n" +
"                  title=\"Editar datos usuario\"><i class=\"p-1 bi bi-pencil\"></i></button>\n" +
"                <button href=\"#\" onclick=\"del()\" class=\"btn btn-danger p-0\" id=\"botonEliminarAlert\" name=\"botonEliminarAlert\" data-toggle=\"tooltip\" data-placement=\"top\"\n" +
"                  title=\"Eliminar datos usuario\"><i class=\"p-1 bi bi-trash\"></i></button>\n" +
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
    
    public static boolean eliminar(Usuarios usuario){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="delete from usuarios where idusuario="+usuario.getIdusuario();
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    
   
    
    public static boolean modificar(Usuarios usuario){
        boolean valor=false;
        if(Conexion.conectar()){
    String sql="update usuarios set tipo_usuario='"+usuario.getTipo_usuario()+"',"
                    + "contra_usuario='"+usuario.getContra_usuario()+"',"
                    + "empleado_idempleado_fk='"+usuario.getEmpleados().getIdempleado()+"',"
                    + "login_usuario='"+usuario.getLogin_usuario()+"',"
                    + "tipo_usuario='"+usuario.getTipo_usuario()+"'"
                    + "where idusuario="+usuario.getIdusuario();
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
    
    public static String generarIdusuario() {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                
                String sql = "SELECT max(idusuario) FROM usuarios";
                
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
//                        id += ""+ rs.getString("idusuario") +"";
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
    
    public static String buscarNombreEmpleado(String nombre, int pagina) {
        //int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from empleados ORDER BY idempleado DESC";
                       // + "upper(cli_nombre) like '%" + nombre.toUpperCase() + "%'"
                       // + " order by id_empleado offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    //Integer id = 1;
                    while (rs.next()) {
                        
                        tabla += "<tr id=e" + rs.getString("idempleado") + " >"
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
    
    public static Usuarios validarAcceso(Usuarios usuario, HttpServletRequest request) {
        String nombre;
        String apellido;
        if (Conexion.conectar()) {
            try {
                String sql = "select * from usuarios u, empleados e  "
                        + "where login_usuario='" + usuario.getLogin_usuario()
                        + "' and contra_usuario='" + Utiles.md5(Utiles.quitarGuiones(usuario.getContra_usuario())) + "'";
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();

                    System.out.println("---> " + sql);
                    if (rs.next()) {
                        HttpSession sesion = request.getSession(true);
                        
                        nombre=rs.getString("nombre_empleado");
                        apellido=rs.getString("apellido_empleado");
                        
                        usuario = new Usuarios();
                        usuario.setIdusuario(rs.getInt("idusuario"));
                        usuario.setLogin_usuario(rs.getString("login_usuario"));
                        usuario.setTipo_usuario(rs.getString("tipo_usuario"));
                        usuario.setContra_usuario(rs.getString("contra_usuario"));
                        usuario.setNombre_usuario(nombre+" "+apellido);
                        //usuario.setEmpleados().set;
                        sesion.setAttribute("usuarioLogueado", usuario);
                    } else {
                        usuario = null;
                    }
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return usuario;
    }
}
