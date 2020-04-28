package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;
import modelo.personajes.*;
import modelo.excepciones.*;

public class TestIntegracionSegundaEntrega {
	
	@Test(expected = TransformacionInvalida.class)
	public void test01GohanRealizaPrimeraTransformacionNoPuedeRealizarLaSegunda(){
		
		Tablero tablero = new Tablero(StatsJuego.tamanioTablero);
		Equipo equipoGuerrerosZ = new Equipo();
		
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		
		Personaje[] equipoZ = {goku,gohan,picolo};

		for(Personaje personaje: equipoZ){
			equipoGuerrerosZ.agregarMiembro(personaje);
			tablero.colocarObjeto(personaje, personaje.getPosicion());
		}
		
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado1Gohan);
		gohan.transformar();
		
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado2Gohan);
		gohan.transformar();
	}
	
	@Test
	public void test02GohanRealizaPrimeraYSegundaTransformacion(){
		
		int REDUCCIONVIDAGOKU = (StatsJuego.puntosVidaInicialGoku)*71/100;
		int REDUCCIONVIDAPICOLO = (StatsJuego.puntosVidaInicialPicolo)*71/100;
		
		Tablero tablero = new Tablero(StatsJuego.tamanioTablero);
		Equipo equipoGuerrerosZ = new Equipo();
		
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		
		Personaje[] equipoZ = {goku,gohan,picolo};

		for(Personaje personaje: equipoZ){
			equipoGuerrerosZ.agregarMiembro(personaje);
			tablero.colocarObjeto(personaje, personaje.getPosicion());
		}
		
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado1Gohan);
		gohan.transformar();
		
		goku.reducirVida(REDUCCIONVIDAGOKU);
		picolo.reducirVida(REDUCCIONVIDAPICOLO);
		
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado2Gohan);
		gohan.transformar();
	}
	
	@Test(expected = TransformacionInvalida.class)
	public void test03PicoloRealizaPrimeraTransformacionNoPuedeRealizarLaSegunda(){
		
		Tablero tablero = new Tablero(StatsJuego.tamanioTablero);
		Equipo equipoGuerrerosZ = new Equipo();
		
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		
		Personaje[] equipoZ = {gohan,picolo};

		for(Personaje personaje: equipoZ){
			equipoGuerrerosZ.agregarMiembro(personaje);
			tablero.colocarObjeto(personaje, personaje.getPosicion());
		}
		
		picolo.aumentarKi(StatsJuego.kiEvolucionEstado1Picolo);
		picolo.transformar();
		
		picolo.aumentarKi(StatsJuego.kiEvolucionEstado2Picolo);
		picolo.transformar();
	}
	
	@Test
	public void test04PicoloRealizaPrimeraYSegundaTransformacion(){
		
		int REDUCCIONVIDAGOHAN = (StatsJuego.puntosVidaInicialPicolo)*81/100;
		
		Tablero tablero = new Tablero(StatsJuego.tamanioTablero);
		Equipo equipoGuerrerosZ = new Equipo();
		
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		
		Personaje[] equipoZ = {gohan,picolo};

		for(Personaje personaje: equipoZ){
			equipoGuerrerosZ.agregarMiembro(personaje);
			tablero.colocarObjeto(personaje, personaje.getPosicion());
		}
		
		picolo.aumentarKi(StatsJuego.kiEvolucionEstado1Picolo);
		picolo.transformar();
		
		gohan.reducirVida(REDUCCIONVIDAGOHAN);
		
		picolo.aumentarKi(StatsJuego.kiEvolucionEstado2Picolo);
		picolo.transformar();
	}
	
	@Test(expected = TransformacionInvalida.class)
	public void test05CellNoPuedeTransformarse(){
		
		Tablero tablero = new Tablero(StatsJuego.tamanioTablero);
		Equipo equipoEnemigos = new Equipo();
		
		Cell cell = new Cell(tablero,equipoEnemigos);
		equipoEnemigos.agregarMiembro(cell);
		tablero.colocarObjeto(cell, cell.getPosicion());
		
		cell.aumentarKi(StatsJuego.kiEvolucionEstado1Cell);
		cell.transformar();
	}
	
	@Test
	public void test06CellAbsorberVidaGoku(){
		
		int TAMANIOTABLERO = 5;
		
		Tablero tablero = new Tablero(TAMANIOTABLERO);
		Equipo equipoZ = new Equipo();
		Equipo equipoEnemigos = new Equipo();
		
		Cell cell = new Cell(tablero,equipoEnemigos);
		equipoEnemigos.agregarMiembro(cell);
		tablero.colocarObjeto(cell, cell.getPosicion());
		
		Goku goku = new Goku(tablero,equipoZ);
		equipoZ.agregarMiembro(goku);
		tablero.colocarObjeto(goku, goku.getPosicion());
		
		cell.aumentarKi(StatsJuego.kiAbsorberVidaCell);
		cell.MoverPersonajeHaciaAbajoIzquierda();
		cell.MoverPersonajeHaciaAbajoIzquierda();
		cell.ataqueEspecial(goku);
		
		assertEquals(goku.getPuntosDeVida(),StatsJuego.puntosVidaInicialGoku-StatsJuego.poderPeleaCellNormal);
		assertEquals(cell.getPuntosDeVida(),StatsJuego.puntosVidaInicialCell + StatsJuego.poderPeleaCellNormal);
		
	}
	
	@Test
	public void test07CellAbsorberVidaAGokuHastaEVolucionar(){
		
		int TAMANIOTABLERO = 5;
		int cantidadAbsorciones = 0;
		
		Tablero tablero = new Tablero(TAMANIOTABLERO);
		Equipo equipoZ = new Equipo();
		Equipo equipoEnemigos = new Equipo();
		
		Cell cell = new Cell(tablero,equipoEnemigos);
		equipoEnemigos.agregarMiembro(cell);
		tablero.colocarObjeto(cell, cell.getPosicion());
		
		Goku goku = new Goku(tablero,equipoZ);
		equipoZ.agregarMiembro(goku);
		tablero.colocarObjeto(goku, goku.getPosicion());
		
		cell.MoverPersonajeHaciaAbajoIzquierda();
		cell.MoverPersonajeHaciaAbajoIzquierda();
		
		cell.aumentarKi(StatsJuego.kiEvolucionEstado1Cell);
		
		while(cantidadAbsorciones<StatsJuego.cantidadAbsorcionesCellParaPrimeraEvolucion){
			cell.aumentarKi(StatsJuego.kiAbsorberVidaCell);
			cell.ataqueEspecial(goku);
			cantidadAbsorciones++;
		}
		
		assertEquals(cell.getPuntosDeVida(),StatsJuego.puntosVidaInicialCell+cell.getPoderDePelea()*cantidadAbsorciones);
		assertEquals(goku.getPuntosDeVida(),StatsJuego.puntosVidaInicialGoku-cell.getPoderDePelea()*cantidadAbsorciones);
				
		cell.transformar();
		assertEquals(cell.getPoderDePelea(),StatsJuego.poderPeleaCellSemiPerfecto);
		assertEquals(cell.getVelocidad(),StatsJuego.velocidadCellSemiPerfecto);
	}
	

	@Test(expected = PersonajeInmovilizado.class)
	public void test08CovierteEnChocolate(){
		
		int TAMANIOTABLERO = 5;
		
		Tablero tablero = new Tablero(TAMANIOTABLERO);
		Equipo equipoZ = new Equipo();
		Equipo equipoEnemigos = new Equipo();
		
		MajinBoo majinBoo = new MajinBoo(tablero,equipoEnemigos);
		equipoEnemigos.agregarMiembro(majinBoo);
		tablero.colocarObjeto(majinBoo, majinBoo.getPosicion());
		
		Goku goku = new Goku(tablero,equipoZ);
		equipoZ.agregarMiembro(goku);
		tablero.colocarObjeto(goku, goku.getPosicion());
		
		goku.MoverPersonajeHaciaArribaDerecha();
		
		majinBoo.MoverPersonajeHaciaAbajoIzquierda();
		majinBoo.MoverPersonajeHaciaAbajoIzquierda();
		
		majinBoo.aumentarKi(StatsJuego.kiAtaqueEspecialMajinBoo);
		majinBoo.ataqueEspecial(goku);
		
		goku.MoverPersonajeHaciaAbajoIzquierda();
	}
	
	@Test
	public void test09AumentaElDanioDeGokuAlTenerMenosDelVeintePorcientoDeVida(){
		
int TAMANIOTABLERO = 5;
		
		Tablero tablero = new Tablero(TAMANIOTABLERO);
		Equipo equipoZ = new Equipo();
		Equipo equipoEnemigos = new Equipo();
		
		Goku goku = new Goku(tablero,equipoZ);
		equipoZ.agregarMiembro(goku);
		tablero.colocarObjeto(goku, goku.getPosicion());
		
		Cell cell = new Cell(tablero,equipoEnemigos);
		equipoEnemigos.agregarMiembro(cell);
		tablero.colocarObjeto(cell, cell.getPosicion());
		
		cell.MoverPersonajeHaciaAbajoIzquierda();
		cell.MoverPersonajeHaciaAbajoIzquierda();
		
		goku.MoverPersonajeHaciaArribaDerecha();
		goku.reducirVida(StatsJuego.puntosVidaInicialGoku*71/100);
		goku.atacarConBasico(cell);
		//assertEquals(cell.getPuntosDeVida(),480);
		assertEquals(cell.getPuntosDeVida(),StatsJuego.puntosVidaInicialCell-StatsJuego.poderPeleaGokuNormal*12/10);
	}
	
	
}
