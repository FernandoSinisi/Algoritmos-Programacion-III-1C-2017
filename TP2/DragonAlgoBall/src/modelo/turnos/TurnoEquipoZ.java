package modelo.turnos;


import modelo.Equipo;
import modelo.Personaje;
import modelo.Tablero;
import modelo.excepciones.GanadorEquipoZ;
import modelo.personajes.GuerreroZ;

public class TurnoEquipoZ extends Turno {
	
	public TurnoEquipoZ(Tablero tablero, Equipo guerrerosZ){
		this.equipo = guerrerosZ;
		this.tablero = tablero;
		this.actualizarAcciones();
		this.AumentarKiInicioDeTurno();
		this.actualizarInmoviles();
		actualizarTurnoNubeVoladora();
	}
	
	private void actualizarInmoviles(){
		for (Personaje guerreroZ: this.equipo.getMiembros()) {
			GuerreroZ guerrero = (GuerreroZ)guerreroZ;
			guerrero.actualizarInmovilizado();
		}
	}
	
	public void controlarCantidadEsferasDelDragon(){
		if (this.equipo.getCantidadDeEsferasCapturadas() >= 7){
			throw new GanadorEquipoZ();
		}
	}
	
	public  void controlarJuegadoresEquipoContrario(){
		if (!this.tablero.quedanJugadoresDelOtroEquipo(this.equipo.getMiembros())){
			throw new GanadorEquipoZ();
		}
	}


}
