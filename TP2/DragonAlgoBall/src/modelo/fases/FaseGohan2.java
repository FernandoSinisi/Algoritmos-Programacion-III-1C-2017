package modelo.fases;

import java.util.HashMap;

import modelo.Equipo;
import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseGohan2 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado2.get("Gohan");
	}

	public Fase transformar(int ki) {
		throw new TransformacionInvalida();
	}
	
	public Fase transformarGohan(int ki,Equipo equipo){
		throw new TransformacionInvalida();
	}

}
