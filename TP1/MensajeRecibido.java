package tp1;

public class MensajeRecibido extends Mensaje {
	
	public MensajeRecibido(String contenido,String remitente){
		super(contenido,remitente);
	}

	public int obtenerCantidadRecibido() {
		return 1;
	}
	
	public int obtenerCantidadEnviado() {
		return 0;
	}

}
