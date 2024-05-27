/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Paquete donde se encuentra esta clase
package Class;

// Importación de ArrayList de Java para manejar listas dinámicas
import java.util.ArrayList;

/**
 * Clase Vigilante que extiende de la clase Usuario, destinada a representar a un vigilante en un sistema de seguridad.
 * Esta clase incluye información adicional específica para los vigilantes, como incidentes reportados, invitados y mercancías.
 *
 * @author deivi
 */
public class Vigilante extends Usuario{
    
    // Atributo para almacenar una lista de incidentes reportados por el vigilante
    private ArrayList<Incidente> incidente = new  ArrayList<>();
    // Atributo para almacenar una lista de invitados relacionados con el vigilante
    private ArrayList<Invitado> invitado = new ArrayList<>();
    // Atributo para almacenar una lista de mercancías bajo la responsabilidad del vigilante
    private ArrayList<Mercancia> mercancia = new ArrayList<>();
    
    // Lista estática para almacenar todos los vigilantes registrados
    public static ArrayList<Vigilante> vigilantes = new ArrayList<>();
    
    /**
     * Constructor de la clase Vigilante que inicializa los atributos del vigilante y sus listas internas.
     * 
     * @param Id ID único del vigilante.
     * @param Nombre Nombre del vigilante.
     * @param Correo Correo electrónico del vigilante.
     * @param Contraseña Contraseña del vigilante.
     */
    public Vigilante(int Id, String Nombre, String Correo, String Contraseña) {
        super(Id, Nombre, Correo, Contraseña); // Llama al constructor de la clase padre Usuario
        this.incidente = new ArrayList<>(); // Inicializa las listas internas
        this.invitado = new ArrayList<>();
    }

    // Getters y setters para las listas internas del vigilante
    public ArrayList<Incidente> getIncidente() {
        return incidente;
    }

    public void setIncidente(ArrayList<Incidente> incidente) {
        this.incidente = incidente;
    }

    public ArrayList<Invitado> getInvitado() {
        return invitado;
    }

    public void setInvitado(ArrayList<Invitado> invitado) {
        this.invitado = invitado;
    }

    public ArrayList<Mercancia> getMercancia() {
        return mercancia;
    }

    public void setMercancia(ArrayList<Mercancia> mercancia) {
        this.mercancia = mercancia;
    }

    /**
     * Sobrescribe el método mostraratributos() de la clase padre Usuario para incluir información específica del vigilante.
     */
    @Override
    public void mostraratributos() {
        super.mostraratributos(); // Muestra los atributos heredados de la clase Usuario
    }
}

