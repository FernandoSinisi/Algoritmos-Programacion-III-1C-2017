package controlador;


import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Personaje;
import modelo.excepciones.TransformacionInvalida;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;

public class BotonTransformarHandler implements EventHandler<ActionEvent>  {

	    private Turno turno;
	    private ContenedorPrincipal contenedor;

	    public BotonTransformarHandler(DragonAlgoBall juego,ContenedorPrincipal contenedor) {
	    	this.contenedor = contenedor;
	    	this.turno = juego.getTurnoActual();
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	    	
	    	try{
	   	    	turno.elegirPersonajeEvolucionar();
	    	    Personaje personajeEvolucionar =  turno.getPersonajeAEvolucionar();
	    	    personajeEvolucionar.transformar();
	    	    contenedor.actualizarBotones(turno);
	    	    Label etiqueta = new Label();
	    		etiqueta.setText(personajeEvolucionar.getNombre() +" se transformo a su nueva fase checkear stats");
	    		etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
	    		etiqueta.setTextFill(Color.WHITE); 
	    		this.contenedor.actualizarConsola(etiqueta);
	    	}
	    	catch (TransformacionInvalida p){
	    	   contenedor.actualizarBotones(turno);
	    	   Label etiqueta = new Label();
	    	   etiqueta.setText("Transformacion invalida");
	    	   etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
	    	   etiqueta.setTextFill(Color.WHITE); 
	    	   this.contenedor.actualizarConsola(etiqueta);
	       }
	  }
}
