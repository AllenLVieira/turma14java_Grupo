package bancos;

import java.util.*;

public class BancoTeste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<ContaPoupanca> contapou = new ArrayList<>();
		List<ContaCorrente> contacor = new ArrayList<>();
		List<ContaEspecial> contaesp = new ArrayList<>();
		List<ContaEmpresa> contaemp = new ArrayList<>();

		final int MAX_MOVIMENTOS = 3;
		int digitaConta, data, operacao, numeroConta = 0, tamanho = 50;
		double valor, valorEmprestimo;
		char opcao, opConta, continuaTransacao = 'S';

		do {
			linha(tamanho);
			System.out.println("\n                     G6 BANK");
			linha(tamanho);
			
			System.out.println("\n[1] - Abertura de conta");
			System.out.println("[2] - Acesso a uma conta existente");
			System.out.println("[3] - Sair");
			operacao = sc.next().charAt(0);
			if (operacao == '1') {
				linha(tamanho);
				System.out.println("\n                 TIPOS DE CONTAS");
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
					break;
				case '2':
					ContaCorrente dm = new ContaCorrente(numeroConta, cpfConta);
					contacor.add(dm);
					break;
				case '3':
					ContaEspecial dv = new ContaEspecial(numeroConta, cpfConta);
					contaesp.add(dv);
					break;
				case '4':
					ContaEmpresa mg = new ContaEmpresa(numeroConta, cpfConta);
					contaemp.add(mg);
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
				if (validarConta(digitaConta, contapou, contacor, contaesp, contaemp) == 0) {
					System.out.println("Conta não existe no G6 Bank.");
				} else if (validarConta(digitaConta, contapou, contacor, contaesp, contaemp) == 1) {
					for (ContaPoupanca p : contapou) {
						if (p.getNumConta() == digitaConta) {
							System.out.println("Digite a data de hoje: ");
							data = sc.nextInt();
							linha(tamanho);
							System.out.println("\n                  Conta Poupança");
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
									System.out.println(
											"Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
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
				} else if (validarConta(digitaConta, contapou, contacor, contaesp, contaemp) == 2) {
					for (ContaCorrente p : contacor) {
						if (p.getNumConta() == digitaConta) {
							linha(tamanho);
							System.out.println("\n                  Conta Corrente");
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
									System.out.println(
											"Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
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
				} else if (validarConta(digitaConta, contapou, contacor, contaesp, contaemp) == 3) {
					for (ContaEspecial p : contaesp) {
						if (p.getNumConta() == digitaConta) {
							linha(tamanho);
							System.out.println("\n                  Conta Especial");
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
									System.out.println(
											"Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
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
				} else if (validarConta(digitaConta, contapou, contacor, contaesp, contaemp) == 4) {
					for (ContaEmpresa p : contaemp) {
						if (p.getNumConta() == digitaConta) {
							linha(tamanho);
							System.out.println("\n                  Conta Empresa");
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
									System.out.println(
											"Resposta incorreta. Você deseja fazer outra transação (S ou N)? ");
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
				}

			} else {
				linha(tamanho);
				System.out.println("\n\tObrigado por utilizar o nosso APP!");
				linha(tamanho);
				System.exit(0);
			}
			System.out.println("Deseja continuar utilizando o APP (S ou N)? ");
			opcao = sc.next().toUpperCase().charAt(0);
		} while (opcao == 'S');
		linha(tamanho);
		System.out.println("\n\tObrigado por utilizar o nosso APP!");
		linha(tamanho);
	}

	static void linha(int tamanho) {
		for (int x = 0; x < tamanho; x++) {
			System.out.print("-");
		}
	}

	static int validarConta(int digitaConta, List<ContaPoupanca> p, List<ContaCorrente> c, List<ContaEspecial> e,
			List<ContaEmpresa> emp) {
		int r = 0;
		for (ContaPoupanca i : p) {
			if (i.getNumConta() == digitaConta) {
				r = 1;
				break;
			}
		}
		for (ContaCorrente i : c) {
			if (i.getNumConta() == digitaConta) {
				r = 2;
				break;
			}
		}
		for (ContaEspecial i : e) {
			if (i.getNumConta() == digitaConta) {
				r = 3;
				break;
			}
		}
		for (ContaEmpresa i : emp) {
			if (i.getNumConta() == digitaConta) {
				r = 4;
				break;
			}
		}
		return r;
	}
}