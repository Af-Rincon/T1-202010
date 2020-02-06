package model.logic;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.LinkedList;
import model.data_structures.ILinkedList;
import model.logic.Comparendo;
import model.data_structures.Node;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private LinkedList<Comparendo> datos;
	
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo()
	{
		datos = new LinkedList<Comparendo>();
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Comparendo dato)
	{	
		datos.append(dato);
	}
	public String darPrimero()
	{
		return datos.darPrimero().darData().darItem();
	}
	public String darUltimo()
	{
		return datos.darUltimo().darData().darItem();
	}
	public String buscar(int objId)
	{
		String buscado = "";
		Node<Comparendo> actual = datos.darPrimero();
		while(actual!=null)
		{
			if(actual.darData().darObjId()==objId)
			{
				buscado = actual.darData().darItem();
			}
			actual = actual.darSiguiente();
		}
		return buscado;
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	
	
	public void cargar()throws FileNotFoundException
	{

		// Obtain Array
		File archivo = new File("./data/comparendos_dei_2018_small.geojson");
		JsonReader lector  = new JsonReader (new InputStreamReader(new FileInputStream(archivo)));
		JsonObject comparendos = JsonParser.parseReader(lector).getAsJsonObject();

		JsonArray features = comparendos.get("features").getAsJsonArray();


		for(JsonElement e: features)
		{
			JsonObject obj = e.getAsJsonObject();
			JsonObject properties= obj.get("properties").getAsJsonObject();

			int objectid = properties.get("OBJECTID").getAsInt();
			String fecha = properties.get("FECHA_HORA").getAsString();
			String vehiculo = properties.get("CLASE_VEHI").getAsString();
			String servicio = properties.get("TIPO_SERVI").getAsString();
			String infraccion = properties.get("INFRACCION").getAsString();
			String descrip = properties.get("DES_INFRAC").getAsString();
			String localidad = properties.get("LOCALIDAD").getAsString();	
			System.out.print(fecha);

			JsonObject geo = obj.get("geometry").getAsJsonObject();
			JsonArray coord = geo.get("coordinates").getAsJsonArray();

			double longitud = coord.get(0).getAsDouble();
			double latitud = coord.get(1).getAsDouble();

			Comparendo nuevo = new Comparendo(objectid, fecha, vehiculo, servicio, infraccion, descrip, localidad, longitud, latitud);

			agregar(nuevo);


		}
	}

}
        
            
           

	



