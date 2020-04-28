package Juego;

import modelo.Equipo;
import modelo.Personaje;
import modelo.StatsJuego;
import modelo.Tablero;
import modelo.consumibles.EsferaDelDragon;
import modelo.consumibles.NubeVoladora;
import modelo.consumibles.SemillaDelErmitanio;
import modelo.personajes.*;
import modelo.turnos.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class DragonAlgoBall {
	TurnoEquipoZ turnoZ;
	TurnoEquipoEnemigos turnoEnemigos;
	Turno Actual;
	Tablero tablero;
	Equipo equipoGuerrerosZ;
	Equipo equipoEnemigos;
	
	public Turno crearModelo(){
		this.tablero = new Tablero(StatsJuego.tamanioTablero);
		this.equipoGuerrerosZ = new Equipo();
		this.equipoEnemigos = new Equipo();
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero, equipoGuerrerosZ);
		
		MajinBoo majinBoo = new MajinBoo(tablero, equipoEnemigos);
		Freezer freezer = new Freezer(tablero, equipoEnemigos);
		Cell cell = new Cell(tablero, equipoEnemigos);
		
		equipoEnemigos.agregarMiembro(cell);
		equipoEnemigos.agregarMiembro(freezer);
		equipoEnemigos.agregarMiembro(majinBoo);
		equipoGuerrerosZ.agregarMiembro(goku);
		equipoGuerrerosZ.agregarMiembro(gohan);
		equipoGuerrerosZ.agregarMiembro(picolo);
		
		tablero.colocarObjeto(cell, cell.getPosicion());
		tablero.colocarObjeto(freezer, freezer.getPosicion());
		tablero.colocarObjeto(majinBoo, majinBoo.getPosicion());
		tablero.colocarObjeto(gohan, gohan.getPosicion());
		tablero.colocarObjeto(goku, goku.getPosicion());
		tablero.colocarObjeto(picolo, picolo.getPosicion());
		
		return generarTurnoInicial();	
		
		
	}
	
	private Turno generarTurnoInicial(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(2);
		
		if(randomInt == 0){
			turnoZ = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
			Actual = turnoZ;
		}
		else{
			turnoEnemigos = new TurnoEquipoEnemigos(tablero, equipoEnemigos);
			Actual = turnoEnemigos;
		}
		return Actual;
	}
	
	public void cambiarTurno(){
		if(Actual == turnoZ){
			Actual.terminoTurno();
			turnoEnemigos = new TurnoEquipoEnemigos(tablero, equipoEnemigos);
			Actual = turnoEnemigos;
		}
		else{
			Actual.terminoTurno();
			turnoZ = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
			Actual = turnoZ;
		}
		this.generarConsumiblesAleatorios();
	}
	

	public Turno getTurnoActual() {
		return this.Actual;
	}
	
	private void generarConsumiblesAleatorios(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(50);
		if(randomInt>=0 && randomInt <4){
			new EsferaDelDragon(tablero);
			return;
		}
		if(randomInt>=11 && randomInt <16){
			new SemillaDelErmitanio(tablero);
			return;
		}
		if(randomInt>=33 && randomInt <38){
			new NubeVoladora(tablero);
			return;
		}
	}

	public ArrayList<Personaje> getPersonajes() {
		ArrayList<Personaje> lista = new ArrayList<Personaje>();
		Collection<Personaje> personajesEnemigos = this.equipoEnemigos.getMiembros();
		Collection<Personaje> personajesZ = this.equipoGuerrerosZ.getMiembros();
		for(Personaje personaje:personajesEnemigos){
			lista.add(personaje);
		}
		for(Personaje personaje :personajesZ){
				lista.add(personaje);
		}
		return lista;
	}
	
}


