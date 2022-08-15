package vista.tablas;

import controlador.tda.lista.ListaEnlazada;
import modelo.Cliente;

import javax.swing.table.AbstractTableModel;

public class TablaClientes extends AbstractTableModel {

        private String[] columnas = {"ID", "Nombre", "Apellido", "Identificacion", "Provincia", "Ciudad", "Direccion"};
        ListaEnlazada<Cliente> listaClientes;

        public TablaClientes() {

        }

        public TablaClientes(ListaEnlazada<Cliente> listaClientes) {
            this.listaClientes = listaClientes;
        }

        @Override
        public int getColumnCount() {
            return columnas.length;
        }

        @Override
        public int getRowCount() {
            return listaClientes.getSize();
        }

        @Override
        public String getColumnName(int columna) {
            return columnas[columna];
        }

        @Override
        public Object getValueAt(int fila, int columna) {
            Cliente cliente;
            try{
                cliente = listaClientes.obtenerDato(fila);
            }catch (Exception e){
                return null;
            }
            switch (columna) {
                case 0:
                    return cliente.getID_Cliente();
                case 1:
                    return cliente.getNombre();
                case 2:
                    return cliente.getApellido();
                case 3:
                    return cliente.getIdentificacion();
                case 4:
                    //return cliente.getProvincia();
                case 5:
                    //return cliente.getCiudad();
                case 6:
                    //return cliente.getDireccion();
                default:
                    return null;
            }
        }
}
