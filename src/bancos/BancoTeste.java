package bancos;

import java.util.Scanner;

public class BancoTeste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int MAX_MOVIMENTOS = 3;
		int data,quantidadeTalao;
		double valor;
		char opcao;
		
		System.out.println("Banco Teste para uso");
		ContaPoupanca cp = new ContaPoupanca(1, "010.467.522-51", 15);
		ContaCorrente dm = new ContaCorrente(2,"319.561.590-88");
		System.out.println("Digite a data de hoje: ");
		data = sc.nextInt();
		System.out.println("Número da conta: " + cp.getNumConta());
		System.out.println("CPF: " + cp.getCpfConta());
		System.out.println("Aniversário da conta: " + cp.getDataAniversarioConta());
		for (int i = 0; i < MAX_MOVIMENTOS; i++) {
			do {
				System.out.println("Você quer [D] Depositar ou [R] Retirar?");
				opcao = sc.next().toUpperCase().charAt(0);
			} while (opcao != 'D' && opcao != 'R');
			if (opcao == 'D') {
				System.out.println("Digite o valor de depósito: ");
				valor = sc.nextDouble();
				cp.depositar(valor);
			} else {
				System.out.println("Digite o valor de retirada: ");
				valor = sc.nextDouble();
				cp.retirar(valor);
			}
		}
		cp.correcaoPoupanca(data);
		System.out.println("Saldo total: " + cp.getSaldoConta());
		System.out.println("________________________________________________");
		System.out.println("Conta Corrente");
		System.out.println("Número da conta: " + dm.getNumConta());
		System.out.println("CPF: " + dm.getCpfConta());
		for (int i = 0; i < MAX_MOVIMENTOS; i++) {
			do {
				System.out.println("Você quer [D] Depositar ou [R] Retirar?");
				opcao = sc.next().toUpperCase().charAt(0);
			} while (opcao != 'D' && opcao != 'R');
			if (opcao == 'D') {
				System.out.println("Digite o valor de depósito: ");
				valor = sc.nextDouble();
				dm.depositar(valor);;
			} else {
				System.out.println("Digite o valor de retirada: ");
				valor = sc.nextDouble();
				dm.retirar(valor);;
			}
		}
		System.out.println("Saldo total: R$ " + dm.getSaldoConta());
		System.out.println("Você deseja imprimir talão(S ou N)? ");
		opcao = sc.next().toUpperCase().charAt(0);
		while (opcao != 'S' && opcao != 'N') {
			System.out.println("\nOpção inválida. Deseja continuar? ");
			opcao = sc.next().toUpperCase().charAt(0);
		}
		System.out.println("Digite a quantidade de talões que deseja imprimir: ");
		quantidadeTalao = sc.nextInt();
		dm.retornaTalao(quantidadeTalao);		
		sc.close();
	}

}
