package controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.turnos.Turno;
import vista.CanvasTablero;
import vista.ContenedorPrincipal;
import Juego.*;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {
	
	DragonAlgoBall juego;
	CanvasTablero canvasTablero;
	Turno turno;
	ContenedorPrincipal contenedor;
	

    public BotonAtacarHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
    	this.juego = juego;
    	this.contenedor = contenedor;
    	this.turno = juego.getTurnoActual();
    	this.canvasTablero = contenedor.getTablero();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	turno.atacar();
    	contenedor.setBotoneraMovimiento(true);
    	contenedor.setContenedorIzquierda(true);
    	contenedor.obtenerBotones().get("botonMover").setDisable(true);
    	this.canvasTablero.setOnMousePressed(new SeleccionarEnemigoHandler(this.juego,this.contenedor));

		Label etiqueta = new Label();
		etiqueta.setText("Se selecciono la opcion de atacar");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE); 
        this.contenedor.actualizarConsola(etiqueta);
    }


}
