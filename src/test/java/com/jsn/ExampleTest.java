package com.jsn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleTest {
    private Example example;

    @BeforeEach
    public void init() {
        this.example = new Example();
    }

    @Test
    public void testSumar() {
        // Given - elementos que se tienen para realizar la prueba
        int numberA = 5;
        int numberB = 10;
        // When : Cuando
        int result = example.sumar(numberA, numberB);
        // Then - Entonces
        assertNotNull(result);
        assertEquals(15, result);
        assertInstanceOf(Integer.class, result);
    }

    @Test
    public void testCheckPositivo() {
        // Given
        int positiveNumber = 5;
        int negativeNumber = -3;

        // When - probar con un número positivo
        boolean result = example.checkPositivo(positiveNumber);

        // Then
        assertTrue(result);

        // When - probar con un número negativo
        // Then - debería lanzar una excepción
        assertThrows(IllegalArgumentException.class, () -> example.checkPositivo(negativeNumber));
    }

    @Test
    public void testContarLetrasA() {
        // Given
        String cadena = "banana";

        // When
        int count = example.contarLetrasA(cadena);

        // Then
        assertEquals(3, count);

        // Given
        String cadenaSinA = "xyz";

        // When
        int countSinA = example.contarLetrasA(cadenaSinA);

        // Then
        assertEquals(0, countSinA);
    }

    @Test
    public void testContieneElemento() {
        // Given
        List<String> lista = Arrays.asList("manzana", "pera", "uva");
        String elementoExistente = "pera";
        String elementoNoExistente = "naranja";

        // When - elemento existe en la lista
        boolean existe = example.contieneElemento(lista, elementoExistente);

        // Then
        assertTrue(existe);

        // When - elemento no existe en la lista
        boolean noExiste = example.contieneElemento(lista, elementoNoExistente);

        // Then
        assertFalse(noExiste);
    }

    @Test
    public void testFactorial() {
        // Given
        int numero = 5;

        // When
        long resultado = example.factorial(numero);

        // Then
        assertEquals(120, resultado);

        // Given - número negativo
        int numeroNegativo = -1;

        // When/Then - debería lanzar una excepción para número negativo
        assertThrows(IllegalArgumentException.class, () -> example.factorial(numeroNegativo));
    }

    @Test
    public void testMensajeConRetraso() throws InterruptedException {
        // Given
        long startTime = System.currentTimeMillis();

        // When
        String result = example.mensajeConRetraso();

        // Then
        assertEquals("Listo después de retraso", result);
        long elapsedTime = System.currentTimeMillis() - startTime;
        assertTrue(elapsedTime >= 5000); // verificar que ha habido el retraso
    }

    @Test
    public void testConvertirAString() {
        // Given
        List<Integer> lista = Arrays.asList(1, 2, 3);

        // When
        List<String> resultado = example.convertirAString(lista);

        // Then
        assertEquals(Arrays.asList("1", "2", "3"), resultado);
        assertInstanceOf(List.class, resultado);
    }

    @Test
    public void testCalcularMediaConListaNula() {
        // Given - lista es null
        List<Integer> lista = null;
        
        // When / Then - se espera una IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> example.calcularMedia(lista), "La lista no puede ser nula o vacía");
    }

    @Test
    public void testCalcularMediaConListaVacia() {
        // Given - lista vacía
        List<Integer> lista = Arrays.asList(); // o Collections.emptyList();
        
        // When / Then - se espera una IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> example.calcularMedia(lista), "La lista no puede ser nula o vacía");
    }

    @Test
    public void testCalcularMediaConListaDeMultiplesElementos() {
        // Given - lista con varios elementos
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
        
        // When - calcular la media
        double resultado = example.calcularMedia(lista);
        
        // Then - verificar que la media es correcta
        assertEquals(3.0, resultado);
    }

    @Test
    public void testCalcularMediaConUnSoloElemento() {
        // Given - lista con un solo elemento
        List<Integer> lista = Arrays.asList(5);
        
        // When - calcular la media
        double resultado = example.calcularMedia(lista);
        
        // Then - la media debe ser el mismo número
        assertEquals(5.0, resultado);
    }
}