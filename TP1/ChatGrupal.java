package tp1;

import java.util.*;

public class ChatGrupal extends Chat {
	
	private Hashtable<String,ArrayList<Mensaje>> miembros;
	
	public ChatGrupal(){
		super();
		this.miembros = new Hashtable<String,ArrayList<Mensaje>>();
	}
	
	public void agregarMensajeRecibido(Mensaje mensaje) {
		this.conversacion.agregarMensaje(mensaje);
		this.buzonEntrada.add(mensaje);
		String nombre = mensaje.remitente();
		this.miembros.get(nombre).add(mensaje);
	}
	public void vaciarChat() {
		this.conversacion.borrarConversacion();
		this.buzonEntrada.clear();
		this.buzonSalida.clear();
		for (ArrayList<Mensaje> mensajes : this.miembros.values()) {
			mensajes.clear();
		}
		
	}
	
	public void borrarMensajes(String nombreContacto) {
		ArrayList<Mensaje> mensajes = this.miembros.get(nombreContacto);
		for(Mensaje msj : mensajes){
			this.buzonEntrada.remove(msj);
		}
		mensajes.clear();
		this.conversacion.borrarMensajes(nombreContacto);
	}

	public void agregarMiembro(String nombre) {
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		this.miembros.put(nombre, mensajes);
	}

	public int cantidadMensajesDe(String nombre) {
		return this.miembros.get(nombre).size();
	}
}
