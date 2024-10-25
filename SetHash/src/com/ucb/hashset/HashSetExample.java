package com.ucb.hashset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // Crear una instancia de HashSet
        Set<String> frutasHash = new HashSet<>();

        // Agregar elementos al HashSet
        frutasHash.add("Manzana");
        frutasHash.add("Banana");
        frutasHash.add("Cereza");
        frutasHash.add("Durazno");

        // Mostrar los elementos del HashSet
        System.out.println("Elementos en el HashSet: " + frutasHash);

        // Verificar si un elemento existe en el HashSet
        boolean contieneBanana = frutasHash.contains("Banana");
        System.out.println("¿El HashSet contiene Banana? " + contieneBanana);

        // Eliminar un elemento del HashSet
        frutasHash.remove("Cereza");

        // Iterar a través de los elementos del HashSet usando un Iterator
        Iterator<String> recorrido = frutasHash.iterator();
        while (recorrido.hasNext()) {
            String fruta = recorrido.next();
            System.out.println(fruta);
        }

        // Tamaño del HashSet
        int tamano = frutasHash.size();
        System.out.println("Tamaño del HashSet: " + tamano);
    }
}

