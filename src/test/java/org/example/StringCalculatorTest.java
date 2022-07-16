package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("Texto vacio = 0")
    void addEmptyString() {
        //arrange
        String value = "";

        //act
        int resultado = stringCalculator.add(value);

        //assert
        Assertions.assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Un solo número devuelve el valor")
    void addOnlyOneNumber() {
        //arrange
        String value = "1";

        //act
        int resultado = stringCalculator.add(value);

        //assert
        Assertions.assertEquals(1, resultado);
    }

    @Test
    @DisplayName("Con número negativos")
    void addNegativeNumber() {
        //arrange
        String value = "-8,9";

        //act
        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                () -> stringCalculator.add("-1,2")
        );

        //assert
        Assertions.assertEquals("NegativeNumberException", thrown.getMessage());
    }

    @Test
    @DisplayName("con delimitador coma")
    void addWithDelimiter() {
        //arrange
        String value = "103,1";

        //act
        int resultado = stringCalculator.add(value);

        //assert
        Assertions.assertEquals(104, resultado);

    }

    @Test
    @DisplayName("con delimitador salto de línea")
    void addWithDelimiterLineBreak() {
        //arrange
        String value = "103\n1\n100";

        //act
        int resultado = stringCalculator.add(value);

        //assert
        Assertions.assertEquals(204, resultado);

    }

    @Test
    @DisplayName("números mayores a 1000 se ignoran")
    void addNumbergreaterthan1000() {
        //arrange
        String value = "103\n4,3333";

        //act
        int resultado = stringCalculator.add(value);

        //assert
        Assertions.assertEquals(107, resultado);
    }


}