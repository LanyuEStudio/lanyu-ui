package es.lanyu.ui.swing.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;

public class BuscaArchivoListener implements ActionListener {
	
	JTextComponent controlEnlazado;
	int modo = JFileChooser.FILES_AND_DIRECTORIES;
	String extensionFiltrada = null;
	FileFilter filtro = null;
	boolean aceptadaBusqueda;
	String directorioPorDefecto;
	String rutaElegida;

	public void setControlEnlazado(JTextComponent controlEnlazado) {
		this.controlEnlazado = controlEnlazado;
	}
	
	public String getDirectorioPorDefecto() {
		return directorioPorDefecto;
	}

	public void setDirectorioPorDefecto(String directorioPorDefecto) {
		this.directorioPorDefecto = directorioPorDefecto;
	}

	public String getRutaElegida() {
		return rutaElegida;
	}

	public void modoSoloArchivos() {
		modo = JFileChooser.FILES_ONLY;
	}
	
	public void modoSoloDirectorios() {
		modo = JFileChooser.DIRECTORIES_ONLY;
	}
	
	public void setExtensionFiltrada(String extensionFiltrada, String descripcion) {
		if(extensionFiltrada == null || extensionFiltrada.equals(""))
			filtro = null;
		else {
			this.extensionFiltrada = extensionFiltrada;
			String desc = descripcion;
			if(desc == null)
				desc = "Archivos de tipo (" + extensionFiltrada + ")";
			
			filtro = new FileNameExtensionFilter(desc, extensionFiltrada);
		}
	}
	
	public boolean isAceptadaBusqueda() {
		return aceptadaBusqueda;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ruta;
		if(controlEnlazado != null)
			ruta = controlEnlazado.getText();
		else
			ruta = directorioPorDefecto;
		
		JFileChooser fc = new JFileChooser();
		if(ruta != null)
			fc.setCurrentDirectory(new File(ruta));
		
		fc.setFileSelectionMode(modo);
		if(filtro != null)
			fc.setFileFilter(filtro);
		
        if (fc.showOpenDialog((JComponent)e.getSource()) == JFileChooser.APPROVE_OPTION) {
        	if(filtro != null && !filtro.accept(fc.getSelectedFile())){
        		File seleccionada = new File(fc.getSelectedFile().getAbsolutePath());
        		if(seleccionada.isFile())
        			fc.setSelectedFile(seleccionada);
        		else
        			fc.setSelectedFile(new File(fc.getSelectedFile().getAbsolutePath() + "." + extensionFiltrada));
        	}
        	
            File archivoElegido = fc.getSelectedFile();
            rutaElegida = archivoElegido.getAbsolutePath();
            if(controlEnlazado != null)
            	controlEnlazado.setText(getRutaElegida());
            
            aceptadaBusqueda = true;
        }
        else
			aceptadaBusqueda = false;
	}

}
