package modelo;

import modelo.personajes.GuerreroZ;

public class Ataque {
	int poderActual;
	public Ataque (int actual){
		poderActual=actual;
	}
	
	private void atacar(Personaje personajeAtacado, int poderDeAtaque){
		personajeAtacado.estado.restarVida(poderDeAtaque);
		if (!personajeAtacado.estado.sigueVivo()){
			personajeAtacado.morir();			
		}
	}
	
	public void ataqueBasico(Personaje personajeAtacado){
		int poderPelea = modificarAtaqueSegunPoderEnemigo(poderActual, personajeAtacado.getPoderDePelea());
		atacar(personajeAtacado,poderPelea);
	}
	
	public void kamehameha(Personaje personajeAtacado){
		//Ataque especial Goku
		int poderPelea = modificarAtaqueSegunPoderEnemigo(poderActual, personajeAtacado.getPoderDePelea());
		this.atacar(personajeAtacado,(int)(poderPelea*StatsJuego.factorAumentoKamehameha));		
	}
	
	public void ataqueBasicoMejoradoGoku(Personaje personajeAtacado){
		//Ataque basico Goku cuando tiene menos del 30% de vida
		int poderPelea = modificarAtaqueSegunPoderEnemigo(poderActual, personajeAtacado.getPoderDePelea());
		
		this.atacar(personajeAtacado,(int)(poderPelea*StatsJuego.factorAumentoDanioGlobalGoku));
	}
	
	public void masenko(Personaje personajeAtacado){
		// Ataque especial Gohan
		int poderPelea = modificarAtaqueSegunPoderEnemigo(poderActual, personajeAtacado.getPoderDePelea());
		this.atacar(personajeAtacado,(int)(poderPelea*StatsJuego.factorAumentoMasenko));
	}
	
	public void makankosappo(Personaje enemigo){
		//Ataque especial Piccolo
		int poderPelea = modificarAtaqueSegunPoderEnemigo(poderActual, enemigo.getPoderDePelea());
		
		this.atacar(enemigo,(int)(poderPelea*StatsJuego.factorAumentoMakankosappo));
	}
	
	public void absorber(Personaje enemigo){
		//Ataque especial Cell
		int poderPelea = modificarAtaqueSegunPoderEnemigo(poderActual, enemigo.getPoderDePelea());
		
		this.atacar(enemigo,poderPelea);
	}
	
	public void rayoMortal(Personaje enemigo){
		//Ataque especial de Freezer
		int poderPelea = modificarAtaqueSegunPoderEnemigo(poderActual, enemigo.getPoderDePelea());
		
		this.atacar(enemigo, (int)(poderPelea*StatsJuego.factorAumentoRayoMortal));
	}
	
	public void convertirEnChocolate(GuerreroZ enemigo){
		enemigo.inmovilizar();
	}
	
	public void setPoderActual(int actual){
		this.poderActual = actual;
	}
	
	private int modificarAtaqueSegunPoderEnemigo(int poderAtacante, int poderAtacado){
		if (poderAtacado > poderAtacante){
			return (int)(poderAtacante*StatsJuego.factorReduccionAtaquePorMayorPoderDePeleaEnemigo);
		}		
		return poderAtacante;
	}
	

}
