package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.Utilidades;
import modelo.Umbral;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.util.Date;

public class UmbralDao extends AdaptadorDao<Umbral> {

    private Umbral umbral;

    public Umbral getUmbral() {
        return umbral;
    }

    public void setUmbral(Umbral umbral) {
        this.umbral = umbral;
    }

    public UmbralDao() {
        super(Umbral.class);
    }

    public void guardar() throws Exception {
        super.guardar(umbral);
    }

    public ListaEnlazada<Umbral> buscar(String Descripcion) throws Exception {
        ListaEnlazada<Umbral> lista = new ListaEnlazada<>();
        try {
            PreparedStatement stmt;

            if (Descripcion == null) {
                stmt = getConexion().prepareStatement("Select * from Umbral");
                System.out.println("Comando : Select * from Umbral");
            } else {
                stmt = getConexion().prepareStatement("Select * from Umbral where Descripcion like '%" + Descripcion.toUpperCase() + "%'");
                System.out.println("Comando : " + "Select * from Umbral where Descripcion like '%" + Descripcion.toUpperCase() + "%'");

            }
            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            String[] columna = new String[resultSetMetaData.getColumnCount()];
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                columna[i] = resultSetMetaData.getColumnLabel(i + 1);
            }
            while (resultSet.next()) {
                Umbral umbral = new Umbral();
                for (int i = 0; i < columna.length; i++) {
                    Object objeto = resultSet.getObject(i + 1);
                    if (objeto != null && objeto.getClass().getName().equals("java.sql.Timestamp")) {
                        Timestamp aux = (Timestamp) objeto;
                        Date fecha = new Date(aux.getTime());
                        Utilidades.cambiarDatos(fecha, columna[i], umbral);
                    } else {
                        Utilidades.cambiarDatos(objeto, columna[i], umbral);
                    }
                }
                System.out.print(umbral.toString());
                lista.insertarCabecera(umbral);
            }
            System.out.println("");

        } catch (Exception e) {
            System.out.println("Error al cargar " + e);
            e.printStackTrace();
        }
        return lista;
    }

    public ListaEnlazada<Umbral> consultarUmbrales(String descripcion) {
        ListaEnlazada<Umbral> aux = new ListaEnlazada<>();
        String sentencia = "";
        if (descripcion == null) {
            sentencia = "SELECT * FROM UMBRAL";
        } else {
            sentencia = "SELECT * FROM UMBRAL WHERE TIPO LIKE '%" + descripcion + "%'";

        }
        try {
            PreparedStatement stmt = getConexion().prepareStatement(sentencia);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en modificar " + e);
            e.printStackTrace();
            sentencia = "SELECT * FROM UMBRAL WHERE TIPO LIKE '%" + descripcion + "%'";

        }
        try {
            PreparedStatement stmt = getConexion().prepareStatement(sentencia);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en modificar " + e);
            e.printStackTrace();
        }
        System.out.println(sentencia);
        return aux;
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
