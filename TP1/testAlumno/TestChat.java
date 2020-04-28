package tp1.testAlumno;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.Chat;
import tp1.ChatGrupal;
import tp1.ChatIndividual;
import tp1.MensajeEnviado;
import tp1.MensajeRecibido;

public class TestChat {
	
	String contenido1 = "hola";
	String remitente1 = "Marcio";
	String contenido2 = "chau";
	String remitente2 = "Pablo";
	MensajeEnviado msj1 = new MensajeEnviado(contenido1,remitente1);
	MensajeRecibido msj2 = new MensajeRecibido(contenido2,remitente2);
	MensajeRecibido msj3 = new MensajeRecibido(contenido1,remitente2);
	
	@Test
    public void test01CrearChatIndividual() {
		Chat chat = new ChatIndividual(); 
        assert(chat instanceof ChatIndividual);
    }
	
	@Test
    public void test02CrearChatGrupal() {
		Chat chat = new ChatGrupal(); 
        assert(chat instanceof ChatGrupal);
    }
	
	@Test
    public void test03ObtenerConversacionChatIndividualVacio() {
		ChatIndividual chat = new ChatIndividual(); 
        assertEquals(chat.obtenerConversacion().tamanio(),0);
    }
	
	@Test
    public void test04ObtenerConversacionChatGrupalVacio() {
		ChatGrupal chat = new ChatGrupal(); 
        assertEquals(chat.obtenerConversacion().tamanio(),0);
    }
	
	@Test
    public void test05ObtenerConversacionChatIndividualVacio() {
		ChatIndividual chat = new ChatIndividual(); 
        assertEquals(chat.obtenerConversacion().tamanio(),0);
    }
	
	@Test
    public void test06ObtenerTamanioConversacionLuegoDeAgregarMensajesChatGrupal() {
		ChatGrupal chat = new ChatGrupal();
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeEnviado(msj1);
        assertEquals(chat.obtenerConversacion().tamanio(),2);
    }
	
	@Test
    public void test07ObtenerTamanioConversacionLuegoDeAgregarMensajesChatIndividual(){
		ChatIndividual chat = new ChatIndividual();
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeRecibido(msj2);
		chat.agregarMensajeRecibido(msj2);
        assertEquals(chat.obtenerConversacion().tamanio(),3);
    }
	
	@Test
    public void test08ObtenerCantidadMensajesEnviadosChatGrupalConMensajes(){
		ChatGrupal chat = new ChatGrupal();
		chat.agregarMiembro(remitente1);
		chat.agregarMiembro(remitente2);
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeRecibido(msj2);
        assertEquals(chat.cantidadMensajesEnviados(),1);
    }
	
	@Test
    public void test09ObtenerCantidadMensajesEnviadosChatIndividualConMensajes(){
		ChatIndividual chat = new ChatIndividual(); 
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeRecibido(msj2);
        assertEquals(chat.cantidadMensajesEnviados(),2);
    }
	
	@Test
    public void test10ObtenerCantidadMensajesRecibidosChatGrupalConMensajes(){
		ChatGrupal chat = new ChatGrupal(); 
		chat.agregarMiembro(remitente1);
		chat.agregarMiembro(remitente2);
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeRecibido(msj2);
        assertEquals(chat.cantidadMensajesEnviados(),1);
    }
	
	@Test
    public void test11ObtenerCantidadMensajesRecibidosChatIndividualConMensajes(){
		ChatIndividual chat = new ChatIndividual(); 
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeRecibido(msj2);
        assertEquals(chat.cantidadMensajesEnviados(),2);
	}
	@Test
	public void test12ObtenerCantidadMensajesEnviadosChatGrupalVacio(){
		ChatGrupal chat = new ChatGrupal();
	    assertEquals(chat.cantidadMensajesEnviados(),0);
	}
		
	@Test
	public void test13ObtenerCantidadMensajesEnviadosChatIndividualVacio(){
		ChatIndividual chat = new ChatIndividual();
		assertEquals(chat.cantidadMensajesEnviados(),0);
	    }
		
	@Test
    public void test14ObtenerCantidadMensajesRecibidosChatGrupalVacio(){
		ChatGrupal chat = new ChatGrupal(); 
        assertEquals(chat.cantidadMensajesRecibidos(),0);
    }
	
	@Test
    public void test15ObtenerCantidadMensajesRecibidosChatIndividualVacio(){
		ChatIndividual chat = new ChatIndividual(); 
        assertEquals(chat.cantidadMensajesEnviados(),0);
	}
	
	@Test
    public void test16ObtenerCantidadTotalMensajesChatGrupalConMensajes(){
		ChatGrupal chat = new ChatGrupal();
		chat.agregarMiembro(remitente1);
		chat.agregarMiembro(remitente2);
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeRecibido(msj2);
        assertEquals(chat.cantidadTotalMensajes(),2);
    }
	
	@Test
    public void test17ObtenerCantidadTotalMensajesChatIndividualConMensajes(){
		ChatGrupal chat = new ChatGrupal();
		chat.agregarMiembro(remitente1);
		chat.agregarMiembro(remitente2);
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeRecibido(msj2);
		chat.agregarMensajeRecibido(msj3);
        assertEquals(chat.cantidadTotalMensajes(),3);
    }
	
	@Test
    public void test18ObtenerCantidadTotalMensajesChatGrupalVacio(){
		ChatGrupal chat = new ChatGrupal();
		chat.agregarMiembro(remitente1);
		chat.agregarMiembro(remitente2);
        assertEquals(chat.cantidadTotalMensajes(),0);
    }
	
	@Test
    public void test19ObtenerCantidadTotalMensajesChatIndividualVacio(){
		ChatGrupal chat = new ChatGrupal();
		chat.agregarMiembro(remitente1);
		chat.agregarMiembro(remitente2);
        assertEquals(chat.cantidadTotalMensajes(),0);
    }
	
	@Test
    public void test20ObtenerCantidadTotalMensajesChatGrupalLuegoDeVaciar(){
		ChatGrupal chat = new ChatGrupal();
		chat.agregarMiembro(remitente1);
		chat.agregarMiembro(remitente2);
		chat.agregarMensajeRecibido(msj2);
		chat.agregarMensajeRecibido(msj3);
		chat.vaciarChat();
        assertEquals(chat.cantidadTotalMensajes(),0);
    }
	@Test
    public void test21ObtenerCantidadTotalMensajesChatIndividualLuegoDeVaciar(){
		ChatIndividual chat = new ChatIndividual();
		chat.agregarMensajeRecibido(msj2);
		chat.agregarMensajeRecibido(msj3);
		chat.vaciarChat();
        assertEquals(chat.cantidadTotalMensajes(),0);
    }
	
	@Test
    public void test22ObtenerCantidadMensajesDeMiembroAlChatGrupal(){
		ChatGrupal chat = new ChatGrupal();
		chat.agregarMiembro(remitente1);
		chat.agregarMiembro(remitente2);
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeRecibido(msj2);
		chat.agregarMensajeRecibido(msj3);
        assertEquals(chat.cantidadMensajesDe(remitente2),2);
    }
	
	@Test
    public void test22ObtenerCantidadMensajesDeMiembroAlChatGrupalLuegoDeBorrarlos(){
		ChatGrupal chat = new ChatGrupal();
		chat.agregarMiembro(remitente1);
		chat.agregarMiembro(remitente2);
		chat.agregarMensajeEnviado(msj1);
		chat.agregarMensajeRecibido(msj2);
		chat.agregarMensajeRecibido(msj3);
		chat.borrarMensajes(remitente2);
        assertEquals(chat.cantidadMensajesDe(remitente2),0);
    }
	

}
