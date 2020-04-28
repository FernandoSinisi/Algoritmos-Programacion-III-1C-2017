package modelo.fases;

import java.util.HashMap;

import modelo.Equipo;
import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FasePicolo2 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado2.get("Picolo");
	}

	public Fase transformar(int ki) {
		throw new TransformacionInvalida();
	}
	
	public Fase transformarPicolo(int ki,Equipo equipo){
		throw new TransformacionInvalida();
	}

}
