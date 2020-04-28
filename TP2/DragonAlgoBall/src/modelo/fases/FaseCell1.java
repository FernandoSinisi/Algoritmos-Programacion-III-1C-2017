package modelo.fases;

import java.util.HashMap;

import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseCell1 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado1.get("Cell");
	}

	public Fase transformar(int ki) {
		if(ki<this.obtenerStats().get("kiEvolucion")){
			throw new TransformacionInvalida();
		}
		return new FaseCell2();
	}
	
	public Fase transformarCell(int ki,int cantidadDeAbsorber){
		if(cantidadDeAbsorber < 8){
			throw new TransformacionInvalida();
		}
		return this.transformar(ki);
	}
}
