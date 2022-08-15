/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.modelos.ControladorReporte;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.FrmReporte;

/**
 *
 * @author Usuario iTC
 */
public class ReportePDF {

    private ControladorReporte CR = new ControladorReporte();

    public ReportePDF(ControladorReporte controladorReporte) {
        this.CR = controladorReporte;
    }

    public void generarPDF() {
        Document documento = new Document();

        //Cliente c = new Cliente(1, "Maria", "Rivas", "1150498580", "Loja", "Gonzanama", "Calle loja entre 10 de Agosto y Sucre");
        //Vehiculo v = new Automovil(4, "Datsun", "1600-t", 2011, "LBC-123", "Camioneta", "Diesel", 1);
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Umbrales" + "Aqui_ID" + ".pdf"));
            documento.open();

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("./Imagenes/Logo.png");
            header.scaleToFit(123, 44);
            header.setAlignment(Chunk.ALIGN_BOTTOM);
            documento.add(header);

            Font font = new Font();
            font.setStyle(Font.BOLD);

            Paragraph parrafo = new Paragraph("\n\n\nReporte Revisión Vehicular");
            parrafo.setAlignment(1);
            documento.add(parrafo);

            documento.add(new Paragraph("\n\nFecha: " + LocalDate.now()));
            documento.add(new Paragraph("Hora: " + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
            documento.add(new Paragraph("Resultado: " + CR.getEstado()));
            documento.add(new Paragraph("\n"));

//            documento.add(new Paragraph("Datos Propietario", font));
//            documento.add(new Paragraph("Nombres: " + CR.getC().getNombre() + " " + CR.getC().getApellido()));
//            documento.add(new Paragraph("Identificación: " + CR.getC().getIdentificacion()));
//            documento.add(new Paragraph("Ciudad: " + CR.getCd().getNombre()));
//            documento.add(new Paragraph("Direccion: " + CR.getL().getDireccion()));
//            documento.add(new Paragraph("Provincia: " + CR.getP().getNombre()));
//            documento.add(new Paragraph("\n"));
//
//            documento.add(new Paragraph("Datos Vehículo", font));
//            documento.add(new Paragraph("Marca: " + CR.getM().getNombre()));
//            documento.add(new Paragraph("Modelo: " + CR.getV().getModelo()));
//            documento.add(new Paragraph("Año: " + CR.getA().getAnio()));
//            documento.add(new Paragraph("Combustible: " + CR.getT_c().getID_TIPOCOMBUSTIBLE()));
//            documento.add(new Paragraph("Placa: " + CR.getA().getPlaca()));
//            documento.add(new Paragraph("Tipo de Vehiculo: " + CR.getT_v().getID_TIPOVEHICULO()));
//            documento.add(new Paragraph("\n"));
            PdfPTable tabla = new PdfPTable(1);
            tabla.addCell("Caracteristicas del Vehiculo");
            documento.add(tabla);

            PdfPTable tabla2 = new PdfPTable(4);
            tabla2.addCell("Propietario");
            tabla2.addCell(CR.getC().getNombre() + " " + CR.getC().getApellido());

            tabla2.addCell("Identificación");
            tabla2.addCell(CR.getC().getIdentificacion());

            tabla2.addCell("Ciudad");
            tabla2.addCell(CR.getCd().getNombre());

            tabla2.addCell("Direccion");
            tabla2.addCell(CR.getL().getDireccion());

            tabla2.addCell("Provincia");
            tabla2.addCell(CR.getP().getNombre());

            //documento.add(tabla2);
//            PdfPTable tabla3 = new PdfPTable(1);
//            tabla3.addCell("Datos Vehiculo");
//            documento.add(tabla3);
            //PdfPTable tabla4 = new PdfPTable(4);
            tabla2.addCell("Marca");
            tabla2.addCell(CR.getM().getNombre());

            tabla2.addCell("Modelo");
            tabla2.addCell(CR.getV().getModelo());

            tabla2.addCell("Año");
            tabla2.addCell(CR.getA().getAnio() + "");

            tabla2.addCell("Combustible");
            tabla2.addCell(CR.getT_c().getID_TIPOCOMBUSTIBLE());

            tabla2.addCell("Placa");
            tabla2.addCell(CR.getA().getPlaca());

            tabla2.addCell("Tipo de Vehiculo");
            tabla2.addCell(CR.getT_v().getID_TIPOVEHICULO());

            documento.add(tabla2);

            documento.add(new Paragraph("\nResultados", font));
            

            //documento.add(new Paragraph("\n\nEstado: " + CR.getEstado()));

            StringBuffer resultados = new StringBuffer();
            resultados.append("\n");
            Integer tipo0 = 0;
            Integer tipo1 = 0;
            Integer tipo2 = 0;
            Integer tipo3 = 0;
            for (int k = 0; k < CR.getResultados().getSize(); k++) {
                try {
                    if (CR.getResultados().obtenerDato(k).toLowerCase().startsWith("tipo")) {
                        if (CR.getResultados().obtenerDato(k).endsWith("0")) {
                            tipo0++;
                        } else if (CR.getResultados().obtenerDato(k).endsWith("1")) {
                            tipo1++;
                        } else if (CR.getResultados().obtenerDato(k).endsWith("2")) {
                            tipo2++;
                        } else if (CR.getResultados().obtenerDato(k).endsWith("3")) {
                            tipo3++;
                        }
                    } else if (k != CR.getResultados().getSize() - 1 && k != 0) {
                        resultados.append(CR.getResultados().obtenerDato(k).toUpperCase() + "\n\n     Tipo 0 = " + tipo0 + "    Tipo 1 = " + tipo1 + "    Tipo2 = " + tipo2 + "    Tipo 3 = " + tipo3 + "\n\n");
                        tipo0 = 0;
                        tipo1 = 0;
                        tipo2 = 0;
                        tipo3 = 0;
                    }
                } catch (Exception e) {
                    Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            documento.add(new Paragraph(String.valueOf(resultados)));
            documento.close();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        //ReportePDF pdf = new ReportePDF(new Reporte(2, 2, 3, true, "El chasis esta un ligeramente aboyado"));
        //pdf.generarPDF();
        ListaEnlazada lista = new ListaEnlazada<>();
        lista.insertarCabecera("NO APRUEBA");
        lista.insertarCabecera("RINES DAÑADOS");
        lista.insertarCabecera("LLANTAS DESGASTADAS");
        lista.insertarCabecera("CAPO ABOLLADO");

        try {
            ControladorReporte reportController = new ControladorReporte(true, "GLS1960", lista);
            ReportePDF pdf = new ReportePDF(reportController);
            pdf.generarPDF();
        } catch (Exception ex) {
            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        String ruta = System.getProperty("user.home");
        File path = new File(ruta + "/Desktop/Reporte_UmbralesAqui_ID.pdf");
        try {
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
