package modelo.fases;

import java.util.HashMap;

import modelo.Equipo;
import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;
import modelo.personajes.Goku;
import modelo.personajes.Picolo;

public class FaseGohan1 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado1.get("Gohan");
	}

	public Fase transformar(int ki) {
		if(ki<this.obtenerStats().get("kiEvolucion")){
			throw new TransformacionInvalida();
		}
		return new FaseGohan2();
	}
	
	public Fase transformarGohan(int ki,Equipo equipo){
		Picolo picolo = (Picolo) equipo.obtenerPersonaje("Picolo");
		Goku goku = (Goku) equipo.obtenerPersonaje("Goku");
		int limiteVidaPicolo = StatsJuego.puntosVidaInicialPicolo*30/100;
		int limiteVidaGoku = StatsJuego.puntosVidaInicialGoku*30/100;
		if(limiteVidaGoku>goku.getPuntosDeVida() && limiteVidaPicolo>picolo.getPuntosDeVida()){
			return this.transformar(ki);
		}
		throw new TransformacionInvalida();
	}

}
