package com.ucb.developer;

import java.util.LinkedList;

public class ElementoMedio {
    public static void encontrarElementoMedio(LinkedList<Integer> lista) {
        int size = lista.size();
        if (size == 0) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (size % 2 == 1) {
            // Si el tamaño es impar, devuelve el elemento central
            int medio = size / 2;
            System.out.println("Elemento medio: " + lista.get(medio));
        } else {
            // Si el tamaño es par, devuelve los dos elementos centrales
            int medio1 = (size / 2) - 1;
            int medio2 = size / 2;
            System.out.println("Elementos medios: " + lista.get(medio1) + " y " + lista.get(medio2));
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        //lista.add(6);

        encontrarElementoMedio(lista);
    }
}
