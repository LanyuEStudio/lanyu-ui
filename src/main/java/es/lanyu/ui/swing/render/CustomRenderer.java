package es.lanyu.ui.swing.render;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.function.Function;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CustomRenderer <T> implements TableCellRenderer {
	
	private final Function<T, String> funcion;
	private boolean opaco;
	private Color seleccionado;
	private Font fuente;
	
	public CustomRenderer(Function<T, String> funcion, boolean opaco, Color seleccionado, Font fuente) {
		super();
		this.funcion = funcion;
		this.opaco = opaco;
		this.seleccionado = seleccionado;
		this.fuente = fuente;
	}
	
	public CustomRenderer(Function<T, String> funcion) {
		this(funcion, true, Color.GREEN, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {

		JLabel etiqueta = new JLabel(funcion.apply((T)value));
		etiqueta.setOpaque(opaco);
		if(isSelected) etiqueta.setBackground(seleccionado);		
		if(fuente != null) etiqueta.setFont(fuente);
		
		return etiqueta;
	}

}
