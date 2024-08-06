import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase genérica de Lista
 * @param <T> Tipo de dato genérico
 */
public class Lista<T> implements Iterable<T> {
    private T[] datos; // vector genérico de datos
    private int total; // tamaño de la lista
    private static final int TOTAL_BASICO = 1000; // valor por defecto

    /**
     * Constructor por defecto
     */
    @SuppressWarnings("unchecked")
    public Lista() {
        this.datos = (T[]) new Object[TOTAL_BASICO];
        this.total = 0;
    }

    /**
     * Constructor con vector definido
     * @param data Los datos a ingresar en vector definido
     */
    @SuppressWarnings("unchecked")
    public Lista(T[] data) {
        this.datos = (T[]) new Object[data.length];
        System.arraycopy(data, 0, this.datos, 0, data.length);
        this.total = data.length;
    }

    /**
     * Constructor con vector y tamaño definido 
     * @param datos Los datos a ingresar en vector definido
     * @param total Tamaño del vector ingresado
     */
    public Lista(T[] datos, int total) {
        this.datos = datos;
        this.total = total;
    }

    /**
     * Agrega un elemento al listado
     * @param elemento Item a agregar
     */
    public void add(T elemento) {
        if (this.total == this.datos.length) {
            resize();
        }
        this.datos[this.total++] = elemento;
    }

    /**
     * Redimensiona el array cuando está lleno
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newDatos = (T[]) new Object[this.datos.length * 2];
        System.arraycopy(this.datos, 0, newDatos, 0, this.total);
        this.datos = newDatos;
    }

    /**
     * Obtiene un elemento del listado
     * @param indice Posición del índice del listado
     * @return El valor en el índice definido
     */
    public T get(int indice) {
        if (indice >= this.total || indice < 0) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return this.datos[indice];
    }

    /**
     * Obtiene el tamaño del listado
     * @return Un número entero con el tamaño del listado
     */
    public int size() {
        return this.total;
    }

    /**
     * Elimina un elemento del índice
     * @param indice Índice para quitar de la lista
     */
    public void remove(int indice) {
        if (indice >= this.total || indice < 0) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        for (int i = indice; i < this.total - 1; i++) {
            this.datos[i] = this.datos[i + 1];
        }
        this.total--;
        this.datos[this.total] = null; // Limpia el ultimo elemento
    }

    /**
     * Insertar datos en el índice mencionado
     * @param elemento Elemento a ingresar
     * @param indice Índice donde se hará ingresar el elemento
     */
    public void insert(T elemento, int indice) {
        if (indice > this.total || indice < 0) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (this.total == this.datos.length) {
            resize();
        }
        for (int i = this.total; i > indice; i--) {
            this.datos[i] = this.datos[i - 1];
        }
        this.datos[indice] = elemento;
        this.total++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < total;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return datos[currentIndex++];
            }
        };
    }
}
