package bancos;

import java.util.Scanner;

public class ContaCorrente extends Conta {
	private int qtdTalao;
	private int talao = 3;
	private int totalTalao;
	public ContaCorrente(int numeroConta, String cpf) {
		super(numeroConta, cpf);
	}
	public int getQtdTalao() {
		return qtdTalao;
	}
	public void setQtdTalao(int qtdTalao) {
		this.qtdTalao = qtdTalao;
	}
	public int getTalao() {
		return talao;
	}
	public int getTotalTalao() {
		return totalTalao;
	}
	public void talao(int talao, int qtdTalao) {
		char opcao;
		do {
			Scanner leia = new Scanner(System.in);
			System.out.println("Você deseja imprimir talão? S/N ");
			opcao = leia.next().toUpperCase().charAt(0);
			while (opcao != 'S' && opcao != 'N') {
				System.out.println("\nOpção inválida. Deseja continuar? S/N");
				opcao = leia.next().toUpperCase().charAt(0);
			}
			if (opcao == 'S') {
				System.out.println("Digite a quantidade que deseja: (Até 3 talões por mês)");
				qtdTalao = leia.nextInt();
				while (qtdTalao < 0 || qtdTalao > 3) {
					System.out.printf("\nQuantidade inválida. Você pode resgatar até %d talões\nDigite a quantidade:", talao);
					qtdTalao = leia.nextInt();
				}
				while (qtdTalao > talao) {
					System.out.printf("Erro! Quantidade disponível: %d. Digite a quantidade:", talao);
					qtdTalao = leia.nextInt();
				}
				talao = talao - qtdTalao;
				totalTalao = totalTalao + qtdTalao;
				if (talao == 0) {
					talao = 3;
				}
				System.out.printf("Quantidade diária impressa: %d\n", qtdTalao);
				System.out.printf("Quantidade total impressa: %d\n", totalTalao);
				System.out.println("Deseja continuar? \n[S]-Sim \n[N]-Não");
				opcao = leia.next().toUpperCase().charAt(0);
			}
		} while (opcao == 'S');
	}
}