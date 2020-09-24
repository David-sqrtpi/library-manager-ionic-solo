package fp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapturaDatosService {

    public static void capturarDatosAdministrador() throws IOException {

        Administrador administrador = new Administrador();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = "";
            System.out.println("PRIMERO SE DEBE REGISTRAR: ");
            System.out.println("INGRESE SU NOMBRE");
            administrador.setNombre(br.readLine());
            System.out.println("INGRESE SU APELLIDO");
            administrador.setApellido(br.readLine());
            System.out.println("INGRESE SU EDAD");
            administrador.setEdad((int) Float.parseFloat(br.readLine()));
            System.out.println("AGREGUE MÁS DETALLES");
            administrador.setDetalles(br.readLine());
            System.out.println("NUMERO TELEFONICO");
            administrador.setTelefono(br.readLine());
        } catch (NumberFormatException e) {
            System.out.println("VALOR ERRONEO");
        }

    }

    public static ConfiguracionBilioteca capturaDeCantidadLibrosPrestamos() throws IOException {
        ConfiguracionBilioteca biblioteca = new ConfiguracionBilioteca();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        System.out.println("INGRESE EL NUMERO DE LIBROS");
        biblioteca.setNumeroDeLibrosAPrestar((int) Float.parseFloat(br.readLine()));
        return biblioteca;
    }

}
