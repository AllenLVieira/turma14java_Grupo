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
			System.out.println("Quantidade inv�lida!");
		}
		else {
			numeroTalaoCheque+=quantidadeTalao;
		}
		System.out.printf("N�mero de tal�es impressos at� o momento: %d",numeroTalaoCheque);
		return numeroTalaoCheque;
	}
}