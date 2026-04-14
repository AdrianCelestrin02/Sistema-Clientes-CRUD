/**
 * @author Adrián Celestrín
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    /**
     * atributos necesarios para la conexion
     */
    private Connection conexion;

    private String url;
    private String user;
    private String password;
    
    /**
     * 
     * @param url
     * @param user
     * @param password
     * @throws SQLException
     */
    public ConexionBD(String url, String user, String password) throws SQLException {
        this.url = url;
        this.user = user;
        this.password = password;

        this.conexion = DriverManager.getConnection(url, user, password);
    }
    /**
     * 
     * @return guarda la conexion
     */
    public Connection getConexion() {
        return conexion;
    }
}
