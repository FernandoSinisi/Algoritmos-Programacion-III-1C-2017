package modelo;

import java.util.*;

public class Equipo {
	protected Hashtable<String,Personaje> miembros;

	
	public Equipo(){
		this.miembros = new Hashtable<String,Personaje>();
	}
	
	public boolean contiene(Personaje personaje){
		return this.miembros.containsKey(personaje.getNombre());
	}
	
	public Collection<Personaje> getMiembros(){
		return miembros.values();
	}
	
	public int getCantidadDeEsferasCapturadas(){
		int total = 0;
		for (Personaje personaje : miembros.values()) {
			total+=personaje.getCantidadEsferasConsumidas();
		}
		return total;
	}
	
	public void agregarMiembro(Personaje personaje){
		String nombre = personaje.getNombre();
		this.miembros.put(nombre,personaje);
	}
	
	public Personaje obtenerPersonaje(String nombre){
		return miembros.get(nombre);
	}
	

}
