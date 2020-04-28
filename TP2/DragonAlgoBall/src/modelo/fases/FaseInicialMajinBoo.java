package modelo.fases;

import java.util.HashMap;

import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseInicialMajinBoo extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsIniciales.get("MajinBoo");
	}

	public Fase transformar(int ki) {
		if(ki<this.obtenerStats().get("kiEvolucion")){
			throw new TransformacionInvalida();
		}
		return new FaseMajinBoo1();
	}

}
