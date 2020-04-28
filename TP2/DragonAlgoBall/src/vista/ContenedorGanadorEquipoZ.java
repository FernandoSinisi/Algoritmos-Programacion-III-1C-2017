package vista;

import Juego.DragonAlgoBall;
import controlador.BotonIniciarJuegoHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class ContenedorGanadorEquipoZ extends BorderPane {

	
	public ContenedorGanadorEquipoZ(Stage stage){
        stage.setFullScreen(true);
        stage.setMaximized(true);
        this.setPadding(new Insets(40));
        Image imagen = new Image("file:src/vista/Imagenes/GanadorEquipoZ.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        AudioClip musicaDeFondo = new AudioClip("file:src/vista/Sonidos/AngelesFuimos.mp3");
        musicaDeFondo.play();
        DragonAlgoBall juego = new DragonAlgoBall();
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego);
        Scene escenaJuego = new Scene(contenedorPrincipal);
        BotonIniciarJuegoHandler botoniniciarjuegohandler = new BotonIniciarJuegoHandler(stage,escenaJuego,musicaDeFondo);
        Button botonReIniciarJuego = new Button();
        botonReIniciarJuego.setText("GANADOR EQUIPO GUERREROS Z \n Reiniciar Juego");
        botonReIniciarJuego.setOnAction(botoniniciarjuegohandler);
        this.setCenter(botonReIniciarJuego);
		
	}
}
