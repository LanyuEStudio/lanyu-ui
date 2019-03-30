package es.lanyu.ui.swing.render;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.swing.JTable;

public class CondicionalCustomRenderer<T> extends CustomRenderer<T> {
	private Predicate<T> condicion;
	private Color cumpleCondicion;
	
	private void setCondicion(Predicate<T> condicion, Color cumpleCondicion){
		this.condicion = condicion;
		this.cumpleCondicion = cumpleCondicion;
	}
	
	public CondicionalCustomRenderer(Function<T, String> funcion, boolean opaco, Color seleccionado, Font fuente, Predicate<T> condicion, Color cumpleCondicion) {
		super(funcion, opaco, seleccionado, fuente);
		setCondicion(condicion, cumpleCondicion);
	}
	
	public CondicionalCustomRenderer(Function<T, String> funcion, Predicate<T> condicion, Color cumpleCondicion) {
		super(funcion);
		setCondicion(condicion, cumpleCondicion);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		Component etiqueta = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		// Si cumple la condicion colorea adecuadamente el fondo
		if(condicion.test((T) value))
			etiqueta.setBackground(cumpleCondicion);
		
		return etiqueta;
	}
}
