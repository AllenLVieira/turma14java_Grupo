package bancos;

import java.util.Scanner;

public class BancoTeste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int MAX_MOVIMENTOS = 3;
		int data;
		double valor;
		char opcao;
		System.out.println("Banco Teste para uso");
		ContaPoupanca cp = new ContaPoupanca(1, "010.467.522-51", 15);
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
		sc.close();
	}

}
