/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Paquete donde se encuentra esta clase
package Class;

// Importación de ArrayList de Java para manejar listas dinámicas
import java.util.ArrayList;

/**
 * Clase Propietario que extiende de la clase Usuario, destinada a representar a un propietario en un sistema de gestión.
 * Esta clase incluye información adicional específica para los propietarios, como sus pagos, invitados, incidentes y mercancías.
 *
 * @author deivi
 */
public class Propietario extends Usuario{
   // Atributo para almacenar una lista de pagos realizados por el propietario
   private ArrayList<Pago> mispagos = new ArrayList<>();
   // Atributo para almacenar una lista de invitados relacionados con el propietario
   private ArrayList<Invitado> invitados = new ArrayList<>();
   // Atributo para almacenar una lista de incidentes reportados por el propietario
   private ArrayList<Incidente> incidente = new  ArrayList<>();
   // Atributo para almacenar una lista de mercancías propiedad del propietario
   private ArrayList<Mercancia> mismercancia = new ArrayList<>();
    
   // Lista estática para almacenar todos los propietarios registrados
   public static ArrayList<Propietario> propietarios = new ArrayList<>();

   /**
    * Constructor de la clase Propietario que inicializa los atributos del propietario y sus listas internas.
    * 
    * @param Id ID único del propietario.
    * @param Nombre Nombre del propietario.
    * @param Correo Correo electrónico del propietario.
    * @param Contraseña Contraseña del propietario.
    */
   public Propietario(int Id, String Nombre, String Correo, String Contraseña) {
       super(Id, Nombre, Correo, Contraseña); // Llama al constructor de la clase padre Usuario
       this.mispagos = new ArrayList<>(); // Inicializa las listas internas
       this.invitados = new ArrayList<>();
       this.incidente = new ArrayList<>();
       this.mismercancia = new ArrayList<>();
   }

   // Getters y setters para las listas internas del propietario
   public ArrayList<Pago> getMispagos() {
       return mispagos;
   }

   public void setMispagos(ArrayList<Pago> mispagos) {
       this.mispagos = mispagos;
   }

   public ArrayList<Invitado> getInvitados() {
       return invitados;
   }

   public void setInvitados(ArrayList<Invitado> invitados) {
       this.invitados = invitados;
   }

   public ArrayList<Incidente> getIncidente() {
       return incidente;
   }

   public void setIncidente(ArrayList<Incidente> incidente) {
       this.incidente = incidente;
   }

   public ArrayList<Mercancia> getMismercancia() {
       return mismercancia;
   }

   public void setMismercancia(ArrayList<Mercancia> mismercancia) {
       this.mismercancia = mismercancia;
   }

   /**
    * Sobrescribe el método mostraratributos() de la clase padre Usuario para incluir información específica del propietario.
    */
   @Override
   public void mostraratributos() {
       super.mostraratributos(); // Muestra los atributos heredados de la clase Usuario
   }
}
