
import Class.Incidente;
import Class.Invitado;
import Class.Mercancia;
import Class.Pago;
import Class.Propietario;
import Class.Vehiculo;
import Class.Vigilante;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author deivi
 */
public class Main {

    /**
     * Método principal de la aplicación.
     * 
     * @param args Argumentos de línea de comando.
     */
    public static void main(String[] args) {

        // Creación de objetos para interactuar con el usuario y realizar operaciones de lectura
        Scanner leer = new Scanner(System.in); // Para leer la entrada del usuario
        Scanner linea = new Scanner(System.in); // Otra instancia de Scanner, pero no se utiliza en el fragmento proporcionado
        Validaciones vld = new Validaciones(); // Objeto para realizar validaciones de entrada
        SesionAdmi sesion = SesionAdmi.obtenerInstancia(); // Obtener la instancia singleton de SesionAdmi
        UsuarioManager sesion_pro = UsuarioManager.getInstance(); // Obtener la instancia singleton de UsuarioManager para propietarios
        UsuarioManager sesion_vig = UsuarioManager.getInstance(); // Obtener la instancia singleton de UsuarioManager para vigilantes
        Propietario propietarioActivo = null; // Variable para almacenar el propietario activo
        LocalDate fechaIngresada = null; // Fecha ingresada por el usuario
        LocalDate fechaexp = null; // Fecha de expiración
        LocalDate fechaInc = null; // Fecha de inicio de contrato
        Vehiculo veh = null; // Objeto para representar un vehículo
        Invitado inv = null; // Objeto para representar un invitado
        boolean sw1 = false; // Bandera para controlar el flujo del programa

        // Variables para almacenar información de entrada del usuario
        String correoInvitado, nombreInvitado, admi_email, admi_contraseña, pro_correo, pro_contraseña, pro_nombre, vig_correo, vig_contraseña, vig_nombre, desc, fecha_inc, mer_nombre, mer_tipo;
        int id_mer_pro, id_invt_pro, idInvitado, inc_id, pago_id, pro_id, vig_id, op, op1, op2, op3, op4, op5;

        // Llama a un método estático de otra clase para leer un archivo, posiblemente inicializando algunos datos o configuraciones
        GestorArchivo.leerArchivo();

        // Bucle principal de la aplicación
        do {
            System.out.println("Bienvenido al Sistema de Administración");
            System.out.println("Por favor, seleccione su rol:");
            System.out.println("1. Administrador");
            System.out.println("2. Propietario");
            System.out.println("3. Vigilante");
            System.out.println("4. Salir");
            System.out.println("Ingrese su elección:");
            op = leer.nextInt(); // Leer la opción seleccionada por el usuario

            switch (op) {
                case 1:
                    do {
                        System.out.println("Menú de Administrador");
                        System.out.println("1. Iniciar Sesión");
                        System.out.println("2. Ver Propietarios Registrados");
                        System.out.println("3. Ver Vigilantes Registrados");
                        System.out.println("4. Visualizar Mercancía");
                        System.out.println("5. gestionar pagos ");
                        System.out.println("6. visualizar incidentes");
                        System.out.println("7. ver invitados.");
                        System.out.println("8. Salir");
                        System.out.println("Ingrese su elección:");
                        op1 = leer.nextInt();

                        switch (op1) {
                            case 1:
                                System.out.println("Cual es su Correo?");
                                admi_email = linea.nextLine();
                                while (vld.validarcorreo(admi_email)) {
                                    admi_email = linea.nextLine();
                                }
                                System.out.println("Cual es su contraseña? ");
                                admi_contraseña = linea.nextLine();
                                while (vld.validarContraseña(admi_contraseña)) {
                                    admi_contraseña = linea.nextLine();
                                }
                                sesion.iniciarSesion(admi_email, admi_contraseña);
                                /*
                                String emailAdminCorrecto="admin@gmail.com";
                                int idAdminCorrecto = 1042243311;
                                String nombreAdmin="kevin";
                                String contraseñaAdmi = "contraseña";
                                 */

                                break;
                            case 2:
                                if (sesion.SesionActiva()) {

                                    sesion.getAdminActual().visualizarpropietarios(Propietario.propietarios);
                                } else {
                                    System.out.println("Inicie Sesion primero");
                                }
                                break;
                            case 3:
                                if (sesion.SesionActiva()) {
                                    sesion.getAdminActual().visualizarvigilantes(Vigilante.vigilantes);
                                } else {
                                    System.out.println("Inicie Sesion primero");
                                }
                                break;
                            case 4:
                                if (sesion.SesionActiva()) {
                                    sesion.getAdminActual().visualizarMercancias(Mercancia.mercancia);

                                } else {
                                    System.out.println("Inicie Sesion primero");
                                }
                                break;
                            case 5:
                                if (sesion.SesionActiva()) {
                                    if (!Pago.pagos_pago.isEmpty()) {
                                        for (int i = 0; i < Pago.pagos_pago.size(); i++) {
                                            Pago pg = Pago.pagos_pago.get(i);
                                            sesion.getAdminActual().getPagos().add(pg);
                                            Pago.pagos_pago.remove(i);
                                        }

                                        sesion.getAdminActual().visualizarPagos( sesion.getAdminActual().getPagos());
                                    } else {
                                        System.out.println("No hay pagos pendientes");
                                    }
                                } else {
                                    System.out.println("Inicie Sesion primero");
                                }
                                break;
                            case 6:
                                if (sesion.SesionActiva()) {

                                    sesion.getAdminActual().visualizarIncidentes(Incidente.incidentes);

                                } else {
                                    System.out.println("Inicie Sesion primero");
                                }
                                break;
                            case 7:
                                 if (sesion.SesionActiva()) {
                                     sesion.getAdminActual().visualizarInvitados(Invitado.invitado);

                                    

                                } else {
                                    System.out.println("Inicie Sesion primero");
                                }
                                break;
                            case 8:
                                sesion.cerrarSesion();
                                break;
                            default:
                                System.out.println("\nERROR: Debe ingresar una opción del 1 al 5.");
                                break;
                        }

                    } while (op1 != 7);

                    break;
                case 2:
                    do {
                        System.out.println("Menú de Propietario");
                        System.out.println("1. Registrarse");
                        System.out.println("2. Iniciar Sesión");
                        System.out.println("3. Salir");
                        System.out.println("Ingrese su elección:");
                        op2 = leer.nextInt();

                        switch (op2) {
                            case 1:
                                System.out.println("Cual es su nombre?");
                                pro_nombre = linea.nextLine();
                                while (vld.validarNombre(pro_nombre)) {
                                    pro_nombre = linea.nextLine();
                                }
                                System.out.println("Cual es su correo?");
                                pro_correo = linea.nextLine();
                                while (vld.validarCorreopropietario(pro_correo, Propietario.propietarios)) {
                                    pro_nombre = linea.nextLine();
                                }
                                System.out.println("Cual es su id?");
                                pro_id = leer.nextInt();
                                while (vld.validarIdPropietario(Propietario.propietarios, pro_id)) {
                                    pro_id = leer.nextInt();
                                }
                                System.out.println("Cual es su contraseña?");
                                pro_contraseña = leer.next();
                                while (vld.validarContraseña(pro_contraseña)) {
                                    pro_contraseña = linea.nextLine();
                                }

                                Propietario propietario = new Propietario(pro_id, pro_nombre, pro_correo, pro_contraseña);
                                Propietario.propietarios.add(propietario);

                                System.out.println("Se ha registrado con exito");

                                break;
                            case 2:
                                String p_correo,
                                 p_contraseña;
                                System.out.println("Cual es su Correo?");
                                p_correo = linea.nextLine();
                                System.out.println("Cual es su contraseña? ");
                                p_contraseña = linea.nextLine();
                                sesion_pro.iniciarSesionPropietario(p_correo, p_contraseña, Propietario.propietarios);

                                if (sesion_pro.SesionActiva() == true) {
                                    do {
                                        System.out.println("_________Bienvenido Propietario________");
                                        System.out.println("1. ver mi ultimo pago");
                                        System.out.println("2. Realizar un Pago");
                                        System.out.println("3. Reportar un Incidente ");
                                        System.out.println("4. Registrar un invitado");
                                        System.out.println("5. ver mis mercancias");
                                        System.out.println("6. Salir");
                                        System.out.println("Ingrese su opcion:");
                                        op3 = leer.nextInt();
                                        switch (op3) {

                                            case 1:
                                                if (sesion_pro.SesionActiva()) {
                                                    propietarioActivo = sesion_pro.getPropietarioActual();
                                                    if (propietarioActivo != null && !propietarioActivo.getMispagos().isEmpty()) {
                                                        Pago ultimoPago = propietarioActivo.getMispagos().get(propietarioActivo.getMispagos().size() - 1);
                                                        System.out.println("Último Pago:");
                                                        System.out.println("_______________________________________");
                                                        System.out.println("ID: " + ultimoPago.getId());
                                                        System.out.println("Fecha de Pago: " + ultimoPago.getFechapago());
                                                        System.out.println("Fecha de Expiración: " + ultimoPago.getFechaexp());
                                                        System.out.println("_______________________________________");

                                                        if (ultimoPago.getFechapago().isAfter(ultimoPago.getFechaexp()) || ultimoPago.getFechapago().isEqual(ultimoPago.getFechaexp())) {
                                                            System.out.println("tu cuota de pago ya expiro");
                                                        } else {
                                                            System.out.println("Vamos. aun estas a tiempo de pagarlo");
                                                        }
                                                    } else {
                                                        System.out.println("No se encontraron pagos.");
                                                    }
                                                } else {
                                                    System.out.println("Debe iniciar sesión primero.");
                                                }

                                                break;
                                            case 2:

                                                System.out.println("----- Realizar Pago -----");

                                                System.out.println("Ingrese Id del pago:");
                                                pago_id = leer.nextInt();

                                                fechaIngresada = LocalDate.now();
                                                System.out.println("Fecha ingresada correctamente: " + fechaIngresada);
                                                fechaexp = fechaIngresada.plusDays(30);
                                                System.out.println("Fecha de expiración antes de crear el pago: " + fechaexp);

                                                Pago pago = new Pago(sesion_pro.getPropietarioActual(), fechaIngresada, fechaexp, pago_id);
                                                sesion_pro.getPropietarioActual().getMispagos().add(pago);
                                                Pago.pagos_pago.add(pago);

                                                System.out.println("Pago realizado exitosamente. Fecha de expiración: " + fechaexp);
                                                break;
                                            case 3:
                                                System.out.println("---- Reportar Incidente ----");
                                                System.out.println("ingrese una id para el reporte(incidente)");
                                                inc_id = leer.nextInt();

                                                System.out.println("ingrese la situacion:");
                                                desc = linea.nextLine();

                                                System.out.println("ingrese la fecha del incidente:");
                                                fecha_inc = linea.nextLine();

                                                try {
                                                    fechaInc = LocalDate.parse(fecha_inc);
                                                    Incidente incidente = new Incidente(inc_id, desc, fechaInc, false, sesion_pro.getPropietarioActual(), null);
                                                    sesion_pro.getPropietarioActual().getIncidente().add(incidente);
                                                    Incidente.incidentes.add(incidente);
                                                    System.out.println("Incidente reportado");
                                                } catch (DateTimeParseException e) {
                                                    System.out.println("Formato de fecha inválido. Por favor, use el formato YYYY-MM-DD.");
                                                    leer.next(); // Limpiar el buffer del scanner

                                                }

                                                break;
                                            case 4:

                                                System.out.println("---- Registrar Invitado ----");
                                                System.out.println("Ingrese ID del Invitado:");
                                                idInvitado = leer.nextInt();
                                                System.out.println("Ingrese nombre del Invitado:");
                                                nombreInvitado = linea.nextLine();
                                                System.out.println("Ingrese correo del Invitado:");
                                                correoInvitado = linea.nextLine();

                                                Invitado invitado = new Invitado(idInvitado, nombreInvitado, correoInvitado, " ", veh);
                                                Invitado.invitado.add(invitado);
                                                sesion_pro.getPropietarioActual().getInvitados().add(invitado);
                                                System.out.println("Invitado registrado.");
                                                break;
                                            case 5:
                                                System.out.println("------ ver mis mercancias ------");
                                                
                                                for (int i = 0; i < Mercancia.mercancia.size(); i++) {
                                                    if (Mercancia.mercancia.get(i).getPropietario().getId() == sesion_pro.getPropietarioActual().getId()) {
                                                        sesion_pro.getPropietarioActual().getMismercancia().add((Mercancia.mercancia.get(i)));
                                                       
                                                    }
                                                }
                                                
                                                if(!(sesion_pro.getPropietarioActual().getMismercancia().isEmpty())){
                                                      System.out.println("-------------Mercancías-------------");
                                                        for (Mercancia mercancia : sesion_pro.getPropietarioActual().getMismercancia()) {
                                                            System.out.println("________________________");
                                                            System.out.println("Nombre: " + mercancia.getNombre());
                                                            System.out.println("Tipo: " + mercancia.getTipo());
                                                            System.out.println("Propietario: " + mercancia.getPropietario().getNombre());
                                                            System.out.println("________________________");
                                                        }
                                                }else{
                                                    System.out.println("no se encuentran mercancias");
                                                }

                                                break;
                                            case 6:
                                                System.out.println("Saliste del menu, volveras al menu anterior");
                                                sesion_pro.cerrarSesion();
                                                break;
                                            default:
                                                System.out.println("\nERROR: Debe ingresar una opción del 1 al 6.");
                                                break;
                                        }

                                    } while (op3 != 6);
                                } else {
                                    System.out.println("papi registrate!!!");
                                }
                                break;
                            case 3:
                                System.out.println("saliendo del menu");
                                break;

                            default:
                                System.out.println("\nERROR: Debe ingresar una opción del 1 al 3.");
                                break;
                        }

                    } while (op2 != 3);
                    break;
                case 3:
                    do {

                        System.out.println("Menú de Vigilante");
                        System.out.println("1. Registrarse");
                        System.out.println("2. Iniciar Sesión");
                        System.out.println("3. Salir");
                        System.out.println("Ingrese su elección:");
                        op4 = leer.nextInt();

                        switch (op4) {
                            case 1:
                                System.out.println("Cual es su nombre?");
                                vig_nombre = linea.nextLine();
                                while (vld.validarNombre(vig_nombre)) {
                                    vig_nombre = linea.nextLine();
                                }
                                System.out.println("Cual es su correo?");
                                vig_correo = linea.nextLine();
                                while (vld.validarCorreovigilante(vig_correo, Vigilante.vigilantes)) {
                                    vig_nombre = linea.nextLine();
                                }
                                System.out.println("Cual es su id?");
                                vig_id = leer.nextInt();
                                while (vld.validarIdVigilante(Vigilante.vigilantes, vig_id)) {
                                    vig_id = leer.nextInt();
                                }

                                System.out.println("Cual es su contraseña?");
                                vig_contraseña = linea.nextLine();
                                while (vld.validarContraseña(vig_contraseña)) {
                                    vig_contraseña = linea.nextLine();
                                }

                                Vigilante vigilante = new Vigilante(vig_id, vig_nombre, vig_correo, vig_contraseña);
                                Vigilante.vigilantes.add(vigilante);

                                System.out.println("Se ha registrado con exito");

                                break;
                            case 2:
                                String v_correo,
                                 v_contraseña;
                                System.out.println("Cual es su Correo?");
                                v_correo = linea.nextLine();
                                System.out.println("Cual es su contraseña? ");
                                v_contraseña = linea.nextLine();

                                sesion_vig.iniciarSesionVigilante(v_correo, v_contraseña, Vigilante.vigilantes);

                                if (sesion_vig.SesionActiva() == true) {
                                    do {
                                        System.out.println("________Bienvenido Vigilante_______");
                                        System.out.println("1. Registrar Incidente");// Registramos tanto como propietarios como vigilantes
                                        System.out.println("2. Registrar Mercancia ");
                                        System.out.println("3. Notificar de Invitado");
                                        System.out.println("4. Salir");
                                        System.out.println("Ingrese su opcion:");
                                        op5 = leer.nextInt();
                                        switch (op5) {
                                            case 1:
                                                System.out.println("------ Registro de incidentes ------");

                                                for (int i = 0; i < Incidente.incidentes.size(); i++) {
                                                    Incidente inc = Incidente.incidentes.get(i);
                                                    if (!inc.isRegistrado()) {
                                                        inc.setRegistrado(true);
                                                        inc.setVigilante(sesion_vig.getVigilanteActual());
                                                        System.out.println("_______________________");
                                                        System.out.println("Incidente registrado: ");
                                                        for (Incidente incidente : Incidente.incidentes) {
                                                            System.out.println("________________________");
                                                            System.out.println("Id: " + incidente.getId());
                                                            System.out.println("Descripción: " + incidente.getInfo());
                                                            System.out.println("Fecha: " + incidente.getFecha());
                                                            System.out.println("Registrado: " + (incidente.isRegistrado() ? "Si" : "No"));
                                                            System.out.println("Propietario: " + incidente.getPropietario().getNombre());

                                                            System.out.println("________________________");
                                                        }
                                                        System.out.println("_______________________");
                                                        System.out.println("");
                                                        sesion_vig.getVigilanteActual().getIncidente().add(inc);
                                                    }

                                                }

                                                break;
                                            case 2:

                                                System.out.println("-------- Registrar Mercancia ------ ");

                                                System.out.println("ingrese el nombre");
                                                mer_nombre = linea.nextLine();
                                                System.out.println("ingrese el tipo de mercancia");
                                                mer_tipo = linea.nextLine();
                                                System.out.println("ingrese la id del propietario al cual pertenece");
                                                id_mer_pro = leer.nextInt();
                                                boolean sw = false;
                                                while (sw == false) {
                                                    for (int i = 0; i < Propietario.propietarios.size(); i++) {
                                                        if (!(Propietario.propietarios.get(i).getId() == id_mer_pro)) {
                                                            System.out.println("ingrese la id del propietario nuevamente");
                                                            id_mer_pro = leer.nextInt();
                                                        } else {
                                                            System.out.println("propietario encontrado");
                                                            propietarioActivo = Propietario.propietarios.get(i);
                                                            sw = true;
                                                        }
                                                    }
                                                }
                                                Mercancia mercancia = new Mercancia(mer_nombre, mer_tipo, propietarioActivo);
                                                Mercancia.mercancia.add(mercancia);
                                                sesion_vig.getVigilanteActual().getMercancia().add(mercancia);
                                                System.out.println("Mercancia registrada");

                                                break;
                                            case 3:

                                                System.out.println("----- Notificar Invitados -----");
                                                System.out.println("Ingresar ID de su invitación:");
                                                id_invt_pro = leer.nextInt();

                                                for (int i = 0; i < Invitado.invitado.size(); i++) {
                                                    if (id_invt_pro == Invitado.invitado.get(i).getId()) {
                                                        inv = Invitado.invitado.get(i);
                                                        Invitado.invitado.remove(i);
                                                        sw1 = true; // Se encontró el invitado con el ID proporcionado
                                                        break; // Salir del bucle una vez encontrado el invitado
                                                    }
                                                }

                                                if (sw1) { // Verificar si se encontró el invitado
                                                    System.out.println("El invitado se encuentra registrado.");
                                                    System.out.println("¿Dispone de un vehículo? (si/no)");
                                                    String disp = leer.next();
                                                    if (disp.equalsIgnoreCase("si")) {
                                                        System.out.println("Ingrese la marca del vehículo del Invitado:");
                                                        String marcaVehiculo = leer.next();
                                                        System.out.println("Ingrese el modelo del vehículo del Invitado:");
                                                        String modeloVehiculo = leer.next();
                                                        System.out.println("Ingrese la placa del vehículo del Invitado:");
                                                        String placaVehiculo = leer.next();

                                                        Vehiculo vehi = new Vehiculo(marcaVehiculo, placaVehiculo, modeloVehiculo);
                                                        inv.setVehiculo(vehi);

                                                        sesion_vig.getVigilanteActual().getInvitado().add(inv);
                                                        Invitado.invitado.addAll(sesion_vig.getVigilanteActual().getInvitado());
                                                        System.out.println("Invitado confirmado con vehículo registrado.");
                                                    } else {
                                                        sesion_vig.getVigilanteActual().getInvitado().add(inv);
                                                        Invitado.invitado.addAll(sesion_vig.getVigilanteActual().getInvitado());
                                                        System.out.println("Invitado confirmado sin vehículo.");
                                                    }
                                                } else {
                                                    System.out.println("No se encontró el invitado con el ID proporcionado.");
                                                }
                                                break;
                                            case 4:
                                                sesion_vig.cerrarSesion();
                                                break;
                                            default:
                                                System.out.println("\nERROR: Debe ingresar una opción del 1 al 4.");
                                                break;
                                        }

                                    } while (op5 != 4);
                                }

                                break;
                            case 3:
                                System.out.println("saliendo del menu");
                                break;

                            default:
                                System.out.println("\nERROR: Debe ingresar una opción del 1 al 3.");
                                break;
                        }
                    } while (op4 != 3);
                    break;
                case 4:
                    System.out.println("gracias por usar nuestro programa!!");
                    break;
                default:
                    System.out.println("\nERROR");
                    break;
            }

        } while (op
                != 4);

        GestorArchivo.escribirArchivo(
                "¡Hasta luego!");
    }
}
