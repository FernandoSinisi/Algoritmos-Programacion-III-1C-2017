package tp1.testAlumno;

import static org.junit.Assert.*;
import org.junit.Test;

import tp1.Contacto;
import tp1.Grupo;
import tp1.MensajeEnviado;
import tp1.MensajeRecibido;
import tp1.Excepciones.MiembroGrupoRepetido;


public class TestGrupo {
	String NOMBREGRUPO = "AlgoIII";
	String NOMBRECONTACTO1 = "Marcio";
	Contacto CONTACTO1 = new Contacto(NOMBRECONTACTO1);
	String NOMBRECONTACTO2 = "Pablo";
	Contacto CONTACTO2 = new Contacto(NOMBRECONTACTO2);
	String NOMBRECONTACTO3 = "Eugenio";
	Contacto CONTACTO3 = new Contacto(NOMBRECONTACTO3);
	String CONTENIDO1 = "hola";
	String CONTENIDO2 = "chau";
	MensajeEnviado MSJ1 = new MensajeEnviado(CONTENIDO1,"Yo");
	MensajeRecibido MSJ2 = new MensajeRecibido(CONTENIDO1,NOMBRECONTACTO1);
	MensajeRecibido MSJ3 = new MensajeRecibido(CONTENIDO2,NOMBRECONTACTO3);
	
	@Test
    public void test01CrearGrupo() {
		Grupo grupo = new Grupo(NOMBREGRUPO); 
        assert(grupo instanceof Grupo);
    }
	
	@Test
    public void test02ObtenerNombreGrupoCreado() {
		Grupo grupo = new Grupo(NOMBREGRUPO); 
        assertEquals(grupo.obtenerNombre(),NOMBREGRUPO);
    }
	
	@Test
    public void test03ObtenerCantidadMiembrosGrupoCreadoSinAgregarMiembros() {
		//Unico mimebro es el administrador o el que creo el grupo (usuario de algochat)//
		Grupo grupo = new Grupo(NOMBREGRUPO); 
        assertEquals(grupo.cantidadMiembros(),1);
    }
	
	@Test
    public void test04ObtenerCantidadMensajesRecibidosDelGrupoSinMensajes() {
		Grupo grupo = new Grupo(NOMBREGRUPO); 
        assertEquals(grupo.cantidadMensajesRecibidos(),0);
    }
	
	@Test
    public void test05ObtenerCantidadMensajesEnviadosAlGrupoSinMensajes() {
		Grupo grupo = new Grupo(NOMBREGRUPO); 
        assertEquals(grupo.cantidadMensajesRecibidos(),0);
    }
	
	@Test
    public void test06GrupoVacioContieneUnContactoDeberiaLanzarFalse() {
		Grupo grupo = new Grupo(NOMBREGRUPO); 
        assert(!grupo.contiene(NOMBRECONTACTO1));
    }
	
	@Test
    public void test07GrupoContieneUnContactoDeberiaLanzarTrue() {
		Grupo grupo = new Grupo(NOMBREGRUPO);
		grupo.agregarMiembro(CONTACTO1);
        assert(grupo.contiene(NOMBRECONTACTO1));
    }
	
	@Test(expected = MiembroGrupoRepetido.class)
    public void test08AgregarContactoYaExistenteDeberiaLanzarMiembroGrupoRepetido() {
		Grupo grupo = new Grupo(NOMBREGRUPO); 
		grupo.agregarMiembro(CONTACTO1);
		grupo.agregarMiembro(CONTACTO1);
    }
	
	@Test
    public void test09ObtenerCantidadMiembrosLuegoDeAgregar() {
		Grupo grupo = new Grupo(NOMBREGRUPO); 
		grupo.agregarMiembro(CONTACTO1);
		grupo.agregarMiembro(CONTACTO2);
		grupo.agregarMiembro(CONTACTO3);
		assertEquals(grupo.cantidadMiembros(),4);
	}
	
	@Test
    public void test10ObtenerCantidadMensajesRecibidosDelGrupoLuegoDeChatear() {
		Grupo grupo = new Grupo(NOMBREGRUPO);
		grupo.agregarMiembro(CONTACTO1);
		grupo.agregarMiembro(CONTACTO2);
		grupo.agregarMiembro(CONTACTO3);
		grupo.recibirMensaje(MSJ2);
		grupo.recibirMensaje(MSJ3);
		grupo.enviarMensaje(MSJ1);
		assertEquals(grupo.cantidadMensajesRecibidos(),2);
    }
	
	@Test
    public void test11ObtenerCantidadMensajesEnviadosAlGrupoLuegoDeChatear() {
		Grupo grupo = new Grupo(NOMBREGRUPO);
		grupo.agregarMiembro(CONTACTO1);
		grupo.agregarMiembro(CONTACTO2);
		grupo.agregarMiembro(CONTACTO3);
		grupo.recibirMensaje(MSJ2);
		grupo.recibirMensaje(MSJ3);
		grupo.enviarMensaje(MSJ1);
		grupo.enviarMensaje(MSJ2);
		grupo.enviarMensaje(MSJ3);
		assertEquals(grupo.cantidadMensajesEnviados(),3);
    }
	
	@Test
    public void test12ObtenerConversacionDelGrupoLuegoDeChatearYVerificarUltimoMensaje() {
		Grupo grupo = new Grupo(NOMBREGRUPO);
		grupo.agregarMiembro(CONTACTO1);
		grupo.agregarMiembro(CONTACTO2);
		grupo.agregarMiembro(CONTACTO3);
		grupo.recibirMensaje(MSJ2);
		grupo.recibirMensaje(MSJ3);
		grupo.enviarMensaje(MSJ1);
		grupo.enviarMensaje(MSJ2);
		grupo.enviarMensaje(MSJ3);
		assertEquals(grupo.obtenerConversacion().get(1),"Eugenio: chau");
    }
	
	@Test
    public void test13ObtenerCantidadMensajesEnviadosLuegoDeBorrarlos() {
		Grupo grupo = new Grupo(NOMBREGRUPO);
		grupo.agregarMiembro(CONTACTO1);
		grupo.agregarMiembro(CONTACTO2);
		grupo.agregarMiembro(CONTACTO3);
		grupo.recibirMensaje(MSJ2);
		grupo.recibirMensaje(MSJ3);
		grupo.enviarMensaje(MSJ1);
		grupo.enviarMensaje(MSJ2);
		grupo.enviarMensaje(MSJ3);
		grupo.borrarMsjs();
		assertEquals(grupo.cantidadMensajesEnviados(),0);
    }
	
	@Test
    public void test14ObtenerCantidadMensajesRecibidosLuegoDeBorrarlos() {
		Grupo grupo = new Grupo(NOMBREGRUPO);
		grupo.agregarMiembro(CONTACTO1);
		grupo.agregarMiembro(CONTACTO2);
		grupo.agregarMiembro(CONTACTO3);
		grupo.recibirMensaje(MSJ2);
		grupo.recibirMensaje(MSJ3);
		grupo.enviarMensaje(MSJ1);
		grupo.enviarMensaje(MSJ2);
		grupo.enviarMensaje(MSJ3);
		grupo.borrarMsjs();
		assertEquals(grupo.cantidadMensajesRecibidos(),0);
    }
	
	@Test
    public void test15ObtenerCantidadMensajesRecibidosDeContactoQueNoEnvioMensaje() {
		Grupo grupo = new Grupo(NOMBREGRUPO);
		grupo.agregarMiembro(CONTACTO1);
		grupo.agregarMiembro(CONTACTO2);
		grupo.agregarMiembro(CONTACTO3);
		grupo.recibirMensaje(MSJ2);
		grupo.recibirMensaje(MSJ3);
		assertEquals(grupo.cantidadMensajesDe(NOMBRECONTACTO2),0);
    }
	
	@Test
    public void test16ObtenerCantidadMensajesRecibidosDeContactoQueEnvioMensaje() {
		Grupo grupo = new Grupo(NOMBREGRUPO);
		grupo.agregarMiembro(CONTACTO1);
		grupo.agregarMiembro(CONTACTO2);
		grupo.agregarMiembro(CONTACTO3);
		grupo.recibirMensaje(MSJ2);
		grupo.recibirMensaje(MSJ2);
		grupo.recibirMensaje(MSJ3);
		assertEquals(grupo.cantidadMensajesDe(NOMBRECONTACTO1),2);
    }
	
	@Test
    public void test17ObtenerCantidadMensajesRecibidosDeContactoLuegoDeBorrarlos() {
		Grupo grupo = new Grupo(NOMBREGRUPO);
		grupo.agregarMiembro(CONTACTO1);
		grupo.agregarMiembro(CONTACTO2);
		grupo.agregarMiembro(CONTACTO3);
		grupo.recibirMensaje(MSJ2);
		grupo.recibirMensaje(MSJ2);
		grupo.recibirMensaje(MSJ3);
		grupo.borrarMensajesDelContacto(NOMBRECONTACTO3);
		assertEquals(grupo.cantidadMensajesDe(NOMBRECONTACTO3),0);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	

}
