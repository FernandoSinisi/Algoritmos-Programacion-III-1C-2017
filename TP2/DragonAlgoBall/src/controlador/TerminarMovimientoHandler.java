package controlador;

import Juego.DragonAlgoBall;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;


public class TerminarMovimientoHandler implements EventHandler<KeyEvent> {
	
	private DragonAlgoBall juego;
	private ContenedorPrincipal contenedor;
	private Turno turno;

    public TerminarMovimientoHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
    	
    	this.contenedor = contenedor;
    	this.juego = juego;
    	this.turno = this.juego.getTurnoActual();
       
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
        	contenedor.setBotoneraMovimiento(true);
    		contenedor.setContenedorIzquierda(true);
    		contenedor.actualizarBotones(turno);
    		this.contenedor.dibujarTablero();
    		Label etiqueta = new Label();
    		etiqueta.setText("Termino Movimiento");
            etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
            etiqueta.setTextFill(Color.WHITE); 
            this.contenedor.actualizarConsola(etiqueta);
    		this.contenedor.setOnKeyPressed(null);
			if(turno.verificarAccionesTurno()){
        		contenedor.cambioDeTurno();
        	}
        }
    }

}
