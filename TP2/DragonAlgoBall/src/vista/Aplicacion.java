package vista;


import controlador.AlertaHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import Juego.DragonAlgoBall;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
    	stage.setTitle("DragonAlgoBall");
        DragonAlgoBall juego = new DragonAlgoBall();
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego);
        Scene escenaJuego = new Scene(contenedorPrincipal);
        AudioClip musicaDeFondo = new AudioClip("file:src/vista/Sonidos/TemaBienvenida.mp3");
        musicaDeFondo.play();
        ContenedorBienvenidos ventanainicial = new ContenedorBienvenidos(stage,musicaDeFondo, escenaJuego);
        Scene escenaBienvenidos = new Scene(ventanainicial,1000,640);
        stage.setScene(escenaBienvenidos);
        stage.setMinHeight(escenaBienvenidos.getHeight());
        stage.setMinWidth(escenaBienvenidos.getWidth());
        stage.setMaxHeight(escenaBienvenidos.getHeight());
        stage.setMaxWidth(escenaBienvenidos.getHeight());
        AlertaHandler alerta = new AlertaHandler();
        stage.setOnCloseRequest(alerta);
        stage.show();
        
            

    }

}

