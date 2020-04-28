package modelo.fases;

import java.util.HashMap;

import modelo.Equipo;
import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseInicialGohan extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsIniciales.get("Gohan");
	}

	public Fase transformar(int ki) {
		if(ki<this.obtenerStats().get("kiEvolucion")){
			throw new TransformacionInvalida();
		}
		return new FaseGohan1();
	}
	
	public Fase transformarGohan(int ki,Equipo equipo){
		return this.transformar(ki);
	}

}
