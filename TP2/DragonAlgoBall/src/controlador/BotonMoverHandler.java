package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;
import Juego.DragonAlgoBall;

public class BotonMoverHandler implements EventHandler<ActionEvent> {
	
	private Turno turno;
	private ContenedorPrincipal contenedor;
	private DragonAlgoBall juego;

	
	public BotonMoverHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
		this.juego = juego;
		this.turno = this.juego.getTurnoActual();
		
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	
        	turno.Mover();
        	this.contenedor.setBotoneraMovimiento(false);
        	this.contenedor.setContenedorIzquierda(true);
        	this.contenedor.setOnKeyPressed(new TerminarMovimientoHandler(this.juego,this.contenedor));
        	this.contenedor.obtenerBotones().get("botonMover").setDisable(true);

    		Label etiqueta = new Label();
    		etiqueta.setText("Se selecciono la opcion mover restan " + turno.getCantidadDePasosRestantesEsteTurno() + " pasos");
            etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
            etiqueta.setTextFill(Color.WHITE); 
            this.contenedor.actualizarConsola(etiqueta);
        	
    }
}
