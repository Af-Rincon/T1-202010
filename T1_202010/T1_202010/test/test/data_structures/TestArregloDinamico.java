package test.data_structures;

import model.data_structures.LinkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private LinkedList arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() {
		arreglo= new LinkedList(TAMANO);
	}

	public void setUp2() {
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(""+i);
		}
	}

	@Test
	public void testArregloDinamico() {
		// TODO
	}

	@Test
	public void testDarElemento() {
		setUp2();
		// TODO
	}

}