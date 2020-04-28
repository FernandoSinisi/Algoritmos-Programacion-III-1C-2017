package tp1;

public class ChatIndividual extends Chat {
	
	public ChatIndividual(){
		super();
	}
	
	public void agregarMensajeRecibido(Mensaje mensaje) {
		this.conversacion.agregarMensaje(mensaje);
		this.buzonEntrada.add(mensaje);
	}
	public void vaciarChat() {
		this.conversacion.borrarConversacion();
		this.buzonEntrada.clear();
		this.buzonSalida.clear();
		
	}

}
