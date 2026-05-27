package servicio;
import modelo.*;
import java.util.ArrayList;

public class EmpleadoServicio {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado e) {

        for (Empleado emp : empleados) {
            if (emp.getCedula().equals(e.getCedula())) {
                System.out.println("Cedula duplicada");
                return;
            }
        }
        empleados.add(e);
        System.out.println("Empleado registrado");
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No existen empleados");
            return;
        }

        for (Empleado e : empleados) {
            System.out.println("==============");
            e.mostrarInformacion();
        }
    }

    public Empleado buscarPorCedula(String cedula) {
        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public void eliminarEmpleado(String cedula) {
        Empleado encontrado = buscarPorCedula(cedula);
        if (encontrado != null) {
            empleados.remove(encontrado);
            System.out.println("Empleado eliminado");

        } else {
            System.out.println("Registro no encontrado");
        }
    }
}