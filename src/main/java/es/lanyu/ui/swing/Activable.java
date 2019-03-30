package es.lanyu.ui.swing;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public interface Activable {
	final static FocusListener focusListener = new FocusListener() {
		@Override
		public void focusLost(FocusEvent e) {((Activable) e.getSource()).desactivar();}
		
		@Override
		public void focusGained(FocusEvent e) {((Activable) e.getSource()).activar();}
	};
	
	default void setActivable(boolean activable) {
		if(activable)
			addFocusListener(focusListener);
		else
			removeFocusListener(focusListener);
	}
	
	@SuppressWarnings("unchecked")
	default boolean getActivable() {
		boolean activable = false;
		Iterable<FocusListener> it = (Iterable<FocusListener>) getFocusListeners(); 
		for(FocusListener fl : it){
			activable = fl == focusListener;
			if(activable) break;
		}
			
		return activable;
	}
	
	//Metodos necesarios de implementar
	void activar();
	void desactivar();
	
	//Metodos que tienen implementados los Component
	Object getFocusListeners();
	void removeFocusListener(FocusListener focuslistener);
	void addFocusListener(FocusListener focuslistener);

}
