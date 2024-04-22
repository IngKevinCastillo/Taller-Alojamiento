/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallersistemaalojamiento;

import java.time.*;
import java.util.*;

/**
 *
 * @author Jairo F
 */
public class Ppal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int OP, numPersonas = 0, codigo, nCuartos = 0, CB, dia, mes, año;
        String direccion, ciudad, pais, datos;
        char AHC;
        ICrudRegistroAlojamiento registro = new RegistroAlojamientoImpArrayList();
        
        do{
            System.out.println("\n\n\t*****Menu*****");
            System.out.println("1. Agregar Datos.");
            System.out.println("2. Cotizar Datos.");
            System.out.println("3. Eliminar Dato");
            System.out.println("4. Listar Datos");
            System.out.println("5. Salir.");
            
            System.out.print("Elige una opcion: ");
            OP = entrada.nextInt();
            
            if (OP == 1) {
            System.out.print("Desea alquilar una habitacion o una cabaña? (h/c) ");
            AHC = entrada.next().charAt(0);
            entrada.nextLine(); // vaciar el buffer.
            if (AHC == 'h') {
                System.out.print("Digite el numero de personas: ");
                numPersonas = entrada.nextInt();
                System.out.print("Digite el codigo: ");
                codigo = entrada.nextInt();
                entrada.nextLine();
                System.out.print("Digite la direccion: ");
                direccion = entrada.nextLine();
                System.out.print("Digite la ciudad: ");
                ciudad = entrada.nextLine();
                System.out.print("Digite el pais: ");
                pais = entrada.nextLine();

                Alojamiento hab = new Habitacion(numPersonas, codigo, direccion, ciudad, pais);
                registro.agregarAlojamiento(hab);
                System.out.print(hab + " registrado.\n");
            } else {
                System.out.print("Digite el numero de cuartos: ");
                nCuartos = entrada.nextInt();
                System.out.print("Digite el codigo: ");
                codigo = entrada.nextInt();
                entrada.nextLine();
                System.out.print("Digite la direccion: ");
                direccion = entrada.nextLine();
                System.out.print("Digite la ciudad: ");
                ciudad = entrada.nextLine();
                System.out.print("Digite el pais: ");
                pais = entrada.nextLine();

                Alojamiento cab = new Cabaña(nCuartos, codigo, direccion, ciudad, pais);
                registro.agregarAlojamiento(cab);
                System.out.print(cab + " registrado\n");
            }
        } else if (OP == 2) {
            System.out.println("\nEjemplo de busqueda y cotizacion de alojamiento");
            System.out.print("Digite el codigo a cotizar: "); CB = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Digite la fecha maxima de arriendo (AA/MM/DD): ");
            datos = entrada.nextLine();
            String partes[] = datos.split("/");
            año = Integer.parseInt(partes[0]);
            mes = Integer.parseInt(partes[1]);
            dia = Integer.parseInt(partes[2]);
            Alojamiento buscado = registro.buscar(CB);
            if (buscado != null) {
                Cotizacion cothab = new Cotizacion(LocalDate.now(), LocalDate.of(año, mes, dia), buscado);
                System.out.println(cothab);
            } else {
                System.out.println("El alojamiento no esta registrado");
            }
        } else if (OP == 3) {
            System.out.println("\nEjemplo de eliminacion y cotizacion de alojamiento");
            System.out.print("Digite el codigo a eliminar: "); CB = entrada.nextInt();
            entrada.nextLine();
            Alojamiento eliminar = registro.buscar(CB);
            registro.eliminar(eliminar);
            Alojamiento buscado = registro.buscar(CB);
            if (buscado != null) {
                System.out.print("Digite el codigo a cotizar: "); CB = entrada.nextInt();
                entrada.nextLine();

                System.out.print("Digite la fecha maxima de arriendo: ");
                datos = entrada.nextLine();
                String partes[] = datos.split("/");
                año = Integer.parseInt(partes[0]);
                mes = Integer.parseInt(partes[1]);
                dia = Integer.parseInt(partes[2]);
                Cotizacion cothab = new Cotizacion(LocalDate.now(), LocalDate.of(año, mes, dia), buscado);
                System.out.println(cothab);
            } else {
                System.out.println("El alojamiento no esta registrado");
            }
        } else if (OP == 4) {
            registro.obtenerAlojamientos();
        } else if (OP == 5) {
            System.out.println("\nSaliendo del programa...");
        } else {
            System.out.println("\nElija una opcion valida.");
        }

        }while(OP != 5);
    }
}
