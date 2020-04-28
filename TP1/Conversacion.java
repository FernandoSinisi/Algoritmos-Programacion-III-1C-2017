package tp1;

import java.util.*;

public class Conversacion {
	private ArrayList<Mensaje> conversacion;
	
	public Conversacion(){
		this.conversacion = new ArrayList<Mensaje>();
	}
	
	public void agregarMensaje(Mensaje mensaje){
		conversacion.add(0,mensaje);
	}
	
	public int tamanio(){
		return conversacion.size();
	}

	public void borrarConversacion() {
		this.conversacion.clear();
	}

	public String get(int i) {
		return this.conversacion.get(i-1).contenido();
	}

	public void borrarMensajes(String nombreContacto) {
		ArrayList<Mensaje> mensajesABorrar = new ArrayList<Mensaje>();
		for(Mensaje msj : this.conversacion){
			if(msj.remitente() == nombreContacto){
				mensajesABorrar.add(msj);
			}
		}
		for(Mensaje msj : mensajesABorrar){
			this.conversacion.remove(msj);
		}
	}
}
