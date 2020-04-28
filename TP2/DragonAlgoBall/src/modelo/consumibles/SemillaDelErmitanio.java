package modelo.consumibles;

import modelo.*;

public class SemillaDelErmitanio extends Consumible {
	public SemillaDelErmitanio(Tablero tablero){
		this.tablero = tablero;
		this.nombre = "Semilla del ermitanio";
		tablero.colocarObjeto(this, this.generarPosicion());
	}
	
	public void consumir(Personaje personaje){
		personaje.consumirSemillaDelErmitanio();
	}
	
}
