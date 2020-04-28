package modelo.consumibles;
import modelo.*;

public class EsferaDelDragon extends Consumible {
	
	public EsferaDelDragon(Tablero tablero){
		this.tablero = tablero;
		this.nombre = "Esfera del dragon";
		tablero.colocarObjeto(this, this.generarPosicion());
	}
	
	public void consumir(Personaje personaje){
		personaje.consumirEsferaDelDragon();
	}
	
	
}
