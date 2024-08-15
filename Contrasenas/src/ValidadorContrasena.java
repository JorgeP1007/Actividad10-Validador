import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ValidadorContrasena implements Runnable {
    private String contrasena;
    private String tipoValidacion;
    private boolean esValido;

    public ValidadorContrasena(String contrasena, String tipoValidacion) {
        this.contrasena = contrasena;
        this.tipoValidacion = tipoValidacion;
        this.esValido = false;
    }

    @Override
    public void run() {
        ContrasenaValidator validator = new ContrasenaValidator();

        switch (tipoValidacion) {
            case "longitud":
                esValido = validator.validarLongitud(contrasena);
                break;
            case "caracterEspecial":
                esValido = validator.validarCaracterEspecial(contrasena);
                break;
            case "mayusculas":
                esValido = validator.validarMayusculas(contrasena);
                break;
            case "minusculas":
                esValido = validator.validarMinusculas(contrasena);
                break;
            case "numeros":
                esValido = validator.validarNumeros(contrasena);
                break;
        }

        String resultado = "Validación de " + tipoValidacion + ": " + (esValido ? "Válida" : "Inválida");
        System.out.println(resultado);
        guardarResultadoEnArchivo(contrasena, resultado);
    }

    // Método para guardar el resultado en un archivo de registro
    private void guardarResultadoEnArchivo(String contrasena, String resultado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("registro_contrasenas.txt", true))) {
            writer.write("Contraseña: " + contrasena + " | " + resultado);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
