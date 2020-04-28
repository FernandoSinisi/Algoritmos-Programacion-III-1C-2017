package tp1;

public class Contacto extends Agendable {
	
	public Contacto(String nombre){
		this.nombre = nombre;
		this.chat = new ChatIndividual();
	}

}
