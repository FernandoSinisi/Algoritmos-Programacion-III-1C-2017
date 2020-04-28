package modelo.fases;

import java.util.HashMap;

import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseInicialCell extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsIniciales.get("Cell");
	}
	
	public Fase transformar(int ki) {
		if(ki<this.obtenerStats().get("kiEvolucion")){
			throw new TransformacionInvalida();
		}
		return new FaseCell1();
	}
	
	public Fase transformarCell(int ki,int cantidadDeAbsorber){
			if(cantidadDeAbsorber < 4){
				throw new TransformacionInvalida();
			}
			return transformar(ki);
		}
}
