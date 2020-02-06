package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run()throws Exception
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int dato = 0;
		String respuesta = "";
		
			while( !fin ){
				view.printMenu();

				int option = lector.nextInt();
				switch(option){
				case 1:
					modelo = new Modelo();
					try{
					modelo.cargar();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					view.printMessage(modelo.darPrimero());
										
					break;

				case 2:
					view.printMessage("--------- \nDar cadena (simple) a buscar: ");
					dato = lector.nextInt();
					respuesta = modelo.buscar(dato);
					if ( respuesta != null)
					{
						view.printMessage("Dato encontrado: "+ respuesta);
					}
					else
					{
						view.printMessage("Dato NO encontrado");
					}
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 3: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
				}
			}
				

	}	
}
