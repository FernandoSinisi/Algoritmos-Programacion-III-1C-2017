package vista;

import java.util.Hashtable;
import Juego.DragonAlgoBall;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import modelo.ObjetoJuego;
import modelo.Posicion;
import modelo.Tablero;
import modelo.turnos.Turno;

public class CanvasTablero extends Canvas{
	DragonAlgoBall juego;
	GraphicsContext context;
	Turno turno;

	public CanvasTablero(DragonAlgoBall juego){
		this.juego = juego;
		this.setWidth(ValoresGraficos.tamanioTablero);
		this.setHeight(ValoresGraficos.tamanioTablero);
		this.context = this.getGraphicsContext2D();
		this.turno = juego.getTurnoActual();
	}
	
	private void limpiar(){
    	Image casillero = new Image("file:src/vista/Imagenes/casilleroVacio.jpg");  
    	for(int i=0 ; i< ValoresGraficos.ladoCasillero ;i++){
    		for(int j=0 ;j<ValoresGraficos.ladoCasillero;j++){
    			context.drawImage(casillero, ValoresGraficos.tamanioCasillero*i, ValoresGraficos.tamanioCasillero*j, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
    		}
    	}
    }
    
    
     private int coordenadaTableroX(int posX){
    	return ((posX -1)*ValoresGraficos.tamanioCasillero);
    }
    
     private int coordenadaTableroY(int posY){
    	return Math.abs((posY -10)*ValoresGraficos.tamanioCasillero);
    }
    
    public void dibujarTablero(){
    	limpiar();
    	Hashtable<String,Image> imagenes = ValoresGraficos.imagenes;
    	Tablero tablero = turno.obtenerTablero();
    	for(Posicion pos: tablero.obtenerPosiciones()){
    		ObjetoJuego objeto = tablero.obtenerObjeto(pos);
    		int coorX = coordenadaTableroX(pos.getCoordenadaX());
    		int coorY = coordenadaTableroY(pos.getCoordenadaY());
    		context.drawImage(imagenes.get(objeto.getNombre()), coorX, coorY, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
    	}
    }
    
    

}
