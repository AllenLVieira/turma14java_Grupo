package bancos;

public class ContaPoupanca extends Conta {

	private int dataAniversarioConta;

	public ContaPoupanca(int numConta, String cpfConta, int dataAniversarioConta) {
		super(numConta, cpfConta);
		this.dataAniversarioConta = dataAniversarioConta;
	}

	public int getDataAniversarioConta() {
		return dataAniversarioConta;
	}

	public void setDataAniversarioConta(int dataAniversarioConta) {
		this.dataAniversarioConta = dataAniversarioConta;
	}

	public void correcaoPoupanca(int dataAtual) {

		if (dataAtual == this.dataAniversarioConta) {
			super.depositar((super.getSaldoConta() * 0.005));
			System.out.println("Parabéns, seu saldo foi incrementado em 0.5%.");
		}
	}
}