/**
 * Nombre del programa: Ejercicio 05 - 23648
 * Descripción: Polimorfismo vía herencia
 * Proyecto realizado para la clase de Programación orientada a objetos
 * Autor: Leonardo Dufrey Mejía Mejía
 * Fecha de creación: 15 de octubre de 2023
 * Fecha de última modificación: 16 de octubre de 2023
 * Fuentes de información: [crédito a toda fuente de información que haya aportado al desarrollo del programa]
 */

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Torneo uvg = new Torneo();
        Scanner teclado = new Scanner(System.in);

        String opciones = "1. Agregar Jugador. \n 2. Mostrar Jugador. \n 3. Mejores Liberos. \n 4. Pasadores con 80%. \n 5. Salir";
        int op = 0;
        boolean continuar = true;
        while (continuar) {
            System.out.println(opciones);
            System.out.println("Ingrese la opción deseada: ");
            op = teclado.nextInt();
            teclado.nextLine(); 

            switch (op) { //Switch con las opciones del menú.
                case 1:
                    uvg.añadirJugador();
                    break;

                case 2:
                    uvg.mostrarJugadores();
                    break;
                case 3:
                    uvg.mejoresLiberos();
                    break;

                case 4:
                 int pasadoresCount = uvg.PasadoresConAltaEfectividad();
                 System.out.println("La cantidad de pasadores con más de 80% de efectividad son: " + pasadoresCount);
                 break;
            
                case 5:
                    continuar = false;
                    System.out.println("Gracias por usar el programa");
                    break;

                default:
                    System.out.println("Ingrese un número válido");
            }
        }
    }
}
