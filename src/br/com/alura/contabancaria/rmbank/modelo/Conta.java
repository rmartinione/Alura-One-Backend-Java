package br.com.alura.contabancaria.rmbank.modelo;

/**
 * Classe que representa uma conta bancária com operações básicas
 * Contém os dados do titular, tipo de conta e saldo
 */
public class Conta {
    // Atributos da conta
    private String titular;   // Nome do titular da conta
    private String tipoConta; // Tipo: Corrente ou Poupança
    private double saldo;     // Saldo atual da conta

    /**
     * Construtor da classe Conta
     * @param titular Nome do titular da conta
     * @param tipoConta Tipo da conta (Corrente/Poupança)
     */
    public Conta(String titular, String tipoConta) {
        this.titular = titular;
        this.tipoConta = tipoConta;
        this.saldo = 0.0; // Saldo inicia zerado
    }

    // === MÉTODOS DE ACESSO (GETTERS) ===

    /**
     * @return Nome do titular da conta
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @return Tipo da conta
     */
    public String getTipoConta() {
        return tipoConta;
    }

    /**
     * @return Saldo atual da conta
     */
    public double getSaldo() {
        return saldo;
    }

    // === MÉTODOS DE OPERAÇÕES BANCÁRIAS ===

    /**
     * Realiza uma transferência (diminui o saldo)
     * @param valor Valor a ser transferido
     * @throws IllegalArgumentException Se o valor for maior que o saldo
     */
    public void transferir(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        saldo -= valor; // Subtrai o valor do saldo
    }

    /**
     * Recebe um valor (aumenta o saldo)
     * @param valor Valor a ser recebido
     * @throws IllegalArgumentException Se o valor for negativo ou zero
     */
    public void receber(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        saldo += valor; // Adiciona o valor ao saldo
    }
}