package com.ucb.hashset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapHashSetExample {
    public static void main(String[] args) {
        // Crear un HashMap para asociar nombres con edades
        Map<String, Integer> oPersonaMap = new HashMap<>();

        // Agregar elementos al HashMap
        oPersonaMap.put("Alice", 25);
        oPersonaMap.put("Bob", 30);
        oPersonaMap.put("Charlie", 28);
        oPersonaMap.put("David", 35);

        // Crear un HashSet para almacenar algunos intereses
        Set<String> oPasatiempos = new HashSet<>();

        // Agregar elementos al HashSet
        oPasatiempos.add("Música");
        oPasatiempos.add("Deportes");
        oPasatiempos.add("Viajes");

        // Acceder a elementos en el HashMap
        int edadAlice = oPersonaMap.get("Alice");
        System.out.println("Edad de Alice: " + edadAlice);

        // Verificar si un nombre existe en el HashMap
        boolean contieneNed = oPersonaMap.containsKey("Ned");
        System.out.println("¿El HashMap contiene a Ned? " + contieneNed);

        // Iterar a través de los nombres y edades en el HashMap
        for (Map.Entry<String, Integer> entry : oPersonaMap.entrySet()) {
            String nombre = entry.getKey();
            int edad = entry.getValue();
            System.out.println(nombre + ": " + edad);
        }

        // Verificar si un interés existe en el HashSet
        boolean contieneDeportes = oPasatiempos.contains("Deportes");
        System.out.println("¿El HashSet contiene Deportes? " + contieneDeportes);

        // Iterar a través de los intereses en el HashSet
        System.out.println("Intereses en el HashSet:");
        for (String interes : oPasatiempos) {
            System.out.println(interes);
        }
    }
}

