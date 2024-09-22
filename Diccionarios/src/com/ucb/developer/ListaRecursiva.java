package com.ucb.developer;

import java.util.LinkedList;

public class ListaRecursiva {
    public static int sumarNodos(LinkedList<Integer> lista, int index) {
        // Caso base: el índice igual a tamaño de lista
        if (index == lista.size()) {
            return 0;
        }
        // Caso recursivo: sumar elemento actual y llamar recursivamente al siguiente
        return lista.get(index) + sumarNodos(lista, index + 1);
    }

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        int suma = sumarNodos(lista, 0);
        System.out.println("La suma de los nodos es: " + suma);
    }
}

