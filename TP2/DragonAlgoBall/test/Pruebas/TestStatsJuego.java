package Pruebas;
import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;
import modelo.excepciones.TransformacionInvalida;
import modelo.personajes.Cell;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.MajinBoo;



public class TestStatsJuego {
	int TAMANIO = 6;
	Equipo EQUIPO1 = new Equipo();
	Equipo EQUIPO2 = new Equipo();
	@Test
	public void test01CrearTableroInicialYVerificarSuTamanio() {
		Tablero tablero = new Tablero(TAMANIO);
		assertEquals(tablero.getTamanio(), TAMANIO);
	}
	
	@Test
	public void test02CrearTableroConPersonajeGokuVerificarVelocidad() {
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero, EQUIPO1);
		assertEquals(goku.getVelocidad(), StatsJuego.velocidadGokuNormal);
	}
	
	@Test
	public void test03CrearTableroConPersonajeSVariosVerificarVelocidades() {
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero, EQUIPO1);
		Gohan gohan = new Gohan(tablero, EQUIPO1);
		Cell cell = new Cell(tablero, EQUIPO2);
		MajinBoo boo = new MajinBoo(tablero, EQUIPO2);
		
		assertEquals(goku.getVelocidad(), StatsJuego.velocidadGokuNormal);
		assertEquals(gohan.getVelocidad(), StatsJuego.velocidadGohanNormal);
		assertEquals(cell.getVelocidad(), StatsJuego.velocidadCellNormal);
		assertEquals(boo.getVelocidad(), StatsJuego.velocidadMajinBooNormal);
	}
	
	@Test
	public void test04CrearTableroConVariosPersonajesYVerificarVelocidad(){
		Tablero tablero = new Tablero(TAMANIO);
		Gohan gohan = new Gohan(tablero, EQUIPO1);
		MajinBoo boo = new MajinBoo(tablero, EQUIPO2);
		assertEquals(gohan.getVelocidad(), StatsJuego.velocidadGohanNormal);
		assertEquals(boo.getVelocidad(), StatsJuego.velocidadMajinBooNormal);		
	}
	
	@Test(expected=TransformacionInvalida.class)
	public void test05CrearJuegoConPersonajeYEvolucionarloNoDeberiaPoder(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero, EQUIPO1);
		goku.transformar();
		
	}
	

	
	
}
