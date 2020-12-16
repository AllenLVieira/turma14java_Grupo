package bancos;



import java.util.Scanner;

public class ContaCorrente extends Conta 
{
	protected int numeroTalaoCheque;

	public ContaCorrente(int numeroConta, String cpf) {
		super(numeroConta, cpf);
	}
	public int getNumeroTalaoCheque() {
		return numeroTalaoCheque;
	}
	
	public void setNumeroTalaoCheque(int numeroTalaoCheque) {
		this.numeroTalaoCheque = numeroTalaoCheque;
	}
	
	public int retornaTalao(int quantidadeTalao) {		
		if (quantidadeTalao < 0 || quantidadeTalao > 3) {
			System.out.println("Quantidade inválida!");
		}
		else {
			numeroTalaoCheque+=quantidadeTalao;
		}
		System.out.printf("Número de talões impressos até o momento: %d",numeroTalaoCheque);
		return numeroTalaoCheque;
	}
}