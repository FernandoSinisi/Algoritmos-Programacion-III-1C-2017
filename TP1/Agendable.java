package tp1;

public abstract class Agendable {
	protected String nombre;
	protected Chat chat;
	
	public String obtenerNombre(){
		return this.nombre;
	}
	public int cantidadMensajesEnviados(){
		return this.chat.cantidadMensajesEnviados();
	}
	
	public int cantidadMensajesRecibidos(){
		return this.chat.cantidadMensajesRecibidos();
	}
	
	public void recibirMensaje(Mensaje msj) {
		chat.agregarMensajeRecibido(msj);
	}

	public void enviarMensaje(Mensaje msj) {
		chat.agregarMensajeEnviado(msj);
	}

	public Conversacion obtenerConversacion() {
		return this.chat.obtenerConversacion();
	}
	
	public void borrarMsjs() {
		chat.vaciarChat();
	}
	
}
