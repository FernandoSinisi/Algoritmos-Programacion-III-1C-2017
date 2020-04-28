package modelo.personajes;

import modelo.*;
import modelo.fases.FaseInicialPicolo;

public class Picolo extends GuerreroZ  {
	
	public Picolo(Tablero tablero,Equipo equipo){
		this.nombre = "Picolo";
		this.tablero = tablero;
		this.fase = new FaseInicialPicolo();
		this.equipo = equipo;
		this.estado = new Estado(this.nombre,this.fase);
		this.ataque = new Ataque(this.getPoderDePelea());
		Posicion pos = new Posicion(2,1);
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
		this.inmovilizado = false;
		this.turnosRestantesInmovilizado=0;
	}
	
	
	public void ataqueEspecial(Personaje enemigo){
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialPicolo);
		this.ataque.makankosappo(enemigo);
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialPicolo);
	}
	
	public void transformar(){
		int kiActual = this.estado.getKi();
		this.fase = this.fase.transformarPicolo(kiActual,this.equipo);
		this.estado.actualizar(this.nombre, this.fase);
	}
	
}
