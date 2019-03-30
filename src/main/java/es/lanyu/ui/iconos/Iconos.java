package es.lanyu.ui.iconos;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Iconos {
	public static final Image OK, ERROR, WARNING, GUARDAR, ABRIR, NUEVO, OPCIONES, BORRAR, BUSCAR;
	private static int filas = 3;
	private static int columnas = 5;
	private static int numeroIconos = filas*columnas;
	private static String rutaIconos = "/es/lanyu/ui/iconos/Iconos.png";
	
	static {
		BufferedImage aux = null;
		try {
			aux = ImageIO.read(Iconos.class.getResourceAsStream(rutaIconos));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se ha encontrado el archivo de iconos: " + rutaIconos);
		}
		finally{
			if(aux != null){
				int w, h;
				w = aux.getWidth();
				h = aux.getHeight();
				int anchoIcono = w/columnas;
				int altoIcono = h/filas;
				BufferedImage[] iconosSeparados = new BufferedImage[numeroIconos];
				for(int i = 0; i < filas; i++){
					for(int j  = 0; j < columnas; j++){
						iconosSeparados[i*columnas + j] = aux.getSubimage(j*altoIcono, i*anchoIcono, anchoIcono, altoIcono);
					}
				}
				OK = iconosSeparados[0];
				ERROR = iconosSeparados[1];
				WARNING = iconosSeparados[2];
				GUARDAR = iconosSeparados[3];
				ABRIR = iconosSeparados[4];
				NUEVO = iconosSeparados[10];
				OPCIONES = iconosSeparados[8];
				BORRAR = iconosSeparados[7];
				BUSCAR = iconosSeparados[13];
			}
			else
				OK = ERROR =  WARNING = GUARDAR = ABRIR = NUEVO = OPCIONES = BORRAR = BUSCAR = null;
		}
	}
	
	/**
	 * Devuelve un icono de dimensiones tamañoxtamaño con la imagen escogida. Si el fichero de iconos
	 * no pudo ser leido devuelve null.
	 * @param icono
	 * @param tama�o
	 * @return icono de dimensiones tamañoxtamaño con la imagen escogida
	 */
	public static ImageIcon getIcono(Image icono, int tamano) {
		ImageIcon imIc = null;
		if(icono != null)
			imIc = new ImageIcon(icono.getScaledInstance(tamano, tamano, Image.SCALE_DEFAULT));
		
		return imIc;
	}
}
