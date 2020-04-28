package modelo.fases;

import java.util.HashMap;

import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseMajinBoo1 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado1.get("MajinBoo");
	}

	public Fase transformar(int ki) {
		if(ki<this.obtenerStats().get("kiEvolucion")){
			throw new TransformacionInvalida();
		}
		return new FaseMajinBoo2();
	}

}
