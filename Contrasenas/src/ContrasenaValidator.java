import java.util.regex.Pattern;

public class ContrasenaValidator {

    public boolean validarLongitud(String contrasena) {
        return contrasena.length() >= 8;
    }

    public boolean validarCaracterEspecial(String contrasena) {
        String regex = "[!@#$%^&*(),.?\":{}|<>]";
        return Pattern.compile(regex).matcher(contrasena).find();
    }

    public boolean validarMayusculas(String contrasena) {
        String regex = "[A-Z]";
        long count = contrasena.chars().filter(ch -> Pattern.matches(regex, Character.toString(ch))).count();
        return count >= 2;
    }

    public boolean validarMinusculas(String contrasena) {
        String regex = "[a-z]";
        long count = contrasena.chars().filter(ch -> Pattern.matches(regex, Character.toString(ch))).count();
        return count >= 3;
    }

    public boolean validarNumeros(String contrasena) {
        String regex = "[0-9]";
        return Pattern.compile(regex).matcher(contrasena).find();
    }
}
