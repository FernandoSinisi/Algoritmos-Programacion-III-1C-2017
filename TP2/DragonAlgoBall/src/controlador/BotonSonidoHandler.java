package controlador;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonSonidoHandler implements EventHandler<ActionEvent>{
	
	private AudioClip musica;
	
	public BotonSonidoHandler(javafx.scene.media.AudioClip musicaDeFondo) {
        this.musica = musicaDeFondo;
	}

	public void handle(ActionEvent event){
        if(musica.isPlaying()){
        	musica.stop();
        }
        else{
        	musica.play();
        }
	}
}
