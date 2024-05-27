
import Class.Propietario;
import Class.Vigilante;
import java.util.ArrayList;

/**
 * Clase Validaciones que contiene métodos para validar entradas de usuario.
 * 
 * @author deivi
 */
public class Validaciones {

    /**
     * Constructor vacío de la clase Validaciones.
     */
    public Validaciones() {
    }
    
    /**
     * Método para validar si un nombre está vacío.
     * 
     * @param nombre El nombre a validar.
     * @return true si el nombre está vacío, false en caso contrario.
     */
    public boolean validarNombre(String nombre) {
        if (nombre.isEmpty()) {
            System.out.println("El nombre está vacío, por favor ingrese uno.");
            return true;
        }
        return false;
    }
    
    /**
     * Método para validar si un correo electrónico está vacío.
     * 
     * @param correo El correo electrónico a validar.
     * @return true si el correo electrónico está vacío, false en caso contrario.
     */
    public boolean validarcorreo(String correo) {
        if (correo.isEmpty()) {
            System.out.println("El correo está vacío, por favor ingrese uno.");
            return true;
        }
        return false;
    }
    
    /**
     * Método para validar si un correo electrónico de vigilante ya existe en una lista de vigilantes.
     * 
     * @param correo El correo electrónico a validar.
     * @param vigilantes La lista de vigilantes para la validación.
     * @return true si el correo electrónico ya existe, false en caso contrario.
     */
    public boolean validarCorreovigilante(String correo, ArrayList<Vigilante> vigilantes) {
        if (correo.isEmpty()) {
            System.out.println("El correo está vacío, por favor ingrese uno.");
            return true;
        }
        for (Vigilante vigilante : vigilantes) {
            if (correo.equals(vigilante.getCorreo())) {
                System.out.println("El correo ya existe, por favor ingrese uno diferente.");
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método para validar si un correo electrónico de propietario ya existe en una lista de propietarios.
     * 
     * @param correo El correo electrónico a validar.
     * @param propietarios La lista de propietarios para la validación.
     * @return true si el correo electrónico ya existe, false en caso contrario.
     */
    public boolean validarCorreopropietario(String correo, ArrayList<Propietario> propietarios) {
        if (correo.isEmpty()) {
            System.out.println("El correo está vacío, por favor ingrese uno.");
            return true;
        }
        for (Propietario propietario : propietarios) {
            if(correo.equals(propietario.getCorreo())){
                System.out.println("El correo ya existe, porfavor ingrese uno diferente.");
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método para validar si una contraseña está vacía.
     * 
     * @param contraseña La contraseña a validar.
     * @return true si la contraseña está vacía, false en caso contrario.
     */
    public boolean validarContraseña(String contraseña) {
        if (contraseña.isEmpty()) {
            System.out.println("La contraseña está vacía, por favor ingrese una.");
            return true;
        }
        return false;
    }
    
    /**
     * Método para validar si un ID de propietario ya existe en una lista de propietarios.
     * 
     * @param propietarios La lista de propietarios para la validación.
     * @param id El ID a validar.
     * @return true si el ID ya existe, false en caso contrario.
     */
    public boolean validarIdPropietario(ArrayList<Propietario> propietarios, int id) {
        if (id <= 0) {
            System.out.println("El ID debe ser un número positivo mayor que cero.");
            return true;
        }
        for (Propietario propietario : propietarios) {
            if (id == propietario.getId()) {
                System.out.println("El ID ya existe, por favor ingrese uno diferente.");
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método para validar si un ID de vigilante ya existe en una lista de vigilantes.
     * 
     * @param vigilantes La lista de vigilantes para la validación.
     * @param id El ID a validar.
     * @return true si el ID ya existe, false en caso contrario.
     */
    public boolean validarIdVigilante(ArrayList<Vigilante> vigilantes, int id) {
        if (id < 0) {
            System.out.println("El ID no puede ser un número negativo.");
            return true;
        }
        for (Vigilante vigilante : vigilantes) {
            if (id == vigilante.getId()) {
                System.out.println("El ID ya existe, por favor ingrese uno diferente.");
                return true;
            }
        }
        return false;
    }
}