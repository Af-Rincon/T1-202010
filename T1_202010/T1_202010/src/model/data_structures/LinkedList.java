package model.data_structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class LinkedList<T> implements ILinkedList<T>  {
		
        
        private Node<T> primero;
        private Node<T> ultimo = null;
        
        private int tamano = 0;

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public LinkedList(  )
        {
               primero = null;
        }
        
		public void addFirst(T item)
		{
			Node<T> cabeza = new Node<T>(item);
			cabeza.cambiarSiguiente(primero);
			primero = cabeza;
			if(primero.darSiguiente()==null)
			{
				ultimo = primero;
			}
			tamano++;
		}
		
		
		
		public void append( T item )
		{
			Node<T> nuevo = new Node<T>(item);
			if(primero == null)
			{
				primero = nuevo;  
			}
			else
			{
				Node<T> actual = primero;
				while(actual.darSiguiente()!=null)
				{
					actual = actual.darSiguiente();
				}
				actual.cambiarSiguiente(nuevo);
			}
			tamano++;
		}

		public int darTamano() {	
			return tamano;
		}

		public Node<T> darPrimero() {	
			return primero;
		}
		
		public Node<T> darUltimo()
		{
			return ultimo;
		}
		
		

		public void eliminar(int pos) {
			int contador = 0;
			if(primero!=null){
				Node<T> actual = primero;
				while(actual!=null)
				{
					if(pos==0)
					{
						primero  = actual.darSiguiente();
					}
					if(contador==(pos-1))
					{
						actual.cambiarSiguiente(actual.darSiguiente());
					}
					actual = actual.darSiguiente();
					contador++;
				}
				tamano--;
			}

		}

}
