package modelo.personajes;




import modelo.Personaje;
import modelo.excepciones.PersonajeInmovilizado;

public abstract class GuerreroZ extends Personaje {
	protected boolean inmovilizado;	
	protected int turnosRestantesInmovilizado;
	
	protected  boolean esGuerreroZ(){return true;};
	protected boolean esEnemigoDeLaTierra(){return false;};
	
	
	
	public void inmovilizar(){
		this.inmovilizado=true;
		this.turnosRestantesInmovilizado = 3 ;
	}
	public void actualizarInmovilizado(){
		if(this.inmovilizado && this.turnosRestantesInmovilizado>0){
			this.turnosRestantesInmovilizado -= 1;
			return;
		}
		this.inmovilizado = false;
	}
	
	public void atacarConBasico(Personaje enemigo){
		if (this.inmovilizado){throw new PersonajeInmovilizado();}
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		ataque.ataqueBasico(enemigo);
	}
	
	public void MoverPersonajeHaciaArriba(){
		if (this.inmovilizado){throw new PersonajeInmovilizado();}
		this.movimiento.MoverArriba(this.tablero);
		
	}

	public void MoverPersonajeHaciaAbajo(){
		if (this.inmovilizado){throw new PersonajeInmovilizado();}
		this.movimiento.MoverAbajo(this.tablero);
	}

	public void MoverPersonajeHaciaDerecha(){
		if (this.inmovilizado){throw new PersonajeInmovilizado();}
		this.movimiento.MoverDerecha(this.tablero);
	}

	public void MoverPersonajeHaciaIzquierda(){
		if (this.inmovilizado){throw new PersonajeInmovilizado();}
		this.movimiento.MoverIzquierda(this.tablero);
	}

	public void MoverPersonajeHaciaArribaDerecha(){
		if (this.inmovilizado){throw new PersonajeInmovilizado();}
		this.movimiento.MoverArribaDerecha(this.tablero);
	}

	public void MoverPersonajeHaciaArribaIzquierda(){
		if (this.inmovilizado){throw new PersonajeInmovilizado();}
		this.movimiento.MoverArribaIzquierda(this.tablero);
	}

	public void MoverPersonajeHaciaAbajoDerecha(){
		if (this.inmovilizado){throw new PersonajeInmovilizado();}
		this.movimiento.MoverAbajoDerecha(this.tablero);
	}

	public void MoverPersonajeHaciaAbajoIzquierda(){
		if (this.inmovilizado){throw new PersonajeInmovilizado();}
		this.movimiento.MoverAbajoIzquierda(this.tablero);
	}
	

}
