
/**
 * @author Adrián Celestrín
 */
package controlador;

import excepciones.CampoErroneoException;
import excepciones.DniInvalidoException;
import modelo.ClienteDAO;
import vista.VentanaClientes;
import vista.VentanaLeer;

public class Controlador {

	/**
	 * 
	 * @param args
	 * @throws DniInvalidoException
	 * @throws CampoErroneoException
	 */
	public static void main(String[] args) throws DniInvalidoException, CampoErroneoException {
		VentanaClientes v=new VentanaClientes();
		ClienteDAO operadorBD=new ClienteDAO();
		int opcion=0;
		
		
		do{
			System.out.println("BIENVENIDOS AL SISTEMA DE GESTIÓN DE CLIENTES");
			System.out.println("--------------");
			System.out.println("------OPCIONES--------");
			System.out.println("1-Registrar Cliente");
			System.out.println("2-Actualizar Cliente");
			System.out.println("3-Borrar Cliente");
			System.out.println("4-Mostrar los Clientes");
			System.out.println("5-SALIR");
			System.out.println("----------");
			opcion=Leer.leerEntero("ELIGE LA OPCION: ");
			switch(opcion) {
			
			case 1:
				v.setVisible(true);
				break;
			
			case 2:
				String dni=v.recibirDNI("Introduce el DNI que quieres modificar");
				int nuevaEdad=v.recibirEdad();
				int filas=operadorBD.actualizarEdad(dni, nuevaEdad);
				v.mostrarMensaje("Clientes actualizados: "+ filas);
				break;
			
			case 3:
				String dniB=v.recibirDNI("Introduce el DNI del cliente que quieres borrar");
				int filasB=operadorBD.borrar(dniB);
				v.mostrarMensaje("Clientes borrados: "+ filasB);
				break;
			
			case 4:
				VentanaLeer vl=new VentanaLeer();
				operadorBD.leer(vl);
				break;
			
			case 5:
				System.out.println("SALIENDO");
				break;
			}
		}while(opcion!=5);

	}

}
