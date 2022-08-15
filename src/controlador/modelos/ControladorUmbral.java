package controlador.modelos;

import com.google.gson.Gson;
import controlador.dao.RangoAnioDao;
import controlador.dao.UmbralDao;
import controlador.tda.lista.ListaEnlazada;
import modelo.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ControladorUmbral {

    private ListaEnlazada<Umbral> listaUmbrales;
    private ListaEnlazada<RangoAnio> listaRangosAnio;
    private UmbralDao udao;
    private RangoAnioDao radao;

    public ControladorUmbral() {
        udao = new UmbralDao();
        radao = new RangoAnioDao();
        listaUmbrales = udao.listar();
        listaRangosAnio = radao.listar();
    }

    public ListaEnlazada<Umbral> getListaUmbrales() {
        return listaUmbrales;
    }

    public void setListaUmbrales(ListaEnlazada<Umbral> listaUmbrales) {
        this.listaUmbrales = listaUmbrales;
    }

    /*public void insertarUmbral(Integer id_valor, Integer anioMin, Integer anioMax, Double [] valoresMin, Double [] valoresMax){
        listaUmbrales.insertar(new Umbral(listaUmbrales.getSize()+1, anioMin, anioMax, valoresMin, valoresMax, id_valor));
    }*/
    public ListaEnlazada<Umbral> obtenerUmbral(Integer id_valor) throws Exception {
        ListaEnlazada<Umbral> listaAux = new ListaEnlazada<>();
        for (int i = 0; i < listaUmbrales.getSize(); i++) {
            if (listaUmbrales.obtenerDato(i).getClave_Umbral().equals(id_valor)) {
                listaAux.insertar(listaUmbrales.obtenerDato(i));
            }
        }
        return listaAux;
    }

    public RangoAnio obtenerRangoAnio(Integer id_rangoAnio) throws Exception {
        ListaEnlazada<RangoAnio> Aux = listaRangosAnio.buscar("ID_RangoAnio", id_rangoAnio);
        return Aux.obtenerDato(0);
    }

    public void cargarUmbrales() {
        Gson gson = new Gson();
        try {
            Umbral[] arrayUmbrales = gson.fromJson(new FileReader("umbrales.json"), Umbral[].class);
            for (Umbral umbral : arrayUmbrales) {
                listaUmbrales.insertar(umbral);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        }
    }

    public void guardarUmbrales() {
        Gson gson = new Gson();
        try {
            Umbral[] arrayUmbrales = new Umbral[listaUmbrales.getSize()];
            arrayUmbrales = listaUmbrales.toArray();
            String json = gson.toJson(arrayUmbrales);
            System.out.println(json);
            FileWriter fw = new FileWriter("umbrales.json");
            fw.write(json);
            fw.flush();
            System.out.println("Se guardo el archivo");
        } catch (Exception e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }

    public String comprobarUmbral(Integer id_valor, Integer anio, Double valor, String tipo) throws Exception {
        ListaEnlazada<Umbral> umbrales = obtenerUmbral(id_valor);
        for (int i = 0; i < umbrales.getSize(); i++) {
            Umbral umbral = umbrales.obtenerDato(i);
            RangoAnio ra = obtenerRangoAnio(umbrales.obtenerDato(i).getID_RangoAnio());
            if ((anio >= ra.getAnioMin() && anio < ra.getAnioMax())
                    && umbral.getCategoria().toLowerCase().equals(tipo.toLowerCase())
                    && umbral.getValorMin() <= valor 
                    && valor < umbral.getValorMax()) {
                if(umbral.getCategoria().toLowerCase() == "todos"){
                    return umbral.getTipo();
                }else if (umbral.getCategoria().toLowerCase() == "todos excepto motos" && tipo.toLowerCase().contains("ruedas")){
                    return umbral.getTipo();
                }else{
                    return umbral.getTipo();
                }
            }
        }
        return "Tipo 0";
    }
}
