package org.uv.dapp02practica02;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        ConectionSQL con = ConectionSQL.getInstance();

        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        
        EmpleadoPojo pojo = new EmpleadoPojo(1, "Adsoftsito", "Calle 26A Av 19 y 21", "2711778353");
        
        EmpleadoPojo resultadoGuardar = empleadoDAO.guardar(pojo);
        if (resultadoGuardar != null) {
            System.out.println("Exito: Empleado guardado correctamente");
        } else {
            System.out.println("Error: No se pudo guardar el empleado");
        }

        pojo.setNombre("Adsoftsito Modificado");
        EmpleadoPojo resultadoModificar = empleadoDAO.modificar(pojo, 1L);
        if (resultadoModificar != null) {
            System.out.println("Exito: Empleado modificado correctamente");
        } else {
            System.out.println("Error: No se pudo modificar el empleado");
        }

        boolean eliminado = empleadoDAO.eliminar(1L);
        if (eliminado) {
            System.out.println("Exito: Empleado eliminado correctamente");
        } else {
            System.out.println("Error: No se pudo eliminar el empleado");
        }

        con.cerrarConexion();
        
        System.out.println("Pruebas finalizadas");
    }
}
