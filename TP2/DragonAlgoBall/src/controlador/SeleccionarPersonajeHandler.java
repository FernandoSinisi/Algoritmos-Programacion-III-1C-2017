
package controlador;

import Juego.DragonAlgoBall;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Posicion;
import vista.*;
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.PosicionInvalida;
import modelo.turnos.Turno;

public class SeleccionarPersonajeHandler implements EventHandler<MouseEvent> {
	
	private Turno turno;
	private CanvasTablero canvas;
	private ContenedorPrincipal contenedor;
	private DragonAlgoBall juego;
	
	public SeleccionarPersonajeHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
		this.juego = juego;
		this.contenedor = contenedor;
		this.canvas = this.contenedor.getTablero();
    	this.turno = this.juego.getTurnoActual();
    	

    }
    
    @Override
    public void handle(MouseEvent t) {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.setLineWidth(5);;
		context.setStroke(Color.RED);
		try {
			int coorX = ((int)(t.getX()/ValoresGraficos.tamanioCasillero))+1; 
			int coorY = Math.abs(((int)(t.getY()/ValoresGraficos.tamanioCasillero))-10);	
		    turno.seleccionarPersonaje(new Posicion(coorX,coorY));
		    canvas.dibujarTablero();
			context.strokeRect(((int)(t.getX()/ValoresGraficos.tamanioCasillero))*ValoresGraficos.tamanioCasillero, ((int)(t.getY()/ValoresGraficos.tamanioCasillero))*ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
			this.contenedor.actualizarBotones(turno);
	   		Label etiqueta = new Label();
    		etiqueta.setText(turno.getPersonajeSeleccionado().getNombre() + " seleccinado");
            etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
            etiqueta.setTextFill(Color.WHITE); 
            this.contenedor.actualizarConsola(etiqueta);
 
		}
		catch (PosicionInvalida  e) {
			Label etiqueta = new Label();
    		etiqueta.setText("Seleccione una posicion de tu equipo");
            etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
            etiqueta.setTextFill(Color.WHITE); 
            this.contenedor.actualizarConsola(etiqueta);
		}
		catch(CasilleroVacio e){
			Label etiqueta = new Label();
    		etiqueta.setText("Seleccione una posicion de tu equipo");
            etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
            etiqueta.setTextFill(Color.WHITE); 
            this.contenedor.actualizarConsola(etiqueta);
		}
		

	}
	

}
