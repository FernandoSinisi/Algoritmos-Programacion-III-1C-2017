package modelo.fases;

import java.util.HashMap;

import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseInicialGoku extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsIniciales.get("Goku");
	}

	public Fase transformar(int kiActual) {
		if(kiActual<this.obtenerStats().get("kiEvolucion")){
			throw new TransformacionInvalida();
		}
		return new FaseGoku1();
	}
}
