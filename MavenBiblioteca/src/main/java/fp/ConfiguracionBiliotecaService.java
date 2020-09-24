package fp;

public class ConfiguracionBiliotecaService {

    public static void modificarCantidadLibrosPrestamo(ConfiguracionBilioteca configuracionBilioteca) {

        System.out.println("VALOR MODIFICADO:"
                + "\n" + " SOLAMENTE SE PODRÁ PRESTAR, COMO MÁXIMO " + configuracionBilioteca.getNumeroDeLibrosAPrestar() + " LIBROS ");
    }

}