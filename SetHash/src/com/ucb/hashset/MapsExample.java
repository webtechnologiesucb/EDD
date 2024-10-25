package com.ucb.hashset;
import java.util.HashMap;
import java.util.Map;

public class MapsExample {
    public static void main(String[] args) {
        // Crear una instancia de HashMap
        Map<String, Integer> hashMap = new HashMap<>();

        // Agregar elementos al mapa
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 28);
        hashMap.put("David", 35);

        // Acceder a elementos por clave
        int edadDeAlice = hashMap.get("Alice");
        System.out.println("Edad de Alice: " + edadDeAlice);

        // Verificar si una clave existe en el mapa
        boolean contieneEve = hashMap.containsKey("Eve");
        System.out.println("¿El mapa contiene a Eve? " + contieneEve);

        // Iterar a través de las claves y valores
        System.out.println("Elementos en el mapa:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String nombre = entry.getKey();
            int edad = entry.getValue();
            System.out.println(nombre + ": " + edad);
        }

        // Eliminar un elemento por clave
        hashMap.remove("Charlie");

        // Tamaño del mapa
        int tamano = hashMap.size();
        System.out.println("Tamaño del mapa: " + tamano);
    }
}
