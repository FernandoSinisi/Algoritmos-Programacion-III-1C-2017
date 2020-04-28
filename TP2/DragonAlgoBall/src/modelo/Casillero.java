package modelo;

import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.CasilleroVacio;

public class Casillero {
	
	private final ObjetoJuego vacio = null;
	private ObjetoJuego objeto = vacio;
	
	public void agregarObjeto(ObjetoJuego unObjeto) {
		if (!this.estaVacio()) {
			throw new CasilleroOcupado();
		}
		this.objeto = unObjeto;
	}
	
	public ObjetoJuego eliminarObjeto() {
		if(this.estaVacio()){
			throw new CasilleroVacio();
		}
		ObjetoJuego unObjeto = this.objeto;
		this.objeto = vacio;
		return unObjeto;
	}
	
	public ObjetoJuego obtenerObjeto() {
		if(this.estaVacio()){
			throw new CasilleroVacio();
		}
		return this.objeto;
	}
	
	public boolean estaVacio(){
		return (objeto == vacio);
	}
	
}