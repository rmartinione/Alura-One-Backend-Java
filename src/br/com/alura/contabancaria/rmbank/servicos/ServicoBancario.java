package br.com.alura.contabancaria.rmbank.servicos;

import br.com.alura.contabancaria.rmbank.modelo.Conta;
import java.util.Scanner;

/**
 * Classe responsável pela interação com o usuário e controle do fluxo do sistema
 */
public class ServicoBancario {
    // Dependências da classe
    private final Conta conta;    // Conta vinculada ao serviço
    private final Scanner scanner; // Scanner para entrada de dados

    /**
     * Construtor do serviço bancário
     * @param conta Conta a ser gerenciada
     */
    public ServicoBancario(Conta conta) {
        this.conta = conta;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Metodo principal que controla o fluxo do menu
     */
    public void exibirMenu() {
        int opcao = 0; // Variável para controle do menu

        // Loop principal do menu
        while (opcao != 4) {
            exibirCabecalho(); // Mostra os dados da conta
            System.out.println(getMenuTexto()); // Exibe o menu
            System.out.print("Digite sua opção: ");

            // Verifica se a entrada é um número
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                processarOpcao(opcao); // Processa a opção selecionada
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }
        scanner.close(); // Fecha o scanner ao sair
    }

    // === MÉTODOS PRIVADOS DE APOIO ===

    /**
     * Exibe o cabeçalho com dados da conta
     */
    private void exibirCabecalho() {
        System.out.println("|-------------------------------------------------------|");
        System.out.printf("|Cliente: %-45s|\n", conta.getTitular());
        System.out.println("|-------------------------------------------------------|");
        System.out.printf("|Conta: %-47s|\n", conta.getTipoConta());
        System.out.println("|-------------------------------------------------------|");
    }

    /**
     * @return Texto formatado do menu de opções
     */
    private String getMenuTexto() {
        return """
                |             Escolha as opções desejadas:              |
                |          __________________________________           |
                |                                                       |
                | 1) - Saldo                                            |
                | 2) - Transferir Valor                                 |
                | 3) - Receber Valor                                    |
                | 4) - Sair                                             |
                |                                                       |
                |-------------------------------------------------------|
                """;
    }

    /**
     * Processa a opção selecionada pelo usuário
     * @param opcao Número da opção escolhida
     */
    private void processarOpcao(int opcao) {
        // Estrutura switch para cada opção
        switch (opcao) {
            case 1 -> exibirSaldo();
            case 2 -> processarTransferencia();
            case 3 -> processarRecebimento();
            case 4 -> System.out.println("Obrigado por usar o RMBank. Até logo!");
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    /**
     * Exibe o saldo atual formatado
     */
    private void exibirSaldo() {
        System.out.printf("Seu saldo atualizado é de: R$%.2f\n", conta.getSaldo());
    }

    /**
     * Processa toda a operação de transferência
     */
    private void processarTransferencia() {
        System.out.println("Digite o valor desejado para transferir: ");
        double valor = scanner.nextDouble();

        try {
            conta.transferir(valor);
            System.out.println("Transferência realizada com sucesso.");
            exibirSaldo();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Processa toda a operação de recebimento
     */
    private void processarRecebimento() {
        System.out.println("Digite o valor recebido: ");
        double valor = scanner.nextDouble();

        try {
            conta.receber(valor);
            System.out.printf("Você recebeu R$%.2f\n", valor);
            exibirSaldo();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}