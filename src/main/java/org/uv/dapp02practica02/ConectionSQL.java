package org.uv.dapp02practica02;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectionSQL {
   
    private static ConectionSQL instance = null;
    private Connection con = null;

    private ConectionSQL() {
        conectar();
    }

    private void conectar() {
        try {
            if (con == null || con.isClosed()) {
                String url = "jdbc:postgresql://localhost:5432/ejemplo";
                con = DriverManager.getConnection(url, "postgres", "123456");
                System.out.println("Conectado a la base de datos.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectionSQL.class.getName()).log(Level.SEVERE, "Error al conectar a la base de datos", ex);
        }
    }
    
    public boolean execute(String sql) {
        try (Statement st = con.createStatement()) { 
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConectionSQL.class.getName()).log(Level.SEVERE, "Error al ejecutar la consulta", ex);
            return false;
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConectionSQL.class.getName()).log(Level.SEVERE, "Error al ejecutar la consulta SELECT", ex);
            return null;
        }
    }

    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexion cerrada.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectionSQL.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", ex);
        }
    }
    
    public Connection getConnection() {
        return con;
    }
    
    public boolean execute(TransacionDB t){
        return t.execute(con);
    }
    
    
    public static ConectionSQL getInstance() {
        if (instance == null) {
            instance = new ConectionSQL();
        }
        return instance;
    }
}
