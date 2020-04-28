package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.Tablero;
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.CasilleroOcupado;
import modelo.personajes.Goku;
import modelo.Casillero;
import modelo.Equipo;
import modelo.ObjetoJuego;

public class TestCasillero {
	
	@Test
	public void test01CrearCasillero(){
		Casillero casillero = new Casillero();
		assert(casillero instanceof Casillero);
	}
	
	@Test
	public void test02CasilleroVacio(){
		Casillero casillero = new Casillero();
		assert(casillero.estaVacio());
	}
	@Test
	public void test03CasilleroNoEstaVacio(){
		Tablero tablero = new Tablero(5);
		Casillero casillero = new Casillero();
		Equipo equipo = new Equipo();
		ObjetoJuego objeto = new Goku(tablero,equipo);
		casillero.agregarObjeto(objeto);
		assert(!casillero.estaVacio());
	}
	
	@Test
	public void test04AgregarObjetoAlCasillero(){
		Tablero tablero = new Tablero(5);
		Casillero casillero = new Casillero();
		Equipo equipo = new Equipo();
		ObjetoJuego objeto = new Goku(tablero,equipo);
		casillero.agregarObjeto(objeto);
		assert(casillero.obtenerObjeto() instanceof ObjetoJuego);
	}
	
	@Test
	public void test05ObtenerObjetoDelCasillero(){
		Tablero tablero = new Tablero(5);
		Casillero casillero = new Casillero();
		Equipo equipo = new Equipo();
		ObjetoJuego objeto = new Goku(tablero,equipo);
		casillero.agregarObjeto(objeto);
		assertEquals(casillero.obtenerObjeto(),objeto);
	}
	
	@Test
	public void test06EliminarObjetoDelCasillero(){
		Tablero tablero = new Tablero(5);
		Casillero casillero = new Casillero();
		Equipo equipo = new Equipo();
		ObjetoJuego objeto = new Goku(tablero,equipo);
		casillero.agregarObjeto(objeto);
		ObjetoJuego objetoeliminado = casillero.eliminarObjeto();
		assertEquals(objetoeliminado,objeto);
		assert(casillero.estaVacio());
	}
	
	@Test (expected=CasilleroVacio.class)
	public void test07ObtenerObjetoDeCasilleroVacio(){
		Casillero casillero = new Casillero();
		casillero.obtenerObjeto();
	}
	
	@Test (expected=CasilleroVacio.class)
	public void test08EliminarObjetoDeCasilleroVacio(){
		Casillero casillero = new Casillero();
		casillero.eliminarObjeto();
	}
	
	@Test(expected=CasilleroOcupado.class)
	public void test09AgregarObjetoACasilleroOcupado(){
		Tablero tablero = new Tablero(5);
		Casillero casillero = new Casillero();
		Equipo equipo = new Equipo();
		ObjetoJuego objeto = new Goku(tablero,equipo);
		casillero.agregarObjeto(objeto);
		casillero.agregarObjeto(objeto);
	}	

}
