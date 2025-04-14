package br.com.alura.contabancaria.rmbank.aplicacao;

import br.com.alura.contabancaria.rmbank.modelo.Conta;
import br.com.alura.contabancaria.rmbank.servicos.ServicoBancario;
import java.util.Scanner;

/**
 * Classe principal que inicia a aplicação
 */
public class Principal {
    /**
     * Metodo main - ponto de entrada do programa
     */
    public static void main(String[] args) {
        // Configuração inicial
        Scanner scanner = new Scanner(System.in);

        // Exibe banner de boas-vindas
        System.out.println("""
                |-------------------------------------------------------|
                |             Seja bem vindo ao RMBank                  |
                |          _________________________________            |
                |          "Sua nova conta bancária digital"            |
                |          _________________________________            |
                |-------------------------------------------------------|
                """);

        // Captura dados do cliente
        System.out.println("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();

        // Cria a conta e o serviço bancário
        Conta conta = new Conta(nomeCliente, "Corrente");
        ServicoBancario servico = new ServicoBancario(conta);

        // Pausa para continuar
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();

        // Inicia o menu principal
        servico.exibirMenu();
        scanner.close();
    }
}