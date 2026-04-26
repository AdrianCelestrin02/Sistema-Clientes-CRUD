/**
 * @author Adrián Celestrín
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vista.VentanaLeer;

public class ClienteDAO {

    private ConexionBD conexionBD;
 
    
    /**
     * inicializar la conexion
     */
    public ClienteDAO() {

        try {
            conexionBD = new ConexionBD(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "bdjava",
                "bdjava"
            );

        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD: " + e.getMessage());
        }
        
      
    }
    public void insertar(String dni, String nombre, String apellidos, int edad) {

        String sql = "INSERT INTO CLIENTES VALUES (?, ?, ?, ?)";

        try {
           PreparedStatement ps =conexionBD.getConexion().prepareStatement(sql);

            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setInt(4, edad);

            int filas = ps.executeUpdate();
            System.out.println("Filas insertadas: " + filas);

        } catch (Exception e) {
            System.out.println("Error INSERT: " + e.getMessage());
        }
    }
    //READ
    public void leer(VentanaLeer v) {

        String sql = "SELECT * FROM CLIENTES";

        try {
            v.setVisible(true);

            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            v.getModelo().setRowCount(0); 

            while (rs.next()) {
                String dni = rs.getString("DNI");
                String nombre = rs.getString("NOMBRE");
                String apellidos = rs.getString("APELIIDOS"); 
                int edad = rs.getInt("EDAD");

                v.getModelo().addRow(new Object[]{dni, nombre, apellidos, edad});
            }

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //UPDATE
    public int actualizarEdad(String dni, int nuevaEdad) {

        String sql = "UPDATE CLIENTES SET EDAD = ? WHERE DNI = ?";
        int filas=0;
        try {
           PreparedStatement ps =conexionBD.getConexion().prepareStatement(sql);

            ps.setInt(1, nuevaEdad);
            ps.setString(2, dni);

             filas = ps.executeUpdate();
             

        } catch (Exception e) {
            System.out.println("Error UPDATE: " + e.getMessage());
        }
        return filas;
    }
    //DELETE
    public int borrar(String dni) {
        int filas=0;
        String sql = "DELETE FROM CLIENTES WHERE DNI = ?";

        try {
            PreparedStatement ps =  conexionBD.getConexion().prepareStatement(sql);

            ps.setString(1, dni);

            filas = ps.executeUpdate();
            System.out.println("Filas eliminadas: " + filas);

        } catch (Exception e) {
            System.out.println("Error DELETE: " + e.getMessage());
        }
        return filas;
    }
    
    
}