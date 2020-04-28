package tp1;

public class AlgoChat {
	private AgendaContactos contactos;
	private AgendaGrupos grupos;
	private String usuario;
	
	public AlgoChat(String nombre){
		contactos = new AgendaContactos();
		grupos = new AgendaGrupos();
		usuario = nombre;
	}
	
	public String nombreUsuario(){
		return this.usuario;
	}
	
	public int cantidadDeChatsIndividuales(){
		return this.contactos.cantidadChats();
	}
	
	public int cantidadDeChatsGrupales(){
		return this.grupos.cantidadChats();
	}
	
	public int cantidadDeContactos(){
		return this.contactos.tamanio();
	}
	
	public int cantidadDeGrupos(){
		return this.grupos.tamanio();
	}
	
	public void agregarContacto(String nombre){
		this.contactos.agregarContacto(nombre);
		
	}
	
	public boolean existeContacto(String nombre){
		return contactos.contiene(nombre);
	}
	
	public boolean existeGrupo(String nombre){
		return grupos.contiene(nombre);
	}
	
	public int cantidadDeMensajesEnviados(){
		return contactos.cantidadMensajesEnviados() + grupos.cantidadMensajesEnviados();
	}
	
	public int cantidadTotalMensajesEnviados(){
		return this.cantidadDeMensajesEnviados();
	}
	
	public int cantidadTotalMensajesRecibidos(){
		return contactos.cantidadMensajesRecibidos() + grupos.cantidadMensajesRecibidos();
	}
	
	public int cantidadMensajesDe(String nombre) {
		return this.contactos.cantidadMensajesDe(nombre)+ this.grupos.cantidadMensajesDe(nombre);
	}
	
	public void recibirMensajeDe(String nombre, String mensaje){
		Agendable contacto = this.contactos.obtenerAgendable(nombre);
		Mensaje msj = new MensajeRecibido(mensaje,nombre);
		contacto.recibirMensaje(msj);
	}

	public void enviarMensajeA(String nombre, String mensaje) {
		Agendable contacto = this.contactos.obtenerAgendable(nombre);
		Mensaje msj = new MensajeEnviado(mensaje,"Yo");
		contacto.enviarMensaje(msj);
	}

	public int cantidadMensajesEnviadosA(String nombre) {
		Agendable contacto = this.contactos.obtenerAgendable(nombre);
		return contacto.cantidadMensajesEnviados();
		
	}

	public Conversacion obtenerConversacionCon(String nombre) {
		Agendable contacto = this.contactos.obtenerAgendable(nombre);
		return contacto.obtenerConversacion();
		
	}

	public void crearGrupo(String nombre) {
		grupos.crearGrupo(nombre);
	}

	public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
		Grupo grupo = (Grupo)this.grupos.obtenerAgendable(nombreGrupo);
		Agendable contacto = contactos.obtenerAgendable(nombreContacto);
		grupo.agregarMiembro(contacto);
	}

	public int cantidadMiembrosEnGrupo(String nombreGrupo) {
		Grupo grupo = (Grupo)this.grupos.obtenerAgendable(nombreGrupo);
		return grupo.cantidadMiembros();
	}

	public void recibirMensajeDeGrupo(String nombreGrupo, String nombreContacto, String mensaje) {
		Agendable grupo = this.grupos.obtenerAgendable(nombreGrupo);
		Mensaje msj = new MensajeRecibido(mensaje,nombreContacto);
		grupo.recibirMensaje(msj);
		
	}

	public void enviarMensajeAGrupo(String nombreGrupo, String mensaje) {
		Agendable grupo = this.grupos.obtenerAgendable(nombreGrupo);
		Mensaje msj = new MensajeEnviado(mensaje,"Yo");
		grupo.enviarMensaje(msj);
	}

	public int cantidadMensajesRecibidosDelGrupo(String nombreGrupo) {
		Agendable grupo = this.grupos.obtenerAgendable(nombreGrupo);
		return grupo.cantidadMensajesRecibidos();
	}
	
	public int cantidadMensajesEnviadosAlGrupo(String nombreGrupo) {
		Agendable grupo = this.grupos.obtenerAgendable(nombreGrupo);
		return grupo.cantidadMensajesEnviados();
	}

	public Conversacion obtenerConversacionConGrupo(String nombreGrupo) {
		Agendable grupo = this.grupos.obtenerAgendable(nombreGrupo);
		return grupo.obtenerConversacion();
		
	}

	public void borrarMensajesDelContacto(String nombreContacto) {
		this.contactos.borrarMensajesDelContacto(nombreContacto);
		this.grupos.borrarMensajesDelContacto(nombreContacto);
	}

	public void borrarMensajesDelGrupo(String nombreGrupo) {
		Agendable grupo = this.grupos.obtenerAgendable(nombreGrupo);
		grupo.borrarMsjs();
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
