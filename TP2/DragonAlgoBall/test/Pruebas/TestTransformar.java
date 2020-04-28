package Pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Equipo;
import modelo.StatsJuego;
import modelo.Tablero;
import modelo.excepciones.TransformacionInvalida;
import modelo.personajes.Cell;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.Picolo;


public class TestTransformar {
	int TAMANIO = 4;
	int KIEVOLUCION1GOKU = 20;
	int KIEVOLUCION2GOKU = 50;
	
	@Test
	public void test01EstadoInicialGoku(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero,equipo);
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuNormal);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuNormal);
	}
	
	@Test
	public void test02EstadoKaioKenGoku(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero,equipo);
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuNormal);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuNormal);
				
		goku.aumentarKi(KIEVOLUCION1GOKU);
		assertEquals(goku.getKi(),KIEVOLUCION1GOKU);
		
		goku.transformar();
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuKaioKen);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuKaioKen);
		
	}
	
	@Test
	public void test03EstadoSsjGoku(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero,equipo);
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuNormal);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuNormal);
		
		goku.aumentarKi(KIEVOLUCION1GOKU);
		assertEquals(goku.getKi(),KIEVOLUCION1GOKU);
		
		goku.transformar();
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuKaioKen);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuKaioKen);
		
		goku.aumentarKi(KIEVOLUCION2GOKU);
		assertEquals(goku.getKi(),KIEVOLUCION2GOKU);
		
		goku.transformar();
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuSsj);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuSsj);
		
	}
	
	@Test
	public void test04EstadoInicialCell(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Cell cell = new Cell(tablero,equipo);
		
		assertEquals(cell.getKi(),0);
		assertEquals(cell.getPoderDePelea(),StatsJuego.poderPeleaCellNormal);
		assertEquals(cell.getVelocidad(),StatsJuego.velocidadCellNormal);
	}
	
	@Test
	public void test05EstadoSemiPerfectoEnCell(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		cell.aumentarKi(200);
		assertEquals(cell.getKi(),200);
		assertEquals(cell.getPoderDePelea(),StatsJuego.poderPeleaCellNormal);
		assertEquals(cell.getVelocidad(),StatsJuego.velocidadCellNormal);
		cell.ataqueEspecial(goku);
		cell.ataqueEspecial(goku);
		cell.ataqueEspecial(goku);
		cell.ataqueEspecial(goku);
		cell.transformar();
		assertEquals(cell.getPoderDePelea(),StatsJuego.poderPeleaCellSemiPerfecto);
		assertEquals(cell.getVelocidad(),StatsJuego.velocidadCellSemiPerfecto);
		
	}
	
	@Test (expected = TransformacionInvalida.class)
	public void test06EvolucionCellASemiPerfectoInvalida(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo2 = new Equipo();
		Cell cell = new Cell(tablero,equipo2);
		cell.transformar();
		
	}
	
	@Test
	public void test07EstadoPerfectoEnCell(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		cell.aumentarKi(2000);
		assertEquals(cell.getKi(),2000);
		assertEquals(cell.getPoderDePelea(),StatsJuego.poderPeleaCellNormal);
		assertEquals(cell.getVelocidad(),StatsJuego.velocidadCellNormal);
		for(int i=0; i<4 ;i++){
			cell.ataqueEspecial(goku);
		}
		cell.transformar();
		for(int i=0;i<8 ;i++){
			cell.ataqueEspecial(goku);
		}
		cell.transformar();
		assertEquals(cell.getPoderDePelea(),StatsJuego.poderPeleaCellPerfecto);
		assertEquals(cell.getVelocidad(),StatsJuego.velocidadCellPerfecto);
		
		

		
	}
	
	@Test (expected = TransformacionInvalida.class)
	public void test08EvolucionInvalidaAEstadoPerfectoEnCell(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		cell.aumentarKi(2000);
		assertEquals(cell.getKi(),2000);
		assertEquals(cell.getPoderDePelea(),StatsJuego.poderPeleaCellNormal);
		assertEquals(cell.getVelocidad(),StatsJuego.velocidadCellNormal);
		for(int i=0; i<4 ;i++){
			cell.ataqueEspecial(goku);
		}
		cell.transformar();
		for(int i=0;i<8 ;i++){
			cell.ataqueEspecial(goku);
		}
		cell.transformar();
		assertEquals(cell.getPoderDePelea(),StatsJuego.poderPeleaCellPerfecto);
		assertEquals(cell.getVelocidad(),StatsJuego.velocidadCellPerfecto);
		cell.transformar();
	}
	
	@Test (expected = TransformacionInvalida.class)
	public void test08TransformarGohanSinKi(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		gohan.transformar();
	}
	
	@Test 
	public void test09TransformarGohanConKiEsValido(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		gohan.aumentarKi(500);
		gohan.transformar();
		assertEquals(gohan.getPoderDePelea(),StatsJuego.poderPeleaGohanSsj);
		assertEquals(gohan.getVelocidad(),StatsJuego.velocidadGohanSsj);
		assertEquals(gohan.getKi(),500-StatsJuego.kiEvolucionEstado1Gohan);
		
	}
	
	@Test (expected = TransformacionInvalida.class)
	public void test10TransformarGohanAFase2SinAmigosHeridosDeberiaSerInvalido(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Picolo picolo = new Picolo(tablero,equipo1);
		Goku goku = new Goku(tablero,equipo1);
		equipo1.agregarMiembro(goku);
		equipo1.agregarMiembro(picolo);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado1Gohan);
		gohan.transformar();
		assertEquals(gohan.getPoderDePelea(),StatsJuego.poderPeleaGohanSsj);
		assertEquals(gohan.getVelocidad(),StatsJuego.velocidadGohanSsj);
		assertEquals(gohan.getKi(),0);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado2Gohan);
		gohan.transformar();
	}
	
	@Test
	public void test11TransformarGohanAFase2ConAmigosHeridosDeberiaSerPosible(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Picolo picolo = new Picolo(tablero,equipo1);
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		equipo1.agregarMiembro(gohan);
		equipo1.agregarMiembro(goku);
		equipo1.agregarMiembro(picolo);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado1Gohan);
		gohan.transformar();
		assertEquals(gohan.getPoderDePelea(),StatsJuego.poderPeleaGohanSsj);
		assertEquals(gohan.getVelocidad(),StatsJuego.velocidadGohanSsj);
		assertEquals(gohan.getKi(),0);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado2Gohan);
		for(int i=0 ; i<20;i++){
			cell.atacarConBasico(goku);
			cell.atacarConBasico(picolo);
		}
		gohan.transformar();
		assertEquals(gohan.getPoderDePelea(),StatsJuego.poderPeleaGohanSsj2);
		assertEquals(gohan.getVelocidad(),StatsJuego.velocidadGohanSsj2);
		assertEquals(gohan.getKi(),0);
	}
	
	@Test(expected = TransformacionInvalida.class)
	public void test12TransformarGohanParaFase2ConAmigosHeridosPeroNoVida30PorCientoDeberiaSerInvalido(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Picolo picolo = new Picolo(tablero,equipo1);
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		equipo1.agregarMiembro(gohan);
		equipo1.agregarMiembro(goku);
		equipo1.agregarMiembro(picolo);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado1Gohan);
		gohan.transformar();
		assertEquals(gohan.getPoderDePelea(),StatsJuego.poderPeleaGohanSsj);
		assertEquals(gohan.getVelocidad(),StatsJuego.velocidadGohanSsj);
		assertEquals(gohan.getKi(),0);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado2Gohan);
		for(int i=0 ; i<17;i++){
			cell.atacarConBasico(goku);
			cell.atacarConBasico(picolo);
		}
		gohan.transformar();
	}
	
	@Test(expected = TransformacionInvalida.class)
	public void test13TransformarGohanParaFase2ConAmigosHeridosPeroSinKiDeberiaSerInvalido(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Picolo picolo = new Picolo(tablero,equipo1);
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		equipo1.agregarMiembro(gohan);
		equipo1.agregarMiembro(goku);
		equipo1.agregarMiembro(picolo);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado1Gohan);
		gohan.transformar();
		assertEquals(gohan.getPoderDePelea(),StatsJuego.poderPeleaGohanSsj);
		assertEquals(gohan.getVelocidad(),StatsJuego.velocidadGohanSsj);
		assertEquals(gohan.getKi(),0);
		for(int i=0 ; i<17;i++){
			cell.atacarConBasico(goku);
			cell.atacarConBasico(picolo);
		}
		gohan.transformar();
	}
	
	@Test(expected = TransformacionInvalida.class)
	public void test14TransformarGohanAMasQueFase2DeberiaSerInvalido(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Picolo picolo = new Picolo(tablero,equipo1);
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		equipo1.agregarMiembro(gohan);
		equipo1.agregarMiembro(goku);
		equipo1.agregarMiembro(picolo);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado1Gohan);
		gohan.transformar();
		assertEquals(gohan.getPoderDePelea(),StatsJuego.poderPeleaGohanSsj);
		assertEquals(gohan.getVelocidad(),StatsJuego.velocidadGohanSsj);
		assertEquals(gohan.getKi(),0);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado2Gohan);
		for(int i=0 ; i<20;i++){
			cell.atacarConBasico(goku);
			cell.atacarConBasico(picolo);
		}
		gohan.transformar();
		gohan.transformar();
		
	}
	
	@Test
	public void test15TransformarGohanConMiembrosEquipoMuertos(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Picolo picolo = new Picolo(tablero,equipo1);
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		equipo1.agregarMiembro(gohan);
		equipo1.agregarMiembro(goku);
		equipo1.agregarMiembro(picolo);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado1Gohan);
		gohan.transformar();
		assertEquals(gohan.getPoderDePelea(),StatsJuego.poderPeleaGohanSsj);
		assertEquals(gohan.getVelocidad(),StatsJuego.velocidadGohanSsj);
		assertEquals(gohan.getKi(),0);
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado2Gohan);
		for(int i=0 ; i<500;i++){
			cell.atacarConBasico(goku);
			cell.atacarConBasico(picolo);
		}
		gohan.transformar();
		assertEquals(gohan.getPoderDePelea(),StatsJuego.poderPeleaGohanSsj2);
		assertEquals(gohan.getVelocidad(),StatsJuego.velocidadGohanSsj2);
		assertEquals(gohan.getKi(),0);
		
	}
	
	@Test (expected = TransformacionInvalida.class)
	public void test16TransformarPicoloSinKi(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Picolo picolo = new Picolo(tablero,equipo1);
		picolo.transformar();
	}
	
	@Test 
	public void test17TransformarPicoloConKiEsValido(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Picolo picolo = new Picolo(tablero,equipo1);
		picolo.aumentarKi(500);
		picolo.transformar();
		assertEquals(picolo.getPoderDePelea(),StatsJuego.poderPeleaPicoloFortalezido);
		assertEquals(picolo.getVelocidad(),StatsJuego.velocidadPicoloFortalezido);
		assertEquals(picolo.getKi(),500-StatsJuego.kiEvolucionEstado1Picolo);
	}
	
	@Test (expected = TransformacionInvalida.class)
	public void test18TransformarPicoloAFase1ConGohanSanoDeberiaSerInvalido(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Picolo picolo = new Picolo(tablero,equipo1);
		equipo1.agregarMiembro(picolo);
		equipo1.agregarMiembro(gohan);
		picolo.aumentarKi(500);
		picolo.transformar();
		assertEquals(picolo.getPoderDePelea(),StatsJuego.poderPeleaPicoloFortalezido);
		assertEquals(picolo.getVelocidad(),StatsJuego.velocidadPicoloFortalezido);
		assertEquals(picolo.getKi(),500-StatsJuego.kiEvolucionEstado1Picolo);
		picolo.transformar();
	}
	
	@Test (expected = TransformacionInvalida.class)
	public void test19TransformarPicoloAFase1ConGohanHeridoPeroNoLoSuficienteDeberiaSerInvalido(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		Picolo picolo = new Picolo(tablero,equipo1);
		equipo1.agregarMiembro(picolo);
		equipo1.agregarMiembro(gohan);
		picolo.aumentarKi(500);
		picolo.transformar();
		assertEquals(picolo.getPoderDePelea(),StatsJuego.poderPeleaPicoloFortalezido);
		assertEquals(picolo.getVelocidad(),StatsJuego.velocidadPicoloFortalezido);
		assertEquals(picolo.getKi(),500-StatsJuego.kiEvolucionEstado1Picolo);
		for(int i=0 ; i<12;i++){
			cell.atacarConBasico(gohan);
		}
		picolo.transformar();
	}
	
	@Test
	public void test20TransformarPicoloAFase1ConGohanHeridoLoSuficienteDeberiaSerValido(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		Picolo picolo = new Picolo(tablero,equipo1);
		equipo1.agregarMiembro(picolo);
		equipo1.agregarMiembro(gohan);
		picolo.aumentarKi(500);
		picolo.transformar();
		assertEquals(picolo.getPoderDePelea(),StatsJuego.poderPeleaPicoloFortalezido);
		assertEquals(picolo.getVelocidad(),StatsJuego.velocidadPicoloFortalezido);
		assertEquals(picolo.getKi(),500-StatsJuego.kiEvolucionEstado1Picolo);
		for(int i=0 ; i<15;i++){
			cell.atacarConBasico(gohan);
		}
		picolo.transformar();
		assertEquals(picolo.getPoderDePelea(),StatsJuego.poderPeleaPicoloProtector);
		assertEquals(picolo.getVelocidad(),StatsJuego.velocidadPicoloProtector);
		assertEquals(picolo.getKi(),500-StatsJuego.kiEvolucionEstado1Picolo-StatsJuego.kiEvolucionEstado2Picolo);
		
	}
	
	@Test(expected = TransformacionInvalida.class)
	public void test21TransformarPicoloAMasQueFase2DeberiaSerInvalido(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		Picolo picolo = new Picolo(tablero,equipo1);
		equipo1.agregarMiembro(picolo);
		equipo1.agregarMiembro(gohan);
		picolo.aumentarKi(500);
		picolo.transformar();
		for(int i=0 ; i<15;i++){
			cell.atacarConBasico(gohan);
		}
		picolo.transformar();
		picolo.transformar();
	}
	
	@Test
	public void test15TransformarPicoloConGohanMuerto(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		Picolo picolo = new Picolo(tablero,equipo1);
		equipo1.agregarMiembro(picolo);
		equipo1.agregarMiembro(gohan);
		picolo.aumentarKi(500);
		picolo.transformar();
		assertEquals(picolo.getPoderDePelea(),StatsJuego.poderPeleaPicoloFortalezido);
		assertEquals(picolo.getVelocidad(),StatsJuego.velocidadPicoloFortalezido);
		assertEquals(picolo.getKi(),500-StatsJuego.kiEvolucionEstado1Picolo);
		for(int i=0 ; i<100;i++){
			cell.atacarConBasico(gohan);
		}
		picolo.transformar();
		assertEquals(picolo.getPoderDePelea(),StatsJuego.poderPeleaPicoloProtector);
		assertEquals(picolo.getVelocidad(),StatsJuego.velocidadPicoloProtector);
		assertEquals(picolo.getKi(),500-StatsJuego.kiEvolucionEstado1Picolo-StatsJuego.kiEvolucionEstado2Picolo);
		
	}
	
	
	
	
	
	
	
}
