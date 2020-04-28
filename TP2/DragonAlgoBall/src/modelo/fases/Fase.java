package modelo.fases;

import java.util.HashMap;

import modelo.Equipo;

public abstract class Fase {
	
	public abstract HashMap<String,Integer> obtenerStats();
	public abstract Fase transformar(int ki);
	public Fase transformarCell(int kiActual, int cantidadDeAbsorber){return null;}
	public Fase transformarGohan(int kiActual,Equipo equipo){return null;}
	public Fase transformarPicolo(int kiActual, Equipo equipo) {return null;}
	
}