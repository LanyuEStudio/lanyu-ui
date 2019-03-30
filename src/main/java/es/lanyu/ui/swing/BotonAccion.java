package es.lanyu.ui.swing;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BotonAccion extends JButton {
	protected static List<ActionListener> listeners;

	static {
		listeners = new LinkedList<>();
	}
	
	public static List<ActionListener> getListeners() {
		return listeners;
	}
	
	public Object getObjetoReceptor(){
		return null;
	}
	
	public BotonAccion(String texto, String comando) {
		super(texto);
		setActionCommand(comando);
		setFocusPainted(false);
		for(ActionListener al : listeners){
			addActionListener(al);
		}
	}
	
	public static void addListener(ActionListener listener) {
		BotonAccion.listeners.add(listener);
	}
	
	public static void removeListener(ActionListener listener) {
		BotonAccion.listeners.remove(listener);
	}
}
