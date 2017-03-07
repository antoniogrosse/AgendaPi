package br.senac.sp.agendadecontatos.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Antonio Grosse
 */
public class ConnectionUtils {
    
    public static Connection con = null;

    
    public static Connection getConnection() throws SQLException {

        if (con == null || con.isClosed()) {

            String dbURL = "jdbc:mysql://127.0.0.1:3311/Agenda";

            Properties properties = new Properties();
            properties.put("user", "root");
            properties.put("password", "root");

            con = DriverManager.getConnection(dbURL, properties);
        }

        return con;
        
    }
    
    public void Desconectar() throws SQLException {

        con.close();

    }
    
}
