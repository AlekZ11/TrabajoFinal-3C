
package vista.tablas;

import controlador.tda.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.RangoAnio;

/**
 *
 * @author patob
 */
public class TablaAnios extends AbstractTableModel{
    private String[] columnas = {"Id","Año mínimo","Año máximo"};
        ListaEnlazada<RangoAnio> listaAnios;

        public TablaAnios() {

        }

        public TablaAnios(ListaEnlazada<RangoAnio> listaAnios) {
            this.listaAnios = listaAnios;
        }

        @Override
        public int getColumnCount() {
            return columnas.length;
        }

        @Override
        public int getRowCount() {
            return listaAnios.getSize();
        }

        @Override
        public String getColumnName(int columna) {
            return columnas[columna];
        }

        @Override
        public Object getValueAt(int fila, int columna) {
            RangoAnio anio;
            try{
                anio = listaAnios.obtenerDato(fila);
            }catch (Exception e){
                return null;
            }
            switch (columna) {
                case 0:
                    return anio.getID_RangoAnio();
                case 1:
                    return anio.getAnioMin();
                case 2:
                    return anio.getAnioMax();
                case 3:
                    //return anio.getCreated_At();
                case 4:
                    //return anio.getUpdated_At();
                default:
                    return null;
            }
        }
}
