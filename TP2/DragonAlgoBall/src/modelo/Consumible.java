package modelo;
import java.util.Random;


public abstract class Consumible extends ObjetoJuego{
	
	public abstract void consumir(Personaje personaje);
	
	public Posicion generarPosicion(){
		Random randomGenerador = new Random();
		int randX = randomGenerador.nextInt(tablero.getTamanio()) +1;
		int randY = randomGenerador.nextInt(tablero.getTamanio()) +1;
		return new Posicion(randX,randY);
	}
	
}
