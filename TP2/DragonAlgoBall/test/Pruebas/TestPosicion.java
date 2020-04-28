package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.Posicion;

public class TestPosicion {
	
	@Test
	public void test01CrearPosicion(){
		Posicion pos = new Posicion(1,5);
		assert(pos instanceof Posicion);
	}
	@Test
	public void test02ObtenerCoordenadaX(){
		Posicion pos = new Posicion(1,2);
		assertEquals(pos.getCoordenadaX(),1);
	}
	@Test
	public void test03ObtenerCoordenadaY(){
		Posicion pos = new Posicion(1,2);
		assertEquals(pos.getCoordenadaY(),2);
	}
	

}
