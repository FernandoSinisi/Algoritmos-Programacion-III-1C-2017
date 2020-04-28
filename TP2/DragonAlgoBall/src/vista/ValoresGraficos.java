package vista;

import java.util.Hashtable;

import javafx.scene.image.Image;

public class ValoresGraficos {
	
	public static final int tamanioTablero = 400;
	public static final int ladoCasillero = 10;
	public static final int tamanioCasillero = (int) tamanioTablero/ladoCasillero;


	public static Hashtable<String,Image> imagenes = obtenerImagenes();
	public static final Hashtable<String,Image> imagenesPersonajesChibi = obtenerImagenesChibi();
	public static final int tamanioFlecha = 50;

	
	private static final int tamanioChibiAncho=50;
	private static final int tamanioChibiAlto=65;
	
	
	private static Hashtable<String,Image> obtenerImagenes(){
		Hashtable<String,Image> imagenes = new Hashtable<String,Image>();
		Image imagenGoku = new Image("file:src/vista/Imagenes/goku.png");
		Image imagenGohan = new Image("file:src/vista/Imagenes/Gohan.png");
		Image imagenPicolo = new Image("file:src/vista/Imagenes/Picolo.png");
		Image imagenFreezer = new Image("file:src/vista/Imagenes/Freezer.png");
		Image imagenCell = new Image("file:src/vista/Imagenes/Cell.png");
		Image imagenMajinBoo = new Image("file:src/vista/Imagenes/MajinBooNormal.png");
		Image imagenEsferaDelDragon = new Image("file:src/vista/Imagenes/EsferaDelDragon.png");
		Image imagenSemillaDelErmitanio = new Image("file:src/vista/Imagenes/SemillaDelErmitanio.png");
		Image imagenNubeVoladora = new Image("file:src/vista/Imagenes/NubeVoladora.png");
		
		imagenes.put("Semilla del ermitanio", imagenSemillaDelErmitanio);
		imagenes.put("Esfera del dragon", imagenEsferaDelDragon);
		imagenes.put("Nube voladora", imagenNubeVoladora);
		imagenes.put("Goku", imagenGoku);
		imagenes.put("Gohan", imagenGohan);
		imagenes.put("Picolo", imagenPicolo);
		imagenes.put("Freezer", imagenFreezer);
		imagenes.put("MajinBoo", imagenMajinBoo);
		imagenes.put("Cell", imagenCell);
		return imagenes;
	}
	
	
	private static Hashtable<String,Image> obtenerImagenesChibi(){
		Hashtable<String,Image> imagenesPersonajes = new Hashtable<String,Image>();
		Image imagenGoku = new Image("file:src/vista/Imagenes/chibiGoku.png",tamanioChibiAncho,tamanioChibiAlto,false,false);
		Image imagenGohan = new Image("file:src/vista/Imagenes/chibiGohan.png",tamanioChibiAncho,tamanioChibiAlto,false,false);
		Image imagenPicolo = new Image("file:src/vista/Imagenes/chibiPicolo.png",tamanioChibiAncho,tamanioChibiAlto,false,false);
		Image imagenFreezer = new Image("file:src/vista/Imagenes/chibiFreezer.png",tamanioChibiAncho,tamanioChibiAlto,false,false);
		Image imagenCell = new Image("file:src/vista/Imagenes/chibiCell.png",tamanioChibiAncho,tamanioChibiAlto,false,false);
		Image imagenMajinBoo = new Image("file:src/vista/Imagenes/chibiMajinBoo.png",tamanioChibiAncho,tamanioChibiAlto,false,false);
		
		imagenesPersonajes.put("Goku", imagenGoku);
		imagenesPersonajes.put("Gohan", imagenGohan);
		imagenesPersonajes.put("Picolo", imagenPicolo);
		imagenesPersonajes.put("Freezer", imagenFreezer);
		imagenesPersonajes.put("MajinBoo", imagenMajinBoo);
		imagenesPersonajes.put("Cell", imagenCell);
		return imagenesPersonajes;
	}
	
	
	
	
	


	
}
