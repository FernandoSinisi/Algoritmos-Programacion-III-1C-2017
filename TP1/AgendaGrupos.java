package tp1;

import tp1.Excepciones.GrupoRepetido;

public class AgendaGrupos extends Agenda {

	public AgendaGrupos(){
		super();
	}
	
	public void crearGrupo(String nombre) {
		if(this.contiene(nombre)){
			throw new GrupoRepetido();
		}
		Grupo grupo = new Grupo(nombre);
		this.agenda.put(nombre, grupo);
	}
	
	public void borrarMensajesDelContacto(String nombreContacto){
		for(Agendable grupo : this.agenda.values()){
			((Grupo)grupo).borrarMensajesDelContacto(nombreContacto);
		}
	}

	public int cantidadMensajesDe(String nombre) {
		int cantidad = 0;
		for(Agendable grupo : this.agenda.values()){
			cantidad += ((Grupo)grupo).cantidadMensajesDe(nombre);
		}
		return cantidad;
	}

}
