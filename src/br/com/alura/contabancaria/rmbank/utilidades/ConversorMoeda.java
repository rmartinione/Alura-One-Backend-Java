package br.com.alura.contabancaria.rmbank.utilidades;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Classe utilitária para formatação de valores monetários
 */
public class ConversorMoeda {
    // Formatador com configuração para Real Brasileiro
    private static final NumberFormat conversor =
            NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    /**
     * Formata um valor double para o padrão monetário brasileiro
     * @param valor Valor a ser formatado
     * @return String com o valor formatado (ex: R$ 1.000,50)
     */
    public static String formatar(double valor) {
        return conversor.format(valor);
    }
}