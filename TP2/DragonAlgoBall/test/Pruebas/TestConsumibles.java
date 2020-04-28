
package Pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Equipo;
import modelo.StatsJuego;
import modelo.Tablero;
import modelo.consumibles.EsferaDelDragon;
import modelo.consumibles.NubeVoladora;
import modelo.consumibles.SemillaDelErmitanio;
import modelo.personajes.Goku;

public class TestConsumibles {
	
	int TAMANIO = 5;
	
	@Test
	public void test01GokuConsumeEsferaDelDragon(){
		int PODERPELEANORMALGOKU = StatsJuego.poderPeleaGokuNormal;
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero, equipo);
		EsferaDelDragon esfera = new EsferaDelDragon(tablero);
		
		assertEquals(goku.getAtaquesRestanteEsferaDelDragon() ,0);
		assertEquals(goku.getCantidadEsferasConsumidas(),0);
		assertEquals(goku.getPoderDePelea(), PODERPELEANORMALGOKU);
		
		esfera.consumir(goku);
		
		assertEquals(goku.getAtaquesRestanteEsferaDelDragon(), 2);
		assertEquals(goku.getCantidadEsferasConsumidas(), 1);
		assertEquals(goku.getPoderDePelea(), PODERPELEANORMALGOKU + PODERPELEANORMALGOKU*1,25);

		
	}
	
	@Test
	public void test02GokuConsumeNubeVoladora(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero, equipo);
		NubeVoladora nube = new NubeVoladora(tablero);
		
		assertEquals(goku.getTurnosRestantesNubeVoladora() ,0);
		assertEquals(goku.getVelocidad() , StatsJuego.velocidadGokuNormal);

		nube.consumir(goku);
		
		assertEquals(goku.getTurnosRestantesNubeVoladora() ,2);
		assertEquals(goku.getVelocidad() , 2 * StatsJuego.velocidadGokuNormal);
		
	}
	
	@Test
	public void test03GokuConsumeSemillaDelErmitanio(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero, equipo);
		SemillaDelErmitanio semilla = new SemillaDelErmitanio(tablero);
		
		assertEquals(goku.getPuntosDeVida() , StatsJuego.puntosVidaInicialGoku);

		semilla.consumir(goku);
		
		assertEquals(goku.getPuntosDeVida() , StatsJuego.puntosVidaInicialGoku + 100);

		
	}
	
}