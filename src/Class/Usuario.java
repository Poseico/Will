/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Paquete donde se encuentra esta clase
package Class;

// Importación de la interfaz de usuario
import Interfaz.usu_interfaz;

/**
 * Clase abstracta Usuario que implementa la interfaz usu_interfaz.
 * Esta clase sirve como base para cualquier entidad que requiera ser considerada como un usuario dentro del sistema.
 * Define atributos comunes a todos los usuarios, como ID, nombre, correo y contraseña, así como métodos para acceder y modificar estos atributos.
 *
 * @author deivi
 */
public abstract class Usuario implements usu_interfaz {
    // Atributo para almacenar el ID único del usuario
    private int Id;
    // Atributo para almacenar el nombre del usuario
    private String Nombre;
    // Atributo para almacenar el correo electrónico del usuario
    private String Correo;
    // Atributo para almacenar la contraseña del usuario
    private String Contraseña;
    
    /**
     * Constructor vacío de la clase Usuario.
     */
    public Usuario(){
        
    }

    /**
     * Constructor de la clase Usuario que inicializa los atributos del usuario.
     * 
     * @param Id ID único del usuario.
     * @param Nombre Nombre del usuario.
     * @param Correo Correo electrónico del usuario.
     * @param Contraseña Contraseña del usuario.
     */
    public Usuario(int Id, String Nombre, String Correo, String Contraseña) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Contraseña = Contraseña;
    }

    // Métodos getter y setter para el ID del usuario
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    // Métodos getter y setter para el nombre del usuario
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    // Métodos getter y setter para el correo electrónico del usuario
    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    // Métodos getter y setter para la contraseña del usuario
    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
 
    /**
     * Método abstracto que debe ser sobrescrito por clases concretas que implementen esta interfaz.
     * Este método se utiliza para mostrar los atributos del usuario.
     */
    @Override
    public void mostraratributos() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Correo: " + getCorreo());
    }
}