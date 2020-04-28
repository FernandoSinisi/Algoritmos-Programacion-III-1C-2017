package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class BotonIniciarJuegoHandler implements EventHandler<ActionEvent> {
	
    Stage stage;
    Scene proximaEscena;
    AudioClip musica;

    public BotonIniciarJuegoHandler(Stage stage, Scene proximaEscena, AudioClip musicaDeFondo) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.musica = musicaDeFondo;
        
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	musica.stop();
    	stage.setMaxHeight(Double.MAX_VALUE);
        stage.setMaxWidth(Double.MAX_VALUE);
        stage.close();
        stage.setScene(proximaEscena);
        stage.setFullScreen(false);
        stage.setMaximized(false);
        stage.show();
        
    }
}
	
	
