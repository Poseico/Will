/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Paquete donde se encuentra esta clase
package Class;

// Importaciones necesarias para trabajar con fechas y horas
import java.time.LocalDate;
import java.time.LocalDateTime;
// Importación de ArrayList de Java para manejar listas dinámicas
import java.util.ArrayList;

/**
 * Clase Pago que representa un pago realizado en un sistema de gestión.
 * Esta clase contiene información sobre el propietario del pago, la fecha de pago, la fecha de expiración
 * y un identificador único para cada pago.
 *
 * @author deivi
 */
public class Pago {
    // Atributo para almacenar el propietario del pago
    private Propietario propietario;
    // Atributo para almacenar la fecha de pago
    private LocalDate fechapago;
    // Atributo para almacenar la fecha de expiración del pago
    private LocalDate fechaexp;
    // Atributo para almacenar el identificador único del pago
    private int Id;
    
    // Lista estática para almacenar todos los pagos realizados
    public static ArrayList<Pago> pagos_pago = new ArrayList<>();
    
    /**
     * Constructor de la clase Pago que inicializa los atributos del pago.
     * 
     * @param propietario Propietario del pago.
     * @param fechapago Fecha de pago.
     * @param fechaexp Fecha de expiración del pago.
     * @param Id Identificador único del pago.
     */
    public Pago(Propietario propietario, LocalDate fechapago, LocalDate fechaexp, int Id) {
        this.propietario = propietario;
        this.fechapago = fechapago; // Se utiliza el parámetro fechapago en lugar de LocalDate.now()
        this.fechaexp = fechaexp;
        this.Id = Id;
    }
    
    // Getter para obtener el propietario del pago
    public Propietario getPropietario() {
        return propietario;
    }

    // Setter para establecer el propietario del pago
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    // Getter para obtener la fecha de pago
    public LocalDate getFechapago() {
        return fechapago;
    }

    // Setter para establecer la fecha de pago
    public void setFechapago(LocalDate fechapago) {
        this.fechapago = fechapago;
    }

    // Getter para obtener la fecha de expiración del pago
    public LocalDate getFechaexp() {
        return fechaexp;
    }

    // Setter para establecer la fecha de expiración del pago
    public void setFechaexp(LocalDate fechaexp) {
        this.fechaexp = fechaexp;
    }

    // Getter para obtener el identificador único del pago
    public int getId() {
        return Id;
    }

    // Setter para establecer el identificador único del pago
    public void setId(int Id) {
        this.Id = Id;
    }
}
