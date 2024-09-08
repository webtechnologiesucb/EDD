package com.ucb.developer;

import java.util.Objects;

public class ListaEnlazada<T> {
    private Nodo<T> cab; // Nodo cabecera de la lista
    private int totalIndices; // conteo de indices de la lista

    /**
     * Constructor de la Lista Enlazada Inicial
     */
    public ListaEnlazada() {
        this.cab = null;
        this.totalIndices = 0;
    }

    /**
     * Determina el tamaño de la lista enlazada
     * @return La cantidad de nodos de la lista
     */
    public int size(){
        return this.totalIndices;
    }

    /**
     * Encuentra el nodo en una posición específica
     * @param indice La posición del nodo buscado
     * @return El nodo en el índice o nulo si no existe
     */
    private Nodo<T> getNodo(int indice)
    {
        Nodo<T> nodo = cab;
        for(int i = 0; i < indice && nodo != null; i++)
            nodo = nodo.sig;
        return nodo;
    }

    /**
     * Agregar un elemento a la izquierda de la lista.
     * O(n) = O(1) Sólo se realizan n operaciones independientemente del tamaño.
     * @param dato El elemento a agregar
     */
    public void insertarDerecha(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cab == null){
            nuevo.sig = null;
            cab = nuevo;
        } else {
            Nodo<T> aux;
            for(aux = cab; aux.sig!=null; aux = aux.sig);
            aux.sig = nuevo;
            nuevo.sig = null;
        }
        this.totalIndices++;
    }

    /**
     * Agregar un elemento a la izquierda de la lista.
     * O(1) Sólo se realizan una operacion independientemente del tamaño.
     * @param dato El elemento a agregar
     */
    public void insertarIzquierda(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.sig = cab;
        cab = nuevo;
        this.totalIndices++;
    }

    /**
     * Eliminar elementos a la derecha de la lista
     * @param dato Dato a eliminar de la lista
     */
    public void eliminarDerecha(T dato) {
        if (cab == null) {
            return; // La lista está vacía, no hay nada que eliminar
        }
        Nodo<T> act;
        Nodo<T> ant = null;
        for(act = cab; act != null ; act = act.sig) {
            if(act.dato == dato)
                break;
            ant = act;
        }
        if (this.totalIndices>0 && act != null & ant != null)
            ant.sig = act.sig;
        else if (ant!=null) {
            ant.sig = null;
        }
        this.totalIndices--;
    }

    /**
     * Eliminar elementos a la izquierda de la lista
     * @param dato Dato a eliminar de la lista
     */
    public void eliminarIzquierda(T dato) {
        if (cab == null) {
            return; // La lista está vacía, no hay nada que eliminar
        }

        if (cab.dato == dato) {
            Nodo<T> aux = cab;
        	cab = aux.sig;
        	aux = null;
            this.totalIndices--;
        }
    }

    /**
     * Obtener el valor en el índice.
     * O(n) sólo se ejecuta hasta el índice, pero debe iterar
     * @param indice La posición del elemento a regresar
     * @return Los datos en el índice
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    public T get(int indice)
    {
        //si está fuera de los límites, lanza una excepción
        if(indice < 0 || indice >= this.totalIndices)
            throw new IndexOutOfBoundsException(Integer.toString(indice));

        Nodo<T> nodo =  getNodo(indice);
        return nodo.dato; //de lo contrario devolver los datos
    }

    /**
     * Establece el valor de los datos en el índice
     * O(n) no hay elementos cambiantes, pero debe iterar hasta el elemento
     * @param indice La posición del elemento a cambiar
     * @param nuevoValor El nuevo valor
     * @return El valor de los datos anterior en el índice
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    public T set(int indice, T nuevoValor)
    {
        if(indice < 0 || indice >= this.totalIndices)
            throw new IndexOutOfBoundsException(Integer.toString(indice)); //si está fuera de los límites, lanza una excepción

        Nodo<T> node = getNodo(indice); //obtener el nodo en el índice
        T resultado = node.dato; //obtener los datos para regresar
        node.dato = nuevoValor; //reemplazar valor
        return resultado; //devolver datos eliminados
    }

    /**
     * Insertar el elemento especificado en el índice
     * O(n) sin elementos cambiables; agregar es una operación de tiempo constante,
     * pero aún debe iterarse para encontrar el índice
     * @param indice La posición donde se insertará el ítem.
     * @param item El elemento a insertar
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    public void insertar(int indice, T item)
    {
        if(indice < 0 || indice > this.totalIndices)
            throw new IndexOutOfBoundsException(Integer.toString(indice)); //si está fuera de los límites, lanza una excepción

        if(indice == 0)
            insertarIzquierda(item); //si el índice es el encabezado, agregue el elemento como encabezado
        else{ //de lo contrario, agregue los nuevos datos en el índice dado
            Nodo<T> node = getNodo(indice -1);
            insertarPosterior(node, item);
        }
    }

    /**
     * Añadir elemento al final de la lista
     * O(n) sin desplazamiento de elementos (más rápido que arrayList) pero debe iterar
     * @param item El elemento a añadir
     * @return true (como se especifica en la interfaz Collections)
     */
    public boolean insertar(T item)
    {
        insertar(this.totalIndices, item);
        return true;
    }

    /**
     * Eliminar el elemento en el índice
     * O(n) = O(n) sin desplazamiento de elementos; eliminar es una operación de tiempo constante, aunque sigue habiendo iteración
     * @param indice La posición donde se va a insertar el elemento
     * @return Los datos eliminados
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    public T eliminar(int indice)
    {
        if(indice < 0 || indice > this.totalIndices)
            throw new IndexOutOfBoundsException(Integer.toString(indice)); //si está fuera de los límites, lanza una excepción

        if(indice == 0)
            return eliminarInicio();//si el índice es el encabezado, agregue el elemento como encabezado
        else{ //de lo contrario, agregue los nuevos datos en el índice dado
            Nodo<T> nodo = getNodo(indice -1);
            return eliminarPosterior(nodo);
        }
    }

    /**
     * Método para devolver el índice de un elemento dado
     * O(n) = O(n) iterar para encontrar el ítem
     * @param destino Los datos a buscar
     * @return El índice del nodo de referencia a los datos
     */
    public int indexOf(T destino)
    {
        Nodo<T> aux;
        int i = 0;
        for (aux = cab; aux != null && aux.dato != destino; aux = aux.sig)
            i++;
        if(aux != null)
            return i;
        return -1; // no encontramos el objetivo
    }

    /**
     * Eliminar la primera ocurrencia del elemento item
     * O(n) = O(n) debe iterar a través de la lista para encontrar item, pero no hay necesidad de desplazar elementos hacia adelante
     * @param item El elemento a eliminar
     * @return true si se encuentra el elemento y se elimina, en caso contrario, devuelve false
     */
    public boolean eliminar(T item)
    {
        int itemQuitado = indexOf(item);
        if(itemQuitado == -1)
            return false;
        else
            eliminar(itemQuitado);
        return true;
    }

    /**
     * Inserta un nuevo elemento antes del que está en la posición índice,
     * Empezando en 0 para la cabecera de la lista. El nuevo elemento se inserta entre
     * el que está en la posición índice -1 y el que estaba antes en la posición índice
     * O(n) debe iterar por la lista
     * @param indice el índice donde se va a insertar el nuevo elemento
     * @param item El elemento a insertar
     */
    public void insertarSinAyuda(int indice, T item)
    {
        if(indice < 0 || indice > this.totalIndices + 1)
            throw new IndexOutOfBoundsException(Integer.toString(indice));
        if(indice == 0)
        {
            cab = new Nodo<>(item, cab); //hacer de la última cabeza el segundo elemento
            this.totalIndices++; //aumentar tamaño
        }
        else{
            Nodo<T> nodo = getNodo(indice -1);
            nodo.sig = new Nodo<>(item, nodo.sig);
            this.totalIndices++;
        }
    }

    /**
     * Añadir un nodo después de un nodo dado
     * @param nodo El nodo que precede al nuevo elemento
     * @param item El elemento a insertar
     */
    private void insertarPosterior(Nodo<T> nodo, T item)
    {
        nodo.sig = new Nodo<>(item, nodo.sig);
        this.totalIndices++;
    }

    /**
     * Eliminar el nodo después de un nodo dado
     * @param nodo El nodo anterior al que se va a eliminar
     * @return Los datos del nodo eliminado, o null si no hay ningún nodo que eliminar
     */
    private T eliminarPosterior(Nodo<T> nodo)
    {
        Nodo<T> ant = nodo.sig; //referencia temporal al nodo que eliminaremos
        if(ant != null) //si hay un nodo para eliminar
        {
            nodo.sig = ant.sig; //eliminarlo
            this.totalIndices = this.totalIndices > 0 ? this.totalIndices-- : 0; //disminuir tamaño
            return ant.dato; //devolver los datos eliminados
        }
        return null; //de lo contrario devolver nulo
    }

    /**
     * Eliminar el primer nodo de la lista
     * @return Los datos del nodo eliminado o nulos si la lista está vací
     */
    private T eliminarInicio()
    {
        Nodo<T> ant = cab;
        if(cab != null) // si hay una cabecera
        {
            cab = cab.sig; // retire la cabecera y haga referencia al siguiente elemento
            this.totalIndices = this.totalIndices > 0 ? this.totalIndices-- : 0; //disminuir el tamaño
            return ant.dato; // devolver los datos de la cabecera
        }
        return null; // devuelve nulo si no hay cabecera
    }

    /**
     * Devuelve una representación de cadena de la lista vinculada
     * O(n) El orden de magnitud depende del tamaño de la lista
     */
    @Override
    public String toString() {
        Nodo<T> aux;
        StringBuilder resultado = new StringBuilder();
        resultado.append("CAB\u2192");
        for (aux = cab; aux != null; aux = aux.sig)
            resultado.append(aux.dato + "\u2192");
        resultado.append("NULL");
        return resultado.toString();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cab, totalIndices);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) 
        	return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
		ListaEnlazada<T> otra = (ListaEnlazada<T>) obj;
        Nodo<T> actual1 = this.cab;
        Nodo<T> actual2 = otra.cab;
        while (actual1 != null && actual2 != null) {
            if (!Objects.equals(actual1.dato, actual2.dato)) 
                return false;
            
            actual1 = actual1.sig;
            actual2 = actual2.sig;
        }
        return actual1 == null && actual2 == null;
    }

    public void sumar() {
        Nodo<T> aux;
        int suma = 0;
        for(aux = cab; aux != null; aux = aux.sig)
            suma += (int) aux.dato;
        System.out.print("Suma:" + suma);
        System.out.println();
    }

    /**
     * Clase Nodo
     * @param <T> Parametros genericos
     */
    public static class Nodo<T> {
        private T dato; // datos del nodo
        private Nodo<T> sig; // puntero al proximo nodo

        private Nodo(T dato) {
            this.dato = dato;
            this.sig = null;
        }

        private Nodo(T item, Nodo<T> actual)
        {
            dato = item;
            sig = actual;
        }
    }
}
