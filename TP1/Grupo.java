package tp1;

import java.util.*;

import tp1.Excepciones.MiembroGrupoRepetido;

public class Grupo extends Agendable{
	
	private Hashtable<String,Contacto> miembros;
	
	public Grupo(String nombre){
		this.chat = new ChatGrupal();
		this.miembros = new Hashtable<String,Contacto>();
		this.nombre = nombre;
	}

	public boolean contiene(String nombre){
		return this.miembros.containsKey(nombre);
	}
	
	public void agregarMiembro(Agendable contacto) {
		String nombre = contacto.obtenerNombre();
		if(this.contiene(nombre)){
			throw new MiembroGrupoRepetido();
		}
		this.miembros.put(nombre, (Contacto)contacto);
		((ChatGrupal)this.chat).agregarMiembro(nombre);
	}

	public int cantidadMiembros() {
		//La cantidad de miembros se le suma 1 debido a que uno mismo pertenece al grupo pero no es un contacto//
		return this.miembros.size()+1;
	}
	
	public void borrarMensajesDelContacto(String nombreContacto){
		((ChatGrupal)chat).borrarMensajes(nombreContacto);
	}

	public int cantidadMensajesDe(String nombre) {
		return ((ChatGrupal)this.chat).cantidadMensajesDe(nombre);
	}
}
