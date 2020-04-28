package modelo;

import java.util.HashMap;
import modelo.StatsJuego;
import modelo.fases.Fase;

public class Estado {
	private boolean vivo;
	private int poderDePelea;
	private int distanciaDeAtaque;
	private int velocidad;
	private int kiEvolucion;
	private int puntosDeVidaIniciales;
	private int puntosDeVida;
	private int ki;
	
	
	public Estado(String nombre,Fase fase){
		this.setearEstado(nombre,fase);
		this.puntosDeVida = fase.obtenerStats().get("puntosDeVida");
		this.puntosDeVidaIniciales = fase.obtenerStats().get("puntosDeVida");
		this.ki = 0;
		this.vivo = true;
	}
	
	public int getVelocidad(){
		return this.velocidad;
	}
	
	public int getPuntosDeVidaIniciales(){
		return puntosDeVidaIniciales;
	}
	
	public int getDistanciaDeAtaque(){
		return this.distanciaDeAtaque;
	}
	
	public void aumentarKi(int kiAumentar) {
		this.ki += kiAumentar;
	}
	
	public int getKi(){
		return this.ki;
	}
	
	public boolean sigueVivo(){
		return this.puntosDeVida > 0;
	}

	public int getPoderDePelea() {
		return this.poderDePelea;
	}
	
	public boolean getVivo(){
		return this.vivo;
	}
	
	public void restarVida(int vida){
		this.puntosDeVida-=vida;
	}
	
	public void incrementarVida(int vida){
		this.puntosDeVida+=vida;
	}
	
	public void restarKi(int kiDisminuir){
		this.ki -= kiDisminuir;
	}
	
	public int getPuntosDeVida() {
		return this.puntosDeVida;
	}
	
	public void aumentarAtaquePorEsferaDelDragon(){
		this.poderDePelea *= StatsJuego.factorAumentoEsferaDelDragon;
	}
	
	public void aumentarVelocidadPorNubeVoladora(){
		this.velocidad *= StatsJuego.factorAumentoNubeVoladora;
	}
	
	public void aumentarPuntosDeVidaPorSemillaDelErmintanio(){
		this.puntosDeVida += StatsJuego.aumentoDeVidaSemillaErmitanio;
	}
	
	public void volverAtaqueANormalidad(Fase fase){
		HashMap<String,Integer> stats = fase.obtenerStats(); 
		this.poderDePelea = stats.get("poderDePelea");
	}
	
	public void volverVelocidadANormalidad(Fase fase){
		HashMap<String,Integer> stats = fase.obtenerStats(); 
		this.velocidad = stats.get("velocidad");
	}
	
	
	public void setearEstado(String personaje,Fase fase){
		HashMap<String,Integer> stats = fase.obtenerStats(); 
		this.poderDePelea = stats.get("poderDePelea");
		this.velocidad = stats.get("velocidad");
		this.distanciaDeAtaque = stats.get("distanciaDeAtaque");
		this.kiEvolucion = stats.get("kiEvolucion");
	}
	
	public void setearAMuerto(){
		this.vivo = false;
		this.poderDePelea = 0;
		this.velocidad = 0;
		this.distanciaDeAtaque = 0;
		this.ki = 0;
		this.puntosDeVida = 0;
		
	}

	public void actualizar(String nombre, Fase fase) {
		this.ki -= this.kiEvolucion; 
		this.setearEstado(nombre, fase);
		
	}

}