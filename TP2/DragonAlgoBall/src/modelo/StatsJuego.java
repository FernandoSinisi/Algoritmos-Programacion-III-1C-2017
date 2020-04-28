package modelo;
import java.util.*;



public class StatsJuego {

	public static final int tamanioTablero = 10;
	public static final int tamanioTableroMinimo = 3;
	public static final int velocidadGokuNormal = 2;
	public static final int velocidadGokuKaioKen = 3;
	public static final int velocidadGokuSsj = 5;
	public static final int distanciaAtaqueGokuNormal = 2;
	public static final int distanciaAtaqueGokuKaioKen = 4;
	public static final int distanciaAtaqueGokuSsj = 4;
	public static final int poderPeleaGokuNormal = 20;
	public static final int poderPeleaGokuKaioKen = 40;
	public static final int poderPeleaGokuSsj = 60;
	public static final int puntosVidaInicialGoku = 500;
	public static final int kiAtaqueEspecialGoku = 20;
	public static final int velocidadGohanNormal = 2;
	public static final int velocidadGohanSsj = 2;
	public static final int velocidadGohanSsj2 = 3;
	public static final int distanciaAtaqueGohanNormal = 2;
	public static final int distanciaAtaqueGohanSsj = 2;
	public static final int distanciaAtaqueGohanSsj2 = 4;
	public static final int poderPeleaGohanNormal = 15;
	public static final int poderPeleaGohanSsj = 30;
	public static final int poderPeleaGohanSsj2 = 100;
	public static final int puntosVidaInicialGohan = 300;
	public static final int kiAtaqueEspecialGohan = 10;
	public static final int velocidadPicoloNormal = 2;
	public static final int velocidadPicoloFortalezido = 3;
	public static final int velocidadPicoloProtector = 4;
	public static final int distanciaAtaquePicoloNormal = 2;
	public static final int distanciaAtaquePicoloFortalezido = 4;
	public static final int distanciaAtaquePicoloProtector = 6;
	public static final int poderPeleaPicoloNormal = 20;
	public static final int poderPeleaPicoloFortalezido = 40;
	public static final int poderPeleaPicoloProtector = 60;
	public static final int puntosVidaInicialPicolo = 500;
	public static final int kiAtaqueEspecialPicolo = 10;
	public static final int velocidadCellNormal = 2;
	public static final int velocidadCellSemiPerfecto = 3;
	public static final int velocidadCellPerfecto = 4;
	public static final int distanciaAtaqueCellNormal = 3;
	public static final int distanciaAtaqueCellSemiPerfecto = 4;
	public static final int distanciaAtaqueCellPerfecto = 4;
	public static final int poderPeleaCellNormal = 20;
	public static final int poderPeleaCellSemiPerfecto = 40;
	public static final int poderPeleaCellPerfecto = 80;
	public static final int puntosVidaInicialCell = 500;
	public static final int kiAtaqueEspecialCell = 5;
	public static final int velocidadFreezerNormal = 4;
	public static final int velocidadFreezerSegundaForma = 4;
	public static final int velocidadFreezerDefinitivo = 6;
	public static final int distanciaAtaqueFreezerNormal = 2;
	public static final int distanciaAtaqueFreezerSegundaForma = 3;
	public static final int distanciaAtaqueFreezerDefinitivo = 3;
	public static final int poderPeleaFreezerNormal = 20;
	public static final int poderPeleaFreezerSegundaForma = 40;
	public static final int poderPeleaFreezerDefinitivo = 50;
	public static final int puntosVidaInicialFreezer = 400;
	public static final int kiAtaqueEspecialFreezer = 20;
	public static final int velocidadMajinBooNormal = 2;
	public static final int velocidadMajinBooMalo = 3;
	public static final int velocidadMajinBooOriginal = 4;
	public static final int distanciaAtaqueMajinBooNormal = 2;
	public static final int distanciaAtaqueMajinBooMalo = 2;
	public static final int distanciaAtaqueMajinBooOriginal = 3;
	public static final int poderPeleaMajinBooNormal = 30;
	public static final int poderPeleaMajinBooMalo = 50;
	public static final int poderPeleaMajinBooOriginal = 60;
	public static final int puntosVidaInicialMajinBoo = 300;
	public static final int kiAtaqueEspecialMajinBoo = 30;
	public static final int kiAbsorberVidaCell = 5;
	public static final int kiEvolucionEstado1Goku = 20;
	public static final int kiEvolucionEstado2Goku = 50;
	public static final int kiEvolucionEstado1Gohan = 10;
	public static final int kiEvolucionEstado2Gohan = 30;
	public static final int kiEvolucionEstado1Picolo = 20;
	public static final int kiEvolucionEstado2Picolo = 0;
	public static final int kiEvolucionEstado1Freezer = 20;
	public static final int kiEvolucionEstado2Freezer = 50;
	public static final int kiEvolucionEstado1MajinBoo = 20;
	public static final int kiEvolucionEstado2MajinBoo = 50;
	public static final int kiEvolucionEstado1Cell = 0;
	public static final int kiEvolucionEstado2Cell = 0;
	public static final int kiAumentoPorTurno = 5;
	public static final double factorReduccionVidaGoku = 0.3;
	public static final double factorAumentoDanioGlobalGoku = 1.2;
	public static final double factorAumentoKamehameha = 1.5;
	public static final double factorAumentoMasenko = 1.25;
	public static final double factorAumentoMakankosappo = 1.25;
	public static final double factorAumentoRayoMortal = 1.5;
	public static final double factorAumentoEsferaDelDragon = 1.25;
	public static final int factorAumentoNubeVoladora = 2;
	public static final int aumentoDeVidaSemillaErmitanio = 100;
	public static final int cantidadAbsorcionesCellParaPrimeraEvolucion = 4;
	public static final int cantidadAbsorcionesCellParaSegundaEvolucion = 8;
	public static final double factorReduccionAtaquePorMayorPoderDePeleaEnemigo = 0.8;
	
	public static final HashMap<String,HashMap<String,Integer>> statsIniciales = obtenerEstadosIniciales();
	public static final HashMap<String,HashMap<String,Integer>> statsEstado1 = obtenerEstados1();
	public static final HashMap<String,HashMap<String,Integer>> statsEstado2 = obtenerEstados2();
	
	public static HashMap<String,HashMap<String, Integer>> obtenerEstadosIniciales(){
		HashMap<String,HashMap<String,Integer>> statsIniciales = new HashMap<String,HashMap<String,Integer>>();	
		HashMap<String,Integer> inicGohan = new HashMap<String,Integer>();
		HashMap<String,Integer> inicGoku = new HashMap<String,Integer>();
		HashMap<String,Integer> inicPicolo = new HashMap<String,Integer>();
		HashMap<String,Integer> inicFreezer = new HashMap<String,Integer>();
		HashMap<String,Integer> inicMajinBoo = new HashMap<String,Integer>();
		HashMap<String,Integer> inicCell = new HashMap<String,Integer>();
		inicGoku.put("velocidad", velocidadGokuNormal);
		inicGoku.put("poderDePelea", poderPeleaGokuNormal);
		inicGoku.put("distanciaDeAtaque", distanciaAtaqueGokuNormal);
		inicGoku.put("kiEvolucion", kiEvolucionEstado1Goku);
		inicGoku.put("puntosDeVida",puntosVidaInicialGoku);
		
		inicGohan.put("velocidad", velocidadGohanNormal);
		inicGohan.put("poderDePelea", poderPeleaGohanNormal);
		inicGohan.put("distanciaDeAtaque", distanciaAtaqueGohanNormal);
		inicGohan.put("kiEvolucion", kiEvolucionEstado1Gohan);
		inicGohan.put("puntosDeVida",puntosVidaInicialGohan);
		
		inicPicolo.put("velocidad", velocidadPicoloNormal);
		inicPicolo.put("poderDePelea", poderPeleaPicoloNormal);
		inicPicolo.put("distanciaDeAtaque", distanciaAtaquePicoloNormal);
		inicPicolo.put("kiEvolucion", kiEvolucionEstado1Picolo);
		inicPicolo.put("puntosDeVida",puntosVidaInicialPicolo);
		
		inicFreezer.put("velocidad", velocidadFreezerNormal);
		inicFreezer.put("poderDePelea", poderPeleaFreezerNormal);
		inicFreezer.put("distanciaDeAtaque", distanciaAtaqueFreezerNormal);
		inicFreezer.put("kiEvolucion", kiEvolucionEstado1Freezer);
		inicFreezer.put("puntosDeVida",puntosVidaInicialFreezer);
		
		inicMajinBoo.put("velocidad", velocidadMajinBooNormal);
		inicMajinBoo.put("poderDePelea", poderPeleaMajinBooNormal);
		inicMajinBoo.put("distanciaDeAtaque", distanciaAtaqueMajinBooNormal);
		inicMajinBoo.put("kiEvolucion", kiEvolucionEstado1MajinBoo);
		inicMajinBoo.put("puntosDeVida",puntosVidaInicialMajinBoo);
		
		inicCell.put("velocidad", velocidadCellNormal);
		inicCell.put("poderDePelea", poderPeleaCellNormal);
		inicCell.put("distanciaDeAtaque", distanciaAtaqueCellNormal);
		inicCell.put("kiEvolucion", kiEvolucionEstado1Cell);
		inicCell.put("puntosDeVida",puntosVidaInicialCell);
		
		statsIniciales.put("Goku", inicGoku);
		statsIniciales.put("Gohan", inicGohan);
		statsIniciales.put("Picolo", inicPicolo);
		statsIniciales.put("Freezer", inicFreezer);
		statsIniciales.put("MajinBoo", inicMajinBoo);
		statsIniciales.put("Cell", inicCell);
		
		return statsIniciales;
	}
	
	public static HashMap<String,HashMap<String,Integer>> obtenerEstados1(){
		HashMap<String,HashMap<String,Integer>> e1Stats = new HashMap<String,HashMap<String,Integer>>();	
		HashMap<String,Integer> e1Gohan = new HashMap<String,Integer>();
		HashMap<String,Integer> e1Goku = new HashMap<String,Integer>();
		HashMap<String,Integer> e1Picolo = new HashMap<String,Integer>();
		HashMap<String,Integer> e1Freezer = new HashMap<String,Integer>();
		HashMap<String,Integer> e1MajinBoo = new HashMap<String,Integer>();
		HashMap<String,Integer> e1Cell = new HashMap<String,Integer>();
		e1Goku.put("velocidad", velocidadGokuKaioKen);
		e1Goku.put("poderDePelea", poderPeleaGokuKaioKen);
		e1Goku.put("distanciaDeAtaque", distanciaAtaqueGokuKaioKen);
		e1Goku.put("kiEvolucion", kiEvolucionEstado2Goku);
		
		e1Gohan.put("velocidad", velocidadGohanSsj);
		e1Gohan.put("poderDePelea", poderPeleaGohanSsj);
		e1Gohan.put("distanciaDeAtaque", distanciaAtaqueGohanSsj);
		e1Gohan.put("kiEvolucion", kiEvolucionEstado2Gohan);
		
		e1Picolo.put("velocidad", velocidadPicoloFortalezido);
		e1Picolo.put("poderDePelea", poderPeleaPicoloFortalezido);
		e1Picolo.put("distanciaDeAtaque", distanciaAtaquePicoloFortalezido);
		e1Picolo.put("kiEvolucion", kiEvolucionEstado2Picolo);
		
		e1Freezer.put("velocidad", velocidadFreezerSegundaForma);
		e1Freezer.put("poderDePelea", poderPeleaFreezerSegundaForma);
		e1Freezer.put("distanciaDeAtaque", distanciaAtaqueFreezerSegundaForma);
		e1Freezer.put("kiEvolucion", kiEvolucionEstado2Freezer);
		
		e1MajinBoo.put("velocidad", velocidadMajinBooMalo);
		e1MajinBoo.put("poderDePelea", poderPeleaMajinBooMalo);
		e1MajinBoo.put("distanciaDeAtaque", distanciaAtaqueMajinBooMalo);
		e1MajinBoo.put("kiEvolucion", kiEvolucionEstado2MajinBoo);
		
		e1Cell.put("velocidad", velocidadCellSemiPerfecto);
		e1Cell.put("poderDePelea", poderPeleaCellSemiPerfecto);
		e1Cell.put("distanciaDeAtaque", distanciaAtaqueCellSemiPerfecto);
		e1Cell.put("kiEvolucion", kiEvolucionEstado2Cell);
		
		e1Stats.put("Goku", e1Goku);
		e1Stats.put("Gohan", e1Gohan);
		e1Stats.put("Picolo", e1Picolo);
		e1Stats.put("Freezer", e1Freezer);
		e1Stats.put("MajinBoo", e1MajinBoo);
		e1Stats.put("Cell", e1Cell);
		
		return e1Stats;
	}

	public static HashMap<String,HashMap<String,Integer>> obtenerEstados2(){
		HashMap<String,HashMap<String,Integer>> e2Stats = new HashMap<String,HashMap<String,Integer>>();	
		HashMap<String,Integer> e2Gohan = new HashMap<String,Integer>();
		HashMap<String,Integer> e2Goku = new HashMap<String,Integer>();
		HashMap<String,Integer> e2Picolo = new HashMap<String,Integer>();
		HashMap<String,Integer> e2Freezer = new HashMap<String,Integer>();
		HashMap<String,Integer> e2MajinBoo = new HashMap<String,Integer>();
		HashMap<String,Integer> e2Cell = new HashMap<String,Integer>();
		e2Goku.put("velocidad", velocidadGokuSsj);
		e2Goku.put("poderDePelea", poderPeleaGokuSsj);
		e2Goku.put("distanciaDeAtaque", distanciaAtaqueGokuSsj);
		e2Goku.put("kiEvolucion", 0);
		
		e2Gohan.put("velocidad", velocidadGohanSsj2);
		e2Gohan.put("poderDePelea", poderPeleaGohanSsj2);
		e2Gohan.put("distanciaDeAtaque", distanciaAtaqueGohanSsj2);
		e2Gohan.put("kiEvolucion",0);
		
		e2Picolo.put("velocidad", velocidadPicoloProtector);
		e2Picolo.put("poderDePelea", poderPeleaPicoloProtector);
		e2Picolo.put("distanciaDeAtaque", distanciaAtaquePicoloProtector);
		e2Picolo.put("kiEvolucion", 0);
		
		e2Freezer.put("velocidad", velocidadFreezerDefinitivo);
		e2Freezer.put("poderDePelea", poderPeleaFreezerDefinitivo);
		e2Freezer.put("distanciaDeAtaque", distanciaAtaqueFreezerDefinitivo);
		e2Freezer.put("kiEvolucion",0);
		
		e2MajinBoo.put("velocidad", velocidadMajinBooOriginal);
		e2MajinBoo.put("poderDePelea", poderPeleaMajinBooOriginal);
		e2MajinBoo.put("distanciaDeAtaque", distanciaAtaqueMajinBooOriginal);
		e2MajinBoo.put("kiEvolucion", 0);
		
		e2Cell.put("velocidad", velocidadCellPerfecto);
		e2Cell.put("poderDePelea", poderPeleaCellPerfecto);
		e2Cell.put("distanciaDeAtaque", distanciaAtaqueCellPerfecto);
		e2Cell.put("kiEvolucion",0);
		
		e2Stats.put("Goku", e2Goku);
		e2Stats.put("Gohan", e2Gohan);
		e2Stats.put("Picolo", e2Picolo);
		e2Stats.put("Freezer", e2Freezer);
		e2Stats.put("MajinBoo", e2MajinBoo);
		e2Stats.put("Cell", e2Cell);
		
		return e2Stats;
	}	
	
		
}
