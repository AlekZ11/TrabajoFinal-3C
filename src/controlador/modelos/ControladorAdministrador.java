package controlador.modelos;

import com.google.gson.Gson;
import controlador.tda.lista.ListaEnlazada;
import modelo.Administrador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ControladorAdministrador {
    private ListaEnlazada<Administrador> listaAdministradores;

    public ControladorAdministrador(){
        listaAdministradores = new ListaEnlazada<>();
    }

    public ListaEnlazada<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(ListaEnlazada<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public void cargarAdministradores(){
        Gson gson = new Gson();
        try {
            Administrador [] arrayAdministradores = gson.fromJson(new FileReader("administradores.json"), Administrador[].class);
            for (Administrador administrador : arrayAdministradores) {
                listaAdministradores.insertar(administrador);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        }
    }

    public void guardarAdministradores(){
        Gson gson = new Gson();
        try {
            Administrador[] arrayAdministradores = new Administrador[listaAdministradores.getSize()];
            for (int i = 0; i < listaAdministradores.getSize(); i++) {
                arrayAdministradores[i] = listaAdministradores.obtenerDato(i);
            }
            String json = gson.toJson(arrayAdministradores);
            System.out.println(json);
            FileWriter fw = new FileWriter("administradores.json");
            fw.write(json);
            fw.flush();
            System.out.println("Se guardo el archivo");
        } catch (Exception e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }
}
