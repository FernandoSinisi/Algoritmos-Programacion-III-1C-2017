package tp1;

import java.util.*;
import tp1.Mensaje;

public abstract class Chat {
	protected ArrayList<Mensaje> buzonEntrada;
	protected ArrayList<Mensaje> buzonSalida;
	protected Conversacion conversacion;
	
	public Chat(){
		this.buzonEntrada = new ArrayList<Mensaje>();
		this.buzonSalida = new ArrayList<Mensaje>();
		this.conversacion = new Conversacion();
	}
	
	public abstract void agregarMensajeRecibido(Mensaje mensaje);
	
	public abstract void vaciarChat();
	
	public Conversacion obtenerConversacion(){
		return this.conversacion;
	}
	
	public int cantidadTotalMensajes(){
		return this.conversacion.tamanio();
	}
	
	public int cantidadMensajesRecibidos(){
		return this.buzonEntrada.size();
	}
	
	public int cantidadMensajesEnviados(){
		return this.buzonSalida.size();
	}
	
	public void agregarMensajeEnviado(Mensaje mensaje){
		this.conversacion.agregarMensaje(mensaje);
		this.buzonSalida.add(mensaje);
	}

}
