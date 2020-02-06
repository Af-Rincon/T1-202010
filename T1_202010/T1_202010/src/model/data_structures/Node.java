package model.data_structures;

public class Node<E> {
	
	private Node<E> siguiente;
	private E data;
	
	public Node(E item){
		data = item;
		siguiente = null;
	}
	
	
	
	public Node<E> darSiguiente()
	{
		return siguiente;
	}
	
	
	public void cambiarSiguiente(Node<E> pSiguiente)
	{
		siguiente = pSiguiente;
	}
	
	public E darData()
	{
		return data;
	}

}
