package modelo.fases;

import java.util.HashMap;

import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseFreezer2 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado2.get("Freezer");
	}

	public Fase transformar(int ki) {
		throw new TransformacionInvalida();
	}

}
