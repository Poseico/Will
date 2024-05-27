/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.GestorArchivo to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deivi
 */
import java.io.*;

public class GestorArchivo {

    // Constante que define el nombre del archivo con el cual se trabajará
    private static final String NOMBRE_ARCHIVO = "datos.txt";

    /**
     * Método para escribir contenido en el archivo especificado.
     * 
     * @param contenido El contenido a escribir en el archivo.
     */
    public static void escribirArchivo(String contenido) {
        try {
            // Se crea un FileWriter para el archivo, configurado en modo append (añadir al final)
            FileWriter writer = new FileWriter(NOMBRE_ARCHIVO, true);
            // Se utiliza un BufferedWriter para escribir el contenido en el archivo
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            // Se escribe el contenido en el archivo y se añade una nueva línea
            bufferWriter.write(contenido);
            bufferWriter.newLine();
            // Se cierra el BufferedWriter
            bufferWriter.close();
            // Mensaje de éxito
            System.out.println("Información escrita en el archivo correctamente.");
        } catch (IOException e) {
            // Manejo de errores al escribir en el archivo
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Método para leer y mostrar el contenido del archivo especificado.
     */
    public static void leerArchivo() {
        try {
            // Se crea un FileReader para el archivo
            FileReader reader = new FileReader(NOMBRE_ARCHIVO);
            // Se utiliza un BufferedReader para leer el contenido del archivo
            BufferedReader bufferReader = new BufferedReader(reader);
            String linea; // Variable para almacenar cada línea leída
            // Se lee el archivo línea por línea hasta que no haya más líneas
            while ((linea = bufferReader.readLine())!= null) {
                System.out.println(linea);
            }
            // Se cierra el BufferedReader
            bufferReader.close();
        } catch (IOException e) {
            // Manejo de errores al leer el archivo
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Método para buscar una palabra específica en el archivo y mostrar las líneas que contienen dicha palabra.
     * 
     * @param palabra La palabra a buscar en el archivo.
     */
    public static void buscarEnArchivo(String palabra) {
        try {
            // Se crea un FileReader para el archivo
            FileReader reader = new FileReader(NOMBRE_ARCHIVO);
            // Se utiliza un BufferedReader para leer el contenido del archivo
            BufferedReader bufferReader = new BufferedReader(reader);
            String linea; // Variable para almacenar cada línea leída
            boolean encontrado = false; // Bandera para indicar si la palabra fue encontrada
            // Se lee el archivo línea por línea hasta que no haya más líneas
            while ((linea = bufferReader.readLine())!= null) {
                if (linea.contains(palabra)) { // Si la línea contiene la palabra buscada
                    System.out.println("Palabra encontrada: " + linea);
                    encontrado = true;
                }
            }
            // Si la palabra no fue encontrada después de leer todo el archivo
            if (!encontrado) {
                System.out.println("La palabra no se encontró en el archivo.");
            }
            // Se cierra el BufferedReader
            bufferReader.close();
        } catch (IOException e) {
            // Manejo de errores al buscar en el archivo
            System.out.println("Error al buscar en el archivo: " + e.getMessage());
        }
    }

    /**
     * Método para eliminar una línea específica del archivo basándose en su contenido.
     * 
     * @param contenido El contenido de la línea a eliminar.
     */
    public static void eliminarDelArchivo(String contenido) {
        try {
            // Se crean objetos File para el archivo original y un archivo temporal
            File inputFile = new File(NOMBRE_ARCHIVO);
            File tempFile = new File("temp.txt");
            // Se utilizan BufferedReader y BufferedWriter para leer y escribir en ambos archivos
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine; // Variable para almacenar cada línea leída
            // Se lee el archivo original línea por línea y se escribe en el archivo temporal solo las líneas que no coinciden con el contenido a eliminar
            while ((currentLine = reader.readLine())!= null) {
                if (!currentLine.equals(contenido)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            // Se cierran el BufferedReader y BufferedWriter
            writer.close();
            reader.close();
            // Se elimina el archivo original y se renombra el archivo temporal al nombre original del archivo
            if (!inputFile.delete()) {
                System.out.println("No se pudo eliminar el archivo original.");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("No se pudo renombrar el archivo temporal.");
                return;
            }
            // Mensaje de éxito
            System.out.println("Información eliminada del archivo correctamente.");
        } catch (IOException e) {
            // Manejo de errores al eliminar información del archivo
            System.out.println("Error al eliminar información del archivo: " + e.getMessage());
        }
    }
}