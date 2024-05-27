
import Class.Propietario;
import Class.Usuario;
import Class.Vigilante;
import java.util.ArrayList;

/**
 * Clase UsuarioManager que gestiona las sesiones de usuarios en la aplicación.
 * Implementa el patrón Singleton para asegurar que sólo exista una instancia de esta clase en toda la aplicación.
 * 
 * @author deivi
 */
public class UsuarioManager {
    // Variable estática para mantener una única instancia de la clase UsuarioManager
    private static UsuarioManager instancia ;
   
    // Variable para almacenar el objeto Usuario actualmente autenticado
    private Usuario sesionActual;
            
    // Constructor privado para evitar la instanciación externa
    private UsuarioManager() {
        
    }

    // Método estático para obtener la instancia Singleton de UsuarioManager
    public static UsuarioManager getInstance() {
        if (instancia == null) {
            instancia = new UsuarioManager();
        }
        return instancia;
    }

    // Método para iniciar sesión de un propietario
    public void iniciarSesionPropietario(String correo, String contraseña, ArrayList<Propietario> propietarios) {
        for (Propietario propietario : propietarios) {
            // Verifica si el correo y la contraseña ingresados coinciden con algún propietario registrado
            if (propietario.getCorreo().equals(correo) && propietario.getContraseña().equals(contraseña)){
                sesionActual = propietario; // Asigna el propietario autenticado a la variable de sesión actual
                System.out.println("Inicio de sesión exitoso como propietario: " + propietario.getNombre());
                return;
            }
        }
        // Si no se encuentra un propietario con esas credenciales, se informa al usuario
        System.out.println("Correo o contraseña incorrectos. Inicio de sesión fallido.");
    }

    // Método para iniciar sesión de un vigilante
    public void iniciarSesionVigilante(String correo, String contraseña, ArrayList<Vigilante> vigilantes) {
        for (Vigilante vigilante : vigilantes) {
            // Verifica si el correo y la contraseña ingresados coinciden con algún vigilante registrado
            if (vigilante.getCorreo().equals(correo) && vigilante.getContraseña().equals(contraseña)){
                sesionActual = vigilante; // Asigna el vigilante autenticado a la variable de sesión actual
                System.out.println("Inicio de sesión exitoso como vigilante: " + vigilante.getNombre());
                return;
            }
        }
        // Si no se encuentra un vigilante con esas credenciales, se informa al usuario
        System.out.println("Correo o contraseña incorrectos. Inicio de sesión fallido.");
    }

    // Método para obtener el propietario actualmente autenticado
    public Propietario getPropietarioActual() {
        if (sesionActual instanceof Propietario propietario) {
            return propietario; // Retorna el propietario si la sesión actual es de un propietario
        }
        return null; // Retorna null si la sesión actual no es de un propietario
    }
    
    // Método para obtener el vigilante actualmente autenticado
    public Vigilante getVigilanteActual() {
        if (sesionActual instanceof Vigilante vigilante) {
            return vigilante; // Retorna el vigilante si la sesión actual es de un vigilante
        }
        return null; // Retorna null si la sesión actual no es de un vigilante
    }
    
    // Método para verificar si hay una sesión activa
    public boolean SesionActiva() {
         if(sesionActual==null){
             return false; // Retorna false si no hay una sesión activa
         }else{
             return true; // Retorna true si hay una sesión activa
         }
    }
     
    // Método para cerrar la sesión actual
    public void cerrarSesion() {
        sesionActual = null; // Establece la variable de sesión actual a null, cerrando la sesión
    }
}