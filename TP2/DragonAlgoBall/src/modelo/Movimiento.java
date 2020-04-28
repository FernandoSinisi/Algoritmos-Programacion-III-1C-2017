package modelo;

import modelo.excepciones.PasosInsuficientes;

public class Movimiento {
	private int cantidadPasosMoverse;
	private Posicion posicionActual;
	
	public Movimiento(int velocidad,Posicion pos){
		this.cantidadPasosMoverse = velocidad;
		this.posicionActual = pos;
	}
	
	public Posicion getPosicion() {
		return this.posicionActual;
	}
	
	public void MoverArriba(Tablero tablero){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes(); 
		Posicion posicionAMoverme = new Posicion(this.posicionActual.getCoordenadaX(),this.posicionActual.getCoordenadaY()+1);
		tablero.moverPersonaje(this.posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		this.posicionActual = posicionAMoverme;
		
	}

	public void MoverAbajo(Tablero tablero){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(this.posicionActual.getCoordenadaX(),this.posicionActual.getCoordenadaY()-1);
		tablero.moverPersonaje(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		this.posicionActual = posicionAMoverme;
		
	}

	public void MoverDerecha(Tablero tablero){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(this.posicionActual.getCoordenadaX()+1,this.posicionActual.getCoordenadaY());
		tablero.moverPersonaje(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		this.posicionActual = posicionAMoverme;
	}

	public void MoverIzquierda(Tablero tablero){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(this.posicionActual.getCoordenadaX()-1,this.posicionActual.getCoordenadaY());
		tablero.moverPersonaje(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		this.posicionActual = posicionAMoverme;
	}


	public void MoverArribaDerecha(Tablero tablero){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(this.posicionActual.getCoordenadaX()+1,this.posicionActual.getCoordenadaY()+1);
		tablero.moverPersonaje(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		this.posicionActual = posicionAMoverme;
	}


	public void MoverArribaIzquierda(Tablero tablero){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(this.posicionActual.getCoordenadaX()-1,this.posicionActual.getCoordenadaY()+1);
		tablero.moverPersonaje(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		this.posicionActual = posicionAMoverme;
	}

	public void MoverAbajoDerecha(Tablero tablero){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(this.posicionActual.getCoordenadaX()+1,this.posicionActual.getCoordenadaY()-1);
		tablero.moverPersonaje(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		this.posicionActual = posicionAMoverme;
	}

	public void MoverAbajoIzquierda(Tablero tablero){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(this.posicionActual.getCoordenadaX()-1,this.posicionActual.getCoordenadaY()-1);
		tablero.moverPersonaje(this.posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		this.posicionActual = posicionAMoverme;
	}

	public void actualizarCantidadPasos(int velocidad) {
		this.cantidadPasosMoverse = velocidad;
	}

	public int getRestantes() {
		if (this.cantidadPasosMoverse==0) throw new PasosInsuficientes();
		return this.cantidadPasosMoverse;
	}
	
}
