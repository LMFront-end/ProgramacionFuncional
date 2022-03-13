package programacionfuncional;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        new Main();

    }

    public Main(){
        // Qué queremos hacer?
        // 1. - Crear una lista de enteros
        List<Integer> numeros = crearLista();

        // 2. - Quedarme solo con los pares
        List<Integer> pares = filtrarPares(numeros);
        // 3. - Pasar cada número al cuadrado
        // 4. - Mostrar cada cuadrado por pantalla
        // 5. - Obtener la suma de los cuadrados


    }

    private List<Integer> crearLista(){
        // List.of -> me construye una lista inmutable
        return List.of(0,1,2,3,5,8,13,21,34,55,89,144);
    }

    private List<Integer> filtrarPares(List<Integer> numeros) {
        numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        return numeros;
    }




}
