package vista.tablas;

import controlador.tda.lista.ListaEnlazada;
import modelo.Automovil;

import javax.swing.table.AbstractTableModel;

public class TablaVehiculos  extends AbstractTableModel {

        private String[] columnas = {"ID", "Placa", "Marca", "Modelo", "Año", "Tipo_Combustible", "Tipo_Vehiculo"};
        ListaEnlazada<Automovil> listaVehiculos;

        public TablaVehiculos() {

        }

        public TablaVehiculos(ListaEnlazada<Automovil> listaVehiculos) {
            this.listaVehiculos = listaVehiculos;
        }

        @Override
        public int getColumnCount() {
            return columnas.length;
        }

        @Override
        public int getRowCount() {
            return listaVehiculos.getSize();
        }

        @Override
        public String getColumnName(int columna) {
            return columnas[columna];
        }

        @Override
        public Object getValueAt(int fila, int columna) {
            Automovil vehiculo;
            try{
                vehiculo = listaVehiculos.obtenerDato(fila);
            }catch (Exception e){
                return null;
            }
            switch (columna) {
                /*case 0:
                    return vehiculo.getId();
                case 1:
                    return vehiculo.getPlaca();
                case 2:
                    return vehiculo.getMarca();
                case 3:
                    return vehiculo.getModelo();
                case 4:
                    return vehiculo.getAnio();
                case 5:
                    return vehiculo.getTipoCombustible();
                case 6:
                    return vehiculo.getTipoVehiculo();*/
                default:
                    return null;
            }
        }
}
