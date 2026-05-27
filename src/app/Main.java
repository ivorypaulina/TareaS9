package app;
import modelo.*;
import servicio.EmpleadoServicio;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmpleadoServicio servicio = new EmpleadoServicio();

        int opcion = 0;

        do {
            try {

                System.out.println("===== CLINICA =====");
                System.out.println("1. Registrar medico");
                System.out.println("2. Registrar administrativo");
                System.out.println("3. Mostrar empleados");
                System.out.println("4. Buscar por cedula");
                System.out.println("5. Eliminar empleado");
                System.out.println("6. Salir");
                System.out.print("Ingrese opcion: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        System.out.print("Cedula: ");
                        String cedula = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = Integer.parseInt(sc.nextLine());

                        System.out.print("Telefono: ");
                        String telefono = sc.nextLine();

                        System.out.print("Correo: ");
                        String correo = sc.nextLine();

                        System.out.print("Especialidad: ");
                        String especialidad = sc.nextLine();

                        System.out.print("Pacientes atendidos: ");
                        int pacientes = Integer.parseInt(sc.nextLine());

                        System.out.print("Valor consulta: ");
                        double valorConsulta = Double.parseDouble(sc.nextLine());

                        Medico medico =
                                new Medico(
                                        cedula,
                                        nombre,
                                        edad,
                                        telefono,
                                        correo,
                                        especialidad,
                                        pacientes,
                                        valorConsulta
                                );

                        servicio.agregarEmpleado(medico);
                        break;

                    case 2:
                        System.out.print("Cedula: ");
                        String c = sc.nextLine();

                        System.out.print("Nombre: ");
                        String n = sc.nextLine();

                        System.out.print("Edad: ");
                        int e = Integer.parseInt(sc.nextLine());

                        System.out.print("Telefono: ");
                        String t = sc.nextLine();

                        System.out.print("Correo: ");
                        String co = sc.nextLine();

                        System.out.print("Departamento: ");
                        String departamento = sc.nextLine();

                        System.out.print("Horas trabajadas: ");
                        int horas = Integer.parseInt(sc.nextLine());

                        System.out.print("Valor hora: ");
                        double valorHora = Double.parseDouble(sc.nextLine());

                        Administrativo admin =
                                new Administrativo(
                                        c,
                                        n,
                                        e,
                                        t,
                                        co,
                                        departamento,
                                        horas,
                                        valorHora
                                );

                        servicio.agregarEmpleado(admin);
                        break;

                    case 3:
                        servicio.mostrarEmpleados();
                        break;

                    case 4:
                        System.out.print("Ingrese cedula: ");
                        String buscar = sc.nextLine();
                        Empleado encontrado = servicio.buscarPorCedula(buscar);

                        if (encontrado != null) {
                            encontrado.mostrarInformacion();

                        } else {
                            System.out.println("Registro no encontrado");
                        }
                        break;

                    case 5:
                        System.out.print("Cedula eliminar: ");
                        String eliminar = sc.nextLine();
                        servicio.eliminarEmpleado(eliminar);
                        break;

                    case 6:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            } catch (NumberFormatException ex) {
                System.out.println("Ingrese numeros validos");

            } catch (Exception ex) {
                System.out.println("Error general");
            }

        } while (opcion != 6);
    }
}