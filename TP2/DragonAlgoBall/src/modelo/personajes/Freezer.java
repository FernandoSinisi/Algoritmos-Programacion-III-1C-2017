package modelo.personajes;

import modelo.Ataque;
import modelo.Equipo;
import modelo.Estado;
import modelo.Movimiento;
import modelo.Personaje;
import modelo.Posicion;
import modelo.StatsJuego;
import modelo.Tablero;
import modelo.fases.FaseInicialFreezer;

public class Freezer extends EnemigoDeLaTierra {

	public Freezer(Tablero tablero,Equipo equipo) {
		this.nombre = "Freezer";
		this.tablero = tablero;
		this.fase = new FaseInicialFreezer();
		this.equipo = equipo;
		this.estado = new Estado(this.nombre,this.fase);
		this.ataque = new Ataque(this.getPoderDePelea());
		Posicion pos = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio()-1);
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
	}

	public void ataqueEspecial(Personaje enemigo){
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialFreezer);
		this.ataque.rayoMortal(enemigo);
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialFreezer);
	}
	
}