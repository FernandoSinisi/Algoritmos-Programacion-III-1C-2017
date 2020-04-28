package tp1;

import java.util.*;

import tp1.Excepciones.NombreNoAgendado;

public abstract class Agenda {
	protected Hashtable<String,Agendable> agenda;
	
	public Agenda(){
		this.agenda = new Hashtable<String,Agendable>();
	}
	
	public int cantidadChats(){
		return this.agenda.size();
	}
	
	public int tamanio(){
		return this.agenda.size();
	}
	
	public boolean contiene(String nombre){
		return this.agenda.containsKey(nombre);
	}
	
	public int cantidadMensajesEnviados() {
		int cantidad = 0 ;
		for (Agendable valor : this.agenda.values()) {
			cantidad += valor.cantidadMensajesEnviados();
		}
		return cantidad;
	}
	public int cantidadMensajesRecibidos() {
		int cantidad = 0 ;
		for (Agendable valor : this.agenda.values()) {
			cantidad += valor.cantidadMensajesRecibidos();
		}
		return cantidad;
	}

	public Agendable obtenerAgendable(String nombre) {
		if(this.contiene(nombre)){
			return agenda.get(nombre);
		}
		throw new NombreNoAgendado();
	}

	public abstract void borrarMensajesDelContacto(String nombreContacto);

	public abstract int cantidadMensajesDe(String nombre);
	


}
	
	
	
	
	

