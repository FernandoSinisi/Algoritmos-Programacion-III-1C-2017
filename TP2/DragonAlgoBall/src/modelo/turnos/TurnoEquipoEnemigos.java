package modelo.turnos;

import modelo.Equipo;
import modelo.Tablero;
import modelo.excepciones.GanadorEquipoEnemigos;


public class TurnoEquipoEnemigos extends Turno {
	
	public TurnoEquipoEnemigos(Tablero tablero, Equipo enemigos){
		this.equipo = enemigos;
		this.tablero = tablero;
		this.actualizarAcciones();
		this.AumentarKiInicioDeTurno();
		actualizarTurnoNubeVoladora();
	}
	
	public void controlarCantidadEsferasDelDragon(){
		if (this.equipo.getCantidadDeEsferasCapturadas() >= 7){
			throw new GanadorEquipoEnemigos();
		}
	}
	
	public  void controlarJuegadoresEquipoContrario(){
		if (!this.tablero.quedanJugadoresDelOtroEquipo(this.equipo.getMiembros())){
			throw new GanadorEquipoEnemigos();
		}
	}
	
}
