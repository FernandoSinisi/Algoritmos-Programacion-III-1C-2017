package tp1.testAlumno;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import tp1.AlgoChat;
import tp1.Excepciones.*;

public class TestAlgoChat {
	String USUARIO = "Fernando";
	String NOMBREGRUPO1 = "AlgoIII";
	String NOMBREGRUPO2 = "AlgoII";
	String NOMBREGRUPO3 = "AlgoI";
	String NOMBRECONTACTO1 = "Marcio";
	String NOMBRECONTACTO2 = "Tomas";
	String NOMBRECONTACTO3 = "Carlos";
	String CONTENIDO1 = "Hola";
	String CONTENIDO2 = "Chau";
	String CONTENIDO3 = "Saludos";
	
	@Test
    public void test01CrearAlgochat() {
		AlgoChat algochat = new AlgoChat("Fernando");
		assert(algochat instanceof AlgoChat);
    }
	
	@Test
    public void test02CrearAlgochatVerificarQueEstaTodoVacio() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		assertEquals(algochat.nombreUsuario(),USUARIO);
		assertEquals(algochat.cantidadDeContactos(),0);
        assertEquals(algochat.cantidadDeGrupos(),0);
        assertEquals(algochat.cantidadDeChatsGrupales(),0);
        assertEquals(algochat.cantidadDeChatsIndividuales(),0);
        assertEquals(algochat.cantidadDeMensajesEnviados(),0);
        assertEquals(algochat.cantidadTotalMensajesRecibidos(),0);
        assertEquals(algochat.cantidadTotalMensajesEnviados(),0);
    }
	
	@Test
    public void test03ExisteGrupoEnAlgochatVacioDeberiaLanzarFalse() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		
		assert(!algochat.existeGrupo(NOMBREGRUPO1));
    }
	
	@Test
    public void test04ExisteContactoEnAlgochatVacioDeberiaLanzarFalse() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		assert(!algochat.existeContacto(NOMBRECONTACTO1));
    }
	
	@Test
    public void test05ExisteGrupoEnAlgochatLuegoDeCrearloDeberiaLanzarTrue() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.crearGrupo(NOMBREGRUPO1);
		assert(algochat.existeGrupo(NOMBREGRUPO1));
    }
	
	@Test
    public void test06ExisteContactoEnAlgochatLuegoDeCrearloDeberiaLanzarTrue() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO1);
		assert(algochat.existeContacto(NOMBRECONTACTO1));
    }
	
	@Test
    public void test07ObtenerCantidadGrupos() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.crearGrupo(NOMBREGRUPO1);
		algochat.crearGrupo(NOMBREGRUPO2);
		assertEquals(algochat.cantidadDeGrupos(),2);
    }
	
	@Test
    public void test08ObtenerCantidadContactos() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.agregarContacto(NOMBRECONTACTO2);
		assertEquals(algochat.cantidadDeContactos(),2);
    }
	
	@Test
    public void test09ObtenerCantidadChatGrupales() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.crearGrupo(NOMBREGRUPO1);
		algochat.crearGrupo(NOMBREGRUPO2);
		algochat.crearGrupo(NOMBREGRUPO3);
		assertEquals(algochat.cantidadDeChatsGrupales(),3);
    }
	
	@Test
    public void test10ObtenerCantidadContactos() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO1);
		assertEquals(algochat.cantidadDeChatsIndividuales(),1);
    }
	
	@Test
    public void test11CantidadMensajesEnviadosAContactoSinChatear() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO1);
		assertEquals(algochat.cantidadMensajesEnviadosA(NOMBRECONTACTO1),0);
    }
	
	@Test
    public void test12CantidadMensajesEnviadosAContactoLuegoDeChatear() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.enviarMensajeA(NOMBRECONTACTO1, CONTENIDO1);
		algochat.enviarMensajeA(NOMBRECONTACTO1, CONTENIDO2);
		assertEquals(algochat.cantidadMensajesEnviadosA(NOMBRECONTACTO1),2);
    }
	
	@Test
    public void test13CantidadMensajesRecibidosDeContactoSinChatear() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO1);
		assertEquals(algochat.cantidadMensajesDe(NOMBRECONTACTO1),0);
    }
	
	@Test
    public void test14CantidadMensajesRecibidosDecontactoLuegoDeChatear() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.recibirMensajeDe(NOMBRECONTACTO2, CONTENIDO1);
		algochat.recibirMensajeDe(NOMBRECONTACTO2, CONTENIDO2);
		algochat.recibirMensajeDe(NOMBRECONTACTO2, CONTENIDO2);
		assertEquals(algochat.cantidadMensajesDe(NOMBRECONTACTO2),3);
    }
	
	@Test
    public void test15CantidadMensajesEnviadosAContactoLuegoDeChatearYBorrar() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.enviarMensajeA(NOMBRECONTACTO1, CONTENIDO1);
		algochat.enviarMensajeA(NOMBRECONTACTO1, CONTENIDO2);
		algochat.borrarMensajesDelContacto(NOMBRECONTACTO1);
		assertEquals(algochat.cantidadMensajesEnviadosA(NOMBRECONTACTO1),0);
    }
	
	@Test
    public void test16CantidadMensajesRecibidosDecontactoLuegoDeChatearYBorrar() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.recibirMensajeDe(NOMBRECONTACTO2, CONTENIDO1);
		algochat.recibirMensajeDe(NOMBRECONTACTO2, CONTENIDO2);
		algochat.borrarMensajesDelContacto(NOMBRECONTACTO2);
		assertEquals(algochat.cantidadMensajesDe(NOMBRECONTACTO2),0);
    }
	
	@Test
    public void test17CantidadTotalMensajesRecibidosDeVariosContactos() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.agregarContacto(NOMBRECONTACTO3);
		algochat.recibirMensajeDe(NOMBRECONTACTO2, CONTENIDO1);
		algochat.recibirMensajeDe(NOMBRECONTACTO1, CONTENIDO2);
		algochat.recibirMensajeDe(NOMBRECONTACTO3, CONTENIDO2);
		assertEquals(algochat.cantidadTotalMensajesRecibidos(),3);
    }
	
	@Test
    public void test18CantidadTotalMensajesEnviadorAVariosContactos() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.agregarContacto(NOMBRECONTACTO3);
		algochat.enviarMensajeA(NOMBRECONTACTO2, CONTENIDO2);
		algochat.enviarMensajeA(NOMBRECONTACTO1, CONTENIDO2);
		algochat.enviarMensajeA(NOMBRECONTACTO3, CONTENIDO1);
		assertEquals(algochat.cantidadTotalMensajesEnviados(),3);
    }
	
	@Test
    public void test19CantidadMiembrosGrupoVacio() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.crearGrupo(NOMBREGRUPO2);
		assertEquals(algochat.cantidadMiembrosEnGrupo(NOMBREGRUPO2),1);
    }
	
	@Test
    public void test20CantidadMiembrosGrupoConMiembros() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.crearGrupo(NOMBREGRUPO2);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO2, NOMBREGRUPO2);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO1, NOMBREGRUPO2);
		assertEquals(algochat.cantidadMiembrosEnGrupo(NOMBREGRUPO2),3);
    }
	
	@Test
    public void test21CantidadMensajesRecibidosDeGrupoSinConversacion() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.crearGrupo(NOMBREGRUPO3);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO2, NOMBREGRUPO3);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO1, NOMBREGRUPO3);
		assertEquals(algochat.cantidadMensajesRecibidosDelGrupo(NOMBREGRUPO3),0);
	}
	
	@Test
    public void test22CantidadMensajesRecibidosDeGrupoConConversacion() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.crearGrupo(NOMBREGRUPO3);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO2, NOMBREGRUPO3);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO1, NOMBREGRUPO3);
		algochat.recibirMensajeDeGrupo(NOMBREGRUPO3, NOMBRECONTACTO1, CONTENIDO1);
		algochat.recibirMensajeDeGrupo(NOMBREGRUPO3, NOMBRECONTACTO2, CONTENIDO2);
		assertEquals(algochat.cantidadMensajesRecibidosDelGrupo(NOMBREGRUPO3),2);
	}
	
	@Test
    public void test23CantidadMensajesEnviadosAlGrupoSinConversacion() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.crearGrupo(NOMBREGRUPO3);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO2, NOMBREGRUPO3);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO1, NOMBREGRUPO3);
		assertEquals(algochat.cantidadMensajesEnviadosAlGrupo(NOMBREGRUPO3),0);
	}
	
	@Test
    public void test24CantidadMensajesEnviadosAlGrupoConConversacion() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.crearGrupo(NOMBREGRUPO3);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO2, NOMBREGRUPO3);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO1, NOMBREGRUPO3);
		algochat.enviarMensajeAGrupo(NOMBREGRUPO3,CONTENIDO1);
		algochat.enviarMensajeAGrupo(NOMBREGRUPO3,CONTENIDO2);
		assertEquals(algochat.cantidadMensajesEnviadosAlGrupo(NOMBREGRUPO3),2);
	}
	
	@Test
    public void test25ObtenerConversacionConContactoYverificanMensajes() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.enviarMensajeA(NOMBRECONTACTO2, CONTENIDO1);
		algochat.recibirMensajeDe(NOMBRECONTACTO2, CONTENIDO1);
		algochat.enviarMensajeA(NOMBRECONTACTO2, CONTENIDO2);
		algochat.recibirMensajeDe(NOMBRECONTACTO2, CONTENIDO3);
		assertEquals(algochat.obtenerConversacionCon(NOMBRECONTACTO2).get(1),"Tomas: Saludos");
		assertEquals(algochat.obtenerConversacionCon(NOMBRECONTACTO2).get(2),"Yo: Chau");
		assertEquals(algochat.obtenerConversacionCon(NOMBRECONTACTO2).get(3),"Tomas: Hola");
		assertEquals(algochat.obtenerConversacionCon(NOMBRECONTACTO2).get(4),"Yo: Hola");
	}
	
	@Test
    public void test26ObtenerConversacionDelGrupoYverificarMensajes() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO2);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.crearGrupo(NOMBREGRUPO3);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO2, NOMBREGRUPO3);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO1, NOMBREGRUPO3);
		algochat.enviarMensajeAGrupo(NOMBREGRUPO3,CONTENIDO1);
		algochat.enviarMensajeAGrupo(NOMBREGRUPO3,CONTENIDO2);
		algochat.recibirMensajeDeGrupo(NOMBREGRUPO3, NOMBRECONTACTO1, CONTENIDO3);
		algochat.recibirMensajeDeGrupo(NOMBREGRUPO3, NOMBRECONTACTO2, CONTENIDO2);
		assertEquals(algochat.obtenerConversacionConGrupo(NOMBREGRUPO3).get(1),"Tomas: Chau");
		assertEquals(algochat.obtenerConversacionConGrupo(NOMBREGRUPO3).get(2),"Marcio: Saludos");
		assertEquals(algochat.obtenerConversacionConGrupo(NOMBREGRUPO3).get(3),"Yo: Chau");
		assertEquals(algochat.obtenerConversacionConGrupo(NOMBREGRUPO3).get(4),"Yo: Hola");
	}
	
	@Test
    public void test27CantidadTotalDeMensajesDeContacto() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO3);
		algochat.crearGrupo(NOMBREGRUPO1);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO3, NOMBREGRUPO1);
		algochat.recibirMensajeDeGrupo(NOMBREGRUPO1, NOMBRECONTACTO3, CONTENIDO3);
		algochat.recibirMensajeDeGrupo(NOMBREGRUPO1, NOMBRECONTACTO3, CONTENIDO2);
		algochat.recibirMensajeDe(NOMBRECONTACTO3, CONTENIDO1);
		algochat.recibirMensajeDe(NOMBRECONTACTO3, CONTENIDO2);
		algochat.recibirMensajeDe(NOMBRECONTACTO3, CONTENIDO3);
		assertEquals(algochat.cantidadMensajesDe(NOMBRECONTACTO3),5);
	}
	
	@Test
    public void test28CantidadTotalDeMensajesDeContactoluegoDeBorrarlos() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO3);
		algochat.crearGrupo(NOMBREGRUPO1);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO3, NOMBREGRUPO1);
		algochat.recibirMensajeDeGrupo(NOMBREGRUPO1, NOMBRECONTACTO3, CONTENIDO3);
		algochat.recibirMensajeDeGrupo(NOMBREGRUPO1, NOMBRECONTACTO3, CONTENIDO2);
		algochat.recibirMensajeDe(NOMBRECONTACTO3, CONTENIDO1);
		algochat.recibirMensajeDe(NOMBRECONTACTO3, CONTENIDO2);
		algochat.recibirMensajeDe(NOMBRECONTACTO3, CONTENIDO3);
		algochat.borrarMensajesDelContacto(NOMBRECONTACTO3);
		assertEquals(algochat.cantidadMensajesDe(NOMBRECONTACTO3),0);
	}
	
	@Test
    public void test29CantidadTotalDeMensajesDelGrupoLuegoDeBorrarlos() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO3);
		algochat.crearGrupo(NOMBREGRUPO1);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO3, NOMBREGRUPO1);
		algochat.recibirMensajeDeGrupo(NOMBREGRUPO1, NOMBRECONTACTO3, CONTENIDO3);
		algochat.recibirMensajeDeGrupo(NOMBREGRUPO1, NOMBRECONTACTO3, CONTENIDO2);
		algochat.enviarMensajeAGrupo(NOMBREGRUPO1, CONTENIDO3);
		algochat.borrarMensajesDelGrupo(NOMBREGRUPO1);
		assertEquals(algochat.cantidadMensajesEnviadosAlGrupo(NOMBREGRUPO1),0);
		assertEquals(algochat.cantidadMensajesRecibidosDelGrupo(NOMBREGRUPO1),0);
	}
	
	@Test(expected = GrupoRepetido.class)
    public void test30CrearGrupoConNombreRepetidoDeberiaLanzarGrupoRepetido() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.crearGrupo(NOMBREGRUPO1);
		algochat.crearGrupo(NOMBREGRUPO1);
	}
	
	@Test(expected = ContactoRepetido.class)
    public void test31CrearCOntactoConNombreRepetidoDeberiaLanzarContactoRepetido() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.agregarContacto(NOMBRECONTACTO1);
	}
	
	@Test(expected = MiembroGrupoRepetido.class)
    public void test32AgregarMiembroConNombreRepetidoDeberiaLanzarMiembroGrupoRepetido() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.crearGrupo(NOMBREGRUPO1);
		algochat.agregarContacto(NOMBRECONTACTO1);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO1, NOMBREGRUPO1);
		algochat.agregarContactoAGrupo(NOMBRECONTACTO1, NOMBREGRUPO1);
	}
	
	@Test(expected = NombreNoAgendado.class)
    public void test33EnviarMensajeAContactoNoAgendadoDeberiaLanzarNombreNoAgendado() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.enviarMensajeA(NOMBRECONTACTO1, CONTENIDO1);
	}
	
	@Test(expected = NombreNoAgendado.class)
    public void test34RecibirMensajeDeContactoNoAgendadoDeberiaLanzarNombreNoAgendado() {
		AlgoChat algochat = new AlgoChat(USUARIO);
		algochat.recibirMensajeDe(NOMBRECONTACTO1, CONTENIDO1);
	}	
}

