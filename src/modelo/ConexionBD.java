package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private Connection conexion;

    private String url;
    private String user;
    private String password;

    public ConexionBD(String url, String user, String password) throws SQLException {
        this.url = url;
        this.user = user;
        this.password = password;

        this.conexion = DriverManager.getConnection(url, user, password);
    }

    public Connection getConexion() {
        return conexion;
    }
}
