import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolaValidacionContrasena {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la contraseña para validar: ");
        String contrasena = scanner.nextLine();

        // Lista de tipos de validaciones
        List<String> validaciones = List.of("longitud", "caracterEspecial", "mayusculas", "minusculas", "numeros");

        // Lista para almacenar hilos
        List<Thread> hilos = new ArrayList<>();

        // Crear y lanzar hilos utilizando expresiones Lambda
        validaciones.forEach(tipoValidacion -> {
            Thread hilo = new Thread(new ValidadorContrasena(contrasena, tipoValidacion));
            hilos.add(hilo);
            hilo.start();
        });

        // Esperar a que todos los hilos terminen
        hilos.forEach(hilo -> {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Validación completa. Resultados guardados en registro_contrasenas.txt");
    }
}
