/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Paquete donde se encuentra esta clase
package Class;

// Importación de ArrayList de Java para manejar listas dinámicas
import java.util.ArrayList;

/**
 * Clase Mercancia que representa un artículo o bien mueble en un sistema de gestión.
 * Esta clase contiene información sobre el nombre, tipo y propietario de la mercancía.
 *
 * @author deivi
 */
public class Mercancia {
    // Atributo para almacenar el nombre de la mercancía
    private String nombre;
    // Atributo para almacenar el tipo de la mercancía
    private String tipo;
    // Atributo para almacenar el propietario de la mercancía
    private Propietario propietario;
    
    // Lista estática para almacenar todas las mercancías registradas
    public static ArrayList<Mercancia> mercancia = new ArrayList<>();

    /**
     * Constructor de la clase Mercancia que inicializa los atributos de la mercancía.
     * 
     * @param nombre Nombre de la mercancía.
     * @param tipo Tipo de la mercancía.
     * @param propietario Propietario de la mercancía.
     */
    public Mercancia(String nombre, String tipo, Propietario propietario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.propietario = propietario;
    }

    // Getter para obtener el nombre de la mercancía
    public String getNombre() {
        return nombre;
    }

    // Setter para establecer el nombre de la mercancía
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para obtener el tipo de la mercancía
    public String getTipo() {
        return tipo;
    }

    // Setter para establecer el tipo de la mercancía
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter para obtener el propietario de la mercancía
    public Propietario getPropietario() {
        return propietario;
    }

    // Setter para establecer el propietario de la mercancía
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
