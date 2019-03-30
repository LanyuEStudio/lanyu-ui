package es.lanyu.ui.swing.listener;

import java.util.EventObject;

@SuppressWarnings("serial")
public class AtributoCambiaEvent extends EventObject {
	int id;
	
	public int getId() {
		return id;
	}
	
	public AtributoCambiaEvent(Object fuente, int id) {
		super(fuente);
		this.id = id;
	}

}
