package modelo;

public abstract class ObjetoJuego {
	protected String nombre;
	protected Tablero tablero;
	
	public String getNombre(){
		return this.nombre;
	}
	public boolean esPersonaje(){
		return (this instanceof Personaje); 
	}
	public boolean esConsumible(){
		return (this instanceof Consumible); 
	}
}