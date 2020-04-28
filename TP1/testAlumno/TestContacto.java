package tp1.testAlumno;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tp1.Contacto;
import tp1.MensajeEnviado;
import tp1.MensajeRecibido;

public class TestContacto {
	
	String NOMBRECONTACTO1 = "Marcio";
	String NOMBRECONTACTO2 = "Pablo";
	Contacto CONTACTO2 = new Contacto(NOMBRECONTACTO2);
	String NOMBRECONTACTO3 = "Eugenio";
	Contacto CONTACTO3 = new Contacto(NOMBRECONTACTO3);
	String CONTENIDO1 = "hola";
	String CONTENIDO2 = "chau";
	MensajeEnviado MSJ1 = new MensajeEnviado(CONTENIDO1,"Yo");
	MensajeEnviado MSJ2 = new MensajeEnviado(CONTENIDO2,"Yo");
	MensajeRecibido MSJ3 = new MensajeRecibido(CONTENIDO1,NOMBRECONTACTO1);
	MensajeRecibido MSJ4 = new MensajeRecibido(CONTENIDO2,NOMBRECONTACTO2);
	MensajeRecibido MSJ5 = new MensajeRecibido(CONTENIDO1,NOMBRECONTACTO3);
	MensajeRecibido MSJ6 = new MensajeRecibido(CONTENIDO2,NOMBRECONTACTO1);
	
	@Test
    public void test01CrearContacto() {
		Contacto contacto = new Contacto(NOMBRECONTACTO1); 
        assert( contacto instanceof Contacto);
    }
	
	@Test
    public void test02ObtenerNombreContacto() {
		Contacto contacto = new Contacto(NOMBRECONTACTO2); 
        assertEquals(contacto.obtenerNombre(),NOMBRECONTACTO2);
    }
	
	@Test
    public void test03ObtenerCantidadMensajesRecibidosSinHaberRecibidoMensajes() {
		Contacto contacto = new Contacto(NOMBRECONTACTO3);
        assertEquals(contacto.cantidadMensajesRecibidos(),0);
	}
	
	@Test
    public void test04ObtenerCantidadMensajesEnviadosSinHaberMandadoMensajes() {
		Contacto contacto = new Contacto(NOMBRECONTACTO1);
        assertEquals(contacto.cantidadMensajesEnviados(),0);
	}
	
	@Test
    public void test05ObtenerCantidadMensajesEnviadosLuegoDeHaberMandadoMensajes() {
		Contacto contacto = new Contacto(NOMBRECONTACTO3);
		contacto.enviarMensaje(MSJ1);
		contacto.enviarMensaje(MSJ2);
		contacto.enviarMensaje(MSJ1);
        assertEquals(contacto.cantidadMensajesEnviados(),3);
	}
	
	@Test
    public void test06ObtenerCantidadMensajesRecibidosLuegoDeHaberRecibidoMensajes() {
		Contacto contacto = new Contacto(NOMBRECONTACTO2);
		contacto.recibirMensaje(MSJ5);
		contacto.recibirMensaje(MSJ4);
        assertEquals(contacto.cantidadMensajesRecibidos(),2);
	}
	
	@Test
    public void test07ObtenerCantidadMensajesRecibidosLuegoDeBorrar() {
		Contacto contacto = new Contacto(NOMBRECONTACTO2);
		contacto.recibirMensaje(MSJ5);
		contacto.recibirMensaje(MSJ4);
		contacto.borrarMsjs();
        assertEquals(contacto.cantidadMensajesRecibidos(),0);
	}
	
	@Test
    public void test08ObtenerCantidadMensajesEnviadosLuegoDeBorrar() {
		Contacto contacto = new Contacto(NOMBRECONTACTO3);
		contacto.enviarMensaje(MSJ1);
		contacto.enviarMensaje(MSJ2);
		contacto.borrarMsjs();
		assertEquals(contacto.cantidadMensajesEnviados(),0);
	}
	
	@Test
    public void test09ObtenerConversacionConContactoYVerificarMensajes() {
		Contacto contacto = new Contacto(NOMBRECONTACTO1);
		contacto.enviarMensaje(MSJ1);
		contacto.recibirMensaje(MSJ3);
		contacto.enviarMensaje(MSJ2);
		contacto.recibirMensaje(MSJ6);
		assertEquals(contacto.obtenerConversacion().get(1),"Marcio: chau");
		assertEquals(contacto.obtenerConversacion().get(2),"Yo: chau");
		assertEquals(contacto.obtenerConversacion().get(3),"Marcio: hola");
		assertEquals(contacto.obtenerConversacion().get(4),"Yo: hola");
	}
	
	
	
	
}
