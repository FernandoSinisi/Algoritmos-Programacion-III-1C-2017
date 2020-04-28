package tp1;

import tp1.Excepciones.ContactoRepetido;

public class AgendaContactos extends Agenda {
	
	public AgendaContactos(){
		super();
	}
	
	public void agregarContacto(String nombre) {
		if(this.agenda.containsKey(nombre)){
			throw new ContactoRepetido();
		}
		Contacto contacto = new Contacto(nombre);
		this.agenda.put(nombre, contacto);
	}
	
	public void borrarMensajesDelContacto(String nombreContacto){
		Agendable contacto = this.obtenerAgendable(nombreContacto);
		contacto.borrarMsjs();
	}

	public int cantidadMensajesDe(String nombre) {
		return this.agenda.get(nombre).cantidadMensajesRecibidos();
	}
		


}
