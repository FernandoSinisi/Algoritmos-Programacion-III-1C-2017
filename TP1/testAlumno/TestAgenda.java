package tp1.testAlumno;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.AgendaContactos;
import tp1.AgendaGrupos;
import tp1.Agendable;
import tp1.Contacto;
import tp1.Grupo;
import tp1.MensajeEnviado;
import tp1.MensajeRecibido;
import tp1.Excepciones.ContactoRepetido;
import tp1.Excepciones.GrupoRepetido;
import tp1.Excepciones.NombreNoAgendado;


public class TestAgenda {
	String NOMBREGRUPO = "AlgoIII";
	String NOMBRECONTACTO = "Marcio";
	String NOMBREGRUPO1 = "AlgoII";
	String NOMBRECONTACTO1 = "Martin";
	String NOMBREGRUPO2 = "AlgoI";
	String NOMBRECONTACTO2 = "Diego";
	String CONTENIDO1 = "hola";
	String CONTENIDO2 = "chau";
	MensajeEnviado MSJ1 = new MensajeEnviado(CONTENIDO1,"Yo");
	MensajeEnviado MSJ2 = new MensajeEnviado(CONTENIDO2,"Yo");
	MensajeRecibido MSJ3 = new MensajeRecibido(CONTENIDO1,NOMBRECONTACTO);
	MensajeRecibido MSJ4 = new MensajeRecibido(CONTENIDO2,NOMBRECONTACTO1);
	
	
	@Test
    public void test01CrearAgendaGrupos() {
		AgendaGrupos grupos = new AgendaGrupos(); 
        assert(grupos instanceof AgendaGrupos);
    }
	
	@Test
    public void test02CrearAgendaContactos() {
		AgendaContactos contactos = new AgendaContactos(); 
        assert(contactos instanceof AgendaContactos);
    }
	
	@Test
    public void test03CantidadDeChatsDeAgendaDeContactosVacia() {
		AgendaContactos contactos = new AgendaContactos(); 
        assertEquals(contactos.cantidadChats(),0);
    }
	
	@Test
    public void test04CantidadAgendaDeGruposVacia() {
		AgendaGrupos grupos = new AgendaGrupos(); 
        assertEquals(grupos.cantidadChats(),0);
    }
	
	@Test
    public void test05TamanioDeAgendaDeContactosVacia() {
		AgendaGrupos contactos = new AgendaGrupos(); 
        assertEquals(contactos.tamanio(),0);
    }
	
	@Test
    public void test06TamanioDeAgendaDeGruposVacia() {
		AgendaGrupos grupos = new AgendaGrupos(); 
        assertEquals(grupos.tamanio(),0);
    }
	
	@Test
    public void test07CantidadMensajesEnviadosAlosGruposDeLaAgendaVacia() {
		AgendaGrupos grupos = new AgendaGrupos(); 
        assertEquals(grupos.cantidadMensajesEnviados(),0);
    }
	
	@Test
    public void test08CantidadMensajesRecibidosAlosContactosDeLaAgendaVacia() {
		AgendaContactos contactos = new AgendaContactos(); 
        assertEquals(contactos.cantidadMensajesRecibidos(),0);
    }
	
	@Test
    public void test09VerificarQueAgendaGruposContieneAgrupoAgregado() {
		AgendaGrupos grupos = new AgendaGrupos();
		grupos.crearGrupo(NOMBREGRUPO);
        assert(grupos.contiene(NOMBREGRUPO));
    }
	
	@Test
    public void test10VerificarQueAgendaContactosContieneContactoAgregado() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
        assert(contactos.contiene(NOMBRECONTACTO));
    }
	
	@Test
    public void test11VerificarTamanioAgendaGruposLuegoDeAgendar() {
		AgendaGrupos grupos = new AgendaGrupos();
		grupos.crearGrupo(NOMBREGRUPO);
		grupos.crearGrupo(NOMBREGRUPO2);
        assertEquals(grupos.tamanio(),2);
    }
	
	@Test
    public void test12VerificarTamanioAgendaContactosLuegoDeAgendar() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
		contactos.agregarContacto(NOMBRECONTACTO1);
		contactos.agregarContacto(NOMBRECONTACTO2);
        assertEquals(contactos.tamanio(),3);
    }
	
	@Test
    public void test13VerificarAgendaGruposNoContieneGrupoNoAgendado() {
		AgendaGrupos grupos = new AgendaGrupos();
		grupos.crearGrupo(NOMBREGRUPO);
		grupos.crearGrupo(NOMBREGRUPO2);
		assert(!grupos.contiene(NOMBREGRUPO1));
    }
	
	@Test
    public void test14VerificarAgendaContactosNoContieneContactoNoAgendado() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
		contactos.agregarContacto(NOMBRECONTACTO1);
        assert(!contactos.contiene(NOMBRECONTACTO2));
    }
	
	@Test
    public void test15ObtenerObjetoAgendadoEnAgendaGrupos() {
		AgendaGrupos grupos = new AgendaGrupos();
		grupos.crearGrupo(NOMBREGRUPO);
		grupos.crearGrupo(NOMBREGRUPO2);
		assertEquals(grupos.obtenerAgendable(NOMBREGRUPO).obtenerNombre(),NOMBREGRUPO);
    }
	
	@Test
    public void test16ObtenerObjetoAgendadoEnAgendaContactos() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
		contactos.agregarContacto(NOMBRECONTACTO1);
		assertEquals(contactos.obtenerAgendable(NOMBRECONTACTO).obtenerNombre(),NOMBRECONTACTO);
    }
	
	@Test(expected = NombreNoAgendado.class)
    public void test17ObtenerObjetoNoAgendadoEnAgendaContactosDeberiaLanzarNombreNoAgendado() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
		contactos.agregarContacto(NOMBRECONTACTO1);
		contactos.obtenerAgendable(NOMBRECONTACTO2);
    }
	
	@Test(expected = NombreNoAgendado.class)
    public void test18ObtenerObjetoAgendadoEnAgendaGruposDeberiaLanzarNombreNoAgendado() {
		AgendaGrupos grupos = new AgendaGrupos();
		grupos.crearGrupo(NOMBREGRUPO);
		grupos.crearGrupo(NOMBREGRUPO2);
		grupos.obtenerAgendable(NOMBREGRUPO1);
    }
	
	@Test(expected = ContactoRepetido.class)
    public void test19AgregarObjetoAgendadoEnAgendaContactosDeberiaLanzarContactoRepetido() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
		contactos.agregarContacto(NOMBRECONTACTO1);
		contactos.agregarContacto(NOMBRECONTACTO1);
    }
	
	@Test(expected = GrupoRepetido.class)
    public void test20AgregarObjetoAgendadoEnAgendaGruposDeberiaLanzarGrupoRepetido() {
		AgendaGrupos grupos = new AgendaGrupos();
		grupos.crearGrupo(NOMBREGRUPO);
		grupos.crearGrupo(NOMBREGRUPO2);
		grupos.crearGrupo(NOMBREGRUPO2);
    }
	
	@Test
    public void test21CantidadMensajesRecibidosATodoslosContactosAgendados() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
		Agendable contacto = contactos.obtenerAgendable(NOMBRECONTACTO);
		contacto.recibirMensaje(MSJ3);
		assertEquals(contactos.cantidadMensajesRecibidos(),1);
    }
	
	@Test
    public void test22CantidadMensajesEnviadosATodoslosContactosAgendados() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
		contactos.agregarContacto(NOMBRECONTACTO1);
		Agendable contacto = contactos.obtenerAgendable(NOMBRECONTACTO);
		Agendable contacto1 = contactos.obtenerAgendable(NOMBRECONTACTO);
		contacto.enviarMensaje(MSJ1);
		contacto1.enviarMensaje(MSJ2);
		assertEquals(contactos.cantidadMensajesEnviados(),2);
    }
	
	@Test
    public void test23CantidadMensajesTotalesConUnContactoAgendado() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
		Agendable contacto = contactos.obtenerAgendable(NOMBRECONTACTO);
		contacto.enviarMensaje(MSJ1);
		contacto.recibirMensaje(MSJ3);
		assertEquals(contactos.cantidadMensajesEnviados()+contactos.cantidadMensajesRecibidos(),2);
    }
	
	@Test
    public void test24CantidadMensajesDeContactoAgendadoEnParticular() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
		Agendable contacto = contactos.obtenerAgendable(NOMBRECONTACTO);
		contacto.enviarMensaje(MSJ1);
		contacto.recibirMensaje(MSJ3);
		assertEquals(contactos.cantidadMensajesDe(NOMBRECONTACTO),1);
    }
	
	@Test
    public void test25CantidadMensajesDeContactoAgendadoEnParticularLuegoDeBorrar() {
		AgendaContactos contactos = new AgendaContactos();
		contactos.agregarContacto(NOMBRECONTACTO);
		Agendable contacto = contactos.obtenerAgendable(NOMBRECONTACTO);
		contacto.enviarMensaje(MSJ1);
		contacto.recibirMensaje(MSJ3);
		contactos.borrarMensajesDelContacto(NOMBRECONTACTO);
		assertEquals(contactos.cantidadMensajesDe(NOMBRECONTACTO),0);
    }
	
	@Test
    public void test26CantidadMensajesDeContactoEnParticularAgrupo() {
		AgendaGrupos grupos = new AgendaGrupos();
		grupos.crearGrupo(NOMBREGRUPO);
		Agendable grupo = grupos.obtenerAgendable(NOMBREGRUPO);
		Contacto contacto = new Contacto(NOMBRECONTACTO);
		((Grupo) grupo).agregarMiembro(contacto);
		grupo.recibirMensaje(MSJ3);
		assertEquals(grupos.obtenerAgendable(NOMBREGRUPO).cantidadMensajesRecibidos(),1);
		assertEquals(grupos.cantidadMensajesDe(NOMBRECONTACTO),1);
    }
	
	@Test
    public void test27CantidadMensajesDeContactoEnParticularAgrupoLuegoDeBorrar() {
		AgendaGrupos grupos = new AgendaGrupos();
		grupos.crearGrupo(NOMBREGRUPO);
		Agendable grupo = grupos.obtenerAgendable(NOMBREGRUPO);
		Contacto contacto = new Contacto(NOMBRECONTACTO);
		((Grupo) grupo).agregarMiembro(contacto);
		grupo.recibirMensaje(MSJ3);
		grupos.borrarMensajesDelContacto(NOMBRECONTACTO);
		assertEquals(grupos.obtenerAgendable(NOMBREGRUPO).cantidadMensajesRecibidos(),0);
		assertEquals(grupos.cantidadMensajesDe(NOMBRECONTACTO),0);
    }

}
