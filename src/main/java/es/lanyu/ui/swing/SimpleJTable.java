package es.lanyu.ui.swing;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.function.Function;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class SimpleJTable<T> extends JTable {

    private List<T> elementos;
    
    @SafeVarargs
	public SimpleJTable(List<T> elementos, String[] nombreColumna, Function<T, Object>... mapeos) {
        super();
        this.elementos = elementos;
        
        if(nombreColumna.length < mapeos.length) {
            throw new IllegalArgumentException("Debe haber al menos tantos nombre de columnas como mapeos");
        }

        AbstractTableModel modelo = new AbstractTableModel() {  
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return mapeos[columnIndex].apply(elementos.get(rowIndex)).toString();
            }
            
            @Override
            public int getRowCount() {
                return elementos.size();
            }
            
            @Override
            public int getColumnCount() {
                return mapeos.length;
            }

            @Override
            public String getColumnName(int column) {
                return nombreColumna[column];
            }

            // Como todas devuleven String sobreescribo este metodo
            @Override
            public Class<?> getColumnClass(int arg0) {
                return String.class;
            }
            
        };
        
        setModel(modelo);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Elimino el borde de la celda seleccionada
        setDefaultRenderer(String.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                return super.getTableCellRendererComponent(table, value, isSelected, false, row, column);
            }
        });
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_DELETE)
                    borrarElemento(getSeleccionado());
                
                ((JTable)e.getSource()).repaint();
            }        
        });
    }
    
    public T getSeleccionado() {
        return elementos.get(getSelectedRow());
    }
    
    private void borrarElemento(T elemento) {
        elementos.remove(elemento);
        System.out.println(elemento + " borrado, quedan " + elementos.size());
    }
    
    /**Establece los anchos de columna preferidos. Un valor negativo no establece ninguno.
     * En caso de haber exceso de ancho se usan los primeros hasta completar.
     * @param anchos array de anchos preferidos por orden de columnas
     */
    public void setAnchosPreferidos(int... anchos) {
        int numeroAnchos = Math.min(anchos.length, getColumnCount());
        for(int i = 0; i < numeroAnchos; i++) {
            if(anchos[i] >= 0) {
                getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
        }
    }
    
}
