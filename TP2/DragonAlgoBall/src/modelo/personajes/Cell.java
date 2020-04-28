package modelo.personajes;

import modelo.Ataque;
import modelo.Equipo;
import modelo.Estado;
import modelo.Movimiento;
import modelo.Personaje;
import modelo.Posicion;
import modelo.StatsJuego;
import modelo.Tablero;
import modelo.fases.FaseInicialCell;


public class Cell extends EnemigoDeLaTierra {
	int cantidadDeAbsorber;
	
	public Cell(Tablero tablero,Equipo equipo) {
		this.nombre = "Cell";
		this.tablero = tablero;
		this.fase = new FaseInicialCell();
		this.equipo = equipo;
		this.estado = new Estado(this.nombre,this.fase);
		this.ataque = new Ataque(this.getPoderDePelea());
		Posicion pos = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio()); 
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
		this.cantidadDeAbsorber = 0;
	}
		
	public void ataqueEspecial(Personaje enemigo){
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialCell);
		this.ataque.absorber(enemigo);
		this.estado.incrementarVida(this.getPoderDePelea());
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialCell);
		this.cantidadDeAbsorber += 1;
	}
	
	public void transformar(){
		int kiActual = this.estado.getKi();
		this.fase = this.fase.transformarCell(kiActual,this.cantidadDeAbsorber);
		this.estado.actualizar(this.nombre, this.fase);

	}
}