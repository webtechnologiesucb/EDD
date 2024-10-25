package com.ucb.hashset;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapTreeSetExample {
    public static void main(String[] args) {
        // Crear un TreeMap para asociar nombres con edades (ordenado por clave)
        Map<String, Integer> treeMap = new TreeMap<>();

        // Agregar elementos al TreeMap
        treeMap.put("Alice", 25);
        treeMap.put("Bob", 30);
        treeMap.put("Charlie", 28);
        treeMap.put("David", 35);

        // Crear un TreeSet para almacenar edades (ordenado naturalmente)
        Set<Integer> treeSet = new TreeSet<>();

        // Agregar edades al TreeSet
        treeSet.add(25);
        treeSet.add(30);
        treeSet.add(28);
        treeSet.add(35);

        // Acceder a elementos en el TreeMap
        int edadDeAlice = treeMap.get("Alice");
        System.out.println("Edad de Alice: " + edadDeAlice);

        // Verificar si un nombre existe en el TreeMap
        boolean contieneEve = treeMap.containsKey("Eve");
        System.out.println("¿El TreeMap contiene a Eve? " + contieneEve);

        // Iterar a través de los nombres y edades en el TreeMap
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String nombre = entry.getKey();
            int edad = entry.getValue();
            System.out.println(nombre + ": " + edad);
        }

        // Verificar si una edad existe en el TreeSet
        boolean contiene35 = treeSet.contains(35);
        System.out.println("¿El TreeSet contiene 35? " + contiene35);

        // Iterar a través de las edades en el TreeSet
        System.out.println("Edades en el TreeSet:");
        for (int edad : treeSet) {
            System.out.println(edad);
        }
    }
}

