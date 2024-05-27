/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Paquete donde se encuentra esta clase
package Class;

// Importación de LocalDate de Java para manejar fechas
import java.time.LocalDate;
// Importación de ArrayList de Java para manejar listas dinámicas
import java.util.ArrayList;

/**
 * Clase Incidente que representa un registro de incidente en un sistema de gestión.
 * Esta clase contiene información sobre el incidente, incluyendo detalles como ID, descripción,
 * fecha de ocurrencia, estado de registro, propietario afectado y vigilante asignado.
 *
 * @author deivi
 */
public class Incidente {
    // Atributo para almacenar el ID único del incidente
    private int id;
    // Atributo para almacenar la descripción del incidente
    private String info;
    // Atributo para almacenar la fecha de ocurrencia del incidente
    private LocalDate Fecha; 
    // Atributo para indicar si el incidente ha sido registrado oficialmente
    private boolean Registrado;
    // Atributo para almacenar el propietario afectado por el incidente
    private Propietario propietario;
    // Atributo para almacenar el vigilante asignado al incidente
    private Vigilante vigilante;
    
    // Lista estática para almacenar todos los incidentes registrados
    public static ArrayList<Incidente> incidentes = new ArrayList<>();

    /**
     * Constructor de la clase Incidente que inicializa los atributos del incidente.
     * 
     * @param id ID único del incidente.
     * @param info Descripción del incidente.
     * @param Fecha Fecha de ocurrencia del incidente.
     * @param Registrado Indicador de si el incidente ha sido registrado oficialmente.
     * @param propietario Propietario afectado por el incidente.
     * @param vigilante Vigilante asignado al incidente.
     */
    public Incidente(int id, String info, LocalDate Fecha, boolean Registrado, Propietario propietario, Vigilante vigilante) {
        this.id = id;
        this.info = info;
        this.Fecha = Fecha;
        this.Registrado = Registrado;
        this.propietario = propietario;
        this.vigilante = vigilante;
    }

    // Getter para obtener el ID del incidente
    public int getId() {
        return id;
    }

    // Setter para establecer el ID del incidente
    public void setId(int id) {
        this.id = id;
    }

    // Getter para obtener la descripción del incidente
    public String getInfo() {
        return info;
    }

    // Setter para establecer la descripción del incidente
    public void setInfo(String info) {
        this.info = info;
    }

    // Getter para obtener la fecha de ocurrencia del incidente
    public LocalDate getFecha() {
        return Fecha;
    }

    // Setter para establecer la fecha de ocurrencia del incidente
    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    // Getter para verificar si el incidente ha sido registrado oficialmente
    public boolean isRegistrado() {
        return Registrado;
    }

    // Setter para actualizar el estado de registro del incidente
    public void setRegistrado(boolean Registrado) {
        this.Registrado = Registrado;
    }

    // Getter para obtener el propietario afectado por el incidente
    public Propietario getPropietario() {
        return propietario;
    }

    // Setter para establecer el propietario afectado por el incidente
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    // Getter para obtener el vigilante asignado al incidente
    public Vigilante getVigilante() {
        return vigilante;
    }

    // Setter para establecer el vigilante asignado al incidente
    public void setVigilante(Vigilante vigilante) {
        this.vigilante = vigilante;
    }
}