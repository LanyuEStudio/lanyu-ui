package es.lanyu.ui.swing.listener;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ArrastradorListener extends MouseAdapter {
    private final Point puntoOrigen = new Point();
    private boolean arrastrando;//Ayuda a seguir arrastrando en movimientos rapidos
    private Component componenteMoviendose;
    
    public Component getComponenteMoviendose() {
		return componenteMoviendose;
	}
    
	public void mouseDragged(final MouseEvent e) {
		if(arrastrando){
			Component c = (Component) e.getSource();
			c.setLocation(c.getX() + e.getX() - puntoOrigen.x, c.getY() + e.getY() - puntoOrigen.y);
		}
    }

    public void mousePressed(MouseEvent e) {
    	componenteMoviendose = e.getComponent();
        puntoOrigen.setLocation(e.getPoint());
        
		arrastrando = (e.getSource() instanceof Delimitable)
				?((Delimitable)e.getSource()).dentroDeLimites()
				:true;
    }

    public void mouseReleased(MouseEvent e) {
    	componenteMoviendose = null;
		arrastrando = false;
    }
    



}
