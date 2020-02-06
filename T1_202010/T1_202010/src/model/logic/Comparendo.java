package model.logic;

public class Comparendo implements Comparable<Comparendo> {
	
	private int objectid;
	private String fecha;
	private String vehiculo;
	private String servicio;
	private String infraccion;
	private String descrip;
	private String localidad;
	private double longitud;
	private double latitud;
	
	public Comparendo(int obj,String f, String vehi, String serv, String inf, String desc, String loc, double longitud, double latitud )
	{
		objectid = obj;
		fecha = f;
		vehiculo = vehi;
		servicio = serv;
		infraccion = inf;
		descrip = desc;
		localidad = loc;
	}
	
	public String darItem()
	{
		return "ObjectId: "+objectid+"Fecha: "+fecha+"Vehiculo: "+vehiculo+"Servicio: "+servicio+"Infraccion: "+infraccion;
	}
	
	public int darObjId()
	{
		return objectid;
	}

	@Override
	public int compareTo(Comparendo o) {
		// TODO Auto-generated method stub
		int num = 1;
		if(objectid==o.darObjId())
		{
			num = 0;
		}
		return num;
	}

}
