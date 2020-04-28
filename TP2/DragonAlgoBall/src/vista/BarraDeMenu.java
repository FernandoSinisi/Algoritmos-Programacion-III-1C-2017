package vista;

import controlador.BotonSalirHandler;
import controlador.OpcionComoJugarEventHandler;
import controlador.OpcionPantallaCompletaEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Stage stage) {

        Menu menuOpciones = new Menu("Opciones");
        Menu menuAyuda = new Menu("Ayuda");
        Menu menuSalir = new Menu("Salir");
        
        MenuItem opcionComoJuego = new MenuItem("Como juego");
        MenuItem opcionSalir = new MenuItem("Salir del juego");
        
        
        BotonSalirHandler salirHandler = new BotonSalirHandler();
        opcionSalir.setOnAction(salirHandler);
        
        OpcionComoJugarEventHandler opcionComoJuegarHandler = new OpcionComoJugarEventHandler();
        opcionComoJuego.setOnAction(opcionComoJuegarHandler);
        
        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        
        opcionPantallaCompleta.setDisable(true);
        
        //Agregar opciones de sonido activado y desactivado.
        
        menuOpciones.getItems().addAll(opcionPantallaCompleta);
        menuAyuda.getItems().addAll(opcionComoJuego);
        menuSalir.getItems().addAll(opcionSalir);
        
        this.getMenus().addAll(menuOpciones, menuAyuda, menuSalir);

    	}
    	
    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }
}
