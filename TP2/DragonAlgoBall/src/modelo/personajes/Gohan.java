package modelo.personajes;

import modelo.*;
import modelo.fases.FaseInicialGohan;


public class Gohan extends GuerreroZ {

	
	public Gohan(Tablero tablero,Equipo equipo){
			this.nombre = "Gohan";
			this.tablero = tablero;
			this.fase = new FaseInicialGohan();
			this.equipo = equipo;
			this.estado = new Estado(this.nombre,this.fase);
			this.ataque = new Ataque(this.getPoderDePelea());
			Posicion pos = new Posicion(1,2);
			this.movimiento = new Movimiento(estado.getVelocidad(),pos);
			this.inmovilizado = false;
			this.turnosRestantesInmovilizado=0;
	}
	
	public void ataqueEspecial(Personaje enemigo){
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialGohan);
		this.ataque.masenko(enemigo);
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialGohan);
	}
	
	public void transformar(){
		int kiActual = this.estado.getKi();
		this.fase = this.fase.transformarGohan(kiActual,this.equipo);
		this.estado.actualizar(this.nombre, this.fase);
	}
	


}