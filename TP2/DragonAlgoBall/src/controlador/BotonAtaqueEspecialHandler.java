package controlador;

import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Personaje;
import modelo.excepciones.AtaqueInvalido;
import modelo.excepciones.KiInsuficiente;
import modelo.turnos.Turno;
import vista.CanvasTablero;
import vista.ContenedorPrincipal;

public class BotonAtaqueEspecialHandler implements EventHandler<ActionEvent> {

	private Turno turno;
	private ContenedorPrincipal contenedor;
	private final DragonAlgoBall juego;
	private CanvasTablero canvasTablero;
	private Personaje atacante;
	private Personaje enemigo;
	

    public BotonAtaqueEspecialHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
    	this.juego = juego;
    	this.contenedor =contenedor;
    	this.canvasTablero = contenedor.getTablero();
    	this.turno = juego.getTurnoActual();
    	
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	
    	this.atacante = this.turno.getPersonajeatacante();
    	this.enemigo = this.turno.getPersonajeAtacado();
    	try{
    		this.atacante.ataqueEspecial(enemigo);
    		this.contenedor.dibujarTablero();
        	if(turno.verificarAccionesTurno()){
        		this.contenedor.cambioDeTurno();
        		return;
        	}
        	this.canvasTablero.setOnMousePressed(new SeleccionarPersonajeHandler(this.juego,this.contenedor));
        	this.contenedor.setBotoneraMovimiento(true);
        	this.contenedor.setContenedorIzquierda(true);
        	this.contenedor.actualizarBotones(turno);

    		Label etiqueta = new Label();
    		etiqueta.setText("Ataque realizado con exito");
            etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
            etiqueta.setTextFill(Color.WHITE); 
            this.contenedor.actualizarConsola(etiqueta);
        }
    	catch(AtaqueInvalido p){
    		if(turno.verificarAccionesTurno()){
        		this.contenedor.cambioDeTurno();
        		
        	}
    		
    		Label etiqueta = new Label();
    		etiqueta.setText("Ataque invalido: Enemigo fuera del alcance");
            etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
            etiqueta.setTextFill(Color.WHITE); 
            this.contenedor.actualizarConsola(etiqueta);
			
    	}
    	catch(KiInsuficiente p){
    		
			if(turno.verificarAccionesTurno()){
        		this.contenedor.cambioDeTurno();
        		
			}
			
			Label etiqueta = new Label();
    		etiqueta.setText("Ataque invalido: No tienes suficiente ki para ataque");
            etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
            etiqueta.setTextFill(Color.WHITE); 
            this.contenedor.actualizarConsola(etiqueta);
    		
    	}
    }
    
}
