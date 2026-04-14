package controlador;

import excepciones.CampoErroneoException;
import excepciones.DniInvalidoException;
import modelo.ClienteDAO;
import vista.VentanaClientes;

public class Controlador {

	public static void main(String[] args) throws DniInvalidoException, CampoErroneoException {
		VentanaClientes v=new VentanaClientes();
		ClienteDAO operadorBD=new ClienteDAO();
		
		System.out.println("BIENVENIDOS AL SISTEMA DE GESTIÓN DE CLIENTES");
		System.out.println("--------------");
		System.out.println("------OPCIONES--------");
		System.out.println("1-Registrar Cliente");
		System.out.println("2-Actualizar Cliente");
		System.out.println("3-Borrar Cliente");
		System.out.println("4-Mostrar los Clientes");
		System.out.println("5-SALIR");
		System.out.println("----------");
		int opcion=Leer.leerEntero("ELIGE LA OPCION: ");
		
		do{
			switch(opcion) {
			
			case 1:
				v.setVisible(true);
				operadorBD.insertar(v.devolverDNI(), v.devolverNombre(), v.devolverApellidos(),v.devolverEdad());
				v.setVisible(false);
				break;
			
			case 2:
				String dni=Leer.leerString("Introduce el DNI del cliente que quieres modificar");
				int nuevaEdad=Leer.leerEntero("Introduce la nueva edad");
				operadorBD.actualizarEdad(dni, nuevaEdad);
				break;
			case 3:
				String dniB=Leer.leerString("Introduce el DNI del cliente que quieres borrar");
				operadorBD.borrar(dniB);
				break;
			case 4:
				operadorBD.leer();
				break;
			case 5:
				System.out.println("SALIENDO");
				break;
			}
		}while(opcion!=5);

	}

}
