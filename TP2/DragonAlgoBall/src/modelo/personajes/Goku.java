package modelo.personajes;

import modelo.*;
import modelo.excepciones.PersonajeInmovilizado;
import modelo.fases.FaseInicialGoku;

public class Goku extends GuerreroZ {
	
	public Goku(Tablero tablero,Equipo equipo) {
		this.nombre = "Goku";
		this.tablero = tablero;
		this.fase = new FaseInicialGoku();
		this.equipo = equipo;
		this.estado = new Estado(this.nombre,this.fase);
		this.ataque = new Ataque(this.getPoderDePelea());
		Posicion pos = new Posicion(1,1);
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
		this.inmovilizado = false;
		this.turnosRestantesInmovilizado=0;
	}

	
	private boolean gokuTieneMenosDelTreintaPorcientoDeVida(){
		return (this.getPuntosDeVida()) < (StatsJuego.puntosVidaInicialGoku*StatsJuego.factorReduccionVidaGoku);
	}
	
	
	
	public void atacarConBasico(Personaje enemigo){
		if (this.inmovilizado)throw new PersonajeInmovilizado();
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		if(this.gokuTieneMenosDelTreintaPorcientoDeVida()){
			ataque.ataqueBasicoMejoradoGoku(enemigo);
			return;
		}
		ataque.ataqueBasico(enemigo);
	}
	
	
	public void ataqueEspecial(Personaje enemigo){
		if (this.inmovilizado) throw new PersonajeInmovilizado();
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialGoku);
		this.ataque.kamehameha(enemigo);
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialGoku);
	}

	
}