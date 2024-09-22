package com.ucb.developer;

import java.util.LinkedList;

public class MatrizTriangular {
    public static LinkedList<LinkedList<Integer>> crearMatriz(int[][] array) {
        LinkedList<LinkedList<Integer>> matriz = new LinkedList<>();
        for (int[] fila : array) {
            LinkedList<Integer> listaFila = new LinkedList<>();
            for (int elemento : fila) {
                listaFila.add(elemento);
            }
            matriz.add(listaFila);
        }
        return matriz;
    }

    public static LinkedList<LinkedList<Integer>> obtenerTriangularSuperior(LinkedList<LinkedList<Integer>> matriz) {
        LinkedList<LinkedList<Integer>> triangularSuperior = new LinkedList<>();
        for (int i = 0; i < matriz.size(); i++) {
            LinkedList<Integer> fila = new LinkedList<>();
            for (int j = 0; j < matriz.get(i).size(); j++) {
                if (j >= i) {
                    fila.add(matriz.get(i).get(j));
                } else {
                    fila.add(0);
                }
            }
            triangularSuperior.add(fila);
        }
        return triangularSuperior;
    }

    public static LinkedList<LinkedList<Integer>> obtenerTriangularInferior(LinkedList<LinkedList<Integer>> matriz) {
        LinkedList<LinkedList<Integer>> triangularInferior = new LinkedList<>();
        for (int i = 0; i < matriz.size(); i++) {
            LinkedList<Integer> fila = new LinkedList<>();
            for (int j = 0; j < matriz.get(i).size(); j++) {
                if (j <= i) {
                    fila.add(matriz.get(i).get(j));
                } else {
                    fila.add(0);
                }
            }
            triangularInferior.add(fila);
        }
        return triangularInferior;
    }

    public static void mostrarMatriz(LinkedList<LinkedList<Integer>> matriz) {
        for (LinkedList<Integer> fila : matriz) {
            System.out.println(fila);
        }
    }

    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        LinkedList<LinkedList<Integer>> matriz = crearMatriz(array);

        System.out.println("Matriz Original:");
        mostrarMatriz(matriz);

        LinkedList<LinkedList<Integer>> triangularSuperior = obtenerTriangularSuperior(matriz);
        System.out.println("\nTriangular Superior:");
        mostrarMatriz(triangularSuperior);

        LinkedList<LinkedList<Integer>> triangularInferior = obtenerTriangularInferior(matriz);
        System.out.println("\nTriangular Inferior:");
        mostrarMatriz(triangularInferior);
    }
}
 
