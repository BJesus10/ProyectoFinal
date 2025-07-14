


public class ListaDoble<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;

    public ListaDoble() {
        cabeza = null;
        cola = null;
    }

    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
    }

    public void mostrar() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    public int tamano() {
        int contador = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public T obtener(int valor){
        
        Nodo<T> actual = cabeza;
        for (int i = 0; i < valor; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();

    }

    public void agregarFinal(T dato) {
        insertar(dato);
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public Nodo<T> getCola() {
        return cola;
    }
}

