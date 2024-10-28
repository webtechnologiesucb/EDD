package com.ucb.ias;

import java.util.*;

class GNodo {
    int id;
    double gPeso;         // Costo desde el inicio hasta el nodo actual
    double hPeso;         // Heurística (estimación del costo hasta el objetivo)
    double fPeso;         // fPeso = gPeso + hPeso
    List<GEnlace> vecinos;
    GNodo generador;

    public GNodo(int id, double hCost) {
        this.id = id;
        this.hPeso = hCost;
        this.gPeso = Double.POSITIVE_INFINITY;
        this.fPeso = Double.POSITIVE_INFINITY;
        this.vecinos = new ArrayList<>();
        this.generador = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
        	return true;
        if (o == null || getClass() != o.getClass()) 
        	return false;
        GNodo nodo = (GNodo) o;
        return id == nodo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class GEnlace {
    GNodo destino;
    double costo;

    public GEnlace(GNodo destino, double costo) {
        this.destino = destino;
        this.costo = costo;
    }
}

public class BidirectionalAStar {
    public List<GNodo> buscar(GNodo inicio, GNodo meta) {
        PriorityQueue<GNodo> conjuntoAbiertoInicial = 
        		new PriorityQueue<>(Comparator.comparingDouble(n -> n.fPeso));
        PriorityQueue<GNodo> conjuntoAbiertoMeta = 
        		new PriorityQueue<>(Comparator.comparingDouble(n -> n.fPeso));
        Map<GNodo, GNodo> entradaInicial = new HashMap<>();
        Map<GNodo, GNodo> entradaMeta = new HashMap<>();
        Set<GNodo> salidaInicial = new HashSet<>();
        Set<GNodo> salidaMeta = new HashSet<>();

        inicio.gPeso = 0;
        inicio.fPeso = heuristico(inicio, meta);
        meta.gPeso = 0;
        meta.fPeso = heuristico(meta, inicio);
        conjuntoAbiertoInicial.add(inicio);
        conjuntoAbiertoMeta.add(meta);

        while (!conjuntoAbiertoInicial.isEmpty() && !conjuntoAbiertoMeta.isEmpty()) {
            // Expansión desde el inicio
            if (!conjuntoAbiertoInicial.isEmpty()) {
                GNodo inicioActual = conjuntoAbiertoInicial.poll();
                salidaInicial.add(inicioActual);
                if (salidaMeta.contains(inicioActual)) {
                    return construirRuta(inicioActual, entradaInicial, entradaMeta);
                }

                for (GEnlace arista : inicioActual.vecinos) {
                    GNodo vecino = arista.destino;
                    double tentativeGCost = inicioActual.gPeso + arista.costo;
                    if (!salidaInicial.contains(vecino) && tentativeGCost < vecino.gPeso) {
                        entradaInicial.put(vecino, inicioActual);
                        vecino.gPeso = tentativeGCost;
                        vecino.fPeso = tentativeGCost + heuristico(vecino, meta);
                        if (!conjuntoAbiertoInicial.contains(vecino)) {
                            conjuntoAbiertoInicial.add(vecino);
                        }
                    }
                }
            }

            // Expansión desde el objetivo
            if (!conjuntoAbiertoMeta.isEmpty()) {
                GNodo metaActual = conjuntoAbiertoMeta.poll();
                salidaMeta.add(metaActual);
                if (salidaInicial.contains(metaActual)) {
                    return construirRuta(metaActual, entradaInicial, entradaMeta);
                }
                for (GEnlace arista : metaActual.vecinos) {
                    GNodo vecino = arista.destino;
                    double gPesoTentativo = metaActual.gPeso + arista.costo;

                    if (!salidaMeta.contains(vecino) && gPesoTentativo < vecino.gPeso) {
                        entradaMeta.put(vecino, metaActual);
                        vecino.gPeso = gPesoTentativo;
                        vecino.fPeso = gPesoTentativo + heuristico(vecino, inicio);
                        if (!conjuntoAbiertoMeta.contains(vecino)) {
                            conjuntoAbiertoMeta.add(vecino);
                        }
                    }
                }
            }
        }

        return Collections.emptyList(); // No se encontró camino
    }

    private double heuristico(GNodo a, GNodo b) {
        return Math.abs(a.id - b.id); // Heurística simple, reemplazar con otra si es necesario
    }

    private List<GNodo> construirRuta(GNodo puntoReunion, Map<GNodo, GNodo> entradaInicial, Map<GNodo, GNodo> entradaMeta) {
        List<GNodo> ruta = new ArrayList<>();
        GNodo actual = puntoReunion;
        while (actual != null) {
            ruta.add(actual);
            actual = entradaInicial.get(actual);
        }
        Collections.reverse(ruta);

        actual = entradaMeta.get(puntoReunion);
        while (actual != null) {
            ruta.add(actual);
            actual = entradaMeta.get(actual);
        }
        return ruta;
    }
    
    public static void main(String[] args) {
        // Crear nodos con heurística inicial (ejemplo arbitrario)
        GNodo inicio = new GNodo(1, 10);
        GNodo nodo2 = new GNodo(2, 8);
        GNodo nodo3 = new GNodo(3, 5);
        GNodo meta = new GNodo(4, 0);  // Heurística de 0 para el nodo objetivo

        // Conectar nodos con aristas (coste arbitrario)
        inicio.vecinos.add(new GEnlace(nodo2, 1.5));
        inicio.vecinos.add(new GEnlace(nodo3, 2.0));
        nodo2.vecinos.add(new GEnlace(meta, 3.0));
        nodo3.vecinos.add(new GEnlace(meta, 1.0));
        nodo2.vecinos.add(new GEnlace(nodo3, 0.5)); // Camino adicional entre nodos

        // Crear instancia del algoritmo Bidirectional A*
        BidirectionalAStar b = new BidirectionalAStar();
        // Ejecutar búsqueda desde start a goal
        List<GNodo> ruta = b.buscar(inicio, meta);

        // Imprimir el resultado
        if (ruta.isEmpty()) {
            System.out.println("No se encontró un camino.");
        } else {
            System.out.print("Camino encontrado: ");
            for (GNodo nodo : ruta) {
                System.out.print(nodo.id + " ");
            }
            System.out.println();
        }
    }
}
