package modelo.consumibles;

import modelo.*;

public class NubeVoladora extends Consumible {
	public NubeVoladora(Tablero tablero){
		this.tablero = tablero;
		this.nombre = "Nube voladora";
		tablero.colocarObjeto(this, this.generarPosicion());
	}
	
	public void consumir(Personaje personaje){
		personaje.consumirNubeVoladora();
	}
	
}
