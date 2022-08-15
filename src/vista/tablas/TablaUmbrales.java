package vista.tablas;

import controlador.tda.lista.ListaEnlazada;
import modelo.Umbral;

import javax.swing.table.AbstractTableModel;
import modelo.RangoAnio;

public class TablaUmbrales extends AbstractTableModel {
    private ListaEnlazada<Umbral> listaUmbrales;
    ListaEnlazada<String> operacion = new ListaEnlazada();
    
    public TablaUmbrales(ListaEnlazada<Umbral> listaUmbrales, ListaEnlazada<String> operacion){
        this.listaUmbrales = listaUmbrales;
        this.operacion = operacion;
    }

    @Override
    public int getRowCount() {
        return listaUmbrales.getSize();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Descripcion";
            case 1:
                return "Categoria";
            case 2:
                return "Id año";
            case 3:
                return "Tipo";
            case 4:
                return "Valor minimo";
            case 5:
                return "Valor maximo";
            case 6:
                return "Clave del umbral";
            case 7:
                return "Operación";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Umbral umbral;
        RangoAnio rangoAnio = new RangoAnio(0, 9999);
        try{
            umbral = listaUmbrales.obtenerDato(fila);
            //rangoAnio = ControladorAnio.obtenerRango(umbral.getID_RangoAnio());
        }catch (Exception e){
            return null;
        }
        switch (columna) {
            case 0:
                return umbral.getDescripcion();
            case 1:
                return umbral.getCategoria();
            case 2:
                return umbral.getID_RangoAnio();
            case 3:
                return umbral.getTipo();
            case 4:
                return umbral.getValorMin();
            case 5:
                return umbral.getValorMax();
            case 6:
                return umbral.getClave_Umbral();
            case 7:
                try {
                return operacion.obtenerDato(fila);
            } catch (Exception e) {
                    System.out.println(e);
            }
            default:
                return null;
        }
    }
}
