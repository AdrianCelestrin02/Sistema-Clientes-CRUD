/**
 * @author Adrián Celestrín
 */
package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.CampoErroneoException;
import excepciones.DniInvalidoException;
import modelo.ClienteDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dniField;
	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField edadField;

	/**
	 * Create the frame.
	 */
	public VentanaClientes() {
		setTitle("Registro de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RELLENA EL FORMULARIO");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setBounds(105, 11, 179, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(79, 71, 48, 14);
		contentPane.add(lblDNI);
		
		dniField = new JTextField();
		dniField.setBounds(150, 68, 96, 20);
		contentPane.add(dniField);
		dniField.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(67, 114, 85, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(67, 149, 69, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(67, 185, 48, 14);
		contentPane.add(lblEdad);
		
		nombreField = new JTextField();
		nombreField.setBounds(150, 111, 96, 20);
		contentPane.add(nombreField);
		nombreField.setColumns(10);
		
		apellidosField = new JTextField();
		apellidosField.setBounds(150, 146, 134, 20);
		contentPane.add(apellidosField);
		apellidosField.setColumns(10);
		
		edadField = new JTextField();
		edadField.setBounds(150, 182, 96, 20);
		contentPane.add(edadField);
		edadField.setColumns(10);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(42, 230, 88, 22);
		contentPane.add(btnEnviar);
		
		JButton btnLimpiar = new JButton("LIMPIAR CAMPOS");
		btnLimpiar.setBounds(188, 230, 159, 22);
		contentPane.add(btnLimpiar);
		
		btnLimpiar.addActionListener(e->limpiarCampos());
		
		btnEnviar.addActionListener(e->{
			try {
				ClienteDAO c=new ClienteDAO();
				c.insertar(devolverDNI(), devolverNombre(),devolverApellidos() , devolverEdad());
				JOptionPane.showMessageDialog(null, "Cliente Registrado","OK",JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error en los Datos","Error",JOptionPane.WARNING_MESSAGE);
			}
		});

	}
	
	public void limpiarCampos() {
		dniField.setText("");
		nombreField.setText("");
		apellidosField.setText("");
		edadField.setText("");
		
	}
	
	public String devolverNombre() throws CampoErroneoException {
		String regex=".*\\\\d.*";
		if(nombreField.getText().matches(regex)){
			throw new CampoErroneoException("Campo erroneo");
		}
		return nombreField.getText();
	}
	
	public String devolverDNI() throws DniInvalidoException{
		if(!validarDNI(dniField.getText())&& !dniField.getText().equals("")) {
			throw new DniInvalidoException("DNI Invalido");
		}
		else{
			return dniField.getText();
		}
	}
	
	public String devolverApellidos() throws CampoErroneoException{
		String regex=".*\\\\d.*";
		if(apellidosField.getText().matches(regex)){
			throw new CampoErroneoException("Campo erroneo");
		}
		return apellidosField.getText();
	}
	
	public int devolverEdad() {
		return Integer.parseInt(edadField.getText()); 
	}
	
	public static boolean validarDNI(String dni) {
	  
	    if (!dni.matches("\\d{8}[A-Za-z]")) {
	        return false;
	    }

	    int numero = Integer.parseInt(dni.substring(0, 8));
	    char letra = Character.toUpperCase(dni.charAt(8));
	    
	    String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
	    char letraCorrecta = letras.charAt(numero % 23);
	    return letra == letraCorrecta;
	}
}
