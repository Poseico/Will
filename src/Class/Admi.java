/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Paquete donde se encuentra esta clase
package Class;

// Importación de la clase ArrayList de Java para manejar listas dinámicas
import java.util.ArrayList;

/**
 * Clase Admi que extiende de la clase Usuario, destinada a manejar operaciones específicas de administración.
 * Esta clase es parte de un sistema de gestión, posiblemente para un parqueadero o similar.
 *
 * @author deivi
 */
public class Admi extends Usuario {

    // Lista para almacenar objetos de tipo Pago
    private ArrayList<Pago> pagos = new ArrayList<>();
    
    // Lista para almacenar objetos de tipo Mercancia
    private ArrayList<Mercancia> mercancia = new ArrayList<>();

    /**
     * Constructor de la clase Admi que inicializa los atributos heredados de la clase Usuario.
     * 
     * @param Id Identificador único del usuario/administrador.
     * @param Nombre Nombre del usuario/administrador.
     * @param Correo Correo electrónico del usuario/administrador.
     * @param Contraseña Contraseña del usuario/administrador.
     */
    public Admi(int Id, String Nombre, String Correo, String Contraseña) {
        super(Id, Nombre, Correo, Contraseña);
    }

    // Getter para obtener la lista de pagos
    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    // Setter para establecer la lista de pagos
    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }

    // Getter para obtener la lista de mercancías
    public ArrayList<Mercancia> getMercancia() {
        return mercancia;
    }

    // Setter para establecer la lista de mercancías
    public void setMercancia(ArrayList<Mercancia> mercancia) {
        this.mercancia = mercancia;
    }

    /**
     * Método para visualizar propietarios registrados.
     * 
     * @param propietarios Lista de propietarios a visualizar.
     */
    public void visualizarpropietarios(ArrayList<Propietario> propietarios) {
        if (!(propietarios.isEmpty())) {
            for (int i = 0; i < propietarios.size(); i++) {
                Propietario pro = Propietario.propietarios.get(i); // Acceso directo a la lista de propietarios, considera usar el getter para mayor encapsulamiento
                System.out.println("_______________________");
                System.out.println("Propietario " + (i + 1));
                pro.mostraratributos();
                System.out.println("_______________________");
            }
        } else {
            System.out.println("No hay ningun propietario registrado para ver");
        }
    }

    /**
     * Método para visualizar vigilantes registrados.
     * 
     * @param vigilantes Lista de vigilantes a visualizar.
     */
    public void visualizarvigilantes(ArrayList<Vigilante> vigilantes) {
        if (!vigilantes.isEmpty()) {
            for (int i = 0; i < vigilantes.size(); i++) {
                Vigilante vi = vigilantes.get(i); // Considera usar el getter para acceder a los elementos de la lista
                System.out.println("_______________________");
                System.out.println("Vigilante" + (i + 1));
                vi.mostraratributos();
                System.out.println("_______________________");
            }
        } else {
            System.out.println("No hay ningun vigilante registrado para ver ");
        }
    }

    /**
     * Método para visualizar pagos realizados.
     * 
     * @param pagos Lista de pagos a visualizar.
     */
    public void visualizarPagos(ArrayList<Pago> pagos) {
        if (pagos.isEmpty()) {
            System.out.println("-------------Pagos-------------");
            for (int i = 0; i < pagos.size(); i++) {
                Propietario pro = pagos.get(i).getPropietario(); // Acceso directo a la propiedad del propietario, considera usar el getter para mayor encapsulamiento
                System.out.println("________________________");
                System.out.println("Id:" + pagos.get(i).getId());
                System.out.println("Nombre del Propietario:" + pro.getNombre());
                System.out.println("Fecha:" + pagos.get(i).getFechapago());
                System.out.println("Fecha de vencimineto:" + pagos.get(i).getFechaexp());
                System.out.println("________________________");
                System.out.println("");
            }
        } else {
            System.out.println("No se han realizados pagos");
        }
    }

    /**
     * Método para visualizar incidentes registrados.
     * 
     * @param incidentes Lista de incidentes a visualizar.
     */
    public void visualizarIncidentes(ArrayList<Incidente> incidentes) {
        if (incidentes.isEmpty()) {
            System.out.println("No hay incidentes registrados.");
        } else {
            System.out.println("-------------Incidentes-------------");
            for (Incidente incidente : incidentes) {
                System.out.println("________________________");
                System.out.println("Id: " + incidente.getId());
                System.out.println("Descripción: " + incidente.getInfo());
                System.out.println("Fecha: " + incidente.getFecha());
                System.out.println("Registrado: " + (incidente.isRegistrado()? "Si" : "No"));
                System.out.println("Propietario: " + incidente.getPropietario().getNombre());
                System.out.println("Vigilante: " + (incidente.getVigilante()!= null? incidente.getVigilante().getNombre() : "N/A"));
                System.out.println("________________________");
            }
        }
    }

    /**
     * Método para visualizar mercancías registradas.
     * 
     * @param mercancias Lista de mercancías a visualizar.
     */
    public void visualizarMercancias(ArrayList<Mercancia> mercancias) {
        if (mercancias.isEmpty()) {
            System.out.println("No hay mercancías registradas.");
        } else {
            System.out.println("-------------Mercancías-------------");
            for (Mercancia mercancia : mercancias) {
                System.out.println("________________________");
                System.out.println("Nombre: " + mercancia.getNombre());
                System.out.println("Tipo: " + mercancia.getTipo());
                System.out.println("Propietario: " + mercancia.getPropietario().getNombre());
                System.out.println("________________________");
            }
        }
    }

    /**
     * Método para visualizar invitados registrados.
     * 
     * @param invitado Lista de invitados a visualizar.
     */
    public void visualizarInvitados(ArrayList<Invitado> invitado) {
        if (!invitado.isEmpty()) {
            System.out.println("-------------Invitados-------------");
            for (Invitado invtado : invitado) {
                Vehiculo vhh = invtado.getVehiculo(); // Considera usar el getter para acceder a los elementos de la lista
                System.out.println("________________________");
                invtado.mostraratributos();
                System.out.println("________________________");
                System.out.println("");
            }
        } else {
            System.out.println("No se han encontrado ");
        }
    }

    /**
     * Sobrescribe el método mostraratributos() de la clase padre Usuario.
     * Este método debería implementarse según las necesidades específicas de la clase Admi.
     */
    @Override
    public void mostraratributos() {
    }
}
