package Pruebas;

import static org.junit.Assert.assertEquals;
import modelo.excepciones.*;

import org.junit.Test;

import modelo.*;
import modelo.personajes.*;

public class TestAtacar {
		
	@Test
	public void test01ColocarDosPersonajesInicialmenteYAtacarlos(){
		Tablero tablero = new Tablero(3);
		Equipo enemigos = new Equipo();
		Equipo equipoz = new Equipo();
		Goku goku = new Goku(tablero,equipoz);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero,enemigos);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.atacarConBasico(cell);

		
		assertEquals(cell.getPuntosDeVida(),480);
	}
	
	@Test(expected= AtaqueInvalido.class)
	public void test02ColocarDosPersonajesQueNoSeLleganAAtacar(){
		Tablero tablero = new Tablero(10);
		Equipo enemigos = new Equipo();
		Equipo equipoz = new Equipo();
		Goku goku = new Goku(tablero,equipoz);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero,enemigos);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.atacarConBasico(cell);
	}
	
	@Test(expected= AtaqueInvalido.class)
	public void test03ColocarDosPersonajesQueSonDelMismoEquipoNoSeDeberianAtacar(){
		Tablero tablero = new Tablero(3);
		Equipo equipoz = new Equipo();
		Goku goku = new Goku(tablero,equipoz);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Gohan gohan = new Gohan(tablero,equipoz);
		tablero.colocarObjeto(gohan,gohan.getPosicion());
		goku.atacarConBasico(gohan);
	}
	
	@Test
	public void test04ColocarDosPersonajesMoverYAtacar(){
		Tablero tablero = new Tablero(6);
		Equipo enemigos = new Equipo();
		Equipo equipoz = new Equipo();
		Goku goku = new Goku(tablero,equipoz);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero,enemigos);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.MoverPersonajeHaciaArribaDerecha();
		goku.MoverPersonajeHaciaArriba();
		cell.MoverPersonajeHaciaAbajoIzquierda();
		
		goku.atacarConBasico(cell);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),480);
	}
	
	@Test
	public void test05ColocarDosPersonajesMoverYAtacarseMutuamente(){
		Tablero tablero = new Tablero(6);
		Equipo enemigos = new Equipo();
		Equipo equipoz = new Equipo();
		Goku goku = new Goku(tablero,equipoz);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero,enemigos);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.MoverPersonajeHaciaArribaDerecha();
		goku.MoverPersonajeHaciaArriba();
		cell.MoverPersonajeHaciaAbajoIzquierda();
		goku.atacarConBasico(cell);
		cell.atacarConBasico(goku);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),480);
		assertEquals(goku.getPuntosDeVida(),480);
	}
	
	@Test(expected= KiInsuficiente.class)
	public void test06ColocarDosPersonajesYUsarAtaqueEspecialGokuDeberiaTirarKiInsuficiente(){
		Tablero tablero = new Tablero(3);
		Equipo enemigos = new Equipo();
		Equipo equipoz = new Equipo();
		Goku goku = new Goku(tablero,equipoz);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero,enemigos);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.ataqueEspecial(cell);
		cell.atacarConBasico(goku);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),480);
		assertEquals(goku.getPuntosDeVida(),480);
	}
	
	@Test
	public void test07ColocarDosPersonajesYUsarAtaqueEspecialGoku(){
		Tablero tablero = new Tablero(3);
		Equipo enemigos = new Equipo();
		Equipo equipoz = new Equipo();
		Goku goku = new Goku(tablero,equipoz);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero,enemigos);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.aumentarKi(100);
		goku.ataqueEspecial(cell);
		cell.atacarConBasico(goku);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),470);
		assertEquals(goku.getPuntosDeVida(),480);
	}
	
	@Test
	public void test08ColocarDosPersonajesYUsarAbsorber(){
		Tablero tablero = new Tablero(3);
		Equipo enemigos = new Equipo();
		Equipo equipoz = new Equipo();
		Goku goku = new Goku(tablero,equipoz);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero,enemigos);
		tablero.colocarObjeto(cell,cell.getPosicion());
		cell.aumentarKi(100);
		cell.ataqueEspecial(goku);
		cell.atacarConBasico(goku);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),520);
		assertEquals(goku.getPuntosDeVida(),460);

		//Corrobor los ki
		assertEquals(cell.getKi(),95);
	}
	
	@Test(expected= AtaqueInvalido.class)
	public void test09ColocarTresPersonajesYUsarAtaquesEspecialesNoDeberiaPoder(){
		Tablero tablero = new Tablero(3);
		Equipo enemigos = new Equipo();
		Equipo equipoz = new Equipo();
		Goku goku = new Goku(tablero,equipoz);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Freezer freezer = new Freezer(tablero,enemigos);
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		Cell cell = new Cell(tablero,enemigos);
		tablero.colocarObjeto(cell,cell.getPosicion());
		cell.aumentarKi(100);
		freezer.aumentarKi(100);
		cell.ataqueEspecial(goku);
		cell.atacarConBasico(goku);
		freezer.ataqueEspecial(cell);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),520);
		assertEquals(goku.getPuntosDeVida(),460);

		//Corrobor los ki
		assertEquals(cell.getKi(),95);
		
		
	}
	
	@Test
	public void test10ColocarTresPersonajesYUsarAtaquesEspeciales(){
		Tablero tablero = new Tablero(3);
		Equipo enemigos = new Equipo();
		Equipo equipoz = new Equipo();
		Goku goku = new Goku(tablero,equipoz);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Freezer freezer = new Freezer(tablero,enemigos);
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		Cell cell = new Cell(tablero,enemigos);
		tablero.colocarObjeto(cell,cell.getPosicion());
		cell.aumentarKi(100);
		freezer.aumentarKi(100);
		cell.ataqueEspecial(goku);
		cell.atacarConBasico(goku);
		freezer.ataqueEspecial(goku);
		assertEquals(cell.getPuntosDeVida(),520);
		assertEquals(goku.getPuntosDeVida(),430);
		assertEquals(cell.getKi(),95);
		assertEquals(freezer.getKi(),80);
	}
}