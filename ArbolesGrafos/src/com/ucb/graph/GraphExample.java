package com.ucb.graph;

import java.util.*;

class GrafoA {
    private int V; // Número de vértices
    private Map<Integer, List<Integer>> listaAdyacencia;

    public GrafoA(int v) {
        V = v;
        listaAdyacencia = new HashMap<>();
        for (int i = 0; i < V; i++) {
            listaAdyacencia.put(i, new ArrayList<>());
        }
    }

    // Agregar una arista al grafo
    public void agregarVertice(int v, int w) {
        listaAdyacencia.get(v).add(w);
        listaAdyacencia.get(w).add(v); // Ya que es un grafo no dirigido
    }

    // Imprimir el grafo
    public void imprimirGrafo() {
        for (int v = 0; v < V; v++) {
            System.out.print("Vértice " + v + " está conectado a: ");
            for (Integer vecino : listaAdyacencia.get(v)) {
                System.out.print(vecino + " ");
            }
            System.out.println();
        }
    }
}

public class GraphExample {
    public static void main(String[] args) {
        int V = 5; // Número de vértices en el grafo
        GrafoA grafo = new GrafoA(V);

        // Agregar aristas al grafo
        grafo.agregarVertice(0, 1);
        grafo.agregarVertice(0, 2);
        grafo.agregarVertice(1, 2);
        grafo.agregarVertice(1, 3);
        grafo.agregarVertice(2, 4);

        // Imprimir el grafo
        grafo.imprimirGrafo();
    }
}