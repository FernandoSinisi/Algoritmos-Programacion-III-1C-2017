package vista;

import java.util.Hashtable;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Personaje;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BotonInformacionPersonajes implements EventHandler<ActionEvent> {
	
	Personaje personaje;
	Canvas canvas;
	Hashtable<String,Image> imagenesPersonajes = ValoresGraficos.imagenes;
	
	public BotonInformacionPersonajes(Personaje personaje, Canvas canvas){
		this.personaje = personaje;
		this.canvas = canvas;
	}

    @Override
    public void handle(ActionEvent actionEvent) {
    	
    	GraphicsContext context = canvas.getGraphicsContext2D();
    	context.clearRect(0, 0, 220,300);
    	context.drawImage(imagenesPersonajes.get(personaje.getNombre()),10,0,200,200);
    	String textoNombre = "Personaje "+ personaje.getNombre(); 
    	String textoPuntosVida = "Puntos de vida: " + personaje.getPuntosDeVida();
    	String textoVelocidad = "Velocidad: " + personaje.getVelocidad();
    	String textoKi = "Ki: " + personaje.getKi();
    	String textoPoderDePelea = "Poder de pelea: " + personaje.getPoderDePelea();
    	
    	context.setFill(Color.RED);
    	context.setFont(Font.font ("Verdana", FontWeight.BOLD, 13));
    	context.fillText(textoNombre, 10, 220);
    	context.fillText(textoPuntosVida, 10, 235);
    	context.fillText(textoVelocidad, 10, 250);
    	context.fillText(textoKi, 10, 265);
    	context.fillText(textoPoderDePelea, 10, 280);
    	
    	
    }

}
