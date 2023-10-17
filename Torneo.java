/**
 * Nombre del programa: Ejercicio 05 - 23648
 * Descripción: Polimorfismo vía herencia
 * Proyecto realizado para la clase de Programación orientada a objetos
 * Autor: Leonardo Dufrey Mejía Mejía
 * Fecha de creación: 15 de octubre de 2023
 * Fecha de última modificación: 16 de octubre de 2023
 * Fuentes de información: [crédito a toda fuente de información que haya aportado al desarrollo del programa]
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Torneo {
    private ArrayList<Jugador> Jugadores; 
    Scanner scanner = new Scanner(System.in); 

    /**
     * 
     */
    public Torneo(){
        Jugadores = new ArrayList<Jugador>(); 
    }


    public void agregarJugador(String nombre, String pais, int errores, int aces, int totalDeServicios, int pasador, int fintas,  int recibosEfectivos,  int ataques,
    int bloqueosEfectivos, int bloqueosFallidos, int tipoJugador){
        switch (tipoJugador){
            case 1: 
            AuxiliarOpuesto AuxiliarOpuesto = new AuxiliarOpuesto(nombre, pais, errores, aces, totalDeServicios, ataques,
            bloqueosEfectivos, bloqueosFallidos);
            Jugadores.add(AuxiliarOpuesto); 
            break; 
            case 2: 
            Libero Libero = new Libero(nombre, pais, errores, aces, totalDeServicios, recibosEfectivos); 
            Jugadores.add(Libero);
            case 3: 
            pasador pas = new pasador(nombre,pais, errores, aces, totalDeServicios, pasador, fintas); 
            Jugadores.add(pas); 
            case 4:
            break; 
        }
        }
        
        /**
         * 
         */
        public void añadirJugador() { //Le pido al usuario todos los datos que necesito para crear al jugador.
            System.out.println("Bienvenido a continuación, agrega la información del jugador, si no aplica solo escribe 0");
            System.out.println("Ingrese el nombre del jugador");
            String nombrejugador = scanner.next();
        
            System.out.println("Ingrese el país del jugador");
            String paisjugador = scanner.next();
        
            System.out.println("Ingrese los errores del jugador");
            int erroresjugador = scanner.nextInt();
        
            System.out.println("Ingrese los aces del jugador");
            int acesjugador = scanner.nextInt();
        
            System.out.println("Ingrese el total de servicios del jugador");
            int totaldeServiciojugador = scanner.nextInt();
        
            System.out.println("Ingrese los pases del jugador");
            int pasesjugador = scanner.nextInt();
        
            System.out.println("Ingrese las fintas del jugador");
            int fintasjugador = scanner.nextInt();
        
            System.out.println("Ingrese los recibos efectivos del jugador");
            int recibosEfectivosjugador = scanner.nextInt();
        
            System.out.println("Ingrese los ataques del jugador");
            int ataquesjugador = scanner.nextInt();

            System.out.println("Ingrese los bloqueos efectivos del jugador");
            int bloqueosefectivosjugador = scanner.nextInt();

            System.out.println("Ingrese los bloqueos fallidos del jugador");
            int bloqueosfallidosjugador = scanner.nextInt();
        
            int tipojugadorjugador;
        
            // Este while es para verificar que ingrese una opción válida de portero y extremo para poder usar la información después
            while (true) {
                System.out.println("Ingrese el número según el tipo de jugador que es: \n 1. Auxiliar/Opuesto. \n 2. Libero. \n 3. Pasador");
                tipojugadorjugador = scanner.nextInt();
        
                // Verificamos si la opción ingresada es válida (1, 2 o 3)
                if (tipojugadorjugador == 1 || tipojugadorjugador == 2 || tipojugadorjugador == 3) {
                    break;
                } else {
                    System.out.println("Opción no válida. Por favor, ingrese 1, 2 o 3.");
                }
            }

            agregarJugador(nombrejugador, paisjugador, erroresjugador, acesjugador, totaldeServiciojugador, pasesjugador, fintasjugador, recibosEfectivosjugador, ataquesjugador, bloqueosefectivosjugador, bloqueosfallidosjugador, tipojugadorjugador);
            System.out.println("Jugador agregado exitosamente");
        }


        /**
         * Funcion para mostrar jugadores
         */
        public void mostrarJugadores() {

        System.out.println("Los jugadores inscritos hasta el momento son: ");
         if (!Jugadores.isEmpty()) {
            for (Jugador jugador: Jugadores) {
                System.out.println("Nombre: " + jugador.getNombre()+ " País: " + jugador.getPais());
                System.out.println("------------------------------------");
            }
            }
         else System.out.println("No hay ningun jugador registrado :(");
    }


    public void mejoresLiberos() {
        System.out.println("Los 3 mejores Liberos inscritos hasta el momento son: ");
        
        if (!Jugadores.isEmpty()) {
            ArrayList<Libero> liberos = new ArrayList<>(); // Crear una lista para los liberos
            for (Jugador jugador : Jugadores) {
                if (jugador instanceof Libero) {
                    Libero libero = (Libero) jugador;
                    int efectividad = libero.CalculodeEfectividad(); 
                    libero.setEfectividad(efectividad);
                    liberos.add(libero);
            
            // Definir un comparador personalizado para ordenar por efectividad descendente
            Comparator<Libero> comparador = new Comparator<Libero>() {
                @Override
                public int compare(Libero libero1, Libero libero2) {
                    return Integer.compare(libero2.getEfectividad(), libero1.getEfectividad());
                }
            };
    
            // Ordenar la lista de liberos en función de la efectividad
            Collections.sort(liberos, comparador);
    
            // Mostrar los 3 mejores liberos
            int numMejores = Math.min(3, liberos.size());
            for (int i = 0; i < numMejores; i++) {
               
                System.out.println("Nombre: " + libero.getNombre());
                System.out.println("País: " + libero.getPais());
                System.out.println("Efectividad: " + libero.getEfectividad() + "%");
                System.out.println("------------------------------------");
            }
        } else {
            System.out.println("No hay ningún libero registrado :(");
        }}}

    }

public int PasadoresConAltaEfectividad() {
    int pasadoresConAltaEfectividad = 0;
    
    // Recorrer la lista de pasadores
    for (Jugador jugador : Jugadores) {
        if (jugador instanceof pasador) {
            Jugador pasador = (pasador) jugador;
            int efectividad = pasador.CalculodeEfectividad(); 
            if (efectividad > 80) {
                pasadoresConAltaEfectividad++;
                // Puedes mostrar los detalles del pasador aquí
            }
        } 
    }
    return pasadoresConAltaEfectividad;
}

public void guardarDatosEnCSV() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("jugadores.csv", true))) {
        for (Jugador jugador : Jugadores) {
            String[] datosJugador = jugador.obtenerDatosCSV(); // Debe implementarse en la clase Jugador
            String jugadorCSV = String.join(",", datosJugador);
            writer.write(jugadorCSV);
            writer.newLine();
        }
        System.out.println("Los datos se han guardado en jugadores.csv correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public void cargarDatosDesdeCSV() {
    try (BufferedReader reader = new BufferedReader(new FileReader("jugadores.csv"))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length >= 11) {
                int tipoJugador = 0; // Valor predeterminado 
                try {
                    if (!datos[10].equals("null")) {
                        tipoJugador = Integer.parseInt(datos[10]);
                    } else {
                        // Manejo de valores nulos
                        tipoJugador = 1; 
                    }
                } catch (NumberFormatException e) {
                    
                    tipoJugador = 0; 
                }

                Jugador jugador = null;
                if (tipoJugador == 1) {
                    jugador = new AuxiliarOpuesto(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[8]), Integer.parseInt(datos[9]), Integer.parseInt(datos[10]));
                } else if (tipoJugador == 2) {
                    jugador = new Libero(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[7]));
                } else if (tipoJugador == 3) {
                    jugador = new pasador(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), Integer.parseInt(datos[6]));
                }
                Jugadores.add(jugador);
            } else {
                System.out.println("Error en el formato de datos en la línea: " + linea);
            }
        }
        System.out.println("Los datos se han cargado desde jugadores.csv correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
