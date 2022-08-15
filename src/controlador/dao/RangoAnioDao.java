package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.Utilidades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.util.Date;
import modelo.RangoAnio;

/**
 *
 * @author patob
 */
public class RangoAnioDao extends AdaptadorDao<RangoAnio> {

    RangoAnio rangoAnio;

    public RangoAnioDao(RangoAnio rangoAnio) {
        super(RangoAnio.class);
        this.rangoAnio = rangoAnio;
    }

    public RangoAnio getRangoAnio() {
        return rangoAnio;
    }

    public void setRangoValores(RangoAnio rangoAnio) {
        this.rangoAnio = rangoAnio;
    }

    public RangoAnioDao() {
        super(RangoAnio.class);
    }

    public ListaEnlazada<RangoAnio> consultarAnios() {
        ListaEnlazada<RangoAnio> lista = new ListaEnlazada<>();
        try {
            PreparedStatement stmt;
            stmt = getConexion().prepareStatement("Select * from Rangoanio");
            System.out.println("Comando : Select * from Rangoanio");

            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            String[] columna = new String[resultSetMetaData.getColumnCount()];
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                columna[i] = resultSetMetaData.getColumnLabel(i + 1);
            }
            while (resultSet.next()) {
                RangoAnio anio = new RangoAnio();
                for (int i = 0; i < columna.length; i++) {
                    Object objeto = resultSet.getObject(i + 1);
                    if (objeto != null && objeto.getClass().getName().equals("java.sql.Timestamp")) {
                        Timestamp aux = (Timestamp) objeto;
                        Date fecha = new Date(aux.getTime());
                        Utilidades.cambiarDatos(fecha, columna[i], anio);
                    } else {
                        Utilidades.cambiarDatos(objeto, columna[i], anio);
                    }
                }
                System.out.print(anio.toString());
                lista.insertarCabecera(anio);
            }
            System.out.println("");

        } catch (Exception e) {
            System.out.println("Error al cargar " + e);
            e.printStackTrace();
        }
        return lista;
    }

    public void ejecutarSentencias(String sentencia) {
        try {
            PreparedStatement stmt;
            System.out.println(sentencia);
            stmt = getConexion().prepareStatement(sentencia);

            stmt.executeQuery();

        } catch (Exception e) {
            System.out.println("Error al cargar " + e);
            e.printStackTrace();
        }
    }
}
