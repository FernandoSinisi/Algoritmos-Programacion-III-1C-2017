package controlador;

import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Personaje;
import modelo.excepciones.MovimientoInvalido;
import modelo.excepciones.PasosInsuficientes;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;

public class BotonMoverAbajoIzquierdaHandler implements EventHandler<ActionEvent> {

	DragonAlgoBall juego;
	ContenedorPrincipal contenedor;
	Turno turno;
	
	public BotonMoverAbajoIzquierdaHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor){
		
		this.juego = juego;
		this.turno = juego.getTurnoActual();
		this.contenedor = contenedor;
	}
    @Override
    public void handle(ActionEvent actionEvent) {
       
        Personaje aMover = turno.getPersonajeMovil();
        try {
            aMover.MoverPersonajeHaciaAbajoIzquierda();
       		Label etiqueta = new Label();
    		etiqueta.setText("Quedan " + turno.getCantidadDePasosRestantesEsteTurno() +" pasos a moverse ");
            etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
            etiqueta.setTextFill(Color.WHITE); 
            this.contenedor.actualizarConsola(etiqueta);
 
        }			
        catch (PasosInsuficientes p) {
    		contenedor.setBotoneraMovimiento(true);
    		contenedor.setContenedorIzquierda(true);
    		contenedor.actualizarBotones(turno);
    		Label etiqueta = new Label();
    		etiqueta.setText("Ya no tienes pasos para moverte");
            etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
            etiqueta.setTextFill(Color.WHITE); 
            this.contenedor.actualizarConsola(etiqueta);
			if(turno.verificarAccionesTurno()){
				
        		contenedor.cambioDeTurno();
        	}
    	}
    	catch (MovimientoInvalido p) {
    		Label etiqueta = new Label();
    		etiqueta.setText("Movimiento invalido");
    		etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
    		etiqueta.setTextFill(Color.WHITE); 
    		this.contenedor.actualizarConsola(etiqueta);
    	}
    	contenedor.dibujarTablero();
    }
}
