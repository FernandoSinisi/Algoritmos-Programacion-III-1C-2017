package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;
import modelo.personajes.*;
import modelo.turnos.*;
import modelo.excepciones.*;


public class TestIntegracionPrimeraEntrega {
	
	int TAMANIO = 10;
	int TAMANIO2 = 5;
	
	@Test
	public void test01UbicarPersonajeEnCasilleroMoverloVerificarPosicion(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero,equipo);
		Posicion posGoku = goku.getPosicion();
		tablero.colocarObjeto(goku, posGoku);
		assertTrue(tablero.compararPosicion(goku.getPosicion(),posGoku));
		goku.MoverPersonajeHaciaArriba();
		Posicion posNuevaGoku = new Posicion(posGoku.getCoordenadaX(),posGoku.getCoordenadaY()+1);
		assertTrue(tablero.compararPosicion(goku.getPosicion(), posNuevaGoku));
	}
	
	@Test (expected = CasilleroOcupado.class)
	public void test02UbicarDosPersonajesEnElMismoCasillero(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Cell cell = new Cell(tablero,equipo2);
		Picolo picolo = new Picolo(tablero,equipo1);
		Posicion pos = cell.getPosicion();
		tablero.colocarObjeto(cell, pos);
		tablero.colocarObjeto(picolo, pos);
	}
	
	@Test (expected = MovimientoInvalido.class)
	public void test03NoPuedePasarUnPersonajePorEncimaDelOtro(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Freezer freezer = new Freezer(tablero,equipo1);
		MajinBoo majinBoo= new MajinBoo(tablero,equipo1);
		tablero.colocarObjeto(freezer, freezer.getPosicion());
		tablero.colocarObjeto(majinBoo, majinBoo.getPosicion());
		majinBoo.MoverPersonajeHaciaAbajoDerecha();	
	}
	
	@Test (expected = TransformacionInvalida.class)
	public void test04FallaAlEvolucionar(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		gohan.transformar();
	}
	
	
	@Test
	public void test05VerificarEvolucionGohan(){
		
		int KIEVOLUCION1GOHAN = 10;
		int PODERPELEAGOHANSSJ = 30;
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		gohan.aumentarKi(KIEVOLUCION1GOHAN);
		gohan.transformar();
		
		assertEquals(gohan.getPoderDePelea(),PODERPELEAGOHANSSJ);
	}
	
	@Test(expected = AtaqueInvalido.class)
	public void test06AtacarADistanciaInvalidaFalla(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		
		tablero.colocarObjeto(goku, goku.getPosicion());
		tablero.colocarObjeto(cell, cell.getPosicion());
		goku.atacarConBasico(cell);
	}
	
	@Test
	public void test07AtaqueValidoSinEvolucionVerificaRestaVida(){
		
		Tablero tablero = new Tablero(TAMANIO2);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		
		tablero.colocarObjeto(goku, goku.getPosicion());
		tablero.colocarObjeto(cell, cell.getPosicion());
		
		int puntosVidaGokuInicial = goku.getPuntosDeVida();
		int ataqueNormalCell = cell.getPoderDePelea();
		
		goku.MoverPersonajeHaciaArribaDerecha();
		goku.MoverPersonajeHaciaArribaDerecha();
		cell.atacarConBasico(goku);
		
		assertEquals(goku.getPuntosDeVida(), puntosVidaGokuInicial - ataqueNormalCell);
	}
	
	@Test (expected = GanadorEquipoZ.class)
	public void test08CrearJuegoConDosJugadores(){
		
		Tablero tablero = new Tablero(StatsJuego.tamanioTablero);
		Equipo equipoGuerrerosZ = new Equipo();
		Equipo equipoEnemigos = new Equipo();
		
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		Personaje[] equipoz = {goku,gohan,picolo};
		
		for(Personaje personaje: equipoz){
			equipoGuerrerosZ.agregarMiembro(personaje);
		}
		

		Cell cell = new Cell(tablero,equipoEnemigos);
		Freezer freezer = new Freezer(tablero,equipoEnemigos);
		MajinBoo majinBoo = new MajinBoo(tablero,equipoEnemigos);
		
		Personaje[] enemigos = {cell,freezer,majinBoo};
		
		for(Personaje personaje: enemigos){
			equipoEnemigos.agregarMiembro(personaje);
		}
		
		TurnoEquipoZ turnoZ1= new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		turnoZ1.controlarJuegadoresEquipoContrario();	
		turnoZ1.terminoTurno();
		
		TurnoEquipoEnemigos turnoEnemigos1 = new TurnoEquipoEnemigos(tablero,equipoEnemigos);
		turnoEnemigos1.controlarJuegadoresEquipoContrario();	

		cell.morir();
		freezer.morir();
		majinBoo.morir();
		
		turnoEnemigos1.terminoTurno();
		
		TurnoEquipoZ turnoZ2= new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		turnoZ2.controlarJuegadoresEquipoContrario();

	}
	
	@Test (expected = AtaqueInvalido.class)
	public void test09AtacarAPersonajeAMayorDistanciaDelAlcance(){
		
		Tablero tablero = new Tablero(StatsJuego.tamanioTablero);
		Equipo equipoGuerrerosZ = new Equipo();
		Equipo equipoEnemigos = new Equipo();
		
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		equipoGuerrerosZ.agregarMiembro(goku);
		
		Cell cell = new Cell(tablero,equipoEnemigos);
		equipoEnemigos.agregarMiembro(cell);
		
		goku.atacarConBasico(cell);
	}
	
	@Test
	public void test10AtaqueValidoVerificandoDanio(){
		
		int TAMANIOTABLERO = 5;
		
		Tablero tablero = new Tablero(TAMANIOTABLERO);
		Equipo equipoGuerrerosZ = new Equipo();
		Equipo equipoEnemigos = new Equipo();
		
		Gohan gohan =  new Gohan(tablero,equipoGuerrerosZ);
		equipoGuerrerosZ.agregarMiembro(gohan);
		tablero.colocarObjeto(gohan,gohan.getPosicion());
		
		MajinBoo majinBoo = new MajinBoo(tablero,equipoEnemigos);
		equipoEnemigos.agregarMiembro(majinBoo);
		tablero.colocarObjeto(majinBoo, majinBoo.getPosicion());
		
		gohan.MoverPersonajeHaciaArribaDerecha();
		gohan.MoverPersonajeHaciaArribaDerecha();
		gohan.atacarConBasico(majinBoo);
		
		assertEquals(majinBoo.getPuntosDeVida(),288);
	}
	
}
