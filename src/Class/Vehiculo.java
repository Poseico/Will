/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Paquete donde se encuentra esta clase
package Class;

/**
 * Clase Vehiculo que representa un vehículo en un sistema de gestión.
 * Esta clase contiene información sobre la marca, placa y modelo del vehículo.
 *
 * @author deivi
 */
public class Vehiculo {
    // Atributo para almacenar la marca del vehículo
    private String Marca;
    // Atributo para almacenar la placa del vehículo
    private String placa;
    // Atributo para almacenar el modelo del vehículo
    private String modelo;

    /**
     * Constructor de la clase Vehiculo que inicializa los atributos del vehículo.
     * 
     * @param Marca Marca del vehículo.
     * @param placa Placa del vehículo.
     * @param modelo Modelo del vehículo.
     */
    public Vehiculo(String Marca, String placa, String modelo) {
        this.Marca = Marca;
        this.placa = placa;
        this.modelo = modelo;
    }

    // Getter para obtener la marca del vehículo
    public String getMarca() {
        return Marca;
    }

    // Setter para establecer la marca del vehículo
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    // Getter para obtener la placa del vehículo
    public String getPlaca() {
        return placa;
    }

    // Setter para establecer la placa del vehículo
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Getter para obtener el modelo del vehículo
    public String getModelo() {
        return modelo;
    }

    // Setter para establecer el modelo del vehículo
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}