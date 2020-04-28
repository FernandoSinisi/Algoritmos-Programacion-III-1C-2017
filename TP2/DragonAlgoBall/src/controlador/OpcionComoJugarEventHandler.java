package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionComoJugarEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Como Juego");
        alert.setHeaderText("Explicacion del Juego:");
        String mensaje = "En el juego hay dos equipos. En el extremo inferior del tablero se "
        				+ "encuentra el equipo de los guerrerosZ y en el otro extremo se encuentra "
        				+ "el equipo de los enemigos de la tierra. "
        				+ "Cada jugador en su turno podra realizar una accion de movimiento, una  de "
        				+ "ataque y una transformacion. Se pueden realizar todas con el mismo o con "
        				+ "distintos personajes del equipo. "
        				+ "En lo que respecta a la accion de movimiento uno debera seleccionar con el mouse"
        				+ "que personaje de su equipo desea mover. Luego de esto debera presionar el boton que se"
        				+ "encuentra en el centro de las flechas, para habilitar la accion del movimiento. "
        				+ "Con las flechas indicara en que direccion desea efectuar cada paso. Los pasos son hacia "
        				+ "uno de los casilleros contiguos. "
        				+ "La cantidad de pasos disponibles para moverse dependera de la velocidad de dicho personaje. "
        				+ "La accion de ataque se podra efectuar con un ataque basico o con uno especial. "
        				+ "El ataque basico no cuesta ki. Se puede relizar siempre y cuando el enemigo se encuentre"
        				+ " a una distancia alcanzable por el ataque del personaje. "
        				+ "El ataque especial cuesta ki. Dependiendo del personaje cambia su efecto."
        				+ "Las transformaciones modifican las caracteristicas del personaje. Estas suelen aumentar "
        				+ "la velocidad, el danio del ataque, el alcance del ataque, etc. Estas cuestan ki. En "
        				+ "ocasiones suelen necesitar que el personaje cumpla con cierto objetivo para realizar la "
        				+ "segunda transformacion. Las transformaciones siempre son hacia la fase de evolucion siguiente "
        				+ "de la que uno se encuentra actualmente. "
        				+ "En el tablero apareceran de manera aleatoria consumibles. Al caer uno encima de estos "
        				+ "podra obtener los beneficios que este brinda. Estos son los siguientes: "
        				+ "La semilla del ermitanio regenera cien puntos de vida al que la consuma. "
        				+ "La esfera del dragon por los proximos 2 ataques, los ataques de quien la agarre, "
        				+ "causaran un veinticinco porciento mas de danio. "
        				+ "La nube voladora en los proximos dos turnos, del personaje que la agarre, tendra "
        				+ "el doble de velocidad. "
        				+ "El juego finaliza cuando uno de los dos equipos gana. Hay dos maneras de ganar el juego. "
        				+ "Una de las formas de ganar es se debe destruir a todos los personajes enemigos. "
        				+ "Otra forma es ganar es el equipo capture siete esferas del dragon. ";
        alert.setContentText(mensaje);
        alert.show();
    }

}