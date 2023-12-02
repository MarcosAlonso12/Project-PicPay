package com.tads.picpay.util;

public class ConvertIdentify {
    public static String formatCpf(String cpf) {
        return convertToCpf(cpf);
    }

    public static String formatCnpj(String cnpj) {
        return convertToCpf(cnpj);
    }

    private static String convertToCpf(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "").replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        return cpf;
    }

    private static String convertCnjp(String cnpj) {
        cnpj = cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        return cnpj;
    }
}
