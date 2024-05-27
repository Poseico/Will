
import Class.Admi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deivi
 */
public class SesionAdmi {
  
    // Variable estática para mantener una única instancia de la clase SesionAdmi
    private static SesionAdmi instancia;  
    
    // Variable para almacenar el objeto Admi actualmente autenticado
    private Admi adminActual; 
    
    // Constructor privado para garantizar que sólo pueda haber una instancia de SesionAdmi
    private SesionAdmi() {
      
    }
    
    // Método estático para obtener la única instancia de SesionAdmi
    public static SesionAdmi obtenerInstancia() {
        if (instancia == null) {
            instancia = new SesionAdmi();
        }
        return instancia;
    }
    
    // Método para iniciar sesión del administrador
    public void iniciarSesion(String email, String contraseña){
      
      // Datos de inicio de sesión correctos para el administrador
      String emailAdminCorrecto="admin@gmail.com";
      int idAdminCorrecto = 1042243311;
      String nombreAdmin="kevin";
      String contraseñaAdmi = "contraseña";
     
      // Verifica si el email y la contraseña ingresados coinciden con los datos correctos
      if(email.equals(emailAdminCorrecto) && contraseña.equals(contraseñaAdmi) ){
       adminActual = new Admi(idAdminCorrecto, nombreAdmin, emailAdminCorrecto, contraseñaAdmi);
          System.out.println("Bienvenido "+ adminActual.getNombre()+"!!");
          
      }else{
          System.out.println("Datos Incorrectos");
      }
    }
    
    // Método para cerrar la sesión del administrador
    public void cerrarSesion() {
    adminActual=null;
    System.out.println("Sesión cerrada ");
    }
    
    
    // Método para obtener el objeto Admi actualmente autenticado
    public Admi getAdminActual() {
        return adminActual;
    }

    
    // Método para verificar si hay una sesión activa
    public boolean SesionActiva() {
         if(adminActual==null){
             return false;
         }else{
             return true;
         }
    }

}