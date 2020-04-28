package modelo.personajes;

import modelo.Personaje;

public abstract class EnemigoDeLaTierra extends Personaje {
	
	protected  boolean esGuerreroZ(){return false;};
	protected boolean esEnemigoDeLaTierra(){return true;};
}
