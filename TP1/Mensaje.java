package tp1;

public abstract class Mensaje {
	private String contenido;
	private String remitente;
	
	public Mensaje(String contenido,String remitente){
		this.contenido= contenido;
		this.remitente = remitente;
	}
	
	public String contenido(){
		return remitente + ": " + contenido;
	}
	
	public String remitente(){
		return remitente;
	}
	
	public abstract int obtenerCantidadRecibido();
	public abstract int obtenerCantidadEnviado();

}
