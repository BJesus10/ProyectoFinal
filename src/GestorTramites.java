
import java.util.LinkedList;

public class GestorTramites {
    LinkedList<Expediente> expedientes = new LinkedList<>();

    public void agregarExpediente(Expediente e) {
        expedientes.add(e);
    }

    public LinkedList<Expediente> obtenerExpedientes() {
        return expedientes;
    }
}


