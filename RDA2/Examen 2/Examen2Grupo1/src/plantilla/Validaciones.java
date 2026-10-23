package plantilla;

/**
 * Métodos para revisar lo que el usuario escribe en los campos.
 * Todos devuelven true si el dato está bien y false si está mal.
 */
public class Validaciones {

    public static boolean estaVacio(String texto) {
        return texto == null || texto.isBlank();
    }

    // Cédula ecuatoriana con el algoritmo del módulo 10
    public static boolean validarCedula(String cedula) {
        if (!cedula.matches("\\d{10}")) {
            return false;
        }
        int provincia = Integer.parseInt(cedula.substring(0, 2));
        if (provincia < 1 || (provincia > 24 && provincia != 30)) {
            return false;
        }
        if (cedula.charAt(2) >= '6') {
            return false;
        }
        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = cedula.charAt(i) - '0';
            // Las posiciones pares se multiplican por 2 y las impares por 1
            int producto = (i % 2 == 0) ? digito * 2 : digito;
            if (producto > 9) {
                producto = producto - 9;
            }
            suma = suma + producto;
        }
        int verificador = (10 - (suma % 10)) % 10;
        return verificador == cedula.charAt(9) - '0';
    }

    // Celular de 10 dígitos que empieza con 09
    public static boolean validarTelefono(String telefono) {
        return telefono.matches("09\\d{8}");
    }

    public static boolean validarCorreo(String correo) {
        return correo.matches("[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+");
    }

    // Solo letras (con tildes y ñ) y espacios
    public static boolean validarNombre(String nombre) {
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");
    }

    // Número entero mayor o igual a 0
    public static boolean validarEntero(String numero) {
        try {
            return Integer.parseInt(numero) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Número con decimales mayor a 0
    public static boolean validarDecimal(String numero) {
        try {
            return Double.parseDouble(numero) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
