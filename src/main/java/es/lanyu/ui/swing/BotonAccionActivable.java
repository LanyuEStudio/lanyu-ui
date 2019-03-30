package es.lanyu.ui.swing;

@SuppressWarnings("serial")
public class BotonAccionActivable extends BotonAccion implements Activable {
	Object objetoReceptorAccion;
	
	@Override
	public Object getObjetoReceptor(){
		return objetoReceptorAccion;
	}
	
	public BotonAccionActivable(String texto, String comando) {
		this(texto, comando, null);
	}
	
	public BotonAccionActivable(String texto, String comando, Object objetoReceptorAccion) {
		super(texto, comando);
		this.objetoReceptorAccion = objetoReceptorAccion;
		setActivable(false);
	}

	@Override
	public void activar() {}

	@Override
	public void desactivar() {}

}
