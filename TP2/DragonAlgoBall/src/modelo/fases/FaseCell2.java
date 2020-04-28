package modelo.fases;

import java.util.HashMap;

import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseCell2 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado2.get("Cell");
	}

	public Fase transformar(int ki) {
		throw new TransformacionInvalida();
	}
	
	public Fase transformarCell(int ki,int cantidadDeAbsorber){
		throw new TransformacionInvalida();
	}

}
