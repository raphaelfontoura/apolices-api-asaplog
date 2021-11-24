package br.com.asaplog.veiculoseguro.utils;

import java.util.UUID;

public class Utils {

    public static Long generateNumber() {
        var number = UUID.randomUUID().getMostSignificantBits();
        number = (long) (number * 0.0001);
        return Math.abs(number);
    }

    public static String convertCpf(String cpf) {
        if (cpf.length() == 11) {
            cpf = cpf.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4");
        }
        return cpf;
    }
}
