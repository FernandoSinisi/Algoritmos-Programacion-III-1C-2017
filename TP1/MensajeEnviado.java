package tp1;

public class MensajeEnviado extends Mensaje {

	public MensajeEnviado(String contenido,String remitente){
		super(contenido,remitente);
	}

	public int obtenerCantidadRecibido() {
		return 0;
	}
	
	public int obtenerCantidadEnviado() {
		return 1;
	}

}
