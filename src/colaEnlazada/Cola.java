package colaEnlazada;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tam;

    public Cola() {
        frente = null;
        fin = null;
        tam = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int tamanio() {
        return tam;
    }

    // insertar elemento.
    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tam++;
    }

    // extraer elemento
    public T extraer() {
        if (estaVacia()) return null;
        T valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        tam--;
        return valor;
    }

    // obtener el primer elemento de la cola
    public T obtenerPrimero() {
        return estaVacia() ? null : frente.dato;
    }

    public T obtenerUltimo() { return estaVacia() ? null : fin.dato; }

    public T obtenerEnPosicion1Base(int pos) {
        if (pos < 1 || pos > tam) return null;
        Nodo<T> actual = frente;
        for (int i = 1; i < pos; i++) actual = actual.siguiente;
        return actual.dato;
    }

    public void vaciar() { frente = fin = null; tam = 0; }

    public String formatoVisual() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = frente;
        while (actual != null) {
            sb.append("|").append(actual.dato).append("|").append("-->");
            actual = actual.siguiente;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
