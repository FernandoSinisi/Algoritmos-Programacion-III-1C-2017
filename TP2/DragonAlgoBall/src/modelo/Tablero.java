package modelo;

import java.util.*;

import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.MovimientoInvalido;
import modelo.excepciones.PosicionInvalida;
import modelo.excepciones.TamanioTableroInvalido;

public class Tablero {
	
	private HashMap <Posicion,Casillero> casilleros;
	private int tamanioTablero;
	
	public Tablero(int tamanio) {
		this.validarTamanio(tamanio);
		this.tamanioTablero = tamanio;
		this.casilleros = new HashMap<Posicion,Casillero>();
	}
	
	public int getTamanio(){
		return tamanioTablero;
	}
	
	public void validarTamanio(int tamanio){
		if(StatsJuego.tamanioTablero<tamanio || StatsJuego.tamanioTableroMinimo>tamanio){
			throw new TamanioTableroInvalido();
		}
	}

	
	public void validarPosicionLimitesTablero(Posicion posicion){
		if(posicion.getCoordenadaX() <= 0 || posicion.getCoordenadaX() > StatsJuego.tamanioTablero ||	posicion.getCoordenadaY() <= 0 || posicion.getCoordenadaY() > StatsJuego.tamanioTablero){
			throw new MovimientoInvalido();
		}
	}
	
	public Personaje obtenerPersonaje(Posicion posicion){
		ObjetoJuego objeto = this.obtenerObjeto(posicion);
		if(!objeto.esPersonaje()){
			throw new PosicionInvalida();
		}
		return (Personaje)objeto;
	}
	
	public Consumible obtenerConsumible(Posicion posicion){
		ObjetoJuego objeto = this.obtenerObjeto(posicion);
		if(!objeto.esConsumible()){
			throw new PosicionInvalida();
		}
		return (Consumible)objeto;
	}
	
	public ObjetoJuego obtenerObjeto(Posicion posicion){
		this.validarPosicionLimitesTablero(posicion);
		for (Posicion pos : this.casilleros.keySet()) {
			if (compararPosicion(pos, posicion)){
				return this.casilleros.get(pos).obtenerObjeto();
			}
		}
		throw new CasilleroVacio();
	}
	
	public boolean compararPosicion(Posicion posicionObtenida, Posicion posicionEsperada){
		return (posicionObtenida.getCoordenadaX() == posicionEsperada.getCoordenadaX() && posicionObtenida.getCoordenadaY() == posicionEsperada.getCoordenadaY());
	}

	public void colocarObjeto(ObjetoJuego objeto,Posicion posicion){
		this.validarPosicionLimitesTablero(posicion);
		for (Posicion pos : this.casilleros.keySet()) {
			if (compararPosicion(pos, posicion)){
				throw new CasilleroOcupado();
			}
		}
		Casillero casillero = new Casillero();
		casillero.agregarObjeto(objeto);
		this.casilleros.put(posicion,casillero);
	}
	

	public Casillero obtenerCasilleroAOcupar(Posicion posicion){
		this.validarPosicionLimitesTablero(posicion);
		for (Posicion pos : this.casilleros.keySet()) {
			if (compararPosicion(pos, posicion)){
				if(this.casilleros.get(pos).obtenerObjeto().esPersonaje())throw new MovimientoInvalido();
				return this.casilleros.get(pos);
			}
		}
		return new Casillero();
	}
	
		
	public void borrarCasillero(Posicion posicion){
		Posicion posicionBorrar = null;
		Set<Posicion> casilleros = this.casilleros.keySet();
		for (Posicion pos : casilleros) {
			if(this.compararPosicion(pos,posicion)){
				posicionBorrar = pos;
				break;
			}
		}
		this.casilleros.remove(posicionBorrar);
	}
	
	public void moverPersonaje(Posicion posicionVieja, Posicion posicionNueva){
		Casillero casilleroAOcupar = this.obtenerCasilleroAOcupar(posicionNueva);
		Personaje personaje = this.obtenerPersonaje(posicionVieja);
		this.borrarCasillero(posicionVieja);
		if(!casilleroAOcupar.estaVacio()){
			Consumible consumible = (Consumible) casilleroAOcupar.eliminarObjeto();
			consumible.consumir(personaje);
			casilleroAOcupar.agregarObjeto(personaje);
			return;
			}
		casilleroAOcupar.agregarObjeto(personaje);
		this.casilleros.put(posicionNueva, casilleroAOcupar);
		return;
	}
	
	public boolean quedanJugadoresDelOtroEquipo(Collection<Personaje> miembrosMiEquipo){
		for (Posicion pos : this.casilleros.keySet()) {
			ObjetoJuego objeto = obtenerObjeto(pos);
			if(objeto.esPersonaje() && !miembrosMiEquipo.contains(objeto)){
				return true;
			}
		}
		return false;
	}
	
	
	public ArrayList<Personaje> getPersonajes(){
		ArrayList<Personaje> lista = new ArrayList<Personaje>();
		for (Casillero casillero : this.casilleros.values()) {
			if(casillero.obtenerObjeto() instanceof Personaje){
				lista.add((Personaje)casillero.obtenerObjeto());
			}
		}
		return lista;
	}

	public Set<Posicion> obtenerPosiciones() {
		return this.casilleros.keySet();
	}

		
		
		
		

}