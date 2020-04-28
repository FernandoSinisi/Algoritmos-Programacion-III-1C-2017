package modelo.fases;

import java.util.HashMap;

import modelo.Equipo;
import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;
import modelo.personajes.Gohan;

public class FasePicolo1 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado1.get("Picolo");
	}

	public Fase transformar(int ki) {
		if(ki<this.obtenerStats().get("kiEvolucion")){
			throw new TransformacionInvalida();
		}
		return new FasePicolo2();
	}
	
	public Fase transformarPicolo(int ki,Equipo equipo){
		Gohan gohan = (Gohan) equipo.obtenerPersonaje("Gohan");
		int limiteVidaGohan = StatsJuego.puntosVidaInicialGohan*20/100;
		if(limiteVidaGohan>gohan.getPuntosDeVida()){
			return this.transformar(ki);
		}
		throw new TransformacionInvalida();
	}

}
