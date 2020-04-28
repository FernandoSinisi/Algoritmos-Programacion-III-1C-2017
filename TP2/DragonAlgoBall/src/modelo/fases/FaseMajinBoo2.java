package modelo.fases;

import java.util.HashMap;

import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseMajinBoo2 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado2.get("MajinBoo");
	}

	public Fase transformar(int ki) {
		throw new TransformacionInvalida();
	}

}
