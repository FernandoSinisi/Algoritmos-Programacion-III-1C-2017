package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.*;
import modelo.consumibles.EsferaDelDragon;
import modelo.excepciones.GanadorEquipoEnemigos;
import modelo.excepciones.GanadorEquipoZ;
import modelo.excepciones.PersonajeInmovilizado;
import modelo.personajes.EnemigoDeLaTierra;
import modelo.personajes.*;
import modelo.personajes.GuerreroZ;
import modelo.turnos.TurnoEquipoEnemigos;
import modelo.turnos.TurnoEquipoZ;


public class TestIntegracionJuego {
	
	int TAMANIO1 = 10;
	int TAMANIO2 = 5;
	@Test
	public void test01imitacionJuego(){
		Tablero tablero = new Tablero(TAMANIO1);
		Equipo equipoGuerrerosZ = new Equipo();
		Equipo equipoEnemigos = new Equipo();
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		Cell cell = new Cell(tablero,equipoEnemigos);
		Freezer freezer = new Freezer(tablero,equipoEnemigos);
		MajinBoo majinboo = new MajinBoo(tablero,equipoEnemigos);
		equipoGuerrerosZ.agregarMiembro(picolo);
		equipoGuerrerosZ.agregarMiembro(goku);
		equipoGuerrerosZ.agregarMiembro(gohan);
		equipoEnemigos.agregarMiembro(majinboo);
		equipoEnemigos.agregarMiembro(cell);
		equipoEnemigos.agregarMiembro(freezer);
		tablero.colocarObjeto(goku,goku.getPosicion());
		tablero.colocarObjeto(gohan,gohan.getPosicion());
		tablero.colocarObjeto(picolo,picolo.getPosicion());
		tablero.colocarObjeto(majinboo,majinboo.getPosicion());
		tablero.colocarObjeto(cell,cell.getPosicion());
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		
		TurnoEquipoZ turnoZ1= new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		Posicion seleccionada = new Posicion(1,1);
		turnoZ1.seleccionarPersonaje(seleccionada);
		turnoZ1.Mover();
		
		//Usuario toco boton mover a arriba - derecha - arriba&derecha
		Personaje aMover = turnoZ1.getPersonajeMovil();
		aMover.MoverPersonajeHaciaArribaDerecha();
		aMover.MoverPersonajeHaciaArriba();
		//aMover.MoverPersonajeHaciaDerecha();
		
		TurnoEquipoEnemigos turnoE1 = new TurnoEquipoEnemigos(tablero, equipoEnemigos);
		Posicion seleccionada2 = new Posicion(10,9); 
		turnoE1.seleccionarPersonaje(seleccionada2);
		turnoE1.Mover();
		
		//Usuario toco boton mover a la abajo - izq - abajoderecha 
		Personaje aMover2 = turnoE1.getPersonajeMovil();
		aMover2.MoverPersonajeHaciaAbajoIzquierda();
		aMover2.MoverPersonajeHaciaAbajo();
		aMover2.MoverPersonajeHaciaIzquierda();
		
		assertEquals(tablero.obtenerObjeto(new Posicion(2,3)).getNombre(),"Goku");
		assertEquals(tablero.obtenerObjeto(new Posicion(8,7)).getNombre(),"Freezer");
	}

		
	@Test
	public void test02ImitacionDelJuegoConElAtaqueDeMajinBooDeberiaInmovilizarPorTresTurnos(){
		Tablero tablero = new Tablero(TAMANIO2);
		Equipo equipoGuerrerosZ = new Equipo();
		Equipo equipoEnemigos = new Equipo();
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		Cell cell = new Cell(tablero,equipoEnemigos);
		Freezer freezer = new Freezer(tablero,equipoEnemigos);
		MajinBoo majinboo = new MajinBoo(tablero,equipoEnemigos);
		equipoGuerrerosZ.agregarMiembro(picolo);
		equipoGuerrerosZ.agregarMiembro(goku);
		equipoGuerrerosZ.agregarMiembro(gohan);
		equipoEnemigos.agregarMiembro(majinboo);
		equipoEnemigos.agregarMiembro(cell);
		equipoEnemigos.agregarMiembro(freezer);
		tablero.colocarObjeto(goku,goku.getPosicion());
		tablero.colocarObjeto(gohan,gohan.getPosicion());
		tablero.colocarObjeto(picolo,picolo.getPosicion());
		tablero.colocarObjeto(majinboo,majinboo.getPosicion());
		tablero.colocarObjeto(cell,cell.getPosicion());
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		
		
		TurnoEquipoEnemigos turnoE1 = new TurnoEquipoEnemigos(tablero, equipoEnemigos);
		
		//Usuario selecciono la posicion de MajinBoo para mover
		Posicion seleccionada1 = new Posicion(4,5); 
		turnoE1.seleccionarPersonaje(seleccionada1);
		turnoE1.Mover();
		//Usuario selecciono la posicion de MajinBoo para mover
		turnoE1.atacar();
		
		EnemigoDeLaTierra aMover = (EnemigoDeLaTierra)turnoE1.getPersonajeMovil();
		aMover.aumentarKi(30); // Harcodeo para probar el ataque especial
		aMover.MoverPersonajeHaciaAbajoIzquierda();
		aMover.MoverPersonajeHaciaAbajoIzquierda();
	
		assertEquals(tablero.obtenerObjeto(new Posicion(2,3)).getNombre(), "MajinBoo");
		
		
		//Usuario selecciono el personaje a atacar
		Posicion seleccionada2 = new Posicion(2,1); 
		EnemigoDeLaTierra atacante = (EnemigoDeLaTierra)turnoE1.getPersonajeatacante();
		
		//usuario selecciono ataque epecial
		atacante.ataqueEspecial(tablero.obtenerPersonaje(seleccionada2));
		
		
		/* *******************CAMBIO DE TURNO********************************** */
		
		TurnoEquipoZ turnoZ1 = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		//Usuario selecciono la posicion de Picolo para mover
		turnoZ1.seleccionarPersonaje(seleccionada2);
		turnoZ1.Mover();
		GuerreroZ aMoverZ = (GuerreroZ) turnoZ1.getPersonajeMovil();
		
		//Voy a intentar mover un personaje inmovilizado por Boo, no deberia poder
		try {
			aMoverZ.MoverPersonajeHaciaAbajo();
			
		} catch (PersonajeInmovilizado e) {
			//Usuario selecciona otro personaje para mover, ahora a Goku a este si lo beria dejar
			Posicion seleccionada3 = new Posicion(1,1); 
			turnoZ1.seleccionarPersonaje(seleccionada3);
			turnoZ1.Mover();
			aMoverZ = (GuerreroZ) turnoZ1.getPersonajeMovil();
			aMoverZ.MoverPersonajeHaciaArribaDerecha();
			assertEquals(tablero.obtenerObjeto(new Posicion(2,2)).getNombre(), "Goku");
		}
		
		/* *******************DESPUES DE 3 TURNOS********************************** */
		turnoZ1 = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		//...
		turnoZ1 = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		//...
		turnoZ1 = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		/* *******************DESPUES DE 3 TURNOS********************************** */
		
		
		//Usuario ya puede volvera jugar con picolo
		turnoZ1.seleccionarPersonaje(seleccionada2);
		turnoZ1.Mover();
		aMoverZ = (GuerreroZ) turnoZ1.getPersonajeMovil();
		aMoverZ.MoverPersonajeHaciaIzquierda();
		assertEquals(tablero.obtenerObjeto(new Posicion(1,1)).getNombre(), "Picolo");
		

	}
	
	@Test (expected = GanadorEquipoZ.class)
	public void test03JuegoSeTerminaGananGuerrerosZConsiguieronLas7Esferas(){
		/* generar 7 esferas del dragon tomarlas con un equipo y cuando termine el turno luego de agarrar la septima
		 * al terminar el turno deberia levantar la excepcion de juego terminado
		 * ATENCION! Poner al lado del @Test (excpected = JuegoTerminado.class) para que reconozca que espera eso
		 */
		
		Tablero tablero = new Tablero(TAMANIO2);
		Equipo equipoGuerrerosZ = new Equipo();
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		equipoGuerrerosZ.agregarMiembro(goku);
		equipoGuerrerosZ.agregarMiembro(gohan);
		equipoGuerrerosZ.agregarMiembro(picolo);
		
		EsferaDelDragon esfera1 = new EsferaDelDragon(tablero);
		esfera1.consumir(goku);
		esfera1.consumir(picolo);
		esfera1.consumir(gohan);
		esfera1.consumir(goku);
		esfera1.consumir(picolo);
		esfera1.consumir(gohan);
		esfera1.consumir(gohan);
		TurnoEquipoZ turnoZ = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		turnoZ.controlarCantidadEsferasDelDragon();
		
		
	}
	
	
	@Test (expected = GanadorEquipoEnemigos.class)
	public void test04JuegoSeTerminaGananEnemigosCuandoMuerenTodosLosDelOtroEquipo(){
		/*idem anterior pero que se maten todos los de un equipo*/
		
		Tablero tablero = new Tablero(TAMANIO2);
		
		Equipo equipoGuerrerosZ = new Equipo();
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		equipoGuerrerosZ.agregarMiembro(goku);
		equipoGuerrerosZ.agregarMiembro(gohan);
		equipoGuerrerosZ.agregarMiembro(picolo);
		
		Equipo equipoEnemigos = new Equipo();
		TurnoEquipoEnemigos turnoEnemigos = new TurnoEquipoEnemigos(tablero,equipoEnemigos);
		Cell cell = new Cell(tablero,equipoEnemigos);
		Freezer freezer = new Freezer(tablero,equipoEnemigos);
		MajinBoo majinBoo = new MajinBoo(tablero,equipoEnemigos);
		equipoEnemigos.agregarMiembro(cell);
		equipoEnemigos.agregarMiembro(freezer);
		equipoEnemigos.agregarMiembro(majinBoo);
		
		goku.morir();
		gohan.morir();
		picolo.morir();
		
		turnoEnemigos.controlarJuegadoresEquipoContrario();
	}
	
}	
