package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import modelo.Equipo;
import modelo.Posicion;
import modelo.Tablero;
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.MovimientoInvalido;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;

public class TestMovimiento {
	int TAMANIO = 10;
	
	@Test
	public void test01CrearUnPersonajeYUbicarloInicialmente(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Posicion pos = new Posicion(1,1);
		tablero.colocarObjeto(goku,goku.getPosicion());
		assertEquals(tablero.obtenerObjeto(pos),goku);
	}
	
	@Test
	public void test02CrearUnPersonajeUbicarloYMoverloHaciaArriba(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Posicion pos = new Posicion(1,2);
		tablero.colocarObjeto(goku,goku.getPosicion());
		goku.MoverPersonajeHaciaArriba();
		assertEquals(tablero.obtenerObjeto(pos),goku);
	}
	
	@Test
	public void test03CrearUnPersonajeUbicarloYMoverloHaciaArribaDosVeces(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Posicion pos = new Posicion(1,3);
		tablero.colocarObjeto(goku,goku.getPosicion());
		goku.MoverPersonajeHaciaArriba();
		goku.MoverPersonajeHaciaArriba();
		assertEquals(tablero.obtenerObjeto(pos),goku);
	}
	
	@Test (expected=CasilleroVacio.class)
	public void test04CrearUnPersonajeUbicarloMoverloYCheckearQueSeHayaBorrado(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Posicion pos = new Posicion(1,1);
		tablero.colocarObjeto(goku,goku.getPosicion());
		goku.MoverPersonajeHaciaArriba();
		assertEquals(tablero.obtenerObjeto(pos),goku);
	}
	
	@Test (expected=MovimientoInvalido.class)
	public void test05CrearDosPersonajesUbicarlosYQueNoSePisen(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Gohan gohan = new Gohan(tablero,equipo1);
		tablero.colocarObjeto(goku,goku.getPosicion());
		tablero.colocarObjeto(gohan,gohan.getPosicion());
		goku.MoverPersonajeHaciaArriba();
	}

	

}
