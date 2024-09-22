package com.ucb.developer;

import java.util.LinkedList;

public class CombinarLista {
    public static LinkedList<Integer> combinarAlternadamente(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
        LinkedList<Integer> resultado = new LinkedList<>();
        int size1 = lista1.size();
        int size2 = lista2.size();
        int maxSize = Math.max(size1, size2);

        for (int i = 0; i < maxSize; i++) {
            if (i < size1) {
                resultado.add(lista1.get(i));
            }
            if (i < size2) {
                resultado.add(lista2.get(i));
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(2);
        lista1.add(3);

        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(4);
        lista2.add(5);
        lista2.add(6);

        LinkedList<Integer> resultado = combinarAlternadamente(lista1, lista2);
        System.out.println("Lista combinada: " + resultado);
    }
}
