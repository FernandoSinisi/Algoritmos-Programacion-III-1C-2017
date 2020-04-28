package tp1.testAlumno;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.Conversacion;
import tp1.MensajeEnviado;
import tp1.MensajeRecibido;

public class TestConversacion {
	String contenido1 = "hola";
	String remitente1 = "Marcio";
	String contenido2 = "chau";
	String remitente2 = "Pablo";
	MensajeEnviado msj1 = new MensajeEnviado(contenido1,remitente1);
	MensajeRecibido msj2 = new MensajeRecibido(contenido2,remitente2);
	MensajeRecibido msj3 = new MensajeRecibido(contenido1,remitente2);
	int POSICIONULTIMOMENSAJE = 1;
	int POSICIONPENULTIMOMENSAJE = 2;
	int POSICIONANTEPENULTIMOMENSAJE = 3;
	
	@Test
    public void test01CrearConversacion() {
		Conversacion conversacion = new Conversacion(); 
        assert(conversacion instanceof Conversacion);
    }
	
	@Test
    public void test02AgregarMensajeRecibidoAConversacion() {
		Conversacion conversacion = new Conversacion();
		conversacion.agregarMensaje(msj2);
        assertEquals(conversacion.get(POSICIONULTIMOMENSAJE),msj2.contenido());
    }
	
	@Test
    public void test03AgregarMensajeEnviadoAConversacion() {
		Conversacion conversacion = new Conversacion();
		conversacion.agregarMensaje(msj1);
        assertEquals(conversacion.get(POSICIONULTIMOMENSAJE),msj1.contenido());
    }
	
	@Test
    public void test04VerificarOrdenDeLlegadaDeVariosMensajesAgregados(){
		Conversacion conversacion = new Conversacion();
		conversacion.agregarMensaje(msj1);
		conversacion.agregarMensaje(msj2);
		conversacion.agregarMensaje(msj3);
		assertEquals(conversacion.get(POSICIONULTIMOMENSAJE),msj3.contenido());
		assertEquals(conversacion.get(POSICIONPENULTIMOMENSAJE),msj2.contenido());
        assertEquals(conversacion.get(POSICIONANTEPENULTIMOMENSAJE),msj1.contenido());
    }
	
	@Test
    public void test05ObtenerTamanioDeConversacionConMensajes(){
		int MENSAJESAGREGADOS = 3;
		Conversacion conversacion = new Conversacion();
		conversacion.agregarMensaje(msj1);
		conversacion.agregarMensaje(msj2);
		conversacion.agregarMensaje(msj3);
		assertEquals(conversacion.tamanio(),MENSAJESAGREGADOS);
    }
	
	@Test
    public void test06ObtenerTamanioDeConversacionVacia(){
		int MENSAJESAGREGADOS = 0;
		Conversacion conversacion = new Conversacion();
		assertEquals(conversacion.tamanio(),MENSAJESAGREGADOS);
    }
	
	@Test
    public void test07VerificarTamanioDeConversacionLuegoDeBorrarla(){
		int MENSAJESAGREGADOS = 3;
		int MENSAJESBORRADOS = 3;
		Conversacion conversacion = new Conversacion();
		conversacion.agregarMensaje(msj1);
		conversacion.agregarMensaje(msj2);
		conversacion.agregarMensaje(msj3);
		conversacion.borrarConversacion();
		assertEquals(conversacion.tamanio(),MENSAJESAGREGADOS - MENSAJESBORRADOS);
		
    }
	
	@Test
    public void test08VerificarTamanioLuegoDeBorrarMensajesDeUnContacto(){
		int MENSAJESAGREGADOS = 3;
		int MENSAJESBORRADOS = 2;
		Conversacion conversacion = new Conversacion();
		conversacion.agregarMensaje(msj1);
		conversacion.agregarMensaje(msj2);
		conversacion.agregarMensaje(msj3);
		conversacion.borrarMensajes(remitente2);
		assertEquals(conversacion.tamanio(),MENSAJESAGREGADOS - MENSAJESBORRADOS);
	}
	
}
