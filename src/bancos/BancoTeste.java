package bancos;

import java.util.*;
import java.util.Scanner;

public class BancoTeste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<ContaPoupanca> contapou = new ArrayList<>();
		List<ContaCorrente> contacor = new ArrayList<>();
		List<ContaEspecial> contaesp = new ArrayList<>();
		List<ContaEmpresa> contaemp = new ArrayList<>();

		final int MAX_MOVIMENTOS = 2;
		int digitaConta, data, operacao, numeroConta = 0, tamanho = 50;

		double valor, valorEmprestimo;
		char opcao, opConta, continuaTransacao = 'S';

		do {
			linha(tamanho);
			System.out.println("\n\t\t    BANCO G6");
			linha(tamanho);

			System.out.println("\n[1] - Abertura de conta");
			System.out.println("[2] - Acesso a uma conta existente");
			System.out.println("[3] - Sair");
			operacao = sc.next().charAt(0);

			if (operacao == '1') {
				linha(tamanho);
				System.out.println("\n\t\tTIPOS DE CONTAS");
				linha(tamanho);
				System.out.println("\n[1] - Conta Poupança");
				System.out.println("[2] - Conta Corrente");
				System.out.println("[3] - Conta Especial");
				System.out.println("[4] - Conta Empresa");
				System.out.println("[5] - conta Universitaria");
				System.out.print("Digite o numero de sua opção: ");
				opConta = sc.next().charAt(0);
				numeroConta++;
				sc.nextLine();
				System.out.println("Digite o seu CPF: ");
				String cpfConta = sc.nextLine();
				switch (opConta) {
				case '1':
					System.out.println("Digite a data de aniversario da conta: ");
					int dataAniversario = sc.nextInt();
					ContaPoupanca cp = new ContaPoupanca(numeroConta, cpfConta, dataAniversario);

					contapou.add(cp);

					System.out.println("Digite a data de hoje: ");
					data = sc.nextInt();
					linha(tamanho);
					System.out.println("\n\t\tConta Poupança");
					linha(tamanho);
					System.out.println("\nNúmero da conta: " + cp.getNumConta());
					System.out.println("CPF: " + cp.getCpfConta());
					System.out.println("Aniversário da conta: " + cp.getDataAniversarioConta());
					System.out.println("Saldo da conta: "+cp.getSaldoConta());
					linha(tamanho);
					for (int i = 0; i < MAX_MOVIMENTOS; i++) {
						do {
							System.out.println("\nVocê quer [D] Depositar ou [R] Retirar?");
							opcao = sc.next().toUpperCase().charAt(0);
						} while (opcao != 'D' && opcao != 'R');
						if (opcao == 'D') {
							System.out.println("Digite o valor de depósito: R$ ");
							valor = sc.nextDouble();
							cp.depositar(valor);
						} else {
							System.out.println("Digite o valor de retirada: R$ ");
							valor = sc.nextDouble();
							cp.retirar(valor);
						}
						System.out.println("Saldo total: R$" + cp.getSaldoConta());
						System.out.println("Você deseja fazer outra transação (S ou N)? ");
						continuaTransacao = sc.next().toUpperCase().charAt(0);
						while (continuaTransacao != 'S' && continuaTransacao != 'N') {
							System.out.println("Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
							continuaTransacao = sc.next().toUpperCase().charAt(0);
						}
						if (continuaTransacao == 'N') {
							break;
						}
						if (i == MAX_MOVIMENTOS - 1) {
							System.out.println("Você atingiu o limite diário de transações.");
						}
					}
					linha(tamanho);
					System.out.println("\n");
					cp.correcaoPoupanca(data);
					System.out.println("Saldo total: R$ " + cp.getSaldoConta());

					break;
				case '2':
					ContaCorrente dm = new ContaCorrente(numeroConta, cpfConta);
					contacor.add(dm);
					linha(tamanho);
					System.out.println("\n\t\tConta Corrente");
					linha(tamanho);
					System.out.println("\nNúmero da conta: " + dm.getNumConta());
					System.out.println("CPF: " + dm.getCpfConta());
					System.out.println("Saldo da conta: "+dm.getSaldoConta());
					linha(tamanho);
					for (int i = 0; i < MAX_MOVIMENTOS; i++) {
						do {
							System.out.println("\nVocê quer [D] Depositar ou [R] Retirar?");
							opcao = sc.next().toUpperCase().charAt(0);
						} while (opcao != 'D' && opcao != 'R');
						if (opcao == 'D') {
							System.out.println("Digite o valor de depósito: R$ ");
							valor = sc.nextDouble();
							dm.depositar(valor);
							;
						} else {
							System.out.println("Digite o valor de retirada: R$ ");
							valor = sc.nextDouble();
							dm.retirar(valor);
						}
						System.out.println("Saldo total: R$ " + dm.getSaldoConta());

						System.out.println("Você deseja fazer outra transação (S ou N)? ");
						continuaTransacao = sc.next().toUpperCase().charAt(0);
						while (continuaTransacao != 'S' && continuaTransacao != 'N') {
							System.out.println("Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
							continuaTransacao = sc.next().toUpperCase().charAt(0);
						}
						if (continuaTransacao == 'N') {
							break;
						}
						if (i == MAX_MOVIMENTOS - 1) {
							System.out.println("Você atingiu o limite diário de transações.");
						}
					}
					linha(tamanho);
					System.out.println("\nSaldo total: R$ " + dm.getSaldoConta());
					dm.talao(dm.getTalao(), dm.getQtdTalao());
					break;
				case '3':
					ContaEspecial dv = new ContaEspecial(numeroConta, cpfConta);
					contaesp.add(dv);
					linha(tamanho);
					System.out.println("\n\t\tConta Especial");
					linha(tamanho);
					System.out.println("\nNúmero da conta: " + dv.getNumConta());
					System.out.println("CPF: " + dv.getCpfConta());
					System.out.println("Saldo da conta: "+dv.getSaldoConta());
					linha(tamanho);
					for (int i = 0; i < MAX_MOVIMENTOS; i++) {
						do {
							System.out.println("\nVocê quer [D] Depositar ou [R] Retirar?");
							opcao = sc.next().toUpperCase().charAt(0);
						} while (opcao != 'D' && opcao != 'R');
						if (opcao == 'D') {
							System.out.println("Digite o valor de depósito: R$ ");
							valor = sc.nextDouble();
							dv.depositar(valor);
							;
						} else {
							System.out.println("Digite o valor de retirada: R$ ");
							valor = sc.nextDouble();
							dv.retirar(valor);

						}
						System.out.println("Saldo total: R$ " + dv.getSaldoConta());
						System.out.println("Limite Atual: R$ " + dv.getLimiteEspecial());
						System.out.println("Você deseja fazer outra transação (S ou N)? ");
						continuaTransacao = sc.next().toUpperCase().charAt(0);
						while (continuaTransacao != 'S' && continuaTransacao != 'N') {
							System.out.println("Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
							continuaTransacao = sc.next().toUpperCase().charAt(0);
						}
						if (continuaTransacao == 'N') {
							break;
						}
						if (i == MAX_MOVIMENTOS - 1) {
							System.out.println("Você atingiu o limite diário de transações.");
						}
					}
					linha(tamanho);
					System.out.println("\nSaldo total: R$ " + dv.getSaldoConta());
					System.out.println("Limite Atual: R$ " + dv.getLimiteEspecial());
					dv.talao(dv.getTalao(), dv.getQtdTalao());
					break;
				case '4':

					ContaEmpresa mg = new ContaEmpresa(numeroConta, cpfConta);
					contaemp.add(mg);
					linha(tamanho);
					System.out.println("\n\t\tConta Empresa");
					linha(tamanho);
					System.out.println("\nNúmero da conta: " + mg.getNumConta());
					System.out.println("CPF: " + mg.getCpfConta());
					System.out.println("Saldo da conta: "+mg.getSaldoConta());
					linha(tamanho);
					for (int i = 0; i < MAX_MOVIMENTOS; i++) {
						do {
							System.out.println("\nVocê quer [D] Depositar ou [R] Retirar?");
							opcao = sc.next().toUpperCase().charAt(0);
						} while (opcao != 'D' && opcao != 'R');
						if (opcao == 'D') {
							System.out.println("Digite o valor de depósito: R$ ");
							valor = sc.nextDouble();
							mg.depositar(valor);
						} else {
							System.out.println("Digite o valor de retirada: R$ ");
							valor = sc.nextDouble();
							mg.retirar(valor);
						}
						do {
							System.out.println("Você quer um empréstimo (S ou N)? ");
							opcao = sc.next().toUpperCase().charAt(0);
						} while (opcao != 'S' && opcao != 'N');
						if (opcao == 'S') {
							System.out.println("Digite o valor: R$ ");
							valorEmprestimo = sc.nextDouble();
							mg.emprestar(valorEmprestimo);
						}
						System.out.println("Saldo total: R$ " + mg.getSaldoConta());
						System.out.println("Valor de emprestimo disponivel: R$ " + mg.getEmprestimoEmpresa());
						System.out.println("Você deseja fazer outra transação (S ou N)? ");
						continuaTransacao = sc.next().toUpperCase().charAt(0);
						while (continuaTransacao != 'S' && continuaTransacao != 'N') {
							System.out.println("Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
							continuaTransacao = sc.next().toUpperCase().charAt(0);
						}
						if (continuaTransacao == 'N') {
							break;
						}
						if (i == MAX_MOVIMENTOS - 1) {
							System.out.println("Você atingiu o limite diário de transações.");
						}
					}
					linha(tamanho);
					System.out.println("\nSaldo total: R$ " + mg.getSaldoConta());
					System.out.println("Valor de emprestimo disponivel: R$ " + mg.getEmprestimoEmpresa());
					break;
				case '5':
					System.out.println("\nWIP!!");
					break;
				}

			} else if (operacao == '2') {
				System.out.println("Digite o número da conta: ");
				digitaConta = sc.nextInt();
				while (digitaConta <= 0) {
					System.out.println("Numero da conta incorreto. Digite o número da conta: ");
					digitaConta = sc.nextInt();
				}
				for (ContaPoupanca p : contapou) {
					if (p.getNumConta() == digitaConta) {
						System.out.println("Digite a data de hoje: ");
						data = sc.nextInt();
						System.out.println("\n\t\tConta Poupança");
						linha(tamanho);
						System.out.println("\nNúmero da conta: " + p.getNumConta());
						System.out.println("CPF: " + p.getCpfConta());
						System.out.println("Aniversário da conta: " + p.getDataAniversarioConta());
						linha(tamanho);
						for (int i = 0; i < MAX_MOVIMENTOS; i++) {
							do {
								System.out.println("\nVocê quer [D] Depositar ou [R] Retirar?");
								opcao = sc.next().toUpperCase().charAt(0);
							} while (opcao != 'D' && opcao != 'R');
							if (opcao == 'D') {
								System.out.println("Digite o valor de depósito: R$ ");
								valor = sc.nextDouble();
								p.depositar(valor);
							} else {
								System.out.println("Digite o valor de retirada: R$ ");
								valor = sc.nextDouble();
								p.retirar(valor);
							}
							System.out.println("Saldo total: R$" + p.getSaldoConta());
							System.out.println("Você deseja fazer outra transação (S ou N)? ");
							continuaTransacao = sc.next().toUpperCase().charAt(0);
							while (continuaTransacao != 'S' && continuaTransacao != 'N') {
								System.out.println("Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
								continuaTransacao = sc.next().toUpperCase().charAt(0);
							}
							if (continuaTransacao == 'N') {
								break;
							}
							if (i == MAX_MOVIMENTOS - 1) {
								System.out.println("Você atingiu o limite diário de transações.");
							}
						}
						linha(tamanho);
						System.out.println("\n");
						p.correcaoPoupanca(data);
						System.out.println("Saldo total: R$ " + p.getSaldoConta());
					}
				}
				for (ContaCorrente p : contacor) {
					if (p.getNumConta() == digitaConta) {
						linha(tamanho);
						System.out.println("\n\t\tConta Corrente");
						linha(tamanho);
						System.out.println("\nNúmero da conta: " + p.getNumConta());
						System.out.println("CPF: " + p.getCpfConta());
						linha(tamanho);
						for (int i = 0; i < MAX_MOVIMENTOS; i++) {
							do {
								System.out.println("\nVocê quer [D] Depositar ou [R] Retirar?");
								opcao = sc.next().toUpperCase().charAt(0);
							} while (opcao != 'D' && opcao != 'R');
							if (opcao == 'D') {
								System.out.println("Digite o valor de depósito: R$ ");
								valor = sc.nextDouble();
								p.depositar(valor);
								;
							} else {
								System.out.println("Digite o valor de retirada: R$ ");
								valor = sc.nextDouble();
								p.retirar(valor);
							}
							System.out.println("Saldo total: R$ " + p.getSaldoConta());

							System.out.println("Você deseja fazer outra transação (S ou N)? ");
							continuaTransacao = sc.next().toUpperCase().charAt(0);
							while (continuaTransacao != 'S' && continuaTransacao != 'N') {
								System.out.println("Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
								continuaTransacao = sc.next().toUpperCase().charAt(0);
							}
							if (continuaTransacao == 'N') {
								break;
							}
							if (i == MAX_MOVIMENTOS - 1) {
								System.out.println("Você atingiu o limite diário de transações.");
							}
						}
						linha(tamanho);
						System.out.println("\nSaldo total: R$ " + p.getSaldoConta());
						p.talao(p.getTalao(), p.getQtdTalao());
					}
				}
				for (ContaEspecial p : contaesp) {
					if (p.getNumConta() == digitaConta) {
						linha(tamanho);
						System.out.println("\n\t\tConta Especial");
						linha(tamanho);
						System.out.println("\nNúmero da conta: " + p.getNumConta());
						System.out.println("CPF: " + p.getCpfConta());
						linha(tamanho);
						for (int i = 0; i < MAX_MOVIMENTOS; i++) {
							do {
								System.out.println("\nVocê quer [D] Depositar ou [R] Retirar?");
								opcao = sc.next().toUpperCase().charAt(0);
							} while (opcao != 'D' && opcao != 'R');
							if (opcao == 'D') {
								System.out.println("Digite o valor de depósito: R$ ");
								valor = sc.nextDouble();
								p.depositar(valor);
								;
							} else {
								System.out.println("Digite o valor de retirada: R$ ");
								valor = sc.nextDouble();
								p.retirar(valor);

							}
							System.out.println("Saldo total: R$ " + p.getSaldoConta());
							System.out.println("Limite Atual: R$ " + p.getLimiteEspecial());
							System.out.println("Você deseja fazer outra transação (S ou N)? ");
							continuaTransacao = sc.next().toUpperCase().charAt(0);
							while (continuaTransacao != 'S' && continuaTransacao != 'N') {
								System.out.println("Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
								continuaTransacao = sc.next().toUpperCase().charAt(0);
							}
							if (continuaTransacao == 'N') {
								break;
							}
							if (i == MAX_MOVIMENTOS - 1) {
								System.out.println("Você atingiu o limite diário de transações.");
							}
						}
						linha(tamanho);
						System.out.println("\nSaldo total: R$ " + p.getSaldoConta());
						System.out.println("Limite Atual: R$ " + p.getLimiteEspecial());
						p.talao(p.getTalao(), p.getQtdTalao());
					}
				}
				for (ContaEmpresa p : contaemp) {
					if (p.getNumConta() == digitaConta) {
						linha(tamanho);
						System.out.println("\n\t\tConta Empresa");
						linha(tamanho);
						System.out.println("\nNúmero da conta: " + p.getNumConta());
						System.out.println("CPF: " + p.getCpfConta());
						linha(tamanho);
						for (int i = 0; i < MAX_MOVIMENTOS; i++) {
							do {
								System.out.println("\nVocê quer [D] Depositar ou [R] Retirar?");
								opcao = sc.next().toUpperCase().charAt(0);
							} while (opcao != 'D' && opcao != 'R');
							if (opcao == 'D') {
								System.out.println("Digite o valor de depósito: R$ ");
								valor = sc.nextDouble();
								p.depositar(valor);
							} else {
								System.out.println("Digite o valor de retirada: R$ ");
								valor = sc.nextDouble();
								p.retirar(valor);
							}
							do {
								System.out.println("Você quer um empréstimo (S ou N)? ");
								opcao = sc.next().toUpperCase().charAt(0);
							} while (opcao != 'S' && opcao != 'N');
							if (opcao == 'S') {
								System.out.println("Digite o valor: R$ ");
								valorEmprestimo = sc.nextDouble();
								p.emprestar(valorEmprestimo);
							}
							System.out.println("Saldo total: R$ " + p.getSaldoConta());
							System.out.println("Valor de emprestimo disponivel: R$ " + p.getEmprestimoEmpresa());
							System.out.println("Você deseja fazer outra transação (S ou N)? ");
							continuaTransacao = sc.next().toUpperCase().charAt(0);
							while (continuaTransacao != 'S' && continuaTransacao != 'N') {
								System.out.println("Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
								continuaTransacao = sc.next().toUpperCase().charAt(0);
							}
							if (continuaTransacao == 'N') {
								break;
							}
							if (i == MAX_MOVIMENTOS - 1) {
								System.out.println("Você atingiu o limite diário de transações.");
							}
						}
						linha(tamanho);
						System.out.println("\nSaldo total: R$ " + p.getSaldoConta());
						System.out.println("Valor de emprestimo disponivel: R$ " + p.getEmprestimoEmpresa());
					}
				}
			} else {
				break;
			}
			System.out.println("Deseja continuar utilizando o APP (S ou N)? ");
			opcao = sc.next().toUpperCase().charAt(0);
			if (opcao == 'N') {
				break;
			}
		} while (true);
		linha(tamanho);
		System.out.println("\n\tObrigado por utilizar o nosso APP!");
		linha(tamanho);
	}

	static void linha(int tamanho) {
		for (int x = 0; x < tamanho; x++) {
			System.out.print("=");
		}
	}
}