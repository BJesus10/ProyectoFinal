

public class GestorTramitesSingleton {
    private static GestorTramites instancia = new GestorTramites();

    public static GestorTramites getInstancia() {
        return instancia;
    }
}
