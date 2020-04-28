package tp1.testAlumno;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import tp1.MensajeEnviado;
import tp1.MensajeRecibido;

public class TestMensaje {
	String contenido = "hola";
	String remitente = "Marcio";
	
	@Test
    public void test01CrearMensajeRecibido() {
		MensajeRecibido msj = new MensajeRecibido(contenido,remitente); 
        assert(msj instanceof MensajeRecibido);
    }
	
	@Test
    public void test02ObtenerRemitenteMensajeRecibido() {
		MensajeRecibido msj = new MensajeRecibido(contenido,remitente); 
        assertEquals(msj.remitente(),remitente);
    }
	
	@Test
    public void test03ObtenerContenidoMensajeRecibido() {
		MensajeRecibido msj = new MensajeRecibido(contenido,remitente); 
        assertEquals(msj.contenido(),remitente + ": " + contenido);
    }
	
	@Test
    public void test04ObtenerCantidadMensajeRecibidoDeUnMensajeRecibido() {
		MensajeRecibido msj = new MensajeRecibido(contenido,remitente); 
        assertEquals(msj.obtenerCantidadRecibido(),1);
    }
	
	@Test
    public void test05ObtenerCantidadMensajeEnviadoDeUnMensajeRecibido() {
		MensajeRecibido msj = new MensajeRecibido(contenido,remitente); 
        assertEquals(msj.obtenerCantidadEnviado(),0);
    }
	
	@Test
    public void test06CrearMensajeEnviado() {
		MensajeEnviado msj = new MensajeEnviado(contenido,remitente); 
        assert(msj instanceof MensajeEnviado);
    }
	
	@Test
    public void test07ObtenerRemitenteMensajeEnviado() {
		MensajeEnviado msj = new MensajeEnviado(contenido,remitente); 
        assertEquals(msj.remitente(),remitente);
    }
	
	@Test
    public void test08ObtenerContenidoMensajeEnviado() {
		MensajeEnviado msj = new MensajeEnviado(contenido,remitente); 
        assertEquals(msj.contenido(),remitente + ": " + contenido);
    }
	
	@Test
    public void test09ObtenerCantidadMensajeRecibidoDeUnMensajeEnviado() {
		MensajeEnviado msj = new MensajeEnviado(contenido,remitente);
        assertEquals(msj.obtenerCantidadRecibido(),0);
    }
	
	@Test
    public void test10ObtenerCantidadMensajeEnviadoDeUnMensajeEnviado() {
		MensajeEnviado msj = new MensajeEnviado(contenido,remitente);
        assertEquals(msj.obtenerCantidadEnviado(),1);
	}
	
	
	


}
