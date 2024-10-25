package com.ucb.hashset;

import java.util.HashMap;
import java.util.Map;

public class HashTableExample {
    public static void main(String[] args) {
        // Crear una instancia de HashMap
        Map<String, Integer> itemMap = new HashMap<>();

        // Agregar elementos a la Hash Table
        itemMap.put("Ariana", 25);
        itemMap.put("Roberto", 30);
        itemMap.put("Charlie", 28);
        itemMap.put("Mariana", 35);

        // Acceder a elementos por clave
        int edadAriana = itemMap.get("Ariana");
        System.out.println("Edad de Ariana: " + edadAriana);

        // Verificar si una clave existe en la Hash Table
        boolean contiene = itemMap.containsKey("Daniel");
        System.out.println("¿Daniel está en la Hash Table? " + contiene);

        // Iterar a través de las claves y valores
        for (Map.Entry<String, Integer> entrada : itemMap.entrySet()) {
            String name = entrada.getKey();
            int edad = entrada.getValue();
            System.out.println(name + ": " + edad);
        }

        // Eliminar un elemento por clave
        itemMap.remove("Charlie");

        // Tamaño de la Hash Table
        int size = itemMap.size();
        System.out.println("Tamaño de la Hash Table: " + size);
    }
}