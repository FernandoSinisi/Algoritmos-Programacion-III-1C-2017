package vista;



import controlador.BotonSalirHandler;
import controlador.BotonIniciarJuegoHandler;
import controlador.BotonSonidoHandler;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class ContenedorBienvenidos extends BorderPane{
	
	Stage stage;

	public ContenedorBienvenidos (Stage stage, AudioClip musicaDeFondo, Scene escenaJuego) {
		super();
        this.stage = stage;
        this.setPadding(new Insets(40));
        Image imagen = new Image("file:src/vista/Imagenes/MainFondo.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        Image jugarSinPulsar  = new Image("file:src/vista/Imagenes/play-encima.png");
        Image jugarPulsado  = new Image("file:src/vista/Imagenes/play-normal.png");
        Image salirSinPulsar  = new Image("file:src/vista/Imagenes/salir-encima.png");
        Image salirPulsado  = new Image("file:src/vista/Imagenes/salir-normal.png");
        Image conSonido  = new Image("file:src/vista/Imagenes/ConSonido.png");
        Image sinSonido  = new Image("file:src/vista/Imagenes/SinSonido.png");
        Button botonIniciarJuego = new Button();
        Button botonSalirJuego = new Button();
        ToggleButton botonSonido = new ToggleButton();
        ImageView imagen2 = new ImageView();
        botonSonido.setGraphic(imagen2);
        imagen2.imageProperty().bind(Bindings.when(botonSonido.selectedProperty())
            .then(sinSonido)
            .otherwise(conSonido)
        );
        botonIniciarJuego.setGraphic(new ImageView(jugarPulsado));
        botonSalirJuego.setGraphic(new ImageView(salirPulsado));
        botonIniciarJuego.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        botonSalirJuego.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        botonSonido.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");

        
        botonIniciarJuego.addEventHandler(MouseEvent.MOUSE_ENTERED,new EventHandler<MouseEvent>() {
        	        @Override public void handle(MouseEvent e) {
        	        	botonIniciarJuego.setGraphic(new ImageView(jugarSinPulsar)); }});
        
        
        botonIniciarJuego.addEventHandler(MouseEvent.MOUSE_EXITED,new EventHandler<MouseEvent>() {
        	        @Override public void handle(MouseEvent e) {
        	        	botonIniciarJuego.setGraphic(new ImageView(jugarPulsado));}});
        
        
        botonSalirJuego.addEventHandler(MouseEvent.MOUSE_ENTERED,new EventHandler<MouseEvent>() {
	        @Override public void handle(MouseEvent e) {
	        	botonSalirJuego.setGraphic(new ImageView(salirSinPulsar)); }});
        
        botonSalirJuego.addEventHandler(MouseEvent.MOUSE_EXITED,new EventHandler<MouseEvent>() {
	        @Override public void handle(MouseEvent e) {
	        	botonSalirJuego.setGraphic(new ImageView(salirPulsado));}});
        
        
        BotonIniciarJuegoHandler botoniniciarjuegohandler = new BotonIniciarJuegoHandler(stage,escenaJuego,musicaDeFondo);
        BotonSalirHandler botonsalirjuegohandler = new BotonSalirHandler();
        BotonSonidoHandler botonsonidohandler = new BotonSonidoHandler(musicaDeFondo);
        botonIniciarJuego.setOnAction(botoniniciarjuegohandler);
        botonSalirJuego.setOnAction(botonsalirjuegohandler);
        botonSonido.setOnAction(botonsonidohandler);
        VBox contenedorVertical = new VBox(botonIniciarJuego, botonSalirJuego);
        VBox contenedorVertical2 = new VBox(botonSonido);
        contenedorVertical.setSpacing(15);
        contenedorVertical.setAlignment(Pos.CENTER_LEFT);
        contenedorVertical2.setAlignment(Pos.TOP_RIGHT);
        this.setLeft(contenedorVertical);
        this.setRight(contenedorVertical2);
	}
}
