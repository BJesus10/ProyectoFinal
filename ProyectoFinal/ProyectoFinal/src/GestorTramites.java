

public class GestorTramites {
    private ListaDoble<Expediente> expedientes;

    public GestorTramites() {
        expedientes = new ListaDoble<>();
    }

    // Agregar un expediente a la lista
    public void agregarExpediente(Expediente e) {
        expedientes.agregarFinal(e);
    }

    // Obtener todos los expedientes registrados
    public ListaDoble<Expediente> obtenerExpedientes() {
        return expedientes;
    }

    // Obtener cuántos expedientes hay (para generar el ID)
    public int obtenerCantidadExpedientes() {
        return expedientes.tamano();
    }
    
    // Buscar un expediente por ID
    public Expediente buscarPorId(int id) {
        for (int i=0; i < expedientes.tamano(); i++) {
            Expediente e = expedientes.obtener(i);
            if (e.id == id) {
                return e;
            }
        }
        return null; // No encontrado
    }
}


