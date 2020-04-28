package controlador;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class BotonSalirHandler implements EventHandler<ActionEvent>{
    
	@Override
	public void handle(ActionEvent windowEvent) {
		 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		 alert.setTitle("Confirmacion salida");
		 alert.setHeaderText("SALIDA");
		 alert.setContentText("Seguro desea abandonar el juego");
		 Optional<ButtonType> resultado = alert.showAndWait();
		 if (resultado.get() == ButtonType.CANCEL){
			 windowEvent.consume();
		 }
		 else{
			 System.exit(0);
		 }
    }

}
