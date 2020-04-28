package Pruebas;

import org.junit.Test;

import modelo.Equipo;
import modelo.ObjetoJuego;
import modelo.Personaje;
import modelo.Tablero;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;


public class TestObjetoJuego {
	
	@Test
	public void test01ObjetoEsPersonajeYnoConsumible(){
		Tablero tablero = new Tablero(10);
		Equipo equipo1 = new Equipo();
		ObjetoJuego goku = new Goku(tablero,equipo1);
		Personaje gohan = new Gohan(tablero,equipo1);
		assert(goku.esPersonaje());
		assert(!gohan.esConsumible());
		}

}
