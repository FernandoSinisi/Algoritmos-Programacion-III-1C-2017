package modelo.personajes;

import modelo.*;
import modelo.fases.FaseInicialMajinBoo;

public class MajinBoo extends EnemigoDeLaTierra {
	
	public MajinBoo(Tablero tablero,Equipo equipo) {
		this.nombre = "MajinBoo";
		this.tablero = tablero;
		this.fase = new FaseInicialMajinBoo();
		this.equipo = equipo;
		this.estado = new Estado(this.nombre,this.fase);
		this.ataque = new Ataque(this.getPoderDePelea());
		Posicion pos = new Posicion(this.tablero.getTamanio()-1,this.tablero.getTamanio());
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
	}
	
	public void ataqueEspecial(Personaje enemigo){
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialMajinBoo);
		this.ataque.convertirEnChocolate((GuerreroZ)enemigo);
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialMajinBoo);
	}
}