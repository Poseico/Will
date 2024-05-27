/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Importación de ArrayList de Java para manejar listas dinámicas
import java.util.ArrayList;

/**
 * Clase Invitado que extiende de la clase Usuario, destinada a representar a un invitado en un sistema de gestión.
 * Esta clase incluye información adicional específica para los invitados, como el vehículo que utilizan durante su visita.
 *
 * @author deivi
 */
public class Invitado extends Usuario{
    
    // Atributo para almacenar el vehículo asociado al invitado
    private Vehiculo vehiculo;
    
    // Lista estática para almacenar todos los invitados registrados
    public static ArrayList<Invitado> invitado = new ArrayList<>();
    
    /**
     * Constructor de la clase Invitado que inicializa los atributos del invitado y su vehículo asociado.
     * 
     * @param Id ID único del invitado.
     * @param Nombre Nombre del invitado.
     * @param Correo Correo electrónico del invitado.
     * @param Contraseña Contraseña del invitado.
     * @param vehiculo Vehículo asociado al invitado.
     */
    public Invitado(int Id, String Nombre, String Correo, String Contraseña, Vehiculo vehiculo) {
        super(Id, Nombre, Correo, Contraseña); // Llama al constructor de la clase padre Usuario
        this.vehiculo = vehiculo; // Asigna el vehículo al invitado
    }

    // Getter para obtener el vehículo asociado al invitado
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    // Setter para establecer el vehículo asociado al invitado
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Sobrescribe el método mostraratributos() de la clase padre Usuario para incluir información específica del vehículo.
     * Este método muestra los atributos del usuario e información adicional del vehículo si está asociado.
     */
    @Override
    public void mostraratributos() {
        super.mostraratributos(); // Muestra los atributos heredados de la clase Usuario
        if (vehiculo!= null) { // Verifica si el vehículo está asociado
            System.out.println("Vehiculo Marca: " + vehiculo.getMarca()); // Muestra la marca del vehículo
            System.out.println("Vehiculo Modelo: " + vehiculo.getModelo()); // Muestra el modelo del vehículo
            System.out.println("Vehiculo Placa: " + vehiculo.getPlaca()); // Muestra la placa del vehículo
        } else {
            System.out.println("No hay vehículo asociado"); // Mensaje si no hay vehículo asociado
        }
    }
}
