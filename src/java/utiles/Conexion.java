/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Conexion {

    private static String driver = "org.postgresql.Driver";
    private static String servidor = "localhost";
    private static String puerto = "5432";
    private static String baseDato = "jveterinariaDB";
    private static String usuario = "postgres";
    private static String clave = "1";
    private static Connection conn;
    private static Statement st;

    public static boolean conectar() {
        boolean valor = false;
        try {
            Class.forName(driver);
            String url = "jdbc:postgresql://" + servidor + ":" + puerto
                    + "/" + baseDato;
            System.out.println("url "+ url);
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            valor = true;
            DatabaseMetaData infoBD = conn.getMetaData();
            System.out.println("estamos conectados a " 
                    + infoBD.getDatabaseProductName());
            System.out.println("version " + infoBD.getDatabaseProductVersion());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public static boolean cerrar() {
        boolean valor = false;
        try {
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public static Connection getConn() {
        return conn;
    }

    public static Statement getSt() {
        return st;
    }

    public static void main(String[] args) {
        Conexion.conectar();
    }
}