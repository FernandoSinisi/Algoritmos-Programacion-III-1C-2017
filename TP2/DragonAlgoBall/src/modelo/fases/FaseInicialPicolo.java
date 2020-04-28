package modelo.fases;

import java.util.HashMap;

import modelo.Equipo;
import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseInicialPicolo extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsIniciales.get("Picolo");
	}
	
	public Fase transformar(int ki) {
		if(ki<this.obtenerStats().get("kiEvolucion")){
			throw new TransformacionInvalida();
		}
		return new FasePicolo1();
	}
	
	public Fase transformarPicolo(int kiActual, Equipo equipo){
		return this.transformar(kiActual);
	}

}
