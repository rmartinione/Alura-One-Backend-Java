import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Captura o nome do cliente
        System.out.println("Digite seu nome: ");
        String nomeCliente = scanner.nextLine(); // Armazena o nome inserido pelo usuário

        // Dados da conta do cliente
        String tipoConta = "Corrente"; // Define o tipo da conta
        double saldo = 0.00; // Define o saldo inicial da conta
        int opcao = 0; // Inicializa a variável de controle do menu

        // Apresentação inicial usando o nome capturado
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|Cliente:             " + nomeCliente + "                    |");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|Conta:               " + tipoConta + "                      ");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("""
                |-------------------------------------------------------|
                |             Seja bem vindo ao RMBank                  |
                |          _________________________________            |
                |          "Sua nova conta bancária digital"            |
                |          _________________________________            |
                |                                                       |
                |                                                       |
                |-------------------------------------------------------|
                """);

        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Aguarda o Enter do usuário

        // Menu de opções
        String menu = """
                |-------------------------------------------------------|
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

        while (opcao != 4) { // Loop do menu principal
            System.out.println(menu);
            System.out.print("Digite sua opção: ");

            if (scanner.hasNextInt()) { // Verifica se a entrada é um número inteiro
                opcao = scanner.nextInt();

                if (opcao == 1) {
                    // Exibe o saldo atual
                    System.out.println("Seu saldo atualizado é de: R$" + saldo);
                } else if (opcao == 2) {
                    // Solicita valor para transferência
                    System.out.println("Digite o valor desejado para transferir: ");
                    double valor = scanner.nextDouble();

                    if (valor > saldo) {
                        System.out.println("Não há saldo suficiente para transferir.");
                    } else {
                        saldo -= valor; // Subtrai o valor do saldo
                        System.out.println("Transferência realizada com sucesso.");
                        System.out.println("Saldo atual: R$" + saldo);
                    }
                } else if (opcao == 3) {
                    // Solicita valor a ser recebido
                    System.out.println("Digite o valor recebido: ");
                    double valor = scanner.nextDouble();
                    saldo += valor; // Adiciona o valor ao saldo
                    System.out.println("Você recebeu R$" + valor);
                    System.out.println("Saldo atual: R$" + saldo);
                } else if (opcao == 4) {
                    // Opção de saída
                    System.out.println("Obrigado por usar o RMBank. Até logo!");
                } else {
                    // Opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                // Em caso de escolher opçao inválida no menu
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpa a entrada inválida
            }
        }

        scanner.close(); // Fecha o scanner
    }
}
