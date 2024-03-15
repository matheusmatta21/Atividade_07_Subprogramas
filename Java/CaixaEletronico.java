import java.util.Scanner;

public class CaixaEletronico {

    static double saldo_atual = 1000.00;

    static void mostrar_saldo(double saldo) {
        System.out.println("Seu saldo atual é: R$" + saldo); // formatar 2 casas
    }

    static void menu(double saldo) {
        System.out.printf("Bem vindo ao Caixa Eletrônico\n");
        mostrar_saldo(saldo);
        System.out.println("Escolha uma opção:\n1 - Saque\n2 - Depósito\n3 - Consultar Saldo");
    }

    static double efetuar_saque(double saldo, double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return saldo;
        } else {
            System.out.println("Saque de R$" + valor + " realizado.");
            return saldo -= valor;
        }
    }

    static double efetuar_deposito(double saldo, double valor) {
        System.out.println("Depósito de R$" + valor + " realizado.");
        return saldo += valor;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            int opcao;
            double valor;
            menu(saldo_atual);
            opcao = scanner.nextInt();
            if (opcao == 1) {
                System.out.println("Digite o valor do saque:");
                valor = scanner.nextDouble();
                saldo_atual = efetuar_saque(saldo_atual, valor);
            } else if (opcao == 2) {
                System.out.println("Digite o valor do depósito:");
                valor = scanner.nextDouble();
                saldo_atual = efetuar_deposito(saldo_atual, valor);
            } else if (opcao == 3) {
                mostrar_saldo(saldo_atual);
            } else {
                System.out.println("Opção inválida.");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
