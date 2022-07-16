package org.example;

import java.util.Objects;

public class StringCalculator {

    public int add(String value) {
        int resultado = 0;
        if (value.isBlank())
            return 0;

        if (Objects.equals(value.length(), 1) && value.matches("\\d"))
            return Integer.parseInt(value);

        String[] numbersString = value.split("[,|\n]");

        for (String ns : numbersString) {
            int number = Integer.parseInt(ns);

            try {
                validateNegativeNumber(number);
                if (number > 1000)
                    continue;

                resultado += number;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return resultado;
    }

    private void validateNegativeNumber(int number) throws Exception {
        if (number < 0)
            throw new Exception("NegativeNumberException");
    }


}
